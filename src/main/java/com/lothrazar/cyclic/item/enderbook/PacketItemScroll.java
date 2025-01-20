package com.lothrazar.cyclic.item.enderbook;

import java.util.function.Supplier;
import com.lothrazar.cyclic.registry.ItemRegistry;
import com.lothrazar.library.packet.PacketFlib;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class PacketItemScroll extends PacketFlib {

  private int slot;
  private boolean isDown;

  public PacketItemScroll(int slot, boolean isDown) {
    this.slot = slot;
    this.isDown = isDown;
  }

  public static void handle(PacketItemScroll message, Supplier<NetworkEvent.Context> ctx) {
//    ctx.get().enqueueWork(() -> {
//      ServerPlayer player = ctx.get().getSender();
//      player.getCooldowns().addCooldown(ItemRegistry.ENDER_BOOK.get(), 5);
//      EnderBookItem.scroll(player, message.slot, message.isDown);
//    });
//    message.done(ctx);
  }

  public static PacketItemScroll decode(FriendlyByteBuf buf) {
    return new PacketItemScroll(buf.readInt(), buf.readBoolean());
  }

  public static void encode(PacketItemScroll msg, FriendlyByteBuf buf) {
    buf.writeInt(msg.slot);
    buf.writeBoolean(msg.isDown);
  }
}
