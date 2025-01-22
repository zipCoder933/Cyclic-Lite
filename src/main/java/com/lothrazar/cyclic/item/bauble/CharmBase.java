package com.lothrazar.cyclic.item.bauble;

import java.util.UUID;
import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.config.ConfigRegistry;
import com.lothrazar.cyclic.registry.ItemRegistry;
import com.lothrazar.cyclic.util.CharmUtil;
import com.lothrazar.library.core.Const;
import com.lothrazar.library.util.EntityUtil;
import com.lothrazar.library.util.ItemStackUtil;
import com.lothrazar.library.util.ParticleUtil;
import com.lothrazar.library.util.SoundUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;

public abstract class CharmBase extends ItemBaseToggle {

  private static final int FIREPROTSECONDS = 10;
  private static final int FALLDISTANCESECONDS = 5;
  private static final int FALLDISTANCELIMIT = 5; // was 6 in 1.12.2
  public static final UUID ID_SPEED = UUID.fromString("12230aa2-eff2-4a81-b92b-a1cb95f115c6");
  public static final UUID ID_SWIMMING = UUID.fromString("92230aa2-eff2-4a81-b92b-a1cb95f115c6");
  public static final UUID ID_LUCK = UUID.fromString("acc30aa2-eff2-4a81-b92b-a1cb95f115c6");
  public static final UUID ID_ATTACKSPEED = UUID.fromString("b4678aa2-eff2-4a81-b92b-a1cb95f115c6");
  boolean fireProt;
  boolean poisonProt;
  boolean witherProt;
  boolean voidProt;
  boolean wingCharm;
  boolean sailboatCharm;

  public CharmBase(Properties properties) {
    super(properties);
  }

  @Override
  public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
    if (!this.canUse(stack)) {
      return;
    }
    if (!this.isOn(stack)) {
      return;
    }
    tryVoidTick(stack, worldIn, entityIn);
    if (entityIn instanceof LivingEntity == false) {
      return;
    }
    if (!this.isOn(stack)) {
      return;
    }
    LivingEntity living = (LivingEntity) entityIn;
    tryPoisonTick(stack, entityIn, living);
    tryWitherTick(stack, entityIn, living);
    tryWingTick(stack, entityIn, living);
    tryFireTick(stack, living);
  }

  private void tryWingTick(ItemStack stack, Entity entityIn, LivingEntity living) {
    if (this.wingCharm && living.fallDistance > FALLDISTANCELIMIT && !living.hasEffect(MobEffects.SLOW_FALLING)) {
      MobEffectInstance eff = new MobEffectInstance(MobEffects.SLOW_FALLING, FALLDISTANCESECONDS * Const.TICKS_PER_SEC, Const.Potions.I);
      living.addEffect(eff);
      ItemStackUtil.damageItem(living, stack);
      SoundUtil.playSound(living, SoundEvents.LADDER_FALL);
    }
  }

  private void tryFireTick(ItemStack stack, LivingEntity living) {
    if (this.fireProt && living.isOnFire() && !living.hasEffect(MobEffects.FIRE_RESISTANCE)) { // do nothing if you already have
      MobEffectInstance eff = new MobEffectInstance(MobEffects.FIRE_RESISTANCE, FIREPROTSECONDS * Const.TICKS_PER_SEC, Const.Potions.I);
      eff.visible = false;
      living.addEffect(eff);
      ItemStackUtil.damageItem(living, stack);
      SoundUtil.playSound(living, SoundEvents.FIRE_EXTINGUISH);
      ParticleUtil.spawnParticle(living.level(), ParticleTypes.DRIPPING_WATER, living.blockPosition(), 9);
    }
  }

  private void tryWitherTick(ItemStack stack, Entity entityIn, LivingEntity living) {
    if (this.witherProt && living.hasEffect(MobEffects.WITHER)) {
      living.removeEffectNoUpdate(MobEffects.WITHER);
      ItemStackUtil.damageItem(living, stack);
      SoundUtil.playSound(entityIn, SoundEvents.GENERIC_DRINK);
    }
  }

  private void tryPoisonTick(ItemStack stack, Entity entityIn, LivingEntity living) {
    if (this.poisonProt && living.hasEffect(MobEffects.POISON)) {
      living.removeEffectNoUpdate(MobEffects.POISON);
      ItemStackUtil.damageItem(living, stack);
      SoundUtil.playSound(entityIn, SoundEvents.GENERIC_DRINK);
    }
  }

  private void tryVoidTick(ItemStack stack, Level worldIn, Entity entityIn) {
    int minY = worldIn.dimensionType().minY();
    int maxY = worldIn.dimensionType().logicalHeight();
    if (this.voidProt && entityIn.blockPosition().getY() < (minY - 40) && entityIn instanceof LivingEntity) {
      LivingEntity entity = (LivingEntity) entityIn;
      EntityUtil.enderTeleportEvent(entity, worldIn, new BlockPos(entityIn.blockPosition().getX(), maxY, entityIn.blockPosition().getZ()));
      ItemStackUtil.damageItem(entity, stack);
      SoundUtil.playSound(entityIn, SoundEvents.ENDERMAN_TELEPORT);
    }
  }

  private static void toggleAttribute(Player player, Item charm, Attribute attr, UUID id, float factor, int flatIncrease, Operation op) {
    ItemStack charmStack = CharmUtil.getIfEnabled(player, charm);
    AttributeInstance attrPlayer = player.getAttribute(attr);
    AttributeModifier oldValue = attrPlayer.getModifier(id);
    if (charmStack.isEmpty()) {
      ///i am NOT holding it. OR im holding but its OFF
      //remove my modifier
      if (oldValue != null) {
        attrPlayer.removeModifier(id);
      }
    }
    else { // im   holding it AND its enabled
      if (oldValue == null) {
        /// add new
        double baseVal = attrPlayer.getBaseValue();
        AttributeModifier newValue = new AttributeModifier(id, "Bonus from " + ModCyclic.MODID, baseVal * factor + flatIncrease, op);
        attrPlayer.addPermanentModifier(newValue);
        //        ModCyclic.LOGGER.info(baseSpeed + " becinesNEW value " + newValue.getAmount() + " -> " + attrPlayer.getValue());
        ItemStackUtil.damageItem(player, charmStack);
      }
      //not newly triggered so countdown tick damage  
      ItemStackUtil.damageItemRandomly(player, charmStack);
    }
  }

  static final AttributeModifier.Operation ADD = AttributeModifier.Operation.ADDITION;
  static final AttributeModifier.Operation MUL = AttributeModifier.Operation.MULTIPLY_BASE;

  static void charmSpeed(Player player) {
    //toggleAttribute(player, ItemRegistry.CHARM_SPEED.get(), Attributes.MOVEMENT_SPEED, ID_SPEED, ConfigRegistry.CHARM_SPEED.get().floatValue(), 0, ADD);
  }

  static void charmLuck(Player player) {
    toggleAttribute(player, ItemRegistry.CHARM_LUCK.get(), Attributes.LUCK, ID_LUCK, 0, ConfigRegistry.CHARM_LUCK.get(), ADD);
  }

  static void charmAttackSpeed(Player player) {
//    toggleAttribute(player, ItemRegistry.CHARM_ATTACKSPEED.get(), Attributes.ATTACK_SPEED, ID_ATTACKSPEED, ConfigRegistry.CHARM_ATTACKSPEED.get().floatValue(), 0, ADD);
  }

  static void charmSwimming(Player player) {
    //toggleAttribute(player, ItemRegistry.FLIPPERS.get(), ForgeMod.SWIM_SPEED.get(), ID_SPEED, 3, 0, MUL);
  }

  static void charmGravity(Player player) {
    //    toggleAttribute(player, ItemRegistry.LESS_GRAVITY.get(), ForgeMod.ENTITY_GRAVITY.get(), ID_GRAVITY, -1, 0, ADD);
    //    toggleAttribute(player, ItemRegistry.MORE_GRAVITY.get(), ForgeMod.ENTITY_GRAVITY.get(), ID_GRAVITY, 4, 0, ADD);
  }

  static void charmExpSpeed(Player player) {
//    ItemStack charmStack = CharmUtil.getIfEnabled(player, ItemRegistry.CHARM_XPSPEED.get());
//    if (!charmStack.isEmpty()) {
//      player.takeXpDelay = 0;
//    }
  }

  public static void onEntityUpdate(Player player) {
    CharmBase.charmGravity(player);
    CharmBase.charmSwimming(player);
    CharmBase.charmSpeed(player);
    CharmBase.charmLuck(player);
    CharmBase.charmAttackSpeed(player);
    CharmBase.charmExpSpeed(player);
  }
}
