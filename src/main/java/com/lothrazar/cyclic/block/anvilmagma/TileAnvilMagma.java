//package com.lothrazar.cyclic.block.anvilmagma;
//
//import java.util.function.Predicate;
//import com.lothrazar.cyclic.block.TileBlockEntityCyclic;
//import com.lothrazar.cyclic.capabilities.block.FluidTankBase;
//import com.lothrazar.cyclic.data.DataTags;
//import com.lothrazar.cyclic.fluid.FluidMagmaHolder;
//import com.lothrazar.cyclic.registry.BlockRegistry;
//import com.lothrazar.cyclic.registry.TileRegistry;
//import com.lothrazar.library.cap.ItemStackHandlerWrapper;
//import com.lothrazar.library.util.ItemStackUtil;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.MenuProvider;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.inventory.AbstractContainerMenu;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.material.Fluid;
//import net.minecraftforge.common.ForgeConfigSpec.IntValue;
//import net.minecraftforge.common.capabilities.Capability;
//import net.minecraftforge.common.capabilities.ForgeCapabilities;
//import net.minecraftforge.common.util.LazyOptional;
//import net.minecraftforge.fluids.FluidStack;
//import net.minecraftforge.fluids.FluidType;
//import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;
//import net.minecraftforge.items.IItemHandler;
//import net.minecraftforge.items.ItemStackHandler;
//
//public class TileAnvilMagma extends TileBlockEntityCyclic implements MenuProvider {
//
//  static enum Fields {
//    TIMER, REDSTONE;
//  }
//
//  public static final int CAPACITY = 64 * FluidType.BUCKET_VOLUME;
//  public static IntValue FLUIDCOST;
//  ItemStackHandler inputSlots = new ItemStackHandler(1) {
//
//    @Override
//    public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
//      if (!stack.isEmpty() && stack.isRepairable() && stack.getDamageValue() == 0) {
//        return outputSlots.insertItem(slot, stack, simulate);
//      }
//      else {
//        return super.insertItem(slot, stack, simulate);
//      }
//    }
//
//    @Override
//    public boolean isItemValid(int slot, ItemStack stack) {
//      return stack.isRepairable() && stack.getDamageValue() > 0;
//    }
//  };
//  ItemStackHandler outputSlots = new ItemStackHandler(1);
//  private ItemStackHandlerWrapper inventory = new ItemStackHandlerWrapper(inputSlots, outputSlots);
//  private LazyOptional<IItemHandler> inventoryCap = LazyOptional.of(() -> inventory);
//  public FluidTankBase tank = new FluidTankBase(this, CAPACITY, isFluidValid());
//  LazyOptional<FluidTankBase> fluidCap = LazyOptional.of(() -> tank);
//
//  public TileAnvilMagma(BlockPos pos, BlockState state) {
//    super(TileRegistry.ANVIL_MAGMA.get(), pos, state);
//    this.needsRedstone = 0;
//  }
//
//  public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, TileAnvilMagma e) {
//    e.tick();
//  }
//
//  public static <E extends BlockEntity> void clientTick(Level level, BlockPos blockPos, BlockState blockState, TileAnvilMagma e) {
//    e.tick();
//  }
//
//  //  @Override
//  public void tick() {
//    if (this.requiresRedstone() && !this.isPowered()) {
//      setLitProperty(false);
//      return;
//    }
//    setLitProperty(true);
//    ItemStack stack = inputSlots.getStackInSlot(0);
//    if (stack.isEmpty() || stack.is(DataTags.ANVIL_IMMUNE)) {
//      //move it over and then done
//      if (outputSlots.getStackInSlot(0).isEmpty()) {
//        outputSlots.insertItem(0, stack.copy(), false);
//        inputSlots.extractItem(0, stack.getCount(), false);
//      }
//      return;
//    }
//    boolean done = (stack.getDamageValue() == 0);
//    if (done && outputSlots.getStackInSlot(0).isEmpty()) {
//      //
//      outputSlots.insertItem(0, stack.copy(), false);
//      inputSlots.extractItem(0, stack.getCount(), false);
//    }
//    final int repair = FLUIDCOST.get(); // fluid
//    boolean work = false;
//    if (tank != null &&
//        tank.getFluidAmount() >= repair &&
//        stack.isRepairable() &&
//        stack.getDamageValue() > 0) {
//      //we can repair so steal some power
//      //ok drain power
//      work = true;
//      tank.drain(repair, FluidAction.EXECUTE);
//    }
//    //shift to other slot
//    if (work) {
//      ItemStackUtil.repairItem(stack);
//    }
//  }
//
//  public Predicate<FluidStack> isFluidValid() {
//    return p -> {
//      Fluid fluid = p.getFluid();
//      return fluid == FluidMagmaHolder.STILL.get();
//    };
//  }
//
//  @Override
//  public Component getDisplayName() {
//    return BlockRegistry.ANVIL_MAGMA.get().getName();
//  }
//
//  @Override
//  public AbstractContainerMenu createMenu(int i, Inventory playerInventory, Player playerEntity) {
//    return new ContainerAnvilMagma(i, level, worldPosition, playerInventory, playerEntity);
//  }
//
//  @Override
//  public void invalidateCaps() {
//    fluidCap.invalidate();
//    inventoryCap.invalidate();
//    super.invalidateCaps();
//  }
//
//  @Override
//  public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
//    if (cap == ForgeCapabilities.ITEM_HANDLER) {
//      return inventoryCap.cast();
//    }
//    if (cap == ForgeCapabilities.FLUID_HANDLER) {
//      return fluidCap.cast();
//    }
//    return super.getCapability(cap, side);
//  }
//
//  @Override
//  public void load(CompoundTag tag) {
//    inventory.deserializeNBT(tag.getCompound(NBTINV));
//    tank.readFromNBT(tag.getCompound(NBTFLUID));
//    super.load(tag);
//  }
//
//  @Override
//  public void saveAdditional(CompoundTag tag) {
//    CompoundTag fluid = new CompoundTag();
//    tank.writeToNBT(fluid);
//    tag.put(NBTFLUID, fluid);
//    tag.put(NBTINV, inventory.serializeNBT());
//    super.saveAdditional(tag);
//  }
//
//  @Override
//  public int getField(int id) {
//    switch (Fields.values()[id]) {
//      case REDSTONE:
//        return this.needsRedstone;
//      case TIMER:
//        return this.timer;
//    }
//    return 0;
//  }
//
//  @Override
//  public void setField(int field, int value) {
//    switch (Fields.values()[field]) {
//      case REDSTONE:
//        this.needsRedstone = value % 2;
//      break;
//      case TIMER:
//        this.timer = value;
//      break;
//    }
//  }
//
//  @Override
//  public void setFluid(FluidStack fluid) {
//    tank.setFluid(fluid);
//  }
//
//  @Override
//  public FluidStack getFluid() {
//    return tank == null ? FluidStack.EMPTY : tank.getFluid();
//  }
//}
