package com.lothrazar.cyclic.net;

import java.util.function.Supplier;
import com.lothrazar.cyclic.block.facade.IBlockFacade;
import com.lothrazar.cyclic.block.facade.ITileFacade;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.NetworkEvent;

public class BlockFacadeMessage {

  private BlockPos pos;
  private boolean erase = false;
  private CompoundTag blockStateTag = new CompoundTag();

  private BlockFacadeMessage() {}

  public BlockFacadeMessage(BlockPos pos, CompoundTag state) {
    this.pos = pos;
    this.blockStateTag = state;
    this.erase = false;
  }

  public BlockFacadeMessage(BlockPos pos, boolean eraseIn) {
    this.pos = pos;
    this.erase = eraseIn;
    blockStateTag = new CompoundTag();
  }

  public static void handle(BlockFacadeMessage message, Supplier<NetworkEvent.Context> ctx) {
    ctx.get().enqueueWork(() -> {
      ServerPlayer player = ctx.get().getSender();
      var serverWorld = player.getCommandSenderWorld();
      BlockState bs = serverWorld.getBlockState(message.pos);
      if (bs.getBlock() instanceof IBlockFacade facadeBlock) {
        ITileFacade tile = facadeBlock.getTileFacade(serverWorld, message.pos);
        if (message.erase) {
          tile.setFacade(new CompoundTag());
        }
        else {
          tile.setFacade(message.blockStateTag);
        }
        serverWorld.markAndNotifyBlock(message.pos, serverWorld.getChunkAt(message.pos),
            bs, bs, 3, 1);
        serverWorld.sendBlockUpdated(message.pos, bs, bs, 3);
        serverWorld.blockUpdated(message.pos, bs.getBlock());
      }
    });
    ctx.get().setPacketHandled(true);
  }

  public static BlockFacadeMessage decode(FriendlyByteBuf buf) {
    BlockFacadeMessage message = new BlockFacadeMessage();
    message.erase = buf.readBoolean();
    message.pos = buf.readBlockPos();
    message.blockStateTag = buf.readNbt();
    return message;
  }

  public static void encode(BlockFacadeMessage msg, FriendlyByteBuf buf) {
    buf.writeBoolean(msg.erase);
    buf.writeBlockPos(msg.pos);
    buf.writeNbt(msg.blockStateTag);
  }
}
