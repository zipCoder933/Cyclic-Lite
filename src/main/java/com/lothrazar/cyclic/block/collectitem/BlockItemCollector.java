//package com.lothrazar.cyclic.block.collectitem;
//
//import com.lothrazar.cyclic.block.BlockCyclic;
//import com.lothrazar.cyclic.registry.MenuTypeRegistry;
//import com.lothrazar.cyclic.registry.TileRegistry;
//import com.lothrazar.library.util.BlockstatesUtil;
//import net.minecraft.client.gui.screens.MenuScreens;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.inventory.AbstractContainerMenu;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.SoundType;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.entity.BlockEntityTicker;
//import net.minecraft.world.level.block.entity.BlockEntityType;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.StateDefinition;
//import net.minecraft.world.level.block.state.properties.BlockStateProperties;
//
//public class BlockItemCollector extends BlockCyclic {
//
//  public BlockItemCollector(Properties properties) {
//    super(properties.strength(1.8F).sound(SoundType.STONE));
//    this.setHasGui();
//  }
//
//  @Override
//  public void setPlacedBy(Level world, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
//    if (entity != null) {
//      world.setBlock(pos, state.setValue(BlockStateProperties.FACING, BlockstatesUtil.getFacingFromEntity(pos, entity)), 2);
//    }
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
//  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
//    return new TileItemCollector(pos, state);
//  }
//
//  @Override
//  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
//    return createTickerHelper(type, TileRegistry.COLLECTOR.get(), world.isClientSide ? TileItemCollector::clientTick : TileItemCollector::serverTick);
//  }
//
//  @Override
//  public void registerClient() {
//    MenuScreens.register(MenuTypeRegistry.COLLECTOR.get(), ScreenItemCollector::new);
//  }
//}
