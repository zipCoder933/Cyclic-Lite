package com.lothrazar.cyclic.block.scaffolding;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

/**
 * Replaceable and responsive
 */
public class BlockScaffoldingResponsive extends BlockScaffolding {

    public BlockScaffoldingResponsive(Properties properties, boolean autobreak) {
        super(properties, autobreak);
    }

    @Override
    @Deprecated
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        //If we are crouching, place instead of replacing
        if (player.isCrouching()) return super.use(state, world, pos, player, hand, hit);

        //Replace a block that is placed in it
        ItemStack heldItem = player.getItemInHand(hand);
        if (heldItem.isEmpty()) {
            return InteractionResult.SUCCESS;
        }
        Block b = Block.byItem(heldItem.getItem());
        if (b != null && b != Blocks.AIR && !(b instanceof BlockScaffolding)
                && world.getBlockState(pos).getBlock() == this) {
            world.destroyBlock(pos, true);
            UseOnContext context = new UseOnContext(player, hand, hit);
            heldItem.useOn(context);
            return InteractionResult.SUCCESS;
            //to cancel event chains
        }
        return InteractionResult.PASS;
    }

    @Override
    public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);
        if (blockIn == this) {
            worldIn.destroyBlock(pos, true);
        }
    }
}
