package com.lothrazar.cyclic.block.facade.soundmuff;

import com.lothrazar.cyclic.block.facade.IBlockFacade;
import com.lothrazar.cyclic.block.soundmuff.SoundmufflerBlock;
import com.lothrazar.cyclic.registry.TileRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class SoundmufflerBlockFacade extends SoundmufflerBlock implements IBlockFacade {

  private static final VoxelShape THREE = Block.makeCuboidShape(6, 6, 6,
      10, 10, 10);

  public SoundmufflerBlockFacade(Properties properties) {
    super(properties.notSolid());
  }

  @Override
  public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
    VoxelShape facade = this.getFacadeShape(state, worldIn, pos, context);
    if (facade != null) {
      return facade;
    }
    return THREE;
  }

  @Override
  public void registerClient() {
    ClientRegistry.bindTileEntityRenderer(TileRegistry.soundproofing_ghost, SoundmuffRender::new);
  }

  @Override
  public boolean hasTileEntity(BlockState state) {
    return true;
  }

  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return new SoundmuffTileFacade();
  }
}
