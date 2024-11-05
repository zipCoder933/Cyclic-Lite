package com.lothrazar.cyclic.block.cable;

import com.lothrazar.cyclic.base.TileEntityBase;
import com.lothrazar.cyclic.block.facade.ITileFacade;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.EnumProperty;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;

public abstract class TileCableBase extends TileEntityBase implements ITileFacade {

  public TileCableBase(TileEntityType<?> tileEntityTypeIn) {
    super(tileEntityTypeIn);
  }

  @Override
  public abstract void setField(int field, int value);

  @Override
  public abstract int getField(int field);

  public EnumConnectType getConnectionType(final Direction side) {
    EnumProperty<EnumConnectType> property = CableBase.FACING_TO_PROPERTY_MAP.get(side);
    return getBlockState().get(property);
  }

  @Override
  public void read(BlockState bs, CompoundNBT tag) {
    this.loadFacade(tag);
    super.read(bs, tag);
  }

  @Override
  public CompoundNBT write(CompoundNBT tag) {
    this.saveFacade(tag);
    return super.write(tag);
  }

  private CompoundNBT facadeState = null;

  @Override
  public CompoundNBT getFacade() {
    return facadeState;
  }

  @Override
  public void setFacade(CompoundNBT facadeState) {
    this.facadeState = facadeState;
  }

  public void updateConnection(final Direction side, final EnumConnectType connectType) {}
}
