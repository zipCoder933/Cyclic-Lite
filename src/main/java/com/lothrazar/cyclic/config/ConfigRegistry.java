package com.lothrazar.cyclic.config;

import com.lothrazar.cyclic.CyclicLogger;
import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.block.CandleWaterBlock;
import com.lothrazar.cyclic.block.LavaSpongeBlock;
import com.lothrazar.cyclic.block.PeatBlock;
import com.lothrazar.cyclic.block.antipotion.TileAntiBeacon;
import com.lothrazar.cyclic.block.anvil.TileAnvilAuto;
import com.lothrazar.cyclic.block.battery.TileBattery;
import com.lothrazar.cyclic.block.batteryclay.TileClayBattery;
import com.lothrazar.cyclic.block.beaconpotion.TilePotionBeacon;
import com.lothrazar.cyclic.block.cable.energy.TileCableEnergy;
import com.lothrazar.cyclic.block.cable.fluid.TileCableFluid;
import com.lothrazar.cyclic.block.eyetp.TileEyeTp;
import com.lothrazar.cyclic.block.generatorexpl.BlockDestruction;
import com.lothrazar.cyclic.block.generatorfood.TileGeneratorFood;
import com.lothrazar.cyclic.block.generatorfuel.TileGeneratorFuel;
import com.lothrazar.cyclic.block.generatorsolar.BlockGeneratorSolar;
import com.lothrazar.cyclic.block.terraglass.TileTerraGlass;
import com.lothrazar.cyclic.item.bauble.AutoCaveTorchItem;
import com.lothrazar.cyclic.item.bauble.AutoTorchItem;
import com.lothrazar.cyclic.item.elemental.IceWand;
import com.lothrazar.cyclic.item.elemental.WaterSpreaderItem;
import com.lothrazar.cyclic.item.food.EdibleFlightItem;
import com.lothrazar.cyclic.item.food.EdibleSpecItem;
import com.lothrazar.cyclic.item.food.EnderApple;
import com.lothrazar.cyclic.item.transporter.TileTransporterEmptyItem;
import com.lothrazar.cyclic.registry.CommandRegistry;
import com.lothrazar.cyclic.registry.CommandRegistry.CyclicCommands;
import com.lothrazar.cyclic.registry.MaterialRegistry;
import com.lothrazar.library.config.ConfigTemplate;
import com.lothrazar.library.util.StringParseUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

public class ConfigRegistry extends ConfigTemplate {

    private static ForgeConfigSpec COMMON_CONFIG;
    private static ForgeConfigSpec CLIENT_CONFIG;

    public void setupMain() {
        COMMON_CONFIG.setConfig(setup(ModCyclic.MODID));
    }

    public void setupClient() {
        CLIENT_CONFIG.setConfig(setup(ModCyclic.MODID + "-client"));
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ConfigRegistry.CLIENT_CONFIG);
    }

    // Defaults
    private static final List<String> BEHEADING = new ArrayList<>();
    private static final List<String> IGNORE_LIST_UNCRAFTER = new ArrayList<>();
    private static final List<String> MBALL_IGNORE = new ArrayList<>();
    private static final List<String> DISARM_IGNORE = new ArrayList<>();
    private static final List<String> TRANSPORTBAG = new ArrayList<>();
    private static final List<String> ENDERAPPLE = new ArrayList<>();
    private static ConfigValue<List<? extends String>> BEHEADING_SKINS;
    private static ConfigValue<List<? extends String>> MBALL_IGNORE_LIST;
    private static ConfigValue<List<? extends String>> DISARM_IGNORE_LIST;
    public static ConfigValue<List<? extends String>> GLOOM_IGNORE_LIST;
    private static final String WALL = "####################################################################################";
    public static IntValue CHARM_LUCK;
    public static DoubleValue CHARM_SPEED;
    public static DoubleValue CHARM_ATTACKSPEED;
    public static BooleanValue OVERRIDE_TRANSPORTER_SINGLETON;
    public static BooleanValue GENERATE_FLOWERS;
    public static BooleanValue TRANSFER_NODES_DIMENSIONAL;
    public static IntValue SOUND_RADIUS;
    public static IntValue RECORDER_RADIUS;
    public static IntValue LaserItemRange;
    public static IntValue LaserItemDamageClose;
    public static IntValue LaserItemDamageFar;
    public static IntValue LaserItemEnergy;
    public static BooleanValue LaserRenderMisses;

    static {
        buildDefaults();
        initConfig();
    }

    private static void buildDefaults() {
        //http://minecraft.gamepedia.com/Player.dat_format#Player_Heads
        //mhf https://twitter.com/Marc_IRL/status/542330244473311232  https://pastebin.com/5mug6EBu
        //other https://www.planetminecraft.com/blog/minecraft-playerheads-2579899/
        //NBT image data from  http://www.minecraft-heads.com/custom/heads/animals/6746-llama
        BEHEADING.add("minecraft:blaze:MHF_Blaze");
        BEHEADING.add("minecraft:cat:MHF_Ocelot");
        BEHEADING.add("minecraft:cave_spider:MHF_CaveSpider");
        BEHEADING.add("minecraft:chicken:MHF_Chicken");
        BEHEADING.add("minecraft:cow:MHF_Cow");
        BEHEADING.add("minecraft:enderman:MHF_Enderman");
        BEHEADING.add("minecraft:ghast:MHF_Ghast");
        BEHEADING.add("minecraft:iron_golem:MHF_Golem");
        BEHEADING.add("minecraft:magma_cube:MHF_LavaSlime");
        BEHEADING.add("minecraft:mooshroom:MHF_MushroomCow");
        BEHEADING.add("minecraft:ocelot:MHF_Ocelot");
        BEHEADING.add("minecraft:pig:MHF_Pig");
        BEHEADING.add("minecraft:zombie_pigman:MHF_PigZombie");
        BEHEADING.add("minecraft:sheep:MHF_Sheep");
        BEHEADING.add("minecraft:slime:MHF_Slime");
        BEHEADING.add("minecraft:spider:MHF_Spider");
        BEHEADING.add("minecraft:squid:MHF_Squid");
        BEHEADING.add("minecraft:villager:MHF_Villager");
        BEHEADING.add("minecraft:witch:MHF_Witch");
        BEHEADING.add("minecraft:wolf:MHF_Wolf");
        BEHEADING.add("minecraft:guardian:MHF_Guardian");
        BEHEADING.add("minecraft:elder_guardian:MHF_Guardian");
        BEHEADING.add("minecraft:snow_golem:MHF_SnowGolem");
        BEHEADING.add("minecraft:silverfish:MHF_Silverfish");
        BEHEADING.add("minecraft:endermite:MHF_Endermite");
        //
        //
        TRANSPORTBAG.addAll(Arrays.asList(
                //legacy
                "parabox:parabox", "extracells:fluidcrafter", "extracells:ecbaseblock", "extracells:fluidfiller",
                //entire mods
                "exnihilosequentia:*", "refinedstorage:*",
                //tconctruct fluid processing
                "tconstruct:seared_fuel_tank", "tconstruct:smeltery_controller", "tconstruct:seared_drain", "tconstruct:seared_fuel_gauge", "tconstruct:seared_ingot_tank", "tconstruct:seared_ingot_gauge", "tconstruct:seared_melter", "tconstruct:seared_heater",
                //drains and ducts
                "tconstruct:scorched_drain", "tconstruct:scorched_duct", "tconstruct:scorched_chute", "tconstruct:foundry_controller", "tconstruct:scorched_alloyer",
                //rftools batteries
                "rftoolspower:cell3", "rftoolspower:cell2", "rftoolspower:cell1", "rftoolspower:cell3", "rftoolspower:cell2", "rftoolspower:cell1"));
        //
        MBALL_IGNORE.add("minecraft:ender_dragon");
        MBALL_IGNORE.add("minecraft:wither");
        DISARM_IGNORE.add("alexsmobs:mimicube");
        ENDERAPPLE.addAll(Arrays.asList(
                "minecraft:eye_of_ender_located",
                "minecraft:on_woodland_explorer_maps",
                "minecraft:on_ocean_explorer_maps",
                "minecraft:village"));
    }

    private static void initConfig() {
        final ForgeConfigSpec.Builder CFG = builder();
        CFG.comment(WALL, "Features with configurable properties are split into categories", WALL).push(ModCyclic.MODID);

//    CFG.comment(WALL, " Worldgen settings  ", WALL).push("worldgen"); //////////////////////////////////////////////////////////////////////////////////////////// worldgen
//    GENERATE_FLOWERS = CFG.comment(" Do the four generate in the world. "
//        + " If false, the 4 flower blocks and 3 features (flower_all, flower_tulip_ flower_lime) will still be registered and can be used externally (data packs etc), "
//        + "but the mod will not use the features to generate/place flowers in world-generation")
//        .define("flowers.enabled", false);

        CFG.comment(WALL, " Edit the permissions of all commands added by the mod.  false means anyone can use, true means only OP players can use  ", WALL)
                .push("command");
        CommandRegistry.COMMANDGETHOME = CFG.comment(" True means only players with OP can use this /cyclic command").define(CyclicCommands.GETHOME.toString(), false);
        CommandRegistry.COMMANDHEALTH = CFG.comment(" True means only players with OP can use this /cyclic command").define(CyclicCommands.HEALTH.toString(), true);
        CommandRegistry.COMMANDHOME = CFG.comment(" True means only players with OP can use this /cyclic command").define(CyclicCommands.HOME.toString(), true);
        CommandRegistry.COMMANDHUNGER = CFG.comment(" True means only players with OP can use this /cyclic command").define(CyclicCommands.HUNGER.toString(), true);
        CommandRegistry.COMMANDDEV = CFG.comment(" True means only players with OP can use this /cyclic command").define(CyclicCommands.DEV.toString(), false);
        CommandRegistry.COMMANDPING = CFG.comment(" True means only players with OP can use this /cyclic command").define(CyclicCommands.PING.toString(), false);
        CFG.pop(); //command

        CFG.comment(WALL, " Logging related configs", WALL)
                .push("logging");
        CyclicLogger.LOGINFO = CFG.comment(" Unblock info logs; very spammy; can be useful for testing certain issues").define("info", false);
        CFG.pop(); //logging
        CFG.comment(WALL, " Item specific configs", WALL)
                .push("items");
        //
        //laser_cannon
        CFG.push("laser_cannon");
        LaserItemRange = CFG.comment(" Maximum range to hit target").defineInRange("range", 6000, 1, 9999);
        LaserItemDamageClose = CFG.comment(" Damage dealt at point blank range").defineInRange("damage_close", 20, 1, Integer.MAX_VALUE);
        LaserItemDamageFar = CFG.comment(" Damage dealt when firing at range").defineInRange("damage_far", 12, 1, Integer.MAX_VALUE);
        LaserItemEnergy = CFG.comment(" Energy cost per firing; only drained when living targets are hit").defineInRange("energy", 10, 1, Integer.MAX_VALUE);
        LaserRenderMisses = CFG.comment(" Render the laser beam even when there is no living target (used to be hardcoded as false, so change this back to restore legacy behavior)").define("render_misses", true);
        CFG.pop();

        CFG.comment(WALL, " spell_water settings", WALL).push("spell_water");
        WaterSpreaderItem.RADIUS = CFG.comment(" Radius defines how far it reaches").defineInRange("radius", 3, 0, 32);
        CFG.pop();

        CFG.comment(WALL, " spell_ice settings", WALL).push("spell_ice");
        IceWand.RADIUS = CFG.comment(" Radius defines how far it reaches").defineInRange("radius", 3, 0, 32);
        CFG.pop();

        CFG.comment(" apple_ender settings").push("apple_ender");
        EnderApple.STRUCTURE_TAGS = CFG.comment(" Which structure tags are looked for").defineList("structure_tags", ENDERAPPLE, it -> it instanceof String);
        EnderApple.PRINTED = CFG.comment(" How many results the client will see").defineInRange("printed", 5, 1, 60);
        CFG.pop();

        CFG.comment(WALL, " Emerald gear settings", WALL).push("emerald");
        MaterialRegistry.EMERALD_DMG = CFG.comment(" Weapon damage").defineInRange("damage", 2.5F, 0.1F, 99F);
        MaterialRegistry.EMERALD_BOOTS = CFG.comment(" Damage Reduction").defineInRange("boots", 3, 1, 99);
        MaterialRegistry.EMERALD_HELM = CFG.comment(" Damage Reduction").defineInRange("helm", 2, 1, 99);
        MaterialRegistry.EMERALD_CHEST = CFG.comment(" Damage Reduction").defineInRange("chest", 9, 1, 99);
        MaterialRegistry.EMERALD_LEG = CFG.comment(" Damage Reduction").defineInRange("leg", 6, 1, 99);
        MaterialRegistry.EMERALD_TOUGH = CFG.comment(" Armor toughness").defineInRange("toughness", 2.5F, 0.1F, 99F);
        CFG.pop();
        CFG.comment(WALL, " Obsidian gear settings", WALL).push("obsidian");
        MaterialRegistry.OBS_TOUGH = CFG.comment(" Armor toughness").defineInRange("toughness", 6.0F, 0.1F, 999F);
        MaterialRegistry.OBS_DMG = CFG.comment(" Weapon damage").defineInRange("damage", 10.5F, 0.1F, 999F);
        MaterialRegistry.OBS_BOOTS = CFG.comment(" Damage Reduction").defineInRange("boots", 7, 1, 999);
        MaterialRegistry.OBS_HELM = CFG.comment(" Damage Reduction").defineInRange("helm", 7, 1, 999);
        MaterialRegistry.OBS_CHEST = CFG.comment(" Damage Reduction").defineInRange("chest", 11, 1, 999);
        MaterialRegistry.OBS_LEG = CFG.comment(" Damage Reduction").defineInRange("leg", 10, 1, 999);
        CFG.pop();
//    ItemProjectileDungeon.RANGE = CFG.comment(" Range in all directions to search for spawner").defineInRange("spawner_seeker.range", 64, 1, 256);
        CHARM_LUCK = CFG.comment(" Boost given by item charm_luck").defineInRange("charm_luck.boost", 25, 0, 100);
        CHARM_SPEED = CFG.comment(" Boost given by item charm_speed").defineInRange("charm_speed.boost", 0.5F, 0, 2F);
        CHARM_ATTACKSPEED = CFG.comment(" Boost given by item charm_attackspeed").defineInRange("charm_attack_speed.boost", 0.5F, 0, 2F);
        AutoTorchItem.LIGHT_LEVEL = CFG.comment(" Light level limit for placing torches").defineInRange("charm_torch.light_level", 9, 0, 15);
        CFG.comment(WALL, " Caving Torch Charm settings", WALL).push("caving_torch");
        AutoCaveTorchItem.LIGHT_LIMIT = CFG.comment(" Light level at which to start placing down a torch").defineInRange("light_limit", 7, 0, 14);
        AutoCaveTorchItem.LIGHT_TARGET = CFG.comment(
                "Light level of the current block after placing down a torch. Must be greater than light_limit",
                "Higher values means torches will be placed closer to you. Lower values means torches will overlap less,",
                "but might result in small dark spots between torches").defineInRange("light_target", 10, 1, 14);
        AutoCaveTorchItem.PREFER_WALLS = CFG.comment(" Whether to prioritise placing torches on walls").define("prefer_walls", true);
        AutoCaveTorchItem.PREFER_LEFT_WALL = CFG.comment(" Which wall to place torches on when digging a 1-wide tunnel", "True means left, False means right").define("prefer_left_wall", false);
        CFG.pop(); // caving_torch
        EdibleFlightItem.TICKS = CFG.comment(" Seconds of flight per chorus_flight").defineInRange("chorus_flight.ticks", 20 * 60, 1, 20 * 1000);
        EdibleSpecItem.TICKS = CFG.comment(" Seconds of noClip per chorus_spectral").defineInRange("chorus_spectral.ticks", 20 * 30, 1, 20 * 1000);
        MBALL_IGNORE_LIST = CFG.comment(" Entity ids that cannot be picked up with the Monster all").defineList("monster_ball.ignore_list", MBALL_IGNORE, it -> it instanceof String);
//        CFG.comment(" Wand settings").push("teleport_wand");
//        TeleporterWandItem.RANGE = CFG.comment(" Maximum distance to activate").defineInRange("range", 256, 8, 1024);
//        CFG.pop();


        CFG.comment(" Sack of Holding settings").push("tile_transporter");
        TileTransporterEmptyItem.IGNORELIST = CFG.comment(" Block these from being picked up")
                .defineList("disable_pickup", TRANSPORTBAG, it -> it instanceof String);
        OVERRIDE_TRANSPORTER_SINGLETON = CFG.comment(" Override chest placement when a 1/2 split chest is picked up, and set placed block as a singleton chests (prevents visual glitch of the open-sided half chest).  Set to false to restore old behavior and allow the split-chest placement.")
                .define("overrideChestSingle", true);
        CFG.pop();


//        CFG.comment(" Heart items").push("heart");
//        HeartToxicItem.HEARTXPMINUS = CFG.comment(" Experience given when eating a poisoned heart").defineInRange("experience", 500, 0, 99999);
//        HeartItem.MAX = CFG.comment(" Maximum number of hearts that can be attained (including initial 10)").defineInRange("maximum", 100, 1, 200);
//        CFG.pop(); //heart

        /**
         * Eye teleport
         */
        CFG.comment(" Ender Anchor Block settings").push("eye_teleport");
        TileEyeTp.RANGE = CFG.comment(" Maximum distance to activate").defineInRange("range", 100, 2, 256);
        TileEyeTp.HUNGER = CFG.comment(" Hunger cost on teleport").defineInRange("hunger", 1, 0, 20);
        TileEyeTp.EXP = CFG.comment(" Exp cost on teleport").defineInRange("exp", 0, 0, 500);
        TileEyeTp.FREQUENCY = CFG.comment(" Tick delay between checks, faster checks can consume server resources (1 means check every tick; 20 means only check once per second)")
                .defineInRange("frequency", 40, 1, 100);
        CFG.pop(); // eye_teleport


        /**
         * Block specific configs
         */
        CFG.pop(); //items
        CFG.comment(WALL, " Block specific configs", WALL).push("blocks"); //////////////////////////////////////////////////////////////////////////////////// blocks
        CFG.push("facades");
        CABLE_FACADES = CFG.comment("\r\n Allow cables to have blocks placed in them as facades (sneak-left-click to set; use empty hand to remove).  Set to false to disable facades")
                .define("cables.enabled", true);
        //a few default
        List<String> list = Arrays.asList("minecraft:double_plant", "minecraft:waterlily",
                "minecraft:torch", "minecraft:*_torch", "minecraft:redstone", "minecraft:iron_bars",
                "minecraft:chest", "minecraft:ender_chest", "minecraft:sculk_vein", "minecraft:string", "minecraft:vine",
                "minecraft:brewing_stand",
                "minecraft:*_dripleaf",
                "minecraft:*_pane",
                "minecraft:*_sapling", "minecraft:*_sign",
                "minecraft:*_door",
                "minecraft:*_banner", "minecraft:*_shulker_box",
                "storagenetwork:*");
        FACADE_IGNORELIST = CFG.comment("\r\n  These blocks are not allowed to be used as Facades for blocks because they look weird (used by cables and Glowstone Facade and Soundproofing Facade and others).  If you want to ignore one entire mod use an entry like this : storagenetwork:* ")
                .defineList("itemsNotAllowed", list, it -> it instanceof String);
        CFG.pop();
        //
        TRANSFER_NODES_DIMENSIONAL = CFG.comment("  Allows the dimensional Transfer Nodes to cross dimensions "
                        + "(no chunk loading is done, you have to do that on your own); "
                        + "This affects blocks cyclic:wireless_energy, cyclic:wireless_item, cyclic:wireless_fluid, cyclic:wireless_transmitter; "
                        + "If you change it to false it will only work if the target is in the same dimension.")
                .define("wireless_transfer_dimensional", true);
        TileAntiBeacon.HARMFUL_POTIONS = CFG.comment(" If true, then all potions marked as harmful/negative will be used in addition to the 'anti_beacon.potion_list' for cures and immunities  (used by both sponge and artemisbeacon).")
                .define("harmful_potions", true);
        TileAntiBeacon.RADIUS = CFG.comment(" Radius to protect players and entities from potion effects being applied (used by both sponge and artemisbeacon). ")
                .defineInRange("anti_beacon.radius", 16, 1, 128);
        TileAntiBeacon.TICKS = CFG.comment(" Ticks to fire anti beacon and remove effects from entities (20 = 1 second).  Does not affect potion immunity which applies regardless of ticks. This only used if you gain a potion effect out of range and then walk into range, so keep this large.")
                .defineInRange("anti_beacon.ticks", 200, 20, 9999);
        //TODO: variant that is (only harmful effects? just like milk that does all effects) ?
        TileAntiBeacon.POTIONS = CFG.comment(" List of extra effects to clear. supports wildcard such as 'cyclic:*'. (This list is is used even if harmful_potions=false or true both)")
                .defineList("anti_beacon.potion_list", Arrays.asList("minecraft:poison", "minecraft:*_poison", "minecraft:wither",
                        "cyclic:gravity",
                        "minecraft:weakness", "minecraft:slowness"), it -> it instanceof String);
        //TODO: can potions have TAGS?
        TileCableFluid.BUFFERSIZE = CFG.comment(" How many buckets of buffer fluid the fluid cable can hold (for each direction. for example 2 here means 2000ub in each face)")
                .defineInRange("cables.fluid.buffer", 16, 1, 32);
        TileCableFluid.TRANSFER_RATE = CFG.comment(" How many fluid units per tick can flow through these cables each tick (1 bucket = 1000) including normal flow and extraction mode")
                .defineInRange("cables.fluid.flow", 16000, 100, Integer.MAX_VALUE);
        TileCableEnergy.BUFFERSIZE = CFG.comment(" How much buffer the energy cables hold (must not be smaller than flow)")
                .defineInRange("cables.energy.buffer", 32000, 1, Integer.MAX_VALUE);
        TileCableEnergy.TRANSFER_RATE = CFG.comment(" How fast energy flows in these cables (must not be greater than buffer)")
                .defineInRange("cables.energy.flow", 32000, 100, Integer.MAX_VALUE);
        //
        TileGeneratorFuel.RF_PER_TICK = CFG.comment(" RF energy per tick generated while burning furnace fuel in this machine.  Burn time in ticks is the same as furnace values, so 1 coal = 1600 ticks")
                .defineInRange("generator_fuel.rf_per_tick", 80, 1, Integer.MAX_VALUE);
        TileGeneratorFood.RF_PER_TICK = CFG.comment(" RF energy per tick generated while burning food in this machine")
                .defineInRange("generator_food.rf_per_tick", 60, 1, Integer.MAX_VALUE);
        TileGeneratorFood.TICKS_PER_FOOD = CFG.comment(" This [factor * (item.food + item.saturation) = ticks] results in the number of ticks food will burn at. IE Bread has (5 + 0.6) with factor 100, will burn for 560 ticks.")
                .defineInRange("generator_food.ticks_per_food", 100, 1, Integer.MAX_VALUE);
        BlockGeneratorSolar.ENERGY_GENERATE = CFG.comment(" Base level of solar power generation (affected by weather contitions).")
                .defineInRange("generator_solar.energy", 16, 1, Integer.MAX_VALUE);
        BlockGeneratorSolar.TIMEOUT = CFG.comment(" Ticks between power gen interval. Example: 40 ticks is 2 seconds. 0 means every tick it generates")
                .defineInRange("generator_solar.ticks", 100, 0, Integer.MAX_VALUE);
        LavaSpongeBlock.RADIUS = CFG.comment(" Reach of the sponge").defineInRange("sponge_lava.radius", 8, 1, 64);
        BlockDestruction.HEIGHT = CFG.comment(" Height for explosion prevention").defineInRange("altar_destruction.height", 8, 1, 512);
        BlockDestruction.RADIUS = CFG.comment(" Reach for explosion prevention").defineInRange("altar_destruction.radius", 32, 1, 128);
        CandleWaterBlock.RADIUS = CFG.comment(" Reach of the candle").defineInRange("water_candle.radius", 8, 1, 64);
        CandleWaterBlock.TICK_RATE = CFG.comment(" Tick rate of the candle").defineInRange("water_candle.tick_rate", 60, 1, Integer.MAX_VALUE);
        TileAnvilAuto.POWERCONF = CFG.comment(" Power per repair anvil").defineInRange("anvil.energy_cost", 6500, 0, Integer.MAX_VALUE);

        TilePotionBeacon.POWERCONF = CFG.comment(" Power per tick beacon").defineInRange("beacon.energy_cost", 10, 0, Integer.MAX_VALUE);

        TilePotionBeacon.POWERCONF = CFG.comment(" Power per tick while in use").defineInRange("beacon.energy_cost", 0, 0, 64000);
        PeatBlock.PEATCHANCE = CFG.comment(" Chance that Peat Bog converts to Peat when wet (is multiplied by the number of surrounding water blocks)")
                .defineInRange("peat.conversion_chance",
                        0.08000000000000F,
                        0.0010000000000F, 1F);
//    TileAnvilMagma.FLUIDCOST = CFG.comment(" Cost of magma fluid per action").defineInRange("anvil_magma.fluid_cost", 100, 1, 64000);
//    CFG.push("disenchanter");
//    TileDisenchant.FLUIDCOST = CFG.comment(" Cost of (or payment for if negative) per enchanted book generated").defineInRange("fluid_cost", 100, -1000, 16000);
//    TileDisenchant.POWERCONF = CFG.comment(" Power per use disenchanter").defineInRange("energy_cost", 2500, 0, Integer.MAX_VALUE);
//    CFG.pop();
//    CFG.push("anvil_void");
//    TileAnvilVoid.FLUIDPAY = CFG.comment(" Payment per void action, if not zero").defineInRange("fluid_cost", 25, 0, Integer.MAX_VALUE);
//    CFG.pop();


        CFG.comment(" soundproofing settings").push("soundproofing"); //soundproofing
        SOUND_RADIUS = CFG.comment(" Radius of sound proofing (distance from each block that it will listen)").defineInRange("radius", 6, 1, 16);
        CFG.pop(); //soundproofing

        CFG.comment(" terra_glass settings").push("terra_glass");
        TileTerraGlass.TIMER_FULL = CFG.comment(" ticks between growth cycles").defineInRange("timer", 100, 1, 10000);
        TileTerraGlass.HEIGHT = CFG.comment(" growth height below the glass").defineInRange("height", 8, 0, 32);
        CFG.pop(); // terra_preta

        CFG.comment(" battery_clay settings").push("battery_clay");
        TileClayBattery.MAX = CFG.comment(" Maximum storage capacity; default 16000 [warning: energy contents of items in world may be reset when changing this value]")
                .defineInRange("capacity", 16000, 1, Integer.MAX_VALUE);
        CFG.pop();
        CFG.comment(" battery settings").push("battery");
        TileBattery.SLOT_CHARGING_RATE = CFG.comment(" RF/t charging rate for the battery item slot")
                .defineInRange("charge", 8000, 1, Integer.MAX_VALUE);
        TileBattery.MAX = CFG.comment(" Maximum storage capacity; default 6400000 [warning: energy contents of items in world may be reset when changing this value]")
                .defineInRange("capacity", 6400000, 1, Integer.MAX_VALUE);
        CFG.pop();


        CFG.pop(); //blocks
        CFG.pop(); //ROOT
        COMMON_CONFIG = CFG.build();

        /**
         * Begin client configs
         */
        final ForgeConfigSpec.Builder CFGC = builder();
        CFGC.comment(WALL, "Client-side properties", WALL)
                .push(ModCyclic.MODID);
        CFGC.comment(WALL, "Block Rendering properties.  Color MUST have one # symbol and then six spots after so #000000 up to #FFFFFF", WALL)
                .push("blocks");
        CFGC.push("colors");
        ClientConfigCyclic.COLLECTOR_ITEM = CFGC.comment(" Specify hex color of preview mode.  default #444044").define("collector_item", "#444044");
        ClientConfigCyclic.COLLECTOR_FLUID = CFGC.comment(" Specify hex color of preview mode.  default #444044").define("collector_fluid", "#444044");
        ClientConfigCyclic.DETECTOR_ENTITY = CFGC.comment(" Specify hex color of preview mode.  default #00FF00").define("detector_entity", "#00FF00");
        ClientConfigCyclic.DETECTOR_ITEM = CFGC.comment(" Specify hex color of preview mode.  default #00AA00").define("detector_item", "#00AA00");
        ClientConfigCyclic.PEAT_FARM = CFGC.comment(" Specify hex color of preview mode.  default #404040").define("peat_farm", "#404040");
        ClientConfigCyclic.MINER = CFGC.comment(" Specify hex color of preview mode.  default #0000AA").define("miner", "#0000AA");
        ClientConfigCyclic.DROPPER = CFGC.comment(" Specify hex color of preview mode.  default #AA0011").define("dropper", "#AA0011");
        ClientConfigCyclic.FORESTER = CFGC.comment(" Specify hex color of preview mode.  default #11BB00").define("forester", "#11BB00");
        ClientConfigCyclic.HARVESTER = CFGC.comment(" Specify hex color of preview mode.  default #00EE00").define("harvester", "#00EE00");
        ClientConfigCyclic.STRUCTURE = CFGC.comment(" Specify hex color of preview mode.  default #FF0000").define("structure", "#FF0000");
        CFGC.pop();
        CFGC.push("text");
        ClientConfigCyclic.FLUID_BLOCK_STATUS = CFGC.comment(" True means this will hide the fluid contents chat message (right click) on relevant blocks (pylon, fluid generator, fluid hopper, solidifier, sprinkler, tank, cask)").define("FluidContents", true);
        CFGC.pop();
        CFGC.pop(); //end of blocks
        CFGC.comment(WALL, "Item Rendering properties.  Color MUST have one # symbol and then six spots after so #000000 up to #FFFFFF", WALL)
                .push("items");
        //
        CFGC.push("colors");
        ClientConfigCyclic.LOCATION = CFGC.comment(" Specify hex color of preview mode for the GPS data card.  default #0000FF").define("location", "#0000FF");
        ClientConfigCyclic.SHAPE_DATA = CFGC.comment(" Specify hex color of preview mode.  default #FFC800").define("shape_data", "#FFC800"); // orange
        ClientConfigCyclic.RANDOMIZE_SCEPTER = CFGC.comment(" Specify hex color of preview mode.  default #0000FF").define("randomize_scepter", "#00EE00");
        ClientConfigCyclic.OFFSET_SCEPTER = CFGC.comment(" Specify hex color of preview mode.  default #0000FF").define("offset_scepter", "#00FF00");
        ClientConfigCyclic.REPLACE_SCEPTER = CFGC.comment(" Specify hex color of preview mode.  default #0000FF").define("replace_scepter", "#FFFF00");
        ClientConfigCyclic.BUILD_SCEPTER = CFGC.comment(" Specify hex color of preview mode.  default #0000FF").define("build_scepter", "#0000FF");
        CFGC.pop();
        CFGC.pop(); //end of items
        CFGC.pop();
        CLIENT_CONFIG = CFGC.build();

    }


    @SuppressWarnings("unchecked")
    public static List<String> getMagicNetList() {
        return (List<String>) MBALL_IGNORE_LIST.get();
    }

    @SuppressWarnings("unchecked")
    public static List<String> getDisarmIgnoreList() {
        return (List<String>) DISARM_IGNORE_LIST.get();
    }

    @SuppressWarnings("unchecked")
    public static List<String> getGloomIgnoreList() {
        return (List<String>) GLOOM_IGNORE_LIST.get();
    }

    @SuppressWarnings("unchecked")
    public static List<String> getFacadeIgnoreList() {
        return (List<String>) FACADE_IGNORELIST.get();
    }

    public static Map<String, String> getMappedBeheading() {
        Map<String, String> mappedBeheading = new HashMap<String, String>();
        for (String s : BEHEADING_SKINS.get()) {
            try {
                String[] stuff = s.split(":");
                String entity = stuff[0] + ":" + stuff[1];
                String skin = stuff[2];
                mappedBeheading.put(entity, skin);
            } catch (Exception e) {
                ModCyclic.LOGGER.error("Beheading Enchantment: Invalid config entry " + s);
            }
        }
        return mappedBeheading;
    }

    public static BooleanValue CABLE_FACADES;
    private static ConfigValue<List<? extends String>> FACADE_IGNORELIST;

    public static boolean isFacadeAllowed(ItemStack item) {
        ResourceLocation itemId = ForgeRegistries.ITEMS.getKey(item.getItem());
        if (StringParseUtil.isInList(getFacadeIgnoreList(), itemId)) {
            return false;
        }
        return true;
    }
}
