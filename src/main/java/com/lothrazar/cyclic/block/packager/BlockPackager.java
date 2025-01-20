//package com.lothrazar.cyclic.block.packager;
//
//import com.lothrazar.cyclic.block.BlockCyclic;
//import com.lothrazar.cyclic.registry.MenuTypeRegistry;
//import com.lothrazar.cyclic.registry.TileRegistry;
//import net.minecraft.client.gui.screens.MenuScreens;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.inventory.AbstractContainerMenu;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.entity.BlockEntityTicker;
//import net.minecraft.world.level.block.entity.BlockEntityType;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.StateDefinition;
//import net.minecraft.world.level.block.state.properties.BlockStateProperties;
//
//public class BlockPackager extends BlockCyclic {
//
//  public BlockPackager(Properties properties) {
//    super(properties.strength(1.8F));
//    this.setHasGui();
//  }
//
//  @Override
//  public boolean hasAnalogOutputSignal(BlockState bs) {
//    return true;
//  }
//
//  @Override
//  public int getAnalogOutputSignal(BlockState st, Level level, BlockPos pos) {
//    return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
//  }
//
//  @Override
//  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
//    builder.add(BlockStateProperties.FACING).add(LIT);
//  }
//
//  @Override
//  public void registerClient() {
//    MenuScreens.register(MenuTypeRegistry.PACKAGER.get(), ScreenPackager::new);
//  }
//
//  @Override
//  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
//    return new TilePackager(pos, state);
//  }
//
//  @Override
//  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
//    return createTickerHelper(type, TileRegistry.PACKAGER.get(), world.isClientSide ? TilePackager::clientTick : TilePackager::serverTick);
//  }
//}
