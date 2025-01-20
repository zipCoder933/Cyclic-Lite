//package com.lothrazar.cyclic.block.expcollect;
//
//import com.lothrazar.cyclic.gui.ContainerBase;
//import com.lothrazar.cyclic.registry.BlockRegistry;
//import com.lothrazar.cyclic.registry.MenuTypeRegistry;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.inventory.ContainerLevelAccess;
//import net.minecraft.world.level.Level;
//
//public class ContainerExpPylon extends ContainerBase {
//
//  TileExpPylon tile;
//
//  public ContainerExpPylon(int windowId, Level world, BlockPos pos, Inventory playerInventory, Player player) {
//    super(MenuTypeRegistry.EXPERIENCE_PYLON.get(), windowId);
//    tile = (TileExpPylon) world.getBlockEntity(pos);
//    this.playerEntity = player;
//    this.playerInventory = playerInventory;
//    layoutPlayerInventorySlots(8, 84);
//    this.trackAllIntFields(tile, TileExpPylon.Fields.values().length);
//  }
//
//  @Override
//  public boolean stillValid(Player playerIn) {
//    return stillValid(ContainerLevelAccess.create(tile.getLevel(), tile.getBlockPos()), playerEntity, BlockRegistry.EXPERIENCE_PYLON.get());
//  }
//}
