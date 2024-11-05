package com.lothrazar.cyclic.net;

import com.lothrazar.cyclic.block.facade.IBlockFacade;
import com.lothrazar.cyclic.block.facade.ITileFacade;
import java.util.function.Supplier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

public class BlockFacadeMessage {

  private BlockPos pos;
  private boolean erase = false;
  private CompoundNBT blockStateTag = new CompoundNBT();

  private BlockFacadeMessage() {}

  public BlockFacadeMessage(BlockPos pos, CompoundNBT state) {
    this.pos = pos;
    this.blockStateTag = state;
    this.erase = false;
  }

  public BlockFacadeMessage(BlockPos pos, boolean eraseIn) {
    this.pos = pos;
    this.erase = eraseIn;
    blockStateTag = new CompoundNBT();
  }

  public static void handle(BlockFacadeMessage message, Supplier<NetworkEvent.Context> ctx) {
    ctx.get().enqueueWork(() -> {
      ServerPlayerEntity player = ctx.get().getSender();
      ServerWorld serverWorld = player.getServerWorld();
      BlockState bs = serverWorld.getBlockState(message.pos);
      Block b = bs.getBlock();
      if (b instanceof IBlockFacade) {
        IBlockFacade facadeBlock = (IBlockFacade) b;
        ITileFacade tile = facadeBlock.getTileFacade(serverWorld, message.pos);
        if (message.erase) {
          tile.setFacade(null);
        }
        else {
          tile.setFacade(message.blockStateTag);
        }
        serverWorld.markAndNotifyBlock(message.pos, serverWorld.getChunkAt(message.pos),
            bs, bs, 3, 1);
      }
    });
    ctx.get().setPacketHandled(true);
  }

  public static BlockFacadeMessage decode(PacketBuffer buf) {
    BlockFacadeMessage message = new BlockFacadeMessage();
    message.erase = buf.readBoolean();
    message.pos = buf.readBlockPos();
    message.blockStateTag = buf.readCompoundTag();
    return message;
  }

  public static void encode(BlockFacadeMessage msg, PacketBuffer buf) {
    buf.writeBoolean(msg.erase);
    buf.writeBlockPos(msg.pos);
    buf.writeCompoundTag(msg.blockStateTag);
  }
}
