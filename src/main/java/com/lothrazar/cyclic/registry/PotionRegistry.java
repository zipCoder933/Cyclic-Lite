package com.lothrazar.cyclic.registry;

import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.library.recipe.BrewingRecipeFlib;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * When selecting potions that we want to keep, ONLY COMMENT THEM OUT ON THIS PAGE!
 */
public class PotionRegistry {

    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, ModCyclic.MODID);
    //TODO: ender aura - pearl + awkward - no pearl/tp dmg
    //TODO: bouncy - slime + ender above
    static final int normal = 3600;
    static final int smal = 1800;
    //  public static final RegistryObject<Potion> ANTIGRAVITY = POTIONS.register("antigravity", () -> new Potion(ModCyclic.MODID + "_antigravity", new MobEffectInstance(PotionEffectRegistry.ANTIGRAVITY.get(), normal, 3)));
    //public static final RegistryObject<Potion> ATTACK_RANGE = POTIONS.register("attack_range", () -> new Potion(ModCyclic.MODID + "_attack_range", new MobEffectInstance(PotionEffectRegistry.ATTACK_RANGE.get(), normal)));
    public static final RegistryObject<Potion> BLIND = POTIONS.register("blind", () -> new Potion(ModCyclic.MODID + "_blind", new MobEffectInstance(MobEffects.BLINDNESS, normal)));

    // public static final RegistryObject<Potion> GRAVITY = POTIONS.register("gravity", () -> new Potion(ModCyclic.MODID + "_gravity", new MobEffectInstance(PotionEffectRegistry.GRAVITY.get(), normal)));
    //public static final RegistryObject<Potion> HASTE = POTIONS.register("haste", () -> new Potion(ModCyclic.MODID + "_haste", new MobEffectInstance(MobEffects.DIG_SPEED, normal)));
    //public static final RegistryObject<Potion> HASTE_STRONG = POTIONS.register("strong_haste", () -> new Potion(ModCyclic.MODID + "_strong_haste", new MobEffectInstance(MobEffects.DIG_SPEED, smal, 1)));

//  public static final RegistryObject<Potion> HUNGER = POTIONS.register("hunger", () -> new Potion(ModCyclic.MODID + "_hunger", new MobEffectInstance(MobEffects.HUNGER, normal)));
//  public static final RegistryObject<Potion> STRONG_HUNGER = POTIONS.register("strong_hunger", () -> new Potion(ModCyclic.MODID + "_strong_hunger", new MobEffectInstance(MobEffects.HUNGER, smal, 1)));

    //  public static final RegistryObject<Potion> LEVITATION = POTIONS.register("levitation", () -> new Potion(ModCyclic.MODID + "_levitation", new MobEffectInstance(MobEffects.LEVITATION, smal)));

    public static final RegistryObject<Potion> MAGNETIC = POTIONS.register("magnetic", () -> new Potion(ModCyclic.MODID + "_magnetic", new MobEffectInstance(PotionEffectRegistry.MAGNETIC.get(), normal)));
    public static final RegistryObject<Potion> REACH_DISTANCE = POTIONS.register("reach_distance", () -> new Potion(ModCyclic.MODID + "_reach_distance", new MobEffectInstance(PotionEffectRegistry.REACH_DISTANCE.get(), normal)));

    //public static final RegistryObject<Potion> RESISTANCE = POTIONS.register("resistance", () -> new Potion(ModCyclic.MODID + "_resistance", new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, smal)));
//  public static final RegistryObject<Potion> STUN = POTIONS.register("stun", () -> new Potion(ModCyclic.MODID + "_stun", new MobEffectInstance(PotionEffectRegistry.STUN.get(), smal)));
//  public static final RegistryObject<Potion> SWIMSPEED = POTIONS.register("swimspeed", () -> new Potion(ModCyclic.MODID + "_swimspeed", new MobEffectInstance(PotionEffectRegistry.SWIMSPEED.get(), normal)));
    // public static final RegistryObject<Potion> FLIGHT = POTIONS.register("flight", () -> new Potion(ModCyclic.MODID + "_flight", new MobEffectInstance(PotionEffectRegistry.FLIGHT.get(), normal)));

//    public static final RegistryObject<Potion> FROST_WALKER = POTIONS.register("frost_walker", () -> new Potion(ModCyclic.MODID + "_frost_walker", new MobEffectInstance(PotionEffectRegistry.FROST_WALKER.get(), normal)));
//    public static final RegistryObject<Potion> SNOWWALK = POTIONS.register("snowwalk", () -> new Potion(ModCyclic.MODID + "_snow", new MobEffectInstance(PotionEffectRegistry.SNOWWALK.get(), smal)));
//    public static final RegistryObject<Potion> WATERWALK = POTIONS.register("waterwalk", () -> new Potion(ModCyclic.MODID + "_waterwalk", new MobEffectInstance(PotionEffectRegistry.WATERWALK.get(), smal)));

    // public static final RegistryObject<Potion> WITHER = POTIONS.register("wither", () -> new Potion(ModCyclic.MODID + "_wither", new MobEffectInstance(MobEffects.WITHER, smal)));


    public static void setup() {
        final ItemStack awkwardPotion = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD);
        final ItemStack thickPotion = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.THICK);
        // Potion recipes
        basicBrewing(PotionRegistry.BLIND.get(), PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.NIGHT_VISION), Items.BEETROOT);
        basicBrewing(PotionRegistry.MAGNETIC.get(), awkwardPotion.copy(), Items.LAPIS_LAZULI);
        basicBrewing(PotionRegistry.REACH_DISTANCE.get(), awkwardPotion.copy(), Items.AMETHYST_SHARD);

//      basicBrewing(PotionRegistry.HASTE.get(), awkwardPotion.copy(), Items.EMERALD);
//      basicBrewing(PotionRegistry.HASTE_STRONG.get(), PotionUtils.setPotion(new ItemStack(Items.POTION), PotionRegistry.HASTE.get()), Items.REDSTONE);
//
//      basicBrewing(PotionRegistry.STUN.get(), awkwardPotion.copy(), Items.CLAY);
//
//      basicBrewing(PotionRegistry.SWIMSPEED.get(), awkwardPotion.copy(), Items.DRIED_KELP_BLOCK);
//
//      basicBrewing(PotionRegistry.LEVITATION.get(), PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.SLOW_FALLING), Items.FERMENTED_SPIDER_EYE);
//
//      basicBrewing(PotionRegistry.RESISTANCE.get(), PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.STRENGTH), Items.IRON_INGOT);
//
//      basicBrewing(PotionRegistry.WITHER.get(), PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WEAKNESS), Items.NETHER_BRICK);
//
//      basicBrewing(PotionRegistry.HUNGER.get(), thickPotion.copy(), Items.ROTTEN_FLESH);
//      basicBrewing(PotionRegistry.STRONG_HUNGER.get(), PotionUtils.setPotion(new ItemStack(Items.POTION), HUNGER.get()), Items.REDSTONE);
//
//      basicBrewing(PotionRegistry.WATERWALK.get(), awkwardPotion.copy(), Items.PRISMARINE_SHARD);
//      basicBrewing(PotionRegistry.WATERWALK.get(), thickPotion.copy(), Items.COD);
//
//      basicBrewing(PotionRegistry.SNOWWALK.get(), awkwardPotion.copy(), Items.SNOWBALL);
//
//      basicBrewing(PotionRegistry.FROST_WALKER.get(), awkwardPotion.copy(), Blocks.ICE.asItem());
//
//      basicBrewing(PotionRegistry.GRAVITY.get(), PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LEAPING), Items.COPPER_INGOT);
//
//      basicBrewing(PotionRegistry.ATTACK_RANGE.get(), awkwardPotion.copy(), Blocks.POINTED_DRIPSTONE.asItem());
//
//      basicBrewing(PotionRegistry.ANTIGRAVITY.get(), PotionUtils.setPotion(new ItemStack(Items.POTION), PotionRegistry.GRAVITY.get()), Items.FERMENTED_SPIDER_EYE);
//
//      basicBrewing(PotionRegistry.FLIGHT.get(), PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.STRONG_HEALING), Items.CHORUS_FRUIT);
    }

    private static void basicBrewing(Potion output, ItemStack inputPot, Item item) {
        BrewingRecipeRegistry.addRecipe(new BrewingRecipeFlib(inputPot, Ingredient.of(item), PotionUtils.setPotion(new ItemStack(Items.POTION), output)));
    }
}
