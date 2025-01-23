///*******************************************************************************
// * The MIT License (MIT)
// *
// * Copyright (C) 2014-2018 Sam Bassett (aka Lothrazar)
// *
// * Permission is hereby granted, free of charge, to any person obtaining a copy
// * of this software and associated documentation files (the "Software"), to deal
// * in the Software without restriction, including without limitation the rights
// * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// * copies of the Software, and to permit persons to whom the Software is
// * furnished to do so, subject to the following conditions:
// *
// * The above copyright notice and this permission notice shall be included in all
// * copies or substantial portions of the Software.
// *
// * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// * SOFTWARE.
// ******************************************************************************/
//package com.lothrazar.cyclic.block.scaffolding;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.context.UseOnContext;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.phys.BlockHitResult;
//
//public class BlockScaffoldingReplace extends BlockScaffolding {
//
//    public BlockScaffoldingReplace(Block.Properties prop) {
//        super(prop, false);
//    }
//
//    @Override
//    @Deprecated
//    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
//        //Replace a block that is placed in it
//        ItemStack heldItem = player.getItemInHand(hand);
//        if (heldItem.isEmpty()) {
//            return InteractionResult.SUCCESS;
//        }
//        Block b = Block.byItem(heldItem.getItem());
//        if (b != null && b != Blocks.AIR && !(b instanceof BlockScaffolding)
//                && world.getBlockState(pos).getBlock() == this) {
//            world.destroyBlock(pos, true);
//            UseOnContext context = new UseOnContext(player, hand, hit);
//            heldItem.useOn(context);
//            return InteractionResult.SUCCESS;
//            //to cancel event chains
//        }
//        return InteractionResult.PASS;
//    }
//
//    @Override
//    public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
//        super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);
//        if (blockIn == this) {
//            worldIn.destroyBlock(pos, true);
//        }
//    }
//}
