package com.lothrazar.cyclic.block.facade;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.world.World;

public interface ITileFacade {

  public static final String NBT_FACADE = "facade";

  CompoundNBT getFacade();

  void setFacade(CompoundNBT facadeState);

  default BlockState getFacadeState(World level) {
    CompoundNBT facadeState = getFacade();
    if (level == null || facadeState == null || facadeState.isEmpty()) {
      return null; // level is null on world load 
    }
    BlockState stateFound = NBTUtil.readBlockState(facadeState);
    return stateFound;
  }

  default void loadFacade(CompoundNBT compound) {
    if (compound.contains(NBT_FACADE)) {
      this.setFacade(compound.getCompound(NBT_FACADE));
    }
    else {
      this.setFacade(null);
    }
  }

  default void saveFacade(CompoundNBT compound) {
    CompoundNBT facadeState = getFacade();
    if (facadeState == null) {
      compound.remove(NBT_FACADE);
    }
    else {
      compound.put(NBT_FACADE, facadeState);
    }
  }
}
