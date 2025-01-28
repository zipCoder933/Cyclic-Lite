package com.lothrazar.cyclic.event;

import com.lothrazar.cyclic.api.IEntityInteractable;
import com.lothrazar.cyclic.block.scaffolding.ItemScaffolding;
import com.lothrazar.cyclic.item.SleepingMatItem;
import com.lothrazar.cyclic.item.bauble.CharmBase;
import com.lothrazar.cyclic.item.builder.BuilderActionType;
import com.lothrazar.cyclic.item.builder.BuilderItem;
import com.lothrazar.cyclic.item.elemental.AntimatterEvaporatorWandItem;
import com.lothrazar.cyclic.item.equipment.GlowingHelmetItem;
import com.lothrazar.cyclic.item.equipment.ShieldCyclicItem;
import com.lothrazar.cyclic.registry.ItemRegistry;
import com.lothrazar.cyclic.registry.SoundRegistry;
import com.lothrazar.cyclic.util.CharmUtil;
import com.lothrazar.library.util.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingTickEvent;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ItemEvents {

    @SubscribeEvent
    public void onShieldBlock(ShieldBlockEvent event) {
    }

    @SubscribeEvent
    public void onLivingJumpEvent(LivingJumpEvent event) {
    }

    @SubscribeEvent
    public void onCriticalHitEvent(CriticalHitEvent event) {
    }

    @SubscribeEvent
    public void onArrowLooseEvent(ArrowLooseEvent event) {
    }

    @SubscribeEvent
    public void onLivingKnockBackEvent(LivingKnockBackEvent event) {
        if (event.getEntity() instanceof Player) {
            Player ply = (Player) event.getEntity();
            if (ply.isBlocking()) {
                //Shield blocking
                ItemStack held = ply.getItemInHand(ply.getUsedItemHand());
                if (held.getItem() instanceof ShieldCyclicItem shieldType) {
                    shieldType.onKnockback(event);
                }
            }
        }
    }

    @SubscribeEvent
    public void onProjectileImpactEvent(ProjectileImpactEvent event) {
    }

    @SubscribeEvent
    public void onPotionAddedEvent(MobEffectEvent.Added event) {
        if (event.getEntity() instanceof Player) {
            Player ply = (Player) event.getEntity();
            ItemStack find;
//       find = CharmUtil.getIfEnabled(ply, ItemRegistry.CHARM_ANTIPOTION.get());
//      if (!find.isEmpty()) {
//        event.getEffectInstance().duration = 0;
//        ItemStackUtil.damageItem(ply, find);
//      }
            find = CharmUtil.getIfEnabled(ply, ItemRegistry.CHARM_STEALTHPOTION.get());
            if (!find.isEmpty()) {
                if (event.getOldEffectInstance() != null) {
                    event.getOldEffectInstance().visible = false;
                }
                event.getEffectInstance().visible = false;
            }
//            find = CharmUtil.getIfEnabled(ply, ItemRegistry.CHARM_BOOSTPOTION.get());
//            if (!find.isEmpty()) {
//                int boost = event.getEffectInstance().duration / 2;
//                event.getEffectInstance().duration += boost;
//                ItemStackUtil.damageItem(ply, find);
//            }
        }
    }

    @SubscribeEvent
    public void onEntityDamage(LivingDamageEvent event) {
        DamageSource src = event.getSource();
        if (event.getEntity() instanceof Player player) {

            if (src.is(DamageTypes.MAGIC) || src.is(DamageTypes.DRAGON_BREATH)) {
                this.damageFinder(event, player, ItemRegistry.CHARM_MAGICDEF.get(), 0.5F);
            } else if (src.is(DamageTypes.STARVE)) {
                if (this.damageFinder(event, player, ItemRegistry.CHARM_STARVATION.get(), 0)) {
                    player.getFoodData().eat(0, 0.2F);
                }
            }

        }
    }

    private boolean damageFinder(LivingDamageEvent event, Player player, Item item, float factor) {
        ItemStack find = CharmUtil.getIfEnabled(player, item);
        if (!find.isEmpty()) {
            float amt = event.getAmount() * factor;
            event.setAmount(amt);
            if (amt <= 0) {
                event.setCanceled(true);
            }
            ItemStackUtil.damageItem(player, find);
            return true;
        }
        return false;
    }

    @SubscribeEvent
    public void onPlayerDeath(LivingDeathEvent event) {
    }

    @SubscribeEvent
    public void onPlayerCloneDeath(PlayerEvent.Clone event) {
        AttributeInstance original = event.getOriginal().getAttribute(Attributes.MAX_HEALTH);
        if (original != null) {
            AttributeModifier healthModifier = original.getModifier(AttributesUtil.DEFAULT_ID);
            if (healthModifier != null) {
                event.getEntity().getAttribute(Attributes.MAX_HEALTH).addPermanentModifier(healthModifier);
            }
        }
    }

    @SubscribeEvent
    public void onEntityUpdate(LivingTickEvent event) {
        LivingEntity liv = event.getEntity();
        if (liv instanceof Player player) {
            CharmBase.onEntityUpdate(player);
//            LoftyStatureApple.onUpdate(player);
            GlowingHelmetItem.onEntityUpdate(event);
        }
    }

    @SubscribeEvent
    public void onXpPickup(PlayerXpEvent.PickupXp event) {
    }

    @SubscribeEvent
    public void onBonemealEvent(BonemealEvent event) {
    }

    @SubscribeEvent
    public void onBedCheck(SleepingLocationCheckEvent event) {
        if (event.getEntity() instanceof Player) {
            Player p = (Player) event.getEntity();
            if (p.getPersistentData().getBoolean(SleepingMatItem.CYCLIC_SLEEPING)) {
                event.setResult(Result.ALLOW);
            }
        }
    }

    @SubscribeEvent
    public void onRightClickBlock(RightClickBlock event) {
        if (event.getItemStack().isEmpty()) {
            return;
        }
        Player player = event.getEntity();
        if (event.getItemStack().getItem() instanceof ItemScaffolding && player.isCrouching()) {
            scaffoldHit(event);
        }
    }

    private void scaffoldHit(RightClickBlock event) {
        ItemScaffolding item = (ItemScaffolding) event.getItemStack().getItem();
        Direction opp = event.getFace().getOpposite();
        BlockPos dest = LevelWorldUtil.nextReplaceableInDirection(event.getLevel(), event.getPos(), opp, 16, item.getBlock());
        if (event.getLevel().isEmptyBlock(dest)) {
            event.getLevel().setBlockAndUpdate(dest, item.getBlock().defaultBlockState());
            ItemStack stac = event.getEntity().getItemInHand(event.getHand());
            ItemStackUtil.shrink(event.getEntity(), stac);
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onEntityInteractEvent(EntityInteract event) {
        if (event.getItemStack().getItem() instanceof IEntityInteractable) {
            IEntityInteractable item = (IEntityInteractable) event.getItemStack().getItem();
            item.interactWith(event);
        }
    }

    @SubscribeEvent
    public void onHit(PlayerInteractEvent.LeftClickBlock event) {
        Player player = event.getEntity();
        ItemStack held = player.getItemInHand(event.getHand());
        Level world = player.getCommandSenderWorld();
        BlockState target = world.getBlockState(event.getPos());

        ///////////////// builders
        if (held.getItem() instanceof BuilderItem) {
            if (BuilderActionType.getTimeout(held) > 0) {
                //without a timeout, this fires every tick. so you 'hit once' and get this happening 6 times
                return;
            }
            BuilderActionType.setTimeout(held);
            event.setCanceled(true);
            if (player.isCrouching()) {
                //pick out target block
                BuilderActionType.setBlockState(held, target);
                ChatUtil.sendStatusMessage(player, target.getBlock().getDescriptionId());
                event.setCanceled(true);
                SoundUtil.playSound(player, SoundRegistry.DCOIN.get(), 0.3F, 1F);
            } else {
                //change size
                if (!world.isClientSide) {
                    BuilderActionType.toggle(held);
                }
                SoundUtil.playSound(player, SoundRegistry.TOOL_MODE.get());
                ChatUtil.sendStatusMessage(player, ChatUtil.lang(BuilderActionType.getName(held)));
                event.setCanceled(true);
            }
        }
        if (held.getItem() instanceof AntimatterEvaporatorWandItem) {
            AntimatterEvaporatorWandItem.toggleMode(player, held);
        }
    }

    @SubscribeEvent
    public void onPlayerPickup(EntityItemPickupEvent event) {
    }
}
