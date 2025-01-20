//package com.lothrazar.cyclic.block.phantom;
//
//import com.lothrazar.cyclic.block.BlockCyclic;
//import com.lothrazar.cyclic.registry.TileRegistry;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.level.BlockGetter;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.entity.BlockEntityTicker;
//import net.minecraft.world.level.block.entity.BlockEntityType;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.StateDefinition;
//import net.minecraft.world.level.block.state.properties.BlockStateProperties;
//import net.minecraft.world.level.block.state.properties.IntegerProperty;
//
//public class MembraneLamp extends BlockCyclic {
//
//  public static final IntegerProperty POWER = BlockStateProperties.POWER;
//
//  public MembraneLamp(Properties properties) {
//    super(properties.lightLevel(state -> {
//      return state.getValue(POWER);
//    }).noOcclusion());
//  }
//
//  @Override
//  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
//    builder.add(POWER);
//  }
//
//  @Override
//  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
//    return new MembraneLampTile(pos, state);
//  }
//
//  @Override
//  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
//    return createTickerHelper(type, TileRegistry.LAMP.get(), world.isClientSide ? MembraneLampTile::clientTick : MembraneLampTile::serverTick);
//  }
//  //  @Override
//  //  public VoxelShape getVisualShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
//  //    return Shapes.block();
//  //  }
//
//  @Override
//  public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
//    return true;
//  }
//}
