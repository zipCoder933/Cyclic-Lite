//package com.lothrazar.cyclic.block.creativeitem;
//
//import com.lothrazar.cyclic.block.TileBlockEntityCyclic;
//import com.lothrazar.cyclic.registry.TileRegistry;
//import com.lothrazar.library.cap.ItemStackHandlerWrapper;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraftforge.common.capabilities.Capability;
//import net.minecraftforge.common.capabilities.ForgeCapabilities;
//import net.minecraftforge.common.util.LazyOptional;
//import net.minecraftforge.items.IItemHandler;
//import net.minecraftforge.items.ItemStackHandler;
//
//public class TileItemInfinite extends TileBlockEntityCyclic {
//
//  public TileItemInfinite(BlockPos pos, BlockState state) {
//    super(TileRegistry.ITEM_INFINITE.get(), pos, state);
//  }
//
//  ItemStackHandler inputSlots = new ItemStackHandler(1);
//  ItemStackHandler outputSlot = new ItemStackHandler(1);
//  private ItemStackHandlerWrapper inventory = new ItemStackHandlerWrapper(inputSlots, outputSlot);
//  private final LazyOptional<IItemHandler> inventoryCap = LazyOptional.of(() -> inventory);
//
//  public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, TileItemInfinite e) {
//    e.tick();
//  }
//
//  public static <E extends BlockEntity> void clientTick(Level level, BlockPos blockPos, BlockState blockState, TileItemInfinite e) {
//    e.tick();
//  }
//
//  @Override
//  public void load(CompoundTag tag) {
//    super.load(tag);
//    inventory.deserializeNBT(tag.getCompound(NBTINV));
//  }
//
//  @Override
//  public void invalidateCaps() {
//    inventoryCap.invalidate();
//    super.invalidateCaps();
//  }
//
//  @Override
//  public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
//    if (cap == ForgeCapabilities.ITEM_HANDLER) {
//      return inventoryCap.cast();
//    }
//    return super.getCapability(cap, side);
//  }
//
//  @Override
//  public void saveAdditional(CompoundTag tag) {
//    tag.put(NBTINV, inventory.serializeNBT());
//    super.saveAdditional(tag);
//  }
//
//  public void tick() {
//    ItemStack stackHere = inputSlots.getStackInSlot(0);
//    if (!stackHere.isEmpty()) {
//      outputSlot.insertItem(0, stackHere.copy(), false);
//    }
//  }
//
//  @Override
//  public void setField(int field, int value) {}
//
//  @Override
//  public int getField(int field) {
//    return 0;
//  }
//}
