package com.lothrazar.cyclicmagic.item;
import java.util.List;
import com.lothrazar.cyclicmagic.IHasConfig;
import com.lothrazar.cyclicmagic.IHasRecipe;
import com.lothrazar.cyclicmagic.ModMain;
import com.lothrazar.cyclicmagic.registry.CapabilityRegistry;
import com.lothrazar.cyclicmagic.registry.CapabilityRegistry.IPlayerExtendedProperties;
import com.lothrazar.cyclicmagic.util.Const;
import com.lothrazar.cyclicmagic.util.UtilChat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.event.entity.player.SleepingLocationCheckEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSleepingBag extends BaseTool implements IHasRecipe, IHasConfig {
  // thank you for the examples forge. player data storage based on API source
  // https://github.com/MinecraftForge/MinecraftForge/blob/1.9/src/test/java/net/minecraftforge/test/NoBedSleepingTest.java
  private static int seconds;
  private static final int levelBoost = Const.Potions.I;
  private static final int durability = 100;
  public static boolean doPotions;
  public ItemSleepingBag() {
    super(durability);
  }
  @Override
  public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
    if (!world.isRemote) {
      final EntityPlayer.SleepResult result = player.trySleep(player.getPosition());
      //			if(UtilWorld.isNight(world) == false){
      if (result == EntityPlayer.SleepResult.OK) {
        final IPlayerExtendedProperties sleep = CapabilityRegistry.getPlayerProperties(player);
        if (sleep != null) {
          sleep.setSleeping(true);
          if (doPotions) {
            player.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, seconds * Const.TICKS_PER_SEC, levelBoost));
            player.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, seconds * Const.TICKS_PER_SEC, levelBoost));
          }
          this.onUse(stack, player, world, hand);
        }
        else {
          //					ModMain.logger.error("NULL IPlayerExtendedProperties found");
          //should never happen... but just in case
          UtilChat.addChatMessage(player, "tile.bed.noSleep");
        }
        return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
      }
      else {
        UtilChat.addChatMessage(player, "tile.bed.noSleep");
      }
    }
    return ActionResult.newResult(EnumActionResult.PASS, stack);
  }
  @SubscribeEvent
  public void onBedCheck(SleepingLocationCheckEvent evt) {
    final IPlayerExtendedProperties sleep = evt.getEntityPlayer().getCapability(ModMain.CAPABILITYSTORAGE, null);
    if (sleep != null && sleep.isSleeping()) {
      evt.setResult(Result.ALLOW);
    }
  }
  @SubscribeEvent
  public void onWakeUp(PlayerWakeUpEvent evt) {
    final IPlayerExtendedProperties sleep = evt.getEntityPlayer().getCapability(ModMain.CAPABILITYSTORAGE, null);
    if (sleep != null) {
      sleep.setSleeping(false);
    }
  }
  @Override
  public void syncConfig(Configuration config) {
    seconds = config.getInt("SleepingMatPotion", Const.ConfigCategory.modpackMisc, 20, 0, 600, "Seconds of potion effect caused by using the sleeping mat");
  }
  @Override
  public void addRecipe() {
    GameRegistry.addShapelessRecipe(new ItemStack(this),
        new ItemStack(Blocks.WOOL, 1, EnumDyeColor.RED.getMetadata()),
        Items.LEATHER);
  }
}