package com.lothrazar.cyclic.block.collectfluid;

import java.util.List;
import com.lothrazar.cyclic.block.TileBlockEntityCyclic;
import com.lothrazar.cyclic.capabilities.block.FluidTankBase;
import com.lothrazar.cyclic.data.PreviewOutlineType;
import com.lothrazar.cyclic.registry.BlockRegistry;
import com.lothrazar.cyclic.registry.TileRegistry;
import com.lothrazar.cyclic.util.FluidHelpers.FluidAttributes;
import com.lothrazar.library.cap.CustomEnergyStorage;
import com.lothrazar.library.util.ShapeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileFluidCollect extends TileBlockEntityCyclic implements MenuProvider {

  static enum Fields {
    REDSTONE, RENDER, SIZE, HEIGHT;
  }

  static final int MAX_HEIGHT = 64;
  public static final int MAX_SIZE = 12; //radius 7 translates to 15x15 area (center block + 7 each side)
  public static final int CAPACITY = 64 * FluidType.BUCKET_VOLUME;
  public static IntValue POWERCONF;
  FluidTankBase tank;
  private final LazyOptional<FluidTankBase> fluidCap = LazyOptional.of(() -> tank);
  private int shapeIndex = 0; // current index of shape array
  private int radius = 4 * 2;
  private int height = 4;
  BlockPos targetPos = null;
  static final int MAX = 64000;
  ItemStackHandler inventory = new ItemStackHandler(1) {

    @Override
    public boolean isItemValid(int slot, ItemStack stack) {
      return Block.byItem(stack.getItem()) != Blocks.AIR;
    }
  };
  CustomEnergyStorage energy = new CustomEnergyStorage(MAX, MAX);
  private LazyOptional<IItemHandler> inventoryCap = LazyOptional.of(() -> inventory);
  private LazyOptional<IEnergyStorage> energyCap = LazyOptional.of(() -> energy);

  public TileFluidCollect(BlockPos pos, BlockState state) {
    super(TileRegistry.COLLECTOR_FLUID.get(), pos, state);
    tank = new FluidTankBase(this, CAPACITY, p -> true);
  }

  public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, TileFluidCollect e) {
    e.tick();
  }

  public static <E extends BlockEntity> void clientTick(Level level, BlockPos blockPos, BlockState blockState, TileFluidCollect e) {
    e.tick();
  }

  public void tick() {
    this.syncEnergy();
    if (this.requiresRedstone() && !this.isPowered()) {
      this.setLitProperty(false);
      return;
    }
    Integer cost = POWERCONF.get();
    if (energy.getEnergyStored() < cost && cost > 0) {
      return;
    }
    ItemStack stack = inventory.getStackInSlot(0);
    //use air if its empty
    BlockState newState = Block.byItem(stack.getItem()).defaultBlockState();
    this.setLitProperty(true);
    List<BlockPos> shape = this.getShapeFilled();
    if (shape.size() == 0) {
      return;
    }
    //iterate around shape
    incrementShapePtr(shape);
    targetPos = shape.get(shapeIndex);
    //ok on this target get fluid check it out
    FluidState fluidState = level.getFluidState(targetPos);
    if (fluidState.isSource()) {
      FluidStack fstack = new FluidStack(fluidState.getType(), FluidAttributes.BUCKET_VOLUME);
      int result = tank.fill(fstack, FluidAction.SIMULATE);
      if (result == FluidAttributes.BUCKET_VOLUME) {
        //we got enough   
        if (level.setBlockAndUpdate(targetPos, newState)) {
          //build the block, shrink the item
          stack.shrink(1);
          //drink fluid
          tank.fill(fstack, FluidAction.EXECUTE);
          energy.extractEnergy(cost, false);
        }
      }
    }
  }

  @Override
  public void setFluid(FluidStack fluid) {
    tank.setFluid(fluid);
  }

  @Override
  public FluidStack getFluid() {
    return tank == null ? FluidStack.EMPTY : tank.getFluid();
  }

  @Override
  public AABB getRenderBoundingBox() {
    return BlockEntity.INFINITE_EXTENT_AABB;
  }

  private int heightWithDirection() {
    Direction blockFacing = this.getBlockState().getValue(BlockStateProperties.FACING);
    int diff = 1; // directionIsUp ? 1 : -1;
    if (blockFacing.getAxis().isVertical()) {
      diff = (blockFacing == Direction.UP) ? 1 : -1;
    }
    return diff * height;
  }

  //for render
  public List<BlockPos> getShapeHollow() {
    BlockPos center = getFacingShapeCenter(radius);
    List<BlockPos> shape = ShapeUtil.squareHorizontalHollow(center, this.radius);
    //
    int heightWithDirection = heightWithDirection();
    if (heightWithDirection != 0) {
      shape = ShapeUtil.repeatShapeByHeight(shape, heightWithDirection);
    }
    if (targetPos != null) {
      shape.add(targetPos);
    }
    return shape;
  }

  //for harvest
  public List<BlockPos> getShapeFilled() {
    BlockPos center = getFacingShapeCenter(radius);
    int heightWithDirection = heightWithDirection();
    List<BlockPos> shape = ShapeUtil.squareHorizontalFull(center, this.radius);
    if (heightWithDirection != 0) {
      shape = ShapeUtil.repeatShapeByHeight(shape, heightWithDirection);
    }
    return shape;
  }

  @Override
  public Component getDisplayName() {
    return BlockRegistry.COLLECTOR_FLUID.get().getName();
  }

  @Override
  public AbstractContainerMenu createMenu(int i, Inventory playerInventory, Player playerEntity) {
    return new ContainerFluidCollect(i, level, worldPosition, playerInventory, playerEntity);
  }

  @Override
  public void invalidateCaps() {
    energyCap.invalidate();
    inventoryCap.invalidate();
    fluidCap.invalidate();
    super.invalidateCaps();
  }

  @Override
  public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
    if (cap == ForgeCapabilities.ITEM_HANDLER) {
      return inventoryCap.cast();
    }
    if (cap == ForgeCapabilities.FLUID_HANDLER) {
      return fluidCap.cast();
    }
    if (cap == ForgeCapabilities.ENERGY) {
      return energyCap.cast();
    }
    return super.getCapability(cap, side);
  }

  @Override
  public void load(CompoundTag tag) {
    // For backwards-compatibility: these weren't always stored, so keep the default
    if (tag.contains("size", Tag.TAG_INT)) {
      radius = tag.getInt("size");
    }
    if (tag.contains("height", Tag.TAG_INT)) {
      height = tag.getInt("height");
    }
    shapeIndex = tag.getInt("shapeIndex");
    tank.readFromNBT(tag.getCompound(NBTFLUID));
    energy.deserializeNBT(tag.getCompound(NBTENERGY));
    inventory.deserializeNBT(tag.getCompound(NBTINV));
    super.load(tag);
  }

  @Override
  public void saveAdditional(CompoundTag tag) {
    tag.putInt("size", radius);
    tag.putInt("height", height);
    tag.put(NBTENERGY, energy.serializeNBT());
    tag.put(NBTINV, inventory.serializeNBT());
    CompoundTag fluid = new CompoundTag();
    tank.writeToNBT(fluid);
    tag.put(NBTFLUID, fluid);
    tag.putInt("shapeIndex", shapeIndex);
    super.saveAdditional(tag);
  }

  private void incrementShapePtr(List<BlockPos> shape) {
    shapeIndex++;
    if (this.shapeIndex < 0 || this.shapeIndex >= shape.size()) {
      this.shapeIndex = 0;
    }
  }

  @Override
  public void setField(int field, int value) {
    switch (Fields.values()[field]) {
      case REDSTONE:
        this.setNeedsRedstone(value);
      break;
      case RENDER:
        this.render = value % PreviewOutlineType.values().length;
      break;
      case HEIGHT:
        height = Math.min(value, MAX_HEIGHT);
      break;
      case SIZE:
        radius = Math.min(value, MAX_SIZE);
      break;
    }
  }

  @Override
  public int getField(int field) {
    switch (Fields.values()[field]) {
      case REDSTONE:
        return this.needsRedstone;
      case RENDER:
        return this.render;
      case HEIGHT:
        return height;
      case SIZE:
        return radius;
    }
    return 0;
  }
}
