package com.lothrazar.cyclic.block.collectfluid;

import javax.annotation.Nonnull;
import com.lothrazar.cyclic.base.TileEntityBase;
import com.lothrazar.cyclic.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileFluidCollect extends TileEntityBase implements ITickableTileEntity {

  private LazyOptional<IItemHandler> inventory = LazyOptional.of(this::createHandler);

  public static enum Fields {
    REDSTONE;
  }

  public TileFluidCollect() {
    super(BlockRegistry.Tiles.collector_fluid);
  }

  private IItemHandler createHandler() {
    return new ItemStackHandler(1);
  }
  // INamedContainerProvider, 
  //  @Override
  //  public ITextComponent getDisplayName() {
  //    return new StringTextComponent(getType().getRegistryName().getPath());
  //  }
  //
  //  @Nullable
  //  @Override
  //  public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
  //    return new ContainerPlacer(i, world, pos, playerInventory, playerEntity);
  //  }

  @Override
  public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, Direction side) {
    if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
      return inventory.cast();
    }
    return super.getCapability(cap, side);
  }

  @Override
  public void read(CompoundNBT tag) {
    inventory.ifPresent(h -> ((INBTSerializable<CompoundNBT>) h).deserializeNBT(tag.getCompound("inv")));
    super.read(tag);
  }

  @Override
  public CompoundNBT write(CompoundNBT tag) {
    inventory.ifPresent(h -> {
      CompoundNBT compound = ((INBTSerializable<CompoundNBT>) h).serializeNBT();
      tag.put("inv", compound);
    });
    return super.write(tag);
  }

  @Override
  public void tick() {
    if (this.requiresRedstone() && !this.isPowered()) {
      return;
    }
    inventory.ifPresent(inv -> {
      ItemStack stack = inv.getStackInSlot(0);
      if (stack.isEmpty() || Block.getBlockFromItem(stack.getItem()) == Blocks.AIR) {
        return;
      }
      //      Direction dir = this.getBlockState().get(BlockStateProperties.FACING);
      //      BlockPos offset = pos.offset(dir);
      //      BlockState state = Block.getBlockFromItem(stack.getItem()).getDefaultState();
      //      if (world.isAirBlock(offset) &&
      //          world.setBlockState(offset, state)) {
      //        stack.shrink(1);
      //      }
    });
  }

  @Override
  public void setField(int field, int value) {
    switch (Fields.values()[field]) {
      case REDSTONE:
        this.setNeedsRedstone(value);
      break;
    }
  }

  @Override
  public int getField(int field) {
    switch (Fields.values()[field]) {
      case REDSTONE:
        return this.getNeedsRedstone();
    }
    return 0;
  }
}
