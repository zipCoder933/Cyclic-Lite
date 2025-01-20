package com.lothrazar.cyclic.registry;

import java.util.ArrayList;
import java.util.List;

import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.block.battery.ItemBlockBattery;
import com.lothrazar.cyclic.block.batteryclay.ItemBlockClayBattery;
import com.lothrazar.cyclic.block.cable.CableWrench;
//import com.lothrazar.cyclic.block.expcollect.ExpItemGain;
//import com.lothrazar.cyclic.block.expcollect.ItemBlockPylon;
import com.lothrazar.cyclic.block.scaffolding.ItemScaffolding;
import com.lothrazar.cyclic.block.tank.ItemBlockTank;
import com.lothrazar.cyclic.block.tankcask.ItemBlockCask;
import com.lothrazar.cyclic.item.CarbonPaperItem;
import com.lothrazar.cyclic.item.ElevationWandItem;
//import com.lothrazar.cyclic.item.FluteItem;
import com.lothrazar.cyclic.item.GemstoneItem;
import com.lothrazar.cyclic.item.ItemBaseCyclic;
import com.lothrazar.cyclic.item.LaserItem;
import com.lothrazar.cyclic.item.OreProspector;
import com.lothrazar.cyclic.item.SleepingMatItem;
import com.lothrazar.cyclic.item.SpawnInspectorTool;
import com.lothrazar.cyclic.item.SpelunkerCaveFinder;
import com.lothrazar.cyclic.item.TeleporterWandItem;
import com.lothrazar.cyclic.item.WandHypnoItem;
import com.lothrazar.cyclic.item.animal.ItemHorseEmeraldJump;
import com.lothrazar.cyclic.item.animal.ItemHorseEnder;
import com.lothrazar.cyclic.item.animal.ItemHorseHealthDiamondCarrot;
import com.lothrazar.cyclic.item.animal.ItemHorseLapisVariant;
import com.lothrazar.cyclic.item.animal.ItemHorseRedstoneSpeed;
import com.lothrazar.cyclic.item.animal.ItemHorseToxic;
import com.lothrazar.cyclic.item.animal.StirrupsItem;
import com.lothrazar.cyclic.item.animal.StirrupsReverseItem;
import com.lothrazar.cyclic.item.bauble.AirAntiGravity;
import com.lothrazar.cyclic.item.bauble.AutoCaveTorchItem;
import com.lothrazar.cyclic.item.bauble.AutoTorchItem;
import com.lothrazar.cyclic.item.bauble.CharmAntidote;
import com.lothrazar.cyclic.item.bauble.CharmFire;
import com.lothrazar.cyclic.item.bauble.CharmInvisible;
import com.lothrazar.cyclic.item.bauble.CharmOverpowered;
import com.lothrazar.cyclic.item.bauble.CharmVoid;
import com.lothrazar.cyclic.item.bauble.CharmWing;
import com.lothrazar.cyclic.item.bauble.CharmWither;
import com.lothrazar.cyclic.item.bauble.GloveItem;
import com.lothrazar.cyclic.item.bauble.ItemBaseToggle;
//import com.lothrazar.cyclic.item.bauble.SoulstoneCharm;
//import com.lothrazar.cyclic.item.boomerang.BoomerangItem;
//import com.lothrazar.cyclic.item.boomerang.BoomerangItem.Boomer;
import com.lothrazar.cyclic.item.builder.BuildStyle;
import com.lothrazar.cyclic.item.builder.BuilderItem;
//import com.lothrazar.cyclic.item.crafting.CraftingBagItem;
import com.lothrazar.cyclic.item.crafting.simple.CraftingStickItem;
import com.lothrazar.cyclic.item.datacard.BlockstateCard;
import com.lothrazar.cyclic.item.datacard.EntityDataCard;
import com.lothrazar.cyclic.item.datacard.LocationGpsCard;
import com.lothrazar.cyclic.item.datacard.SettingsCard;
import com.lothrazar.cyclic.item.datacard.ShapeCard;
import com.lothrazar.cyclic.item.datacard.SoundCard;
import com.lothrazar.cyclic.item.datacard.filter.FilterCardItem;
import com.lothrazar.cyclic.item.elemental.AntimatterEvaporatorWandItem;
import com.lothrazar.cyclic.item.elemental.DarkFireballItem;
import com.lothrazar.cyclic.item.elemental.EvokerFangItem;
import com.lothrazar.cyclic.item.elemental.FireExtinguishItem;
import com.lothrazar.cyclic.item.elemental.FireScepter;
import com.lothrazar.cyclic.item.elemental.FireballItem;
//import com.lothrazar.cyclic.item.elemental.FishingMagicItem;
import com.lothrazar.cyclic.item.elemental.GlowingSpark;
import com.lothrazar.cyclic.item.elemental.IceWand;
import com.lothrazar.cyclic.item.elemental.LightningScepter;
import com.lothrazar.cyclic.item.elemental.SnowScepter;
import com.lothrazar.cyclic.item.elemental.TorchThrowingItem;
import com.lothrazar.cyclic.item.elemental.WaterSpreaderItem;
import com.lothrazar.cyclic.item.ender.EnderBagItem;
import com.lothrazar.cyclic.item.ender.EnderEyeReuseItem;
import com.lothrazar.cyclic.item.ender.EnderPearlMount;
import com.lothrazar.cyclic.item.ender.EnderPearlReuse;
import com.lothrazar.cyclic.item.ender.EnderWingItem;
import com.lothrazar.cyclic.item.ender.EnderWingSp;
//import com.lothrazar.cyclic.item.ender.ItemProjectileDungeon;
import com.lothrazar.cyclic.item.enderbook.EnderBookItem;
import com.lothrazar.cyclic.item.equipment.AmethystAxeItem;
import com.lothrazar.cyclic.item.equipment.AmethystHoeItem;
import com.lothrazar.cyclic.item.equipment.AmethystPickaxeItem;
import com.lothrazar.cyclic.item.equipment.AmethystShovelItem;
import com.lothrazar.cyclic.item.equipment.GlowingHelmetItem;
import com.lothrazar.cyclic.item.equipment.MattockItem;
import com.lothrazar.cyclic.item.equipment.RotatorItem;
import com.lothrazar.cyclic.item.equipment.ShearsMaterial;
import com.lothrazar.cyclic.item.equipment.ShieldCyclicItem;
import com.lothrazar.cyclic.item.equipment.ShieldCyclicItem.ShieldType;
import com.lothrazar.cyclic.item.food.AppleBuffs;
import com.lothrazar.cyclic.item.food.AppleChocolate;
import com.lothrazar.cyclic.item.food.EdibleFlightItem;
import com.lothrazar.cyclic.item.food.EdibleSpecItem;
import com.lothrazar.cyclic.item.food.EnderApple;
import com.lothrazar.cyclic.item.food.HeartItem;
import com.lothrazar.cyclic.item.food.HeartToxicItem;
import com.lothrazar.cyclic.item.food.LoftyStatureApple;
import com.lothrazar.cyclic.item.food.MilkBottle;
//import com.lothrazar.cyclic.item.food.inventorycake.ItemCakeInventory;
//import com.lothrazar.cyclic.item.lunchbox.ItemLunchbox;
import com.lothrazar.cyclic.item.magicnet.ItemMagicNet;
import com.lothrazar.cyclic.item.magicnet.ItemMobContainer;
import com.lothrazar.cyclic.item.missile.WandMissileItem;
import com.lothrazar.cyclic.item.random.RandomizerItem;
import com.lothrazar.cyclic.item.redstone.LeverRemote;
import com.lothrazar.cyclic.item.scythe.ScytheBrush;
import com.lothrazar.cyclic.item.scythe.ScytheForage;
import com.lothrazar.cyclic.item.scythe.ScytheHarvest;
import com.lothrazar.cyclic.item.scythe.ScytheLeaves;
import com.lothrazar.cyclic.item.slingshot.SlingshotItem;
//import com.lothrazar.cyclic.item.storagebag.ItemStorageBag;
import com.lothrazar.cyclic.item.torchthrow.ItemTorchThrower;
import com.lothrazar.cyclic.item.transporter.TileTransporterEmptyItem;
import com.lothrazar.cyclic.item.transporter.TileTransporterItem;
import com.lothrazar.cyclic.registry.MaterialRegistry.ToolMats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {

    public static List<ItemBaseCyclic> ITEMSFIXME = new ArrayList<>();
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModCyclic.MODID);
    static final int SMALLPOTIONDUR = 20 * 90; // 1:30
    static final int LARGEPOTIONDUR = 3 * 20 * 60; // 3:00
    static final float APPLESATUR = Foods.APPLE.getSaturationModifier();


    public static final RegistryObject<Item> APPLE_ENDER = ITEMS.register("apple_ender", () -> new EnderApple(new Item.Properties().food(new FoodProperties.Builder().nutrition(Foods.APPLE.getNutrition()).saturationMod(0).alwaysEat().build())));

    public static final RegistryObject<Item> APPLE_LOFTY_STATURE = ITEMS.register("apple_lofty_stature", () -> new LoftyStatureApple(new Item.Properties().food(new FoodProperties.Builder().nutrition(Foods.APPLE.getNutrition()).saturationMod(0).alwaysEat()
            .build())));

    public static final RegistryObject<Item> APPLE_HONEY = ITEMS.register("apple_honey", () -> new ItemBaseCyclic(new Item.Properties().food(new FoodProperties.Builder().nutrition(Foods.APPLE.getNutrition() * 2).saturationMod(APPLESATUR * 2)
            .build())));

    public static final RegistryObject<Item> APPLE_CHORUS = ITEMS.register("apple_chorus", () -> new AppleBuffs(new Item.Properties().food(new FoodProperties.Builder().nutrition(Foods.APPLE.getNutrition()).saturationMod(APPLESATUR)
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, LARGEPOTIONDUR, 1), 1)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, LARGEPOTIONDUR, 0), 1)
            .effect(() -> new MobEffectInstance(MobEffects.UNLUCK, LARGEPOTIONDUR, 1), 1)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, SMALLPOTIONDUR, 1), 1)
            .alwaysEat()
            .build())));

//    public static final RegistryObject<Item> APPLE_BONE = ITEMS.register("apple_bone", () -> new AppleBuffs(new Item.Properties().food(new FoodProperties.Builder().nutrition(Foods.APPLE.getNutrition()).saturationMod(APPLESATUR)
//            .effect(() -> new MobEffectInstance(MobEffects.JUMP, LARGEPOTIONDUR, 4 + 5), 1)
//            .effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, LARGEPOTIONDUR, 0), 1)
//            .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, LARGEPOTIONDUR, 2), 1)
//            .effect(() -> new MobEffectInstance(MobEffects.UNLUCK, LARGEPOTIONDUR, 0), 1)
//            .alwaysEat()
//            .build())));
//    public static final RegistryObject<Item> APPLE_PRISMARINE = ITEMS.register("apple_prismarine", () -> new AppleBuffs(new Item.Properties().food(new FoodProperties.Builder().nutrition(Foods.APPLE.getNutrition()).saturationMod(APPLESATUR)
//            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, LARGEPOTIONDUR, 0), 1)
//            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, LARGEPOTIONDUR, 0), 1)
//            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, LARGEPOTIONDUR, 0), 1)
//            .alwaysEat()
//            .build())));
//    public static final RegistryObject<Item> APPLE_LAPIS = ITEMS.register("apple_lapis", () -> new AppleBuffs(new Item.Properties().food(new FoodProperties.Builder().nutrition(Foods.APPLE.getNutrition()).saturationMod(APPLESATUR * 4)
//            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, LARGEPOTIONDUR, 0), 1)
//            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, LARGEPOTIONDUR, 0), 1)
//            .effect(() -> new MobEffectInstance(MobEffects.CONDUIT_POWER, LARGEPOTIONDUR, 0), 1)
//            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, LARGEPOTIONDUR, 0), 1)
//            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, LARGEPOTIONDUR, 0), 1)
//            .fast().alwaysEat()
//            .build())));
//    public static final RegistryObject<Item> APPLE_IRON = ITEMS.register("apple_iron", () -> new AppleBuffs(new Item.Properties().food(new FoodProperties.Builder().nutrition(Foods.APPLE.getNutrition()).saturationMod(APPLESATUR)
//            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, LARGEPOTIONDUR, 2), 1)
//            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, LARGEPOTIONDUR, 2), 1)
//            .fast().alwaysEat()
//            .build())));
//    public static final RegistryObject<Item> APPLE_DIAMOND = ITEMS.register("apple_diamond", () -> new AppleBuffs(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(1)
//            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, SMALLPOTIONDUR, 4), 1)
//            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, SMALLPOTIONDUR, 4), 1)
//            .fast().alwaysEat()
//            .build())));
//    public static final RegistryObject<Item> APPLE_EMERALD = ITEMS.register("apple_emerald", () -> new AppleBuffs(new Item.Properties().food(new FoodProperties.Builder().nutrition(Foods.APPLE.getNutrition() * 3).saturationMod(APPLESATUR)
//            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, SMALLPOTIONDUR, 2), 1)
//            .effect(() -> new MobEffectInstance(MobEffects.LUCK, SMALLPOTIONDUR, 1), 1)
//            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, SMALLPOTIONDUR, 1), 1)
//            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, SMALLPOTIONDUR, 1), 1)
//            .alwaysEat().build())));

    public static final RegistryObject<Item> APPLE_CHOCOLATE = ITEMS.register("apple_chocolate", () -> new AppleChocolate(new Item.Properties().food(new FoodProperties.Builder().nutrition(Foods.APPLE.getNutrition()).saturationMod(APPLESATUR * 2)
            .alwaysEat().build())));


    //Really useful items
    public static final RegistryObject<Item> GLOWING_HELMET = ITEMS.register("glowing_helmet", () -> new GlowingHelmetItem(MaterialRegistry.ArmorMats.GLOWING, ArmorItem.Type.HELMET, (new Item.Properties())));
    public static final RegistryObject<Item> CHARM_STEALTHPOTION = ITEMS.register("charm_stealthpotion", () -> new ItemBaseToggle(new Item.Properties().stacksTo(1)));

    //  public static final RegistryObject<Item> FLUIDHOPPER = ITEMS.register("hopper_fluid", () -> new BlockItem(BlockRegistry.FLUIDHOPPER.get(), new Item.Properties()));
//  public static final RegistryObject<Item> HOPPER = ITEMS.register("hopper", () -> new BlockItem(BlockRegistry.HOPPER.get(), new Item.Properties()));
//  public static final RegistryObject<Item> HOPPERGOLD = ITEMS.register("hopper_gold", () -> new BlockItem(BlockRegistry.HOPPERGOLD.get(), new Item.Properties()));
//  public static final RegistryObject<Item> ANVILVOID = ITEMS.register("anvil_void", () -> new BlockItem(BlockRegistry.ANVILVOID.get(), new Item.Properties()));
//  public static final RegistryObject<Item> FANSLAB = ITEMS.register("fan_slab", () -> new BlockItem(BlockRegistry.FANSLAB.get(), new Item.Properties()));
//    public static final RegistryObject<Item> ROTATOR = ITEMS.register("rotator", () -> new BlockItem(BlockRegistry.ROTATOR.get(), new Item.Properties()));



    public static final RegistryObject<Item> DETECTORMOON = ITEMS.register("detector_moon", () -> new BlockItem(BlockRegistry.DETECTORMOON.get(), new Item.Properties()));

    //    public static final RegistryObject<Item> DETECTORWEATHER = ITEMS.register("detector_weather", () -> new BlockItem(BlockRegistry.DETECTORWEATHER.get(), new Item.Properties()));
    //  public static final RegistryObject<Item> SPRINKLER = ITEMS.register("sprinkler", () -> new BlockItem(BlockRegistry.SPRINKLER.get(), new Item.Properties()));
//    public static final RegistryObject<Item> SHEARING = ITEMS.register("shearing", () -> new BlockItem(BlockRegistry.SHEARING.get(), new Item.Properties()));
//    public static final RegistryObject<Item> DOORBELL = ITEMS.register("doorbell", () -> new BlockItem(BlockRegistry.DOORBELL.get(), new Item.Properties()));


    //    public static final RegistryObject<Item> PROSPECTOR = ITEMS.register("prospector", () -> new OreProspector(new Item.Properties().durability(256)));
//    public static final RegistryObject<Item> ENDER_BOOK = ITEMS.register("ender_book", () -> new EnderBookItem(new Item.Properties().durability(8)));

    //Glass
    //public static final RegistryObject<Item> TERRAGLASS = ITEMS.register("terra_glass", () -> new BlockItem(BlockRegistry.TERRAGLASS.get(), new Item.Properties()));
    //public static final RegistryObject<Item> GLASS_CONNECTED = ITEMS.register("glass_connected", () -> new BlockItem(BlockRegistry.GLASS_CONNECTED.get(), new Item.Properties()));
    public static final RegistryObject<Item> DARK_GLASS = ITEMS.register("dark_glass", () -> new BlockItem(BlockRegistry.DARK_GLASS.get(), new Item.Properties()));
    public static final RegistryObject<Item> DARK_GLASS_CONNECTED = ITEMS.register("dark_glass_connected", () -> new BlockItem(BlockRegistry.DARK_GLASS_CONNECTED.get(), new Item.Properties()));


    //public static final RegistryObject<Item> ENDER_ITEM_SHELF = ITEMS.register("ender_item_shelf", () -> new BlockItem(BlockRegistry.ENDER_ITEM_SHELF.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPIKES_DIAMOND = ITEMS.register("spikes_diamond", () -> new BlockItem(BlockRegistry.SPIKES_DIAMOND.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPIKES_IRON = ITEMS.register("spikes_iron", () -> new BlockItem(BlockRegistry.SPIKES_IRON.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPIKES_CURSE = ITEMS.register("spikes_curse", () -> new BlockItem(BlockRegistry.SPIKES_CURSE.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPIKES_FIRE = ITEMS.register("spikes_fire", () -> new BlockItem(BlockRegistry.SPIKES_FIRE.get(), new Item.Properties()));


    public static final RegistryObject<Item> CABLE_WRENCH = ITEMS.register("cable_wrench", () -> new CableWrench(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_PIPE = ITEMS.register("item_pipe", () -> new BlockItem(BlockRegistry.ITEM_PIPE.get(), new Item.Properties()));

    //remove energy and fluid related items
//    public static final RegistryObject<Item> ENERGY_PIPE = ITEMS.register("energy_pipe", () -> new BlockItem(BlockRegistry.ENERGY_PIPE.get(), new Item.Properties()));
//    public static final RegistryObject<Item> FLUID_PIPE = ITEMS.register("fluid_pipe", () -> new BlockItem(BlockRegistry.FLUID_PIPE.get(), new Item.Properties()));
//    public static final RegistryObject<Item> TANK = ITEMS.register("tank", () -> new ItemBlockTank(BlockRegistry.TANK.get(), new Item.Properties()));

    //Remove wireless items
//    public static final RegistryObject<Item> WIRELESS_ENERGY = ITEMS.register("wireless_energy", () -> new BlockItem(BlockRegistry.WIRELESS_ENERGY.get(), new Item.Properties()));
//    public static final RegistryObject<Item> WIRELESS_ITEM = ITEMS.register("wireless_item", () -> new BlockItem(BlockRegistry.WIRELESS_ITEM.get(), new Item.Properties()));
//    public static final RegistryObject<Item> WIRELESS_FLUID = ITEMS.register("wireless_fluid", () -> new BlockItem(BlockRegistry.WIRELESS_FLUID.get(), new Item.Properties()));

//    public static final RegistryObject<Item> WIRELESS_TRANSMITTER = ITEMS.register("wireless_transmitter", () -> new BlockItem(BlockRegistry.WIRELESS_TRANSMITTER.get(), new Item.Properties()));
//    public static final RegistryObject<Item> WIRELESS_RECEIVER = ITEMS.register("wireless_receiver", () -> new BlockItem(BlockRegistry.WIRELESS_RECEIVER.get(), new Item.Properties()));


    //    public static final RegistryObject<Item> BUILD_SCEPTER = ITEMS.register("build_scepter", () -> new BuilderItem(new Item.Properties(), BuildStyle.NORMAL));
//    public static final RegistryObject<Item> REPLACE_SCEPTER = ITEMS.register("replace_scepter", () -> new BuilderItem(new Item.Properties(), BuildStyle.REPLACE));
//    public static final RegistryObject<Item> OFFSET_SCEPTER = ITEMS.register("offset_scepter", () -> new BuilderItem(new Item.Properties(), BuildStyle.OFFSET));
//    public static final RegistryObject<Item> RANDOMIZE_SCEPTER = ITEMS.register("randomize_scepter", () -> new RandomizerItem(new Item.Properties()));
//    public static final RegistryObject<Item> SPAWNINSPECTOR = ITEMS.register("spawn_inspector", () -> new SpawnInspectorTool(new Item.Properties().durability(256)));
//    public static final RegistryObject<Item> CHARM_WING = ITEMS.register("charm_wing", () -> new CharmWing(new Item.Properties().durability(64)));
    public static final RegistryObject<Item> SLINGSHOT = ITEMS.register("slingshot", () -> new SlingshotItem(new Item.Properties().durability(64)));
//    public static final RegistryObject<Item> SOULSTONE = ITEMS.register("soulstone", () -> new SoulstoneCharm(new Item.Properties().durability(8)));

    //    public static final RegistryObject<Item> INVENTORY_CAKE = ITEMS.register("inventory_cake", () -> new ItemCakeInventory(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(1).saturationMod(10).alwaysEat().build())));
    //  public static final RegistryObject<Item> SOUND_RECORDER = ITEMS.register("sound_recorder", () -> new BlockItem(BlockRegistry.SOUND_RECORDER.get(), new Item.Properties()));
//  public static final RegistryObject<Item> SOUND_PLAYER = ITEMS.register("sound_player", () -> new BlockItem(BlockRegistry.SOUND_PLAYER.get(), new Item.Properties()));
//    public static final RegistryObject<Item> GENERATOR_FUEL = ITEMS.register("generator_fuel", () -> new BlockItem(BlockRegistry.GENERATOR_FUEL.get(), new Item.Properties()));
//    public static final RegistryObject<Item> GENERATOR_FOOD = ITEMS.register("generator_food", () -> new BlockItem(BlockRegistry.GENERATOR_FOOD.get(), new Item.Properties()));
//    public static final RegistryObject<Item> GENERATOR_FLUID = ITEMS.register("generator_fluid", () -> new BlockItem(BlockRegistry.GENERATOR_FLUID.get(), new Item.Properties()));
//    public static final RegistryObject<Item> GENERATOR_ITEM = ITEMS.register("generator_item", () -> new BlockItem(BlockRegistry.GENERATOR_ITEM.get(), new Item.Properties()));
    //  public static final RegistryObject<Item> PACKAGER = ITEMS.register("packager", () -> new BlockItem(BlockRegistry.PACKAGER.get(), new Item.Properties()));
//    public static final RegistryObject<Item> SOUND_DATA = ITEMS.register("sound_data", () -> new SoundCard(new Item.Properties()));
    //  public static final RegistryObject<Item> MEMBRANE = ITEMS.register("membrane", () -> new BlockItem(BlockRegistry.MEMBRANE.get(), new Item.Properties()));
//  public static final RegistryObject<Item> LAMP = ITEMS.register("lamp", () -> new BlockItem(BlockRegistry.LAMP.get(), new Item.Properties()));
//  public static final RegistryObject<Item> SOIL = ITEMS.register("soil", () -> new BlockItem(BlockRegistry.SOIL.get(), new Item.Properties()));
//  public static final RegistryObject<Item> CLOUD = ITEMS.register("cloud", () -> new BlockItem(BlockRegistry.CLOUD.get(), new Item.Properties()));
//  public static final RegistryObject<Item> CLOUD_MEMBRANE = ITEMS.register("cloud_membrane", () -> new BlockItem(BlockRegistry.CLOUD_MEMBRANE.get(), new Item.Properties()));


    public static final RegistryObject<Item> MELTER = ITEMS.register("melter", () -> new BlockItem(BlockRegistry.MELTER.get(), new Item.Properties()));
    public static final RegistryObject<Item> SOLIDIFIER = ITEMS.register("solidifier", () -> new BlockItem(BlockRegistry.SOLIDIFIER.get(), new Item.Properties()));

    public static final RegistryObject<Item> GEM_OBSIDIAN = ITEMS.register("gem_obsidian", () -> new GemstoneItem(new Item.Properties()));
    public static final RegistryObject<Item> GEM_AMBER = ITEMS.register("gem_amber", () -> new GemstoneItem(new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_COBBLESTONE = ITEMS.register("compressed_cobblestone", () -> new BlockItem(BlockRegistry.COMPRESSED_COBBLESTONE.get(), new Item.Properties()));

    //Redundant
    //    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget", () -> new GemstoneItem(new Item.Properties()));
//    public static final RegistryObject<Item> NETHERITE_NUGGET = ITEMS.register("netherite_nugget", () -> new GemstoneItem(new Item.Properties()));
    //    public static final RegistryObject<Item> FLINT_BLOCK = ITEMS.register("flint_block", () -> new BlockItem(BlockRegistry.FLINT_BLOCK.get(), new Item.Properties()));
//    public static final RegistryObject<Item> OBSIDIAN_PRESSURE_PLATE = ITEMS.register("obsidian_pressure_plate", () -> new BlockItem(BlockRegistry.OBSIDIAN_PRESSURE_PLATE.get(), new Item.Properties()));
//    public static final RegistryObject<Item> GOLD_BARS = ITEMS.register("gold_bars", () -> new BlockItem(BlockRegistry.GOLD_BARS.get(), new Item.Properties()));
//    public static final RegistryObject<Item> GOLD_CHAIN = ITEMS.register("gold_chain", () -> new BlockItem(BlockRegistry.GOLD_CHAIN.get(), new Item.Properties()));
//    public static final RegistryObject<Item> GOLD_LANTERN = ITEMS.register("gold_lantern", () -> new BlockItem(BlockRegistry.GOLD_LANTERN.get(), new Item.Properties()));
//    public static final RegistryObject<Item> GOLD_SOUL_LANTERN = ITEMS.register("gold_soul_lantern", () -> new BlockItem(BlockRegistry.GOLD_SOUL_LANTERN.get(), new Item.Properties()));
//    public static final RegistryObject<Item> COPPER_BARS = ITEMS.register("copper_bars", () -> new BlockItem(BlockRegistry.COPPER_BARS.get(), new Item.Properties()));
//    public static final RegistryObject<Item> COPPER_CHAIN = ITEMS.register("copper_chain", () -> new BlockItem(BlockRegistry.COPPER_CHAIN.get(), new Item.Properties()));
//    public static final RegistryObject<Item> COPPER_LANTERN = ITEMS.register("copper_lantern", () -> new BlockItem(BlockRegistry.COPPER_LANTERN.get(), new Item.Properties()));
//    public static final RegistryObject<Item> COPPER_SOUL_LANTERN = ITEMS.register("copper_soul_lantern", () -> new BlockItem(BlockRegistry.COPPER_SOUL_LANTERN.get(), new Item.Properties()));
//    public static final RegistryObject<Item> COPPER_PRESSURE_PLATE = ITEMS.register("copper_pressure_plate", () -> new BlockItem(BlockRegistry.COPPER_PRESSURE_PLATE.get(), new Item.Properties()));
//    public static final RegistryObject<Item> NETHERITE_BARS = ITEMS.register("netherite_bars", () -> new BlockItem(BlockRegistry.NETHERITE_BARS.get(), new Item.Properties()));
//    public static final RegistryObject<Item> NETHERTIE_CHAIN = ITEMS.register("netherite_chain", () -> new BlockItem(BlockRegistry.NETHERTIE_CHAIN.get(), new Item.Properties()));
//    public static final RegistryObject<Item> NETHERITE_PRESSURE_PLATE = ITEMS.register("netherite_pressure_plate", () -> new BlockItem(BlockRegistry.NETHERITE_PRESSURE_PLATE.get(), new Item.Properties()));
//    public static final RegistryObject<Item> NETHERITE_LANTERN = ITEMS.register("netherite_lantern", () -> new BlockItem(BlockRegistry.NETHERITE_LANTERN.get(), new Item.Properties()));
//    public static final RegistryObject<Item> SPONGE_LAVA = ITEMS.register("sponge_lava", () -> new BlockItem(BlockRegistry.SPONGE_LAVA.get(), new Item.Properties()));
//    public static final RegistryObject<Item> SPONGE_MILK = ITEMS.register("sponge_milk", () -> new BlockItem(BlockRegistry.SPONGE_MILK.get(), new Item.Properties()));
//    public static final RegistryObject<Item> CRUSHER = ITEMS.register("crusher", () -> new BlockItem(BlockRegistry.CRUSHER.get(), new Item.Properties()));

    //Data cards
    public static final RegistryObject<Item> STATECARD = ITEMS.register("blockstate_data", () -> new BlockstateCard(new Item.Properties()));
    public static final RegistryObject<Item> LOCATION_DATA = ITEMS.register("location_data", () -> new LocationGpsCard(new Item.Properties()));
    //    public static final RegistryObject<Item> SETTINGS_DATA = ITEMS.register("settings_data", () -> new SettingsCard(new Item.Properties()));
    public static final RegistryObject<Item> SHAPE_DATA = ITEMS.register("shape_data", () -> new ShapeCard(new Item.Properties()));
//    public static final RegistryObject<Item> FILTER_DATA = ITEMS.register("filter_data", () -> new FilterCardItem(new Item.Properties()));
//    public static final RegistryObject<Item> ENTITY_DATA = ITEMS.register("entity_data", () -> new EntityDataCard(new Item.Properties()));


    //Flowers
    public static final RegistryObject<Item> FLOWER_CYAN = ITEMS.register("flower_cyan", () -> new BlockItem(BlockRegistry.FLOWER_CYAN.get(), new Item.Properties()));
    public static final RegistryObject<Item> FLOWER_PURPLE = ITEMS.register("flower_purple_tulip", () -> new BlockItem(BlockRegistry.FLOWER_PURPLE_TULIP.get(), new Item.Properties()));
    public static final RegistryObject<Item> FLOWER_BROWN = ITEMS.register("flower_absalon_tulip", () -> new BlockItem(BlockRegistry.FLOWER_ABSALON_TULIP.get(), new Item.Properties()));
    public static final RegistryObject<Item> FLOWER_LIME = ITEMS.register("flower_lime_carnation", () -> new BlockItem(BlockRegistry.FLOWER_LIME_CARNATION.get(), new Item.Properties()));

    //Candles
    public static final RegistryObject<Item> WATER_CANDLE = ITEMS.register("water_candle", () -> new BlockItem(BlockRegistry.WATER_CANDLE.get(), new Item.Properties()));
    public static final RegistryObject<Item> PEACE_CANDLE = ITEMS.register("peace_candle", () -> new BlockItem(BlockRegistry.PEACE_CANDLE.get(), new Item.Properties()));
    //  public static final RegistryObject<Item> TELEPORT = ITEMS.register("teleport", () -> new BlockItem(BlockRegistry.TELEPORT.get(), new Item.Properties()));
//    public static final RegistryObject<Item> STORAGE_BAG = ITEMS.register("storage_bag", () -> new ItemStorageBag(new Item.Properties().stacksTo(1).setNoRepair()));
//    public static final RegistryObject<Item> CRAFTING_BAG = ITEMS.register("crafting_bag", () -> new CraftingBagItem(new Item.Properties().stacksTo(1).setNoRepair()));
    public static final RegistryObject<Item> CRAFTING_STICK = ITEMS.register("crafting_stick", () -> new CraftingStickItem(new Item.Properties().stacksTo(1).setNoRepair()));
    public static final RegistryObject<Item> MOB_CONTAINER = ITEMS.register("mob_container", () -> new ItemMobContainer(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> TILE_TRANSPORTER_EMPTY = ITEMS.register("tile_transporter_empty", () -> new TileTransporterEmptyItem(new Item.Properties()));
    //    public static final RegistryObject<Item> TILE_TRANSPORTER = ITEMS.register("tile_transporter", () -> new TileTransporterItem(new Item.Properties()));
    public static final RegistryObject<Item> MAGIC_NET = ITEMS.register("magic_net", () -> new ItemMagicNet(new Item.Properties()));
    //    public static final RegistryObject<Item> BOOMERANG_STUN = ITEMS.register("boomerang_stun", () -> new BoomerangItem(Boomer.STUN, new Item.Properties().durability(256)));
//    public static final RegistryObject<Item> BOOMERANG_CARRY = ITEMS.register("boomerang_carry", () -> new BoomerangItem(Boomer.CARRY, new Item.Properties().durability(256)));
//    public static final RegistryObject<Item> BOOMERANG_DAMAGE = ITEMS.register("boomerang_damage", () -> new BoomerangItem(Boomer.DAMAGE, new Item.Properties().durability(256)));
//    public static final RegistryObject<Item> SPAWNER_SEEKER = ITEMS.register("spawner_seeker", () -> new ItemProjectileDungeon(new Item.Properties()));
//    public static final RegistryObject<Item> GLOVE_CLIMB = ITEMS.register("glove_climb", () -> new GloveItem(new Item.Properties().durability(256 * 8)));
//    public static final RegistryObject<Item> FLIPPERS = ITEMS.register("flippers", () -> new ItemBaseToggle(new Item.Properties().durability(256 * 4)));
    //    public static final RegistryObject<Item> HEART = ITEMS.register("heart", () -> new HeartItem(new Item.Properties().stacksTo(16)));
//    public static final RegistryObject<Item> HEART_EMPTY = ITEMS.register("heart_empty", () -> new HeartToxicItem(new Item.Properties().stacksTo(16)));
//    public static final RegistryObject<Item> CARBON_PAPER = ITEMS.register("carbon_paper", () -> new CarbonPaperItem(new Item.Properties()));


    //Scepters/wands
//    public static final RegistryObject<Item> WAND_HYPNO = ITEMS.register("wand_hypno", () -> new WandHypnoItem(new Item.Properties()));
//    public static final RegistryObject<Item> WAND_MISSILE = ITEMS.register("wand_missile", () -> new WandMissileItem(new Item.Properties()));
//    public static final RegistryObject<Item> EVOKER_FANG = ITEMS.register("evoker_fang", () -> new EvokerFangItem(new Item.Properties()));
//    public static final RegistryObject<Item> ICE_SCEPTER = ITEMS.register("ice_scepter", () -> new SnowScepter(new Item.Properties().durability(256)));
//    public static final RegistryObject<Item> FIRE_SCEPTER = ITEMS.register("fire_scepter", () -> new FireScepter(new Item.Properties().durability(256)));
//    public static final RegistryObject<Item> LIGHTNING_SCEPTER = ITEMS.register("lightning_scepter", () -> new LightningScepter(new Item.Properties().durability(256)));
//    public static final RegistryObject<Item> LASER = ITEMS.register("laser", () -> new BlockItem(BlockRegistry.LASER.get(), new Item.Properties()));
//    public static final RegistryObject<Item> LASER_CANNON = ITEMS.register("laser_cannon", () -> new LaserItem(new Item.Properties()));

    //Ender stuff
    public static final RegistryObject<Item> ENDER_BAG = ITEMS.register("ender_bag", () -> new EnderBagItem(new Item.Properties()));
//    public static final RegistryObject<Item> SPELL_WATER = ITEMS.register("spell_water", () -> new WaterSpreaderItem(new Item.Properties().durability(256)));
//    public static final RegistryObject<Item> SPELL_ICE = ITEMS.register("spell_ice", () -> new IceWand(new Item.Properties().durability(256)));
//    public static final RegistryObject<Item> TORCH_LAUNCHER = ITEMS.register("torch_launcher", () -> new ItemTorchThrower(new Item.Properties()));
//    public static final RegistryObject<Item> ENDER_EYE_REUSE = ITEMS.register("ender_eye_reuse", () -> new EnderEyeReuseItem(new Item.Properties()));
//    public static final RegistryObject<Item> ENDER_PEARL_REUSE = ITEMS.register("ender_pearl_reuse", () -> new EnderPearlReuse(new Item.Properties()));
//    public static final RegistryObject<Item> ENDER_PEARL_MOUNTED = ITEMS.register("ender_pearl_mounted", () -> new EnderPearlMount(new Item.Properties()));
//    public static final RegistryObject<Item> SPELUNKER = ITEMS.register("spelunker", () -> new SpelunkerCaveFinder(new Item.Properties().durability(256)));

    //Charms
    public static final RegistryObject<Item> CHORUS_FLIGHT = ITEMS.register("chorus_flight", () -> new EdibleFlightItem(new Item.Properties()));
    public static final RegistryObject<Item> CHORUS_SPECTRAL = ITEMS.register("chorus_spectral", () -> new EdibleSpecItem(new Item.Properties()));
//    public static final RegistryObject<Item> CHARM_LONGFALL = ITEMS.register("charm_longfall", () -> new ItemBaseToggle(new Item.Properties().durability(256 * 4)));
    public static final RegistryObject<Item> CHARM_CREEPER = ITEMS.register("charm_creeper", () -> new ItemBaseToggle(new Item.Properties().durability(256)));
    public static final RegistryObject<Item> CHARM_STONE = ITEMS.register("charm_stone", () -> new ItemBaseToggle(new Item.Properties().durability(256 * 4)));
    public static final RegistryObject<Item> CHARM_ANTIPOTION = ITEMS.register("charm_antipotion", () -> new ItemBaseToggle(new Item.Properties().durability(256)));
    public static final RegistryObject<Item> CHARM_BOOSTPOTION = ITEMS.register("charm_boostpotion", () -> new ItemBaseToggle(new Item.Properties().durability(256)));
    public static final RegistryObject<Item> CHARM_CRIT = ITEMS.register("charm_crit", () -> new ItemBaseToggle(new Item.Properties().durability(256 * 4)));
//    public static final RegistryObject<Item> QUIVER_DMG = ITEMS.register("quiver_damage", () -> new ItemBaseToggle(new Item.Properties().durability(256 * 4)));
//    public static final RegistryObject<Item> QUIVER_LIT = ITEMS.register("quiver_lightning", () -> new ItemBaseToggle(new Item.Properties().durability(256 * 4)));
//    public static final RegistryObject<Item> CLOAK_INVISIBLE = ITEMS.register("charm_invisible", () -> new CharmInvisible(new Item.Properties().durability(256 * 4)));
    public static final RegistryObject<Item> CHARM_MAGICDEF = ITEMS.register("charm_magicdefense", () -> new ItemBaseToggle(new Item.Properties().durability(256 * 4)));
    public static final RegistryObject<Item> CHARM_STARVATION = ITEMS.register("charm_starvation", () -> new ItemBaseToggle(new Item.Properties().durability(256 * 256)));
    public static final RegistryObject<Item> CHARM_VENOM = ITEMS.register("charm_venom", () -> new ItemBaseToggle(new Item.Properties().durability(256)));
    public static final RegistryObject<Item> CHARM_WATER = ITEMS.register("charm_water", () -> new ItemBaseToggle(new Item.Properties().durability(256)));
    public static final RegistryObject<Item> CHARM_SPEED = ITEMS.register("charm_speed", () -> new ItemBaseToggle(new Item.Properties().durability(256 * 4)));
    public static final RegistryObject<Item> CHARM_KNOCKBACK_RESIST = ITEMS.register("charm_knockback_resistance", () -> new ItemBaseToggle(new Item.Properties().durability(256)));
    public static final RegistryObject<Item> CHARM_LUCK = ITEMS.register("charm_luck", () -> new ItemBaseToggle(new Item.Properties().durability(256 * 4)));
    public static final RegistryObject<Item> CHARM_ATTACKSPEED = ITEMS.register("charm_attack_speed", () -> new ItemBaseToggle(new Item.Properties().durability(256 * 4)));
    public static final RegistryObject<Item> CHARM_XPSPEED = ITEMS.register("charm_xp_speed", () -> new ItemBaseToggle(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> CHARM_XPSTOPPER = ITEMS.register("charm_xp_blocker", () -> new ItemBaseToggle(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> CHARM_TORCH = ITEMS.register("charm_torch", () -> new AutoTorchItem(new Item.Properties().durability(256 * 4)));
//    public static final RegistryObject<Item> CHARM_TORCH_CAVE = ITEMS.register("charm_torch_cave", () -> new AutoCaveTorchItem(new Item.Properties().durability(256 * 4)));
//    public static final RegistryObject<Item> CHARM_HOME = ITEMS.register("charm_home", () -> new EnderWingItem(new Item.Properties().durability(256)));
    public static final RegistryObject<Item> CHARM_WORLD = ITEMS.register("charm_world", () -> new EnderWingSp(new Item.Properties().durability(256)));
//    public static final RegistryObject<Item> ANTIGRAVITY = ITEMS.register("antigravity", () -> new AirAntiGravity(new Item.Properties().durability(1024 * 4)));
    public static final RegistryObject<Item> CHARM_VOID = ITEMS.register("charm_void", () -> new CharmVoid(new Item.Properties().durability(64)));
//    public static final RegistryObject<Item> CHARM_ANTIDOTE = ITEMS.register("charm_antidote", () -> new CharmAntidote(new Item.Properties().durability(64)));
    public static final RegistryObject<Item> CHARM_FIRE = ITEMS.register("charm_fire", () -> new CharmFire(new Item.Properties().durability(64)));
//    public static final RegistryObject<Item> CHARM_WITHER = ITEMS.register("charm_wither", () -> new CharmWither(new Item.Properties().durability(64)));
//    public static final RegistryObject<Item> CHARM_ULTIMATE = ITEMS.register("charm_ultimate", () -> new CharmOverpowered(new Item.Properties().durability(256)));


//    public static final RegistryObject<Item> ELEVATION_WAND = ITEMS.register("elevation_wand", () -> new ElevationWandItem(new Item.Properties().durability(256)));
//    public static final RegistryObject<Item> TELEPORT_WAND = ITEMS.register("teleport_wand", () -> new TeleporterWandItem(new Item.Properties().durability(64)));
//    public static final RegistryObject<Item> SCYTHE_HARVEST = ITEMS.register("scythe_harvest", () -> new ScytheHarvest(new Item.Properties().durability(1024)));
//    public static final RegistryObject<Item> ANTIMATTER_WAND = ITEMS.register("antimatter_wand", () -> new AntimatterEvaporatorWandItem(new Item.Properties().durability(1024)));
//    public static final RegistryObject<Item> SHEARS_FLINT = ITEMS.register("shears_flint", () -> new ShearsMaterial(new Item.Properties().durability(64)));
//    public static final RegistryObject<Item> ROTATION_WAND = ITEMS.register("rotation_wand", () -> new RotatorItem(new Item.Properties().durability(256)));
//    public static final RegistryObject<Item> SCYTHE_BRUSH = ITEMS.register("scythe_brush", () -> new ScytheBrush(new Item.Properties().durability(256)));
//    public static final RegistryObject<Item> SCYTHE_FORAGE = ITEMS.register("scythe_forage", () -> new ScytheForage(new Item.Properties().durability(256)));
//    public static final RegistryObject<Item> SCYTHE_LEAVES = ITEMS.register("scythe_leaves", () -> new ScytheLeaves(new Item.Properties().durability(256)));
//    public static final RegistryObject<Item> STIRRUPS = ITEMS.register("stirrups", () -> new StirrupsItem(new Item.Properties().durability(256)));
//    public static final RegistryObject<Item> STIRRUPS_REVERSE = ITEMS.register("stirrups_reverse", () -> new StirrupsReverseItem(new Item.Properties().durability(256)));
//    public static final RegistryObject<Item> LEVER_REMOTE = ITEMS.register("lever_remote", () -> new LeverRemote(new Item.Properties().stacksTo(1)));
    //  public static final RegistryObject<Item> GHOST_PHANTOM = ITEMS.register("ghost_phantom", () -> new BlockItem(BlockRegistry.GHOST_PHANTOM.get(), new Item.Properties()));
//  public static final RegistryObject<Item> GHOST = ITEMS.register("ghost", () -> new BlockItem(BlockRegistry.GHOST.get(), new Item.Properties()));
    //    public static final RegistryObject<Item> APPLE_SPROUT = ITEMS.register("apple_sprout", () -> new BlockItem(BlockRegistry.APPLE_SPROUT.get(), new Item.Properties()));
//    public static final RegistryObject<Item> APPLE_SPROUT_DIAMOND = ITEMS.register("apple_sprout_diamond", () -> new BlockItem(BlockRegistry.APPLE_SPROUT_DIAMOND.get(), new Item.Properties()));
//    public static final RegistryObject<Item> APPLE_SPROUT_EMERALD = ITEMS.register("apple_sprout_emerald", () -> new BlockItem(BlockRegistry.APPLE_SPROUT_EMERALD.get(), new Item.Properties()));
//    public static final RegistryObject<Item> COMPUTER_SHAPE = ITEMS.register("computer_shape", () -> new BlockItem(BlockRegistry.COMPUTER_SHAPE.get(), new Item.Properties()));

    //Beacon
//    public static final RegistryObject<Item> BEACON = ITEMS.register("beacon", () -> new BlockItem(BlockRegistry.BEACON.get(), new Item.Properties()));
//    public static final RegistryObject<Item> ANTI_BEACON = ITEMS.register("anti_beacon", () -> new BlockItem(BlockRegistry.ANTI_BEACON.get(), new Item.Properties()));
    public static final RegistryObject<Item> BEACON_REDSTONE = ITEMS.register("beacon_redstone", () -> new BlockItem(BlockRegistry.BEACON_REDSTONE.get(), new Item.Properties()));


    //If anything, we can just remove the item from the registry
    //  public static final RegistryObject<Item> EYE_REDSTONE = ITEMS.register("eye_redstone", () -> new BlockItem(BlockRegistry.EYE_REDSTONE.get(), new Item.Properties()));
    public static final RegistryObject<Item> EYE_TELEPORT = ITEMS.register("eye_teleport", () -> new BlockItem(BlockRegistry.EYE_TELEPORT.get(), new Item.Properties()));
    //    public static final RegistryObject<Item> BATTERY_CLAY = ITEMS.register("battery_clay", () -> new ItemBlockClayBattery(BlockRegistry.BATTERY_CLAY.get(), new Item.Properties()));
//    public static final RegistryObject<Item> BATTERY = ITEMS.register("battery", () -> new ItemBlockBattery(BlockRegistry.BATTERY.get(), new Item.Properties()));
//    public static final RegistryObject<Item> PEAT_UNBAKED = ITEMS.register("peat_unbaked", () -> new BlockItem(BlockRegistry.PEAT_UNBAKED.get(), new Item.Properties()));
//    public static final RegistryObject<Item> PEAT_BAKED = ITEMS.register("peat_baked", () -> new BlockItem(BlockRegistry.PEAT_BAKED.get(), new Item.Properties()));
    //    public static final RegistryObject<Item> PEAT_FARM = ITEMS.register("peat_farm", () -> new BlockItem(BlockRegistry.PEAT_FARM.get(), new Item.Properties()));
    //  public static final RegistryObject<Item> PLACER = ITEMS.register("placer", () -> new BlockItem(BlockRegistry.PLACER.get(), new Item.Properties()));
//  public static final RegistryObject<Item> BREAKER = ITEMS.register("breaker", () -> new BlockItem(BlockRegistry.BREAKER.get(), new Item.Properties()));
//  public static final RegistryObject<Item> USER = ITEMS.register("user", () -> new BlockItem(BlockRegistry.USER.get(), new Item.Properties()));
//  public static final RegistryObject<Item> DROPPER = ITEMS.register("dropper", () -> new BlockItem(BlockRegistry.DROPPER.get(), new Item.Properties()));
//  public static final RegistryObject<Item> FORESTER = ITEMS.register("forester", () -> new BlockItem(BlockRegistry.FORESTER.get(), new Item.Properties()));
//    public static final RegistryObject<Item> MINER = ITEMS.register("miner", () -> new BlockItem(BlockRegistry.MINER.get(), new Item.Properties()));
//        public static final RegistryObject<Item> STRUCTURE = ITEMS.register("structure", () -> new BlockItem(BlockRegistry.STRUCTURE.get(), new Item.Properties()));
    //  public static final RegistryObject<Item> HARVESTER = ITEMS.register("harvester", () -> new BlockItem(BlockRegistry.HARVESTER.get(), new Item.Properties()));
//  public static final RegistryObject<Item> COLLECTOR = ITEMS.register("collector", () -> new BlockItem(BlockRegistry.COLLECTOR.get(), new Item.Properties()));
//    public static final RegistryObject<Item> COLLECTOR_FLUID = ITEMS.register("collector_fluid", () -> new BlockItem(BlockRegistry.COLLECTOR_FLUID.get(), new Item.Properties()));
//    public static final RegistryObject<Item> PLACER_FLUID = ITEMS.register("placer_fluid", () -> new BlockItem(BlockRegistry.PLACER_FLUID.get(), new Item.Properties()));
//    public static final RegistryObject<Item> CASK = ITEMS.register("cask", () -> new ItemBlockCask(BlockRegistry.CASK.get(), new Item.Properties()));
    //  public static final RegistryObject<Item> CRATE = ITEMS.register("crate", () -> new BlockItem(BlockRegistry.CRATE.get(), new Item.Properties()));
//  public static final RegistryObject<Item> MINI_CRATE = ITEMS.register("crate_mini", () -> new BlockItem(BlockRegistry.CRATE_MINI.get(), new Item.Properties()));
//    public static final RegistryObject<Item> CLOCK = ITEMS.register("clock", () -> new BlockItem(BlockRegistry.CLOCK.get(), new Item.Properties()));
    //  public static final RegistryObject<Item> PLATE_LAUNCH_REDSTONE = ITEMS.register("plate_launch_redstone", () -> new BlockItem(BlockRegistry.PLATE_LAUNCH_REDSTONE.get(), new Item.Properties()));
//  public static final RegistryObject<Item> PLATE_LAUNCH = ITEMS.register("plate_launch", () -> new BlockItem(BlockRegistry.PLATE_LAUNCH.get(), new Item.Properties()));
//    public static final RegistryObject<Item> DETECTOR_ITEM = ITEMS.register("detector_item", () -> new BlockItem(BlockRegistry.DETECTOR_ITEM.get(), new Item.Properties()));
//    public static final RegistryObject<Item> DETECTOR_ENTITY = ITEMS.register("detector_entity", () -> new BlockItem(BlockRegistry.DETECTOR_ENTITY.get(), new Item.Properties()));
    //    public static final RegistryObject<Item> SCREEN = ITEMS.register("screen", () -> new BlockItem(BlockRegistry.SCREEN.get(), new Item.Properties()));
    //  public static final RegistryObject<Item> UNCRAFTER = ITEMS.register("uncrafter", () -> new BlockItem(BlockRegistry.UNCRAFTER.get(), new Item.Properties()));
//  public static final RegistryObject<Item> FISHER = ITEMS.register("fisher", () -> new BlockItem(BlockRegistry.FISHER.get(), new Item.Properties()));
//  public static final RegistryObject<Item> DISENCHANTER = ITEMS.register("disenchanter", () -> new BlockItem(BlockRegistry.DISENCHANTER.get(), new Item.Properties()));
//  public static final RegistryObject<Item> FAN = ITEMS.register("fan", () -> new BlockItem(BlockRegistry.FAN.get(), new Item.Properties()));
//    public static final RegistryObject<Item> LIGHT_CAMO = ITEMS.register("light_camo", () -> new BlockItem(BlockRegistry.LIGHT_CAMO.get(), new Item.Properties()));
    //    public static final RegistryObject<Item> SOUNDPROOFING_GHOST = ITEMS.register("soundproofing_ghost", () -> new BlockItem(BlockRegistry.SOUNDPROOFING_GHOST.get(), new Item.Properties()));
    public static final RegistryObject<Item> SOUNDPROOFING = ITEMS.register("soundproofing", () -> new BlockItem(BlockRegistry.SOUNDPROOFING.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANVIL = ITEMS.register("anvil", () -> new BlockItem(BlockRegistry.ANVIL.get(), new Item.Properties()));
    //  public static final RegistryObject<Item> ANVIL_MAGMA = ITEMS.register("anvil_magma", () -> new BlockItem(BlockRegistry.ANVIL_MAGMA.get(), new Item.Properties()));
    //  public static final RegistryObject<Item> TRASH = ITEMS.register("trash", () -> new BlockItem(BlockRegistry.TRASH.get(), new Item.Properties()));
    public static final RegistryObject<Item> BATTERY_INFINITE = ITEMS.register("battery_infinite", () -> new BlockItem(BlockRegistry.BATTERY_INFINITE.get(), new Item.Properties()));
    //  public static final RegistryObject<Item> ITEM_INFINITE = ITEMS.register("item_infinite", () -> new BlockItem(BlockRegistry.ITEM_INFINITE.get(), new Item.Properties()));
//  public static final RegistryObject<Item> DICE = ITEMS.register("dice", () -> new BlockItem(BlockRegistry.DICE.get(), new Item.Properties()));
//    public static final RegistryObject<Item> TERRA_PRETA = ITEMS.register("terra_preta", () -> new BlockItem(BlockRegistry.TERRA_PRETA.get(), new Item.Properties()));
    //  public static final RegistryObject<Item> FIREPLACE = ITEMS.register("fireplace", () -> new BlockItem(BlockRegistry.FIREPLACE.get(), new Item.Properties()));
//    public static final RegistryObject<Item> CRAFTER = ITEMS.register("crafter", () -> new BlockItem(BlockRegistry.CRAFTER.get(), new Item.Properties()));
    public static final RegistryObject<Item> UNBREAKABLE_BLOCK = ITEMS.register("unbreakable_block", () -> new BlockItem(BlockRegistry.UNBREAKABLE_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> UNBREAKABLE_REACTIVE = ITEMS.register("unbreakable_reactive", () -> new BlockItem(BlockRegistry.UNBREAKABLE_REACTIVE.get(), new Item.Properties()));
    //  public static final RegistryObject<Item> CONVEYOR = ITEMS.register("conveyor", () -> new BlockItem(BlockRegistry.CONVEYOR.get(), new Item.Properties()));
//  public static final RegistryObject<Item> ENDER_SHELF = ITEMS.register("ender_shelf", () -> new BlockItem(BlockRegistry.ENDER_SHELF.get(), new Item.Properties()));
//  public static final RegistryObject<Item> ENDER_CONTROLLER = ITEMS.register("ender_controller", () -> new BlockItem(BlockRegistry.ENDER_CONTROLLER.get(), new Item.Properties()));
    public static final RegistryObject<Item> WORKBENCH = ITEMS.register("workbench", () -> new BlockItem(BlockRegistry.WORKBENCH.get(), new Item.Properties()));
//    public static final RegistryObject<Item> EXPERIENCE_PYLON = ITEMS.register("experience_pylon", () -> new ItemBlockPylon(BlockRegistry.EXPERIENCE_PYLON.get(), new Item.Properties()));
//    public static final RegistryObject<Item> EXPERIENCE_FOOD = ITEMS.register("experience_food", () -> new ExpItemGain(new Item.Properties()));
//    public static final RegistryObject<Item> PEAT_FUEL = ITEMS.register("peat_fuel", () -> new ItemBaseCyclic(new Item.Properties()));
//    public static final RegistryObject<Item> PEAT_FUEL_ENRICHED = ITEMS.register("peat_fuel_enriched", () -> new ItemBaseCyclic(new Item.Properties()));
//    public static final RegistryObject<Item> BIOMASS = ITEMS.register("biomass", () -> new ItemBaseCyclic(new Item.Properties()));

    //Useless stuff
//    public static final RegistryObject<Item> MATTOCK = ITEMS.register("mattock", () -> new MattockItem(Tiers.DIAMOND, new Item.Properties().durability(9000), 1));
//    public static final RegistryObject<Item> MATTOCK_NETHER = ITEMS.register("mattock_nether", () -> new MattockItem(Tiers.NETHERITE, new Item.Properties().durability(9001), 2));
//    public static final RegistryObject<Item> MATTOCK_STONE = ITEMS.register("mattock_stone", () -> new MattockItem(Tiers.STONE, new Item.Properties().durability(1024), 1));
//    public static final RegistryObject<Item> SLEEPING_MAT = ITEMS.register("sleeping_mat", () -> new SleepingMatItem(new Item.Properties()));

    //Durable shears
//    public static final RegistryObject<Item> SHEARS_OBSIDIAN = ITEMS.register("shears_obsidian", () -> new ShearsMaterial(new Item.Properties().durability(1024 * 1024)));

    //Scaffolding
    public static final RegistryObject<Item> SCAFFOLD_REPLACE = ITEMS.register("scaffold_replace", () -> new ItemScaffolding(BlockRegistry.SCAFFOLD_REPLACE.get(), new Item.Properties()));
    public static final RegistryObject<Item> SCAFFOLD_FRAGILE = ITEMS.register("scaffold_fragile", () -> new ItemScaffolding(BlockRegistry.SCAFFOLD_FRAGILE.get(), new Item.Properties()));
    public static final RegistryObject<Item> SCAFFOLD_RESPONSIVE = ITEMS.register("scaffold_responsive", () -> new ItemScaffolding(BlockRegistry.SCAFFOLD_RESPONSIVE.get(), new Item.Properties()));

    //    public static final RegistryObject<Item> CARROT_ENDER = ITEMS.register("carrot_ender", () -> new ItemHorseEnder(new Item.Properties()));
//    public static final RegistryObject<Item> DIAMOND_CARROT_HEALTH = ITEMS.register("diamond_carrot_health", () -> new ItemHorseHealthDiamondCarrot(new Item.Properties()));
//    public static final RegistryObject<Item> REDSTONE_CARROT_SPEED = ITEMS.register("redstone_carrot_speed", () -> new ItemHorseRedstoneSpeed(new Item.Properties()));
//    public static final RegistryObject<Item> EMERALD_CARROT_JUMP = ITEMS.register("emerald_carrot_jump", () -> new ItemHorseEmeraldJump(new Item.Properties()));
//    public static final RegistryObject<Item> LAPIS_CARROT_VARIANT = ITEMS.register("lapis_carrot_variant", () -> new ItemHorseLapisVariant(new Item.Properties()));
//    public static final RegistryObject<Item> TOXIC_CARROT = ITEMS.register("toxic_carrot", () -> new ItemHorseToxic(new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_BOOTS = ITEMS.register("crystal_boots", () -> new ArmorItem(MaterialRegistry.ArmorMats.GEMOBSIDIAN, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_HELMET = ITEMS.register("crystal_helmet", () -> new ArmorItem(MaterialRegistry.ArmorMats.GEMOBSIDIAN, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_CHESTPLATE = ITEMS.register("crystal_chestplate", () -> new ArmorItem(MaterialRegistry.ArmorMats.GEMOBSIDIAN, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_LEGGINGS = ITEMS.register("crystal_leggings", () -> new ArmorItem(MaterialRegistry.ArmorMats.GEMOBSIDIAN, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots", () -> new ArmorItem(MaterialRegistry.ArmorMats.EMERALD, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet", () -> new ArmorItem(MaterialRegistry.ArmorMats.EMERALD, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate", () -> new ArmorItem(MaterialRegistry.ArmorMats.EMERALD, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings", () -> new ArmorItem(MaterialRegistry.ArmorMats.EMERALD, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_PICKAXE = ITEMS.register("amethyst_pickaxe", () -> new AmethystPickaxeItem(MaterialRegistry.ToolMats.AMETHYST, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(MaterialRegistry.ToolMats.COPPER, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", () -> new PickaxeItem(MaterialRegistry.ToolMats.EMERALD, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_PICKAXE = ITEMS.register("crystal_pickaxe", () -> new PickaxeItem(MaterialRegistry.ToolMats.GEMOBSIDIAN, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> SANDSTONE_PICKAXE = ITEMS.register("sandstone_pickaxe", () -> new PickaxeItem(MaterialRegistry.ToolMats.SANDSTONE, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> NETHERBRICK_PICKAXE = ITEMS.register("netherbrick_pickaxe", () -> new PickaxeItem(MaterialRegistry.ToolMats.NETHERBRICK, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_AXE = ITEMS.register("amethyst_axe", () -> new AmethystAxeItem(MaterialRegistry.ToolMats.AMETHYST, 6.0F, -3.1F, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(MaterialRegistry.ToolMats.COPPER, 6.0F, -3.1F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe", () -> new AxeItem(MaterialRegistry.ToolMats.EMERALD, 5.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_AXE = ITEMS.register("crystal_axe", () -> new AxeItem(MaterialRegistry.ToolMats.GEMOBSIDIAN, 5.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> SANDSTONE_AXE = ITEMS.register("sandstone_axe", () -> new AxeItem(MaterialRegistry.ToolMats.SANDSTONE, 5.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> NETHERBRICK_AXE = ITEMS.register("netherbrick_axe", () -> new AxeItem(MaterialRegistry.ToolMats.NETHERBRICK, 5.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_HOE = ITEMS.register("amethyst_hoe", () -> new AmethystHoeItem(ToolMats.AMETHYST, -4, 0F, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe", () -> new HoeItem(ToolMats.COPPER, -4, 0F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe", () -> new HoeItem(ToolMats.EMERALD, -4, 0F, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_HOE = ITEMS.register("crystal_hoe", () -> new HoeItem(ToolMats.GEMOBSIDIAN, -4, 0F, new Item.Properties()));
    public static final RegistryObject<Item> SANDSTONE_HOE = ITEMS.register("sandstone_hoe", () -> new HoeItem(ToolMats.SANDSTONE, -4, 0F, new Item.Properties()));
    public static final RegistryObject<Item> NETHERBRICK_HOE = ITEMS.register("netherbrick_hoe", () -> new HoeItem(ToolMats.NETHERBRICK, -4, 0F, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_SHOVEL = ITEMS.register("amethyst_shovel", () -> new AmethystShovelItem(MaterialRegistry.ToolMats.AMETHYST, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(MaterialRegistry.ToolMats.COPPER, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel", () -> new ShovelItem(MaterialRegistry.ToolMats.EMERALD, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_SHOVEL = ITEMS.register("crystal_shovel", () -> new ShovelItem(MaterialRegistry.ToolMats.GEMOBSIDIAN, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> SANDSTONE_SHOVEL = ITEMS.register("sandstone_shovel", () -> new ShovelItem(MaterialRegistry.ToolMats.SANDSTONE, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> NETHERBRICK_SHOVEL = ITEMS.register("netherbrick_shovel", () -> new ShovelItem(MaterialRegistry.ToolMats.NETHERBRICK, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_SWORD = ITEMS.register("amethyst_sword", () -> new SwordItem(MaterialRegistry.ToolMats.AMETHYST, 3, -2.4F, (new Item.Properties())));
    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new SwordItem(MaterialRegistry.ToolMats.COPPER, 3, -2.4F, (new Item.Properties())));
    public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword", () -> new SwordItem(MaterialRegistry.ToolMats.EMERALD, 3, -2.4F, (new Item.Properties())));
    public static final RegistryObject<Item> CRYSTAL_SWORD = ITEMS.register("crystal_sword", () -> new SwordItem(MaterialRegistry.ToolMats.GEMOBSIDIAN, 3, -2.4F, (new Item.Properties())));
    public static final RegistryObject<Item> SANDSTONE_SWORD = ITEMS.register("sandstone_sword", () -> new SwordItem(MaterialRegistry.ToolMats.SANDSTONE, 3, -2.4F, (new Item.Properties())));
    public static final RegistryObject<Item> NETHERBRICK_SWORD = ITEMS.register("netherbrick_sword", () -> new SwordItem(MaterialRegistry.ToolMats.NETHERBRICK, 3, -2.4F, (new Item.Properties())));
    public static final RegistryObject<Item> SHIELD_WOOD = ITEMS.register("shield_wood", () -> new ShieldCyclicItem(new Item.Properties().durability(84), ShieldType.WOOD));
    public static final RegistryObject<Item> SHIELD_LEATHER = ITEMS.register("shield_leather", () -> new ShieldCyclicItem(new Item.Properties().durability(168), ShieldType.LEATHER));
    public static final RegistryObject<Item> SHIELD_FLINT = ITEMS.register("shield_flint", () -> new ShieldCyclicItem(new Item.Properties().durability(168 + 84), ShieldType.FLINT));
    public static final RegistryObject<Item> SHIELD_OBSIDIAN = ITEMS.register("shield_obsidian", () -> new ShieldCyclicItem(new Item.Properties().durability(168 * 8), ShieldType.OBSIDIAN));
    public static final RegistryObject<Item> SHIELD_BONE = ITEMS.register("shield_bone", () -> new ShieldCyclicItem(new Item.Properties().durability(168 + 84), ShieldType.BONE));
    public static final RegistryObject<Item> FIRE_KILLER = ITEMS.register("fire_killer", () -> new FireExtinguishItem(new Item.Properties()));
    public static final RegistryObject<Item> MILK_BOTTLE = ITEMS.register("milk_bottle", () -> new MilkBottle(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())));
    public static final RegistryObject<Item> FIREBALL_ORANGE = ITEMS.register("fireball", () -> new FireballItem(new Item.Properties()));


    //  public static final RegistryObject<Item> MAGNET_BLOCK = ITEMS.register("magnet_block", () -> new BlockItem(BlockRegistry.MAGNET_BLOCK.get(), new Item.Properties()));
//    public static final RegistryObject<Item> BUTTON_BASALT = ITEMS.register("button_basalt", () -> new BlockItem(BlockRegistry.BUTTON_BASALT.get(), new Item.Properties()));
//    public static final RegistryObject<Item> BUTTON_BLACKSTONE = ITEMS.register("button_blackstone", () -> new BlockItem(BlockRegistry.BUTTON_BLACKSTONE.get(), new Item.Properties()));
    public static final RegistryObject<Item> ALTAR_DESTRUCTION = ITEMS.register("altar_destruction", () -> new BlockItem(BlockRegistry.ALTAR_DESTRUCTION.get(), new Item.Properties()));
    public static final RegistryObject<Item> GENERATOR_SOLAR = ITEMS.register("generator_solar", () -> new BlockItem(BlockRegistry.GENERATOR_SOLAR.get(), new Item.Properties()));
    public static final RegistryObject<Item> NO_SOLICITING = ITEMS.register("no_soliciting", () -> new BlockItem(BlockRegistry.NO_SOLICITING.get(), new Item.Properties()));
    //    public static final RegistryObject<Item> FLUTE = ITEMS.register("flute_summoning", () -> new FluteItem(new Item.Properties()));
    //    public static final RegistryObject<Item> SPARK = ITEMS.register("spark", () -> new GlowingSpark(new Item.Properties()));
    public static final RegistryObject<Item> FIREBALL_DARK = ITEMS.register("fireball_dark", () -> new DarkFireballItem(new Item.Properties()));
    public static final RegistryObject<Item> WAXED_REDSTONE = ITEMS.register("waxed_redstone", () -> new BlockItem(BlockRegistry.WAXED_REDSTONE.get(), new Item.Properties()));
    //    public static final RegistryObject<Item> LUNCHBOX = ITEMS.register("lunchbox", () -> new ItemLunchbox(new Item.Properties()));
    //  public static final RegistryObject<Item> ENDER_FISHING = ITEMS.register("ender_fishing", () -> new FishingMagicItem(new Item.Properties()));
    public static final RegistryObject<Item> ENDER_TORCH = ITEMS.register("ender_torch", () -> new TorchThrowingItem(new Item.Properties()));
}
