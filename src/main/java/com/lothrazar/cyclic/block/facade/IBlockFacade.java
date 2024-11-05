package com.lothrazar.cyclic.block.facade;

import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public interface IBlockFacade {

  default VoxelShape getFacadeShape(BlockState state, IBlockReader level, BlockPos pos, ISelectionContext ctx) {
    BlockState tfs = getFacadeState(state, level, pos);
    if (tfs != null && tfs.getBlock() != state.getBlock()) {
      return ctx == null ? tfs.getShape(level, pos) : tfs.getShape(level, pos, ctx);
    }
    return null;
  }

  default BlockState getFacadeState(BlockState state, IBlockReader level, BlockPos pos) {
    if (level == null) {
      return null;
    }
    ITileFacade tile = this.getTileFacade(level, pos);
    if (tile != null && level instanceof World) {
      return tile.getFacadeState((World) level);
    }
    return null;
  }

  default ITileFacade getTileFacade(IBlockReader level, BlockPos pos) {
    if (level == null) {
      return null;
    }
    TileEntity tile = level.getTileEntity(pos);
    if (tile instanceof ITileFacade) {
      return (ITileFacade) tile;
    }
    return null;
  }
}
