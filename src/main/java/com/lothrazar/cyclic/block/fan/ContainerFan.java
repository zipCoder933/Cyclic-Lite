//package com.lothrazar.cyclic.block.fan;
//
//import com.lothrazar.cyclic.gui.ContainerBase;
//import com.lothrazar.cyclic.registry.BlockRegistry;
//import com.lothrazar.cyclic.registry.MenuTypeRegistry;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.inventory.ContainerLevelAccess;
//import net.minecraft.world.level.Level;
//import net.minecraftforge.items.SlotItemHandler;
//
//public class ContainerFan extends ContainerBase {
//
//  protected TileFan tile;
//
//  public ContainerFan(int windowId, Level world, BlockPos pos, Inventory playerInventory, Player player) {
//    super(MenuTypeRegistry.FAN.get(), windowId);
//    tile = (TileFan) world.getBlockEntity(pos);
//    this.playerEntity = player;
//    this.playerInventory = playerInventory;
//    this.endInv = 1;
//    addSlot(new SlotItemHandler(tile.filter, 0, 149, 9) {
//
//      @Override
//      public void setChanged() {
//        tile.setChanged();
//      }
//    });
//    layoutPlayerInventorySlots(8, 84);
//    this.trackAllIntFields(tile, TileFan.Fields.values().length);
//    this.trackEnergy(tile);
//  }
//
//  @Override
//  public boolean stillValid(Player playerIn) {
//    return stillValid(ContainerLevelAccess.create(tile.getLevel(), tile.getBlockPos()), playerEntity, BlockRegistry.FAN.get());
//  }
//}
