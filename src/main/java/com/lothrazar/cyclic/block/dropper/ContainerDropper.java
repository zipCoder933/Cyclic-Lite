//package com.lothrazar.cyclic.block.dropper;
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
//public class ContainerDropper extends ContainerBase {
//
//  TileDropper tile;
//
//  public ContainerDropper(int windowId, Level world, BlockPos pos, Inventory playerInventory, Player player) {
//    super(MenuTypeRegistry.DROPPER.get(), windowId);
//    tile = (TileDropper) world.getBlockEntity(pos);
//    this.playerEntity = player;
//    this.playerInventory = playerInventory;
//    tile.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(h -> {
//      this.endInv = h.getSlots();
//      addSlot(new SlotItemHandler(h, 0, 89, 59) {
//
//        @Override
//        public void setChanged() {
//          tile.setChanged();
//        }
//      });
//    });
//    addSlot(new SlotItemHandler(tile.gpsSlots, 0, 10, 59) {
//
//      @Override
//      public void setChanged() {
//        tile.setChanged();
//      }
//    });
//    layoutPlayerInventorySlots(8, 84);
//    this.trackAllIntFields(tile, TileDropper.Fields.values().length);
//    trackEnergy(tile);
//  }
//
//  public int getEnergy() {
//    return tile.getCapability(ForgeCapabilities.ENERGY).map(IEnergyStorage::getEnergyStored).orElse(0);
//  }
//
//  @Override
//  public boolean stillValid(Player playerIn) {
//    return stillValid(ContainerLevelAccess.create(tile.getLevel(), tile.getBlockPos()), playerEntity, BlockRegistry.DROPPER.get());
//  }
//}
