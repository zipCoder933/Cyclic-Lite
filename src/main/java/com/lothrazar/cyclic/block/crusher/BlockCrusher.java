//package com.lothrazar.cyclic.block.crusher;
//
//import com.lothrazar.cyclic.block.BlockCyclic;
//import com.lothrazar.cyclic.registry.MenuTypeRegistry;
//import com.lothrazar.cyclic.registry.TileRegistry;
//import net.minecraft.client.gui.screens.MenuScreens;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.entity.BlockEntityTicker;
//import net.minecraft.world.level.block.entity.BlockEntityType;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.StateDefinition;
//
//public class BlockCrusher extends BlockCyclic {
//
//  public BlockCrusher(Properties properties) {
//    super(properties.strength(0.7F));
//    this.setHasGui();
//  }
//
//  @Override
//  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
//    builder.add(LIT);
//  }
//
//  @Override
//  public void registerClient() {
//    //    ItemBlockRenderTypes.setRenderLayer(this, RenderType.cutoutMipped());
//    MenuScreens.register(MenuTypeRegistry.CRUSHER.get(), ScreenCrusher::new);
//  }
//
//  @Override
//  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
//    return new TileCrusher(pos, state);
//  }
//
//  @Override
//  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
//    return createTickerHelper(type, TileRegistry.CRUSHER.get(), world.isClientSide ? TileCrusher::clientTick : TileCrusher::serverTick);
//  }
//}
