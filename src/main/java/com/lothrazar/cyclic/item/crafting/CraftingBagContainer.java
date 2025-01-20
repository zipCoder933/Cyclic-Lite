//package com.lothrazar.cyclic.item.crafting;
//
//import java.util.Optional;
//import com.lothrazar.cyclic.ModCyclic;
//import com.lothrazar.cyclic.data.IContainerCraftingAction;
//import com.lothrazar.cyclic.gui.ContainerBase;
//import com.lothrazar.cyclic.registry.ItemRegistry;
//import com.lothrazar.cyclic.registry.MenuTypeRegistry;
//import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.world.Container;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.inventory.ClickType;
//import net.minecraft.world.inventory.CraftingContainer;
//import net.minecraft.world.inventory.ResultContainer;
//import net.minecraft.world.inventory.ResultSlot;
//import net.minecraft.world.inventory.Slot;
//import net.minecraft.world.inventory.TransientCraftingContainer;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.crafting.CraftingRecipe;
//import net.minecraft.world.item.crafting.RecipeType;
//import net.minecraft.world.level.Level;
//import net.minecraftforge.common.capabilities.ForgeCapabilities;
//import net.minecraftforge.items.IItemHandler;
//
//public class CraftingBagContainer extends ContainerBase implements IContainerCraftingAction {
//
//  private final TransientCraftingContainer craftMatrix = new TransientCraftingContainer(this, 3, 3);
//  private final ResultContainer craftResult = new ResultContainer();
//  //
//  public int slot = -1;
//  public ItemStack bag = ItemStack.EMPTY;
//
//  public CraftingBagContainer(int id, Inventory playerInventory, Player player, int slot) {
//    super(MenuTypeRegistry.CRAFTING_BAG.get(), id);
//    this.slot = slot;
//    ModCyclic.LOGGER.info("bag slot " + slot);
//    this.playerEntity = player;
//    this.playerInventory = playerInventory;
//    this.endInv = 10;
//    //result first
//    this.addSlot(new ResultSlot(playerInventory.player, this.craftMatrix, this.craftResult, 0, 124, 35));
//    if (slot > -1) {
//      this.bag = playerInventory.getItem(slot);
//    }
//    if (bag == null || bag.isEmpty()) {
//      this.bag = super.findBag(ItemRegistry.CRAFTING_BAG.get());
//    }
//    //grid
//    for (int i = 0; i < 3; i++) {
//      for (int j = 0; j < 3; j++) {
//        addSlot(new Slot(craftMatrix, j + i * 3, 30 + j * 18, 17 + i * 18) {
//
//          @Override
//          public boolean mayPlace(ItemStack stack) {
//            return !(stack.getItem() instanceof CraftingBagItem);
//          }
//        });
//      }
//    }
//    bag.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(h -> {
//      for (int j = 0; j < h.getSlots(); j++) {
//        ItemStack inBag = h.getStackInSlot(j);
//        if (!inBag.isEmpty()) {
//          this.craftMatrix.setItem(j, h.getStackInSlot(j));
//        }
//      }
//    });
//    layoutPlayerInventorySlots(8, 84);
//  }
//
//  @Override
//  public void removed(Player playerIn) { // onContainerClosed
//    super.removed(playerIn);
//    this.craftResult.setItem(0, ItemStack.EMPTY);
//    if (playerIn.level().isClientSide == false) {
//      IItemHandler handler = bag.getCapability(ForgeCapabilities.ITEM_HANDLER).orElse(null);
//      if (handler != null)
//        for (int i = 0; i < 9; i++) {
//          ItemStack crafty = this.craftMatrix.getItem(i);
//          handler.extractItem(i, 64, false);
//          handler.insertItem(i, crafty, false);
//        }
//    }
//  }
//
//  @Override
//  public void slotsChanged(Container inventory) {
//    Level world = playerInventory.player.level();
//    if (!world.isClientSide) {
//      ServerPlayer player = (ServerPlayer) playerInventory.player;
//      ItemStack itemstack = ItemStack.EMPTY;
//      Optional<CraftingRecipe> optional = world.getServer().getRecipeManager().getRecipeFor(RecipeType.CRAFTING, craftMatrix, world);
//      if (optional.isPresent()) {
//        CraftingRecipe icraftingrecipe = optional.get();
//        if (craftResult.setRecipeUsed(world, player, icraftingrecipe)) {
//          itemstack = icraftingrecipe.assemble(craftMatrix, world.registryAccess());
//        }
//      }
//      craftResult.setItem(0, itemstack);
//      player.connection.send(new ClientboundContainerSetSlotPacket(containerId, this.getStateId(), 0, itemstack));
//    }
//  }
//
//  @Override
//  public boolean canTakeItemForPickAll(ItemStack itemStack, Slot slot) {
//    return slot.container != craftResult && super.canTakeItemForPickAll(itemStack, slot);
//  }
//
//  @Override
//  public boolean stillValid(Player playerIn) {
//    return true;
//  }
//
//  @Override
//  public void clicked(int slotId, int dragType, ClickType clickTypeIn, Player player) {
//    if (!(slotId < 0 || slotId >= this.slots.size())) {
//      ItemStack myBag = this.slots.get(slotId).getItem();
//      if (myBag.getItem() instanceof CraftingBagItem) {
//        //lock the bag in place by returning empty
//        return; // ItemStack.EMPTY;
//      }
//    }
//    super.clicked(slotId, dragType, clickTypeIn, player);
//  }
//
//  @Override
//  public ItemStack transferStack(Player playerIn, int index) {
//    return super.quickMoveStack(playerIn, index);
//  }
//
//  @Override
//  public CraftingContainer getCraftMatrix() {
//    return this.craftMatrix;
//  }
//
//  @Override
//  public ResultContainer getCraftResult() {
//    return this.craftResult;
//  }
//}
