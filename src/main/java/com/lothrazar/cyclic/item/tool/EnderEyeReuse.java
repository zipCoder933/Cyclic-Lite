package com.lothrazar.cyclic.item.tool;

import com.lothrazar.cyclic.base.ItemBase;
import com.lothrazar.cyclic.util.UtilItemStack;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.item.EyeOfEnderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.EnderEyeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class EnderEyeReuse extends ItemBase {

  public EnderEyeReuse(Properties properties) {
    super(properties.maxDamage(256));
  }

  @Override
  public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity player, Hand hand) {
    ItemStack stack = player.getHeldItem(hand);
    if (!worldIn.isRemote) {
      EnderEyeItem x;
      //      BlockPos blockpos = worldIn.getChunkProvider().getChunkGenerator().findNearestStructure(worldIn, "Stronghold", new BlockPos(playerIn), 100, false);
      BlockPos blockpos = ((ServerWorld) worldIn).getChunkProvider().getChunkGenerator().findNearestStructure(worldIn, "Stronghold", new BlockPos(player), 100, false);
      if (blockpos != null) {
        double posX = player.func_226277_ct_();
        double posY = player.func_226278_cu_();
        double posZ = player.func_226281_cx_();
        EyeOfEnderEntity eyeofenderentity = new EyeOfEnderEntity(worldIn, posX, posY + player.getHeight() / 2.0F, posZ);
        eyeofenderentity.func_213863_b(new ItemStack(Items.ENDER_EYE));
        eyeofenderentity.moveTowards(blockpos);
        worldIn.addEntity(eyeofenderentity);
        if (player instanceof ServerPlayerEntity) {
          CriteriaTriggers.USED_ENDER_EYE.trigger((ServerPlayerEntity) player, blockpos);
        }
        worldIn.playSound((PlayerEntity) null, posX, posY, posZ, SoundEvents.ENTITY_ENDER_EYE_LAUNCH, SoundCategory.NEUTRAL, 0.5F,
            0.4F / (random.nextFloat() * 0.4F + 0.8F));
        worldIn.playEvent((PlayerEntity) null, 1003, new BlockPos(player), 0);
        if (!player.abilities.isCreativeMode) {
          //           stack.shrink(1);
          UtilItemStack.damageItem(stack);
        }
        player.addStat(Stats.ITEM_USED.get(this));
        player.getCooldownTracker().setCooldown(stack.getItem(), 10);
        //         return new ActionResult<>(ActionResultType.SUCCESS, stack);
      }
    }
    return super.onItemRightClick(worldIn, player, hand);
  }
}
