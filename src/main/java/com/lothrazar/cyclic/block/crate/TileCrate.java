//package com.lothrazar.cyclic.block.crate;
//
//import com.lothrazar.cyclic.block.TileBlockEntityCyclic;
//import com.lothrazar.cyclic.registry.BlockRegistry;
//import com.lothrazar.cyclic.registry.TileRegistry;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.MenuProvider;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.inventory.AbstractContainerMenu;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraftforge.common.capabilities.Capability;
//import net.minecraftforge.common.capabilities.ForgeCapabilities;
//import net.minecraftforge.common.util.LazyOptional;
//import net.minecraftforge.items.IItemHandler;
//import net.minecraftforge.items.ItemStackHandler;
//
//public class TileCrate extends TileBlockEntityCyclic implements MenuProvider {
//
//  ItemStackHandler inventory = new ItemStackHandler(9 * 9);
//  private LazyOptional<IItemHandler> inventoryCap = LazyOptional.of(() -> inventory);
//
//  public TileCrate(BlockPos pos, BlockState state) {
//    super(TileRegistry.CRATE.get(), pos, state);
//  }
//
//  @Override
//  public Component getDisplayName() {
//    return BlockRegistry.CRATE.get().getName();
//  }
//
//  @Override
//  public AbstractContainerMenu createMenu(int i, Inventory playerInventory, Player playerEntity) {
//    this.updateComparatorOutputLevel();
//    return new ContainerCrate(i, level, worldPosition, playerInventory, playerEntity);
//  }
//
//  @Override
//  public void invalidateCaps() {
//    this.updateComparatorOutputLevel();
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
//  public void load(CompoundTag tag) {
//    inventory.deserializeNBT(tag.getCompound(NBTINV));
//    super.load(tag);
//  }
//
//  @Override
//  public void saveAdditional(CompoundTag tag) {
//    super.saveAdditional(tag);
//    tag.put(NBTINV, inventory.serializeNBT());
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
