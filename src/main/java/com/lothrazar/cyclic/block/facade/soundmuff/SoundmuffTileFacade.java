package com.lothrazar.cyclic.block.facade.soundmuff;

import com.lothrazar.cyclic.block.TileBlockEntityCyclic;
import com.lothrazar.cyclic.block.facade.ITileFacade;
import com.lothrazar.cyclic.registry.TileRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.state.BlockState;

public class SoundmuffTileFacade extends TileBlockEntityCyclic implements ITileFacade {

  public SoundmuffTileFacade(BlockPos pos, BlockState state) {
    super(TileRegistry.SOUNDPROOFING_GHOST.get(), pos, state);
  }

  @Override
  public CompoundTag getUpdateTag() {
    CompoundTag syncData = super.getUpdateTag();
    return syncData;
  }

  @Override
  public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
    if (pkt.getTag().contains(NBT_FACADE)) {
      this.load(pkt.getTag());
      super.onDataPacket(net, pkt);
    }
  }

  @Override
  public void load(CompoundTag tag) {
    this.loadFacade(tag);
    super.load(tag);
  }

  @Override
  public void saveAdditional(CompoundTag tag) {
    this.saveFacade(tag);
    super.saveAdditional(tag);
  }

  @Override
  public void setField(int field, int value) {}

  @Override
  public int getField(int field) {
    return 0;
  }

  private CompoundTag facadeState = null;

  @Override
  public CompoundTag getFacade() {
    return facadeState;
  }

  @Override
  public void setFacade(CompoundTag facadeStateIn) {
    this.facadeState = facadeStateIn;
  }
}
