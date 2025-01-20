//package com.lothrazar.cyclic.block.anvilmagma;
//
//import com.lothrazar.cyclic.gui.ContainerBase;
//import com.lothrazar.cyclic.registry.BlockRegistry;
//import com.lothrazar.cyclic.registry.MenuTypeRegistry;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.inventory.ContainerLevelAccess;
//import net.minecraft.world.level.Level;
//import net.minecraftforge.common.capabilities.ForgeCapabilities;
//import net.minecraftforge.energy.IEnergyStorage;
//import net.minecraftforge.items.SlotItemHandler;
//
//public class ContainerAnvilMagma extends ContainerBase {
//
//  TileAnvilMagma tile;
//
//  public ContainerAnvilMagma(int windowId, Level world, BlockPos pos, Inventory playerInventory, Player player) {
//    super(MenuTypeRegistry.ANVIL_MAGMA.get(), windowId);
//    tile = (TileAnvilMagma) world.getBlockEntity(pos);
//    this.playerEntity = player;
//    this.playerInventory = playerInventory;
//    addSlot(new SlotItemHandler(tile.inputSlots, 0, 55, 35) {
//
//      @Override
//      public void setChanged() {
//        tile.setChanged();
//      }
//    });
//    addSlot(new SlotItemHandler(tile.outputSlots, 0, 109, 35) {
//
//      @Override
//      public void setChanged() {
//        tile.setChanged();
//      }
//    });
//    this.endInv = 2;
//    layoutPlayerInventorySlots(8, 84);
//    this.trackAllIntFields(tile, TileAnvilMagma.Fields.values().length);
//    trackEnergy(tile);
//  }
//
//  public int getEnergy() {
//    return tile.getCapability(ForgeCapabilities.ENERGY).map(IEnergyStorage::getEnergyStored).orElse(0);
//  }
//
//  @Override
//  public boolean stillValid(Player playerIn) {
//    return stillValid(ContainerLevelAccess.create(tile.getLevel(), tile.getBlockPos()), playerEntity, BlockRegistry.ANVIL_MAGMA.get());
//  }
//}
