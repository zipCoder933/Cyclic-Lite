package com.lothrazar.cyclic.item.crafting;

import java.util.function.Supplier;

import com.lothrazar.cyclic.item.crafting.simple.CraftingStickContainer;
import com.lothrazar.cyclic.item.crafting.simple.CraftingStickContainerProvider;
//import com.lothrazar.cyclic.item.lunchbox.ContainerProviderLunchbox;
//import com.lothrazar.cyclic.item.lunchbox.ItemLunchbox;
//import com.lothrazar.cyclic.item.storagebag.ContainerStorageBag;
//import com.lothrazar.cyclic.item.storagebag.StorageBagContainerProvider;
import com.lothrazar.cyclic.registry.ItemRegistry;
import com.lothrazar.library.packet.PacketFlib;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkHooks;

public class PacketItemGui extends PacketFlib {

    private int slot;
    private Item item;

    public PacketItemGui(int slot, Item item) {
        this.slot = slot;
        this.item = item;
    }

    public static void handle(PacketItemGui message, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (message.item == ItemRegistry.CRAFTING_STICK.get() && (player.containerMenu instanceof CraftingStickContainer) == false) {
                NetworkHooks.openScreen(player, new CraftingStickContainerProvider(message.slot), buf -> buf.writeInt(message.slot));
            }
//     else if (message.item == ItemRegistry.LUNCHBOX.get()) { //TODO: (lite) remove?
//        //put the food in the lunchbox
//        ItemStack itemFoodMouse = player.containerMenu.getCarried();
//        if (itemFoodMouse.isEmpty()) {
//          //right click on mouse-empty-holding means open the GUI like the stick
//          NetworkHooks.openScreen(player, new ContainerProviderLunchbox(), buf -> buf.writeInt(message.slot));
//        }
//        else if (itemFoodMouse.isEdible()) {
//          ItemStack lunchbox = player.getInventory().getItem(message.slot);//why is it air
//          ItemLunchbox.insertFoodIntoLunchbox(lunchbox, itemFoodMouse, player);
//        }
//        //else it is not edible so do nothing
//      } // end of lunchbox flow
//      else if (message.item == ItemRegistry.STORAGE_BAG.get() && (player.containerMenu instanceof ContainerStorageBag) == false) {
//        NetworkHooks.openScreen(player, new StorageBagContainerProvider(message.slot), buf -> buf.writeInt(message.slot));
//      }
//      else if (message.item == ItemRegistry.CRAFTING_BAG.get() && (player.containerMenu instanceof CraftingBagContainer) == false) {
//        NetworkHooks.openScreen(player, new CraftingBagContainerProvider(message.slot), buf -> buf.writeInt(message.slot));
//      }
        });
        message.done(ctx);
    }

    public static PacketItemGui decode(FriendlyByteBuf buf) {
        return new PacketItemGui(buf.readInt(), buf.readItem().getItem());
    }

    public static void encode(PacketItemGui msg, FriendlyByteBuf buf) {
        buf.writeInt(msg.slot);
        buf.writeItem(new ItemStack(msg.item));
    }
}
