package com.lothrazar.cyclic.registry;

import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.block.antipotion.TileAntiBeacon;
import com.lothrazar.cyclic.block.anvil.TileAnvilAuto;
import com.lothrazar.cyclic.block.battery.TileBattery;
import com.lothrazar.cyclic.block.batteryclay.TileClayBattery;
import com.lothrazar.cyclic.block.batterycreative.TileBatteryInfinite;
import com.lothrazar.cyclic.block.beaconpotion.TilePotionBeacon;
import com.lothrazar.cyclic.block.beaconredstone.TileBeaconRedstone;
import com.lothrazar.cyclic.block.bedrock.UnbreakablePoweredTile;
import com.lothrazar.cyclic.block.cable.energy.TileCableEnergy;
import com.lothrazar.cyclic.block.cable.fluid.TileCableFluid;
import com.lothrazar.cyclic.block.cable.item.TileCableItem;
import com.lothrazar.cyclic.block.clock.TileRedstoneClock;
import com.lothrazar.cyclic.block.detectmoon.TileMoon;
import com.lothrazar.cyclic.block.detectorentity.TileDetector;
import com.lothrazar.cyclic.block.detectoritem.TileDetectorItem;
import com.lothrazar.cyclic.block.detectweather.TileWeather;
import com.lothrazar.cyclic.block.eye.TileEye;
import com.lothrazar.cyclic.block.eyetp.TileEyeTp;
import com.lothrazar.cyclic.block.facade.light.TileLightFacade;
import com.lothrazar.cyclic.block.facade.soundmuff.SoundmuffTileFacade;
import com.lothrazar.cyclic.block.generatorfluid.TileGeneratorFluid;
import com.lothrazar.cyclic.block.generatorfood.TileGeneratorFood;
import com.lothrazar.cyclic.block.generatorfuel.TileGeneratorFuel;
import com.lothrazar.cyclic.block.generatoritem.TileGeneratorDrops;
import com.lothrazar.cyclic.block.generatorsolar.TileGeneratorSolar;
import com.lothrazar.cyclic.block.laser.TileLaser;
import com.lothrazar.cyclic.block.spikes.TileDiamondSpikes;
import com.lothrazar.cyclic.block.tank.TileTank;
import com.lothrazar.cyclic.block.tankcask.TileCask;
import com.lothrazar.cyclic.block.terraglass.TileTerraGlass;
import com.lothrazar.cyclic.block.workbench.TileWorkbench;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TileRegistry {

    public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ModCyclic.MODID);

    public static final RegistryObject<BlockEntityType<TileMoon>> DETECTORMOON = TILES.register("detector_moon", () -> BlockEntityType.Builder.of(TileMoon::new, BlockRegistry.DETECTORMOON.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileWeather>> DETECTORWEATHER = TILES.register("detector_weather", () -> BlockEntityType.Builder.of(TileWeather::new, BlockRegistry.DETECTORWEATHER.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileTerraGlass>> TERRA_GLASS = TILES.register("terra_glass", () -> BlockEntityType.Builder.of(TileTerraGlass::new, BlockRegistry.TERRAGLASS.get()).build(null));
   public static final RegistryObject<BlockEntityType<TileGeneratorFuel>> GENERATOR_FUEL = TILES.register("generator_fuel", () -> BlockEntityType.Builder.of(TileGeneratorFuel::new, BlockRegistry.GENERATOR_FUEL.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileGeneratorFood>> GENERATOR_FOOD = TILES.register("generator_food", () -> BlockEntityType.Builder.of(TileGeneratorFood::new, BlockRegistry.GENERATOR_FOOD.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileGeneratorDrops>> GENERATOR_ITEM = TILES.register("generator_item", () -> BlockEntityType.Builder.of(TileGeneratorDrops::new, BlockRegistry.GENERATOR_ITEM.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileGeneratorFluid>> GENERATOR_FLUID = TILES.register("generator_fluid", () -> BlockEntityType.Builder.of(TileGeneratorFluid::new, BlockRegistry.GENERATOR_FLUID.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileGeneratorSolar>> GENERATOR_SOLAR = TILES.register("generator_solar", () -> BlockEntityType.Builder.of(TileGeneratorSolar::new, BlockRegistry.GENERATOR_SOLAR.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileDiamondSpikes>> SPIKES_DIAMOND = TILES.register("spikes_diamond", () -> BlockEntityType.Builder.of(TileDiamondSpikes::new, BlockRegistry.SPIKES_DIAMOND.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileLightFacade>> LIGHT_CAMO = TILES.register("light_camo", () -> BlockEntityType.Builder.of(TileLightFacade::new, BlockRegistry.LIGHT_CAMO.get()).build(null));
    public static final RegistryObject<BlockEntityType<SoundmuffTileFacade>> SOUNDPROOFING_GHOST = TILES.register("soundproofing_ghost", () -> BlockEntityType.Builder.of(SoundmuffTileFacade::new, BlockRegistry.SOUNDPROOFING_GHOST.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileEye>> EYE_REDSTONE = TILES.register("eye_redstone", () -> BlockEntityType.Builder.of(TileEye::new, BlockRegistry.EYE_REDSTONE.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileEyeTp>> EYE_TELEPORT = TILES.register("eye_teleport", () -> BlockEntityType.Builder.of(TileEyeTp::new, BlockRegistry.EYE_TELEPORT.get()).build(null));
    //  public static final RegistryObject<BlockEntityType<TileAnvilMagma>> ANVIL_MAGMA = TILES.register("anvil_magma", () -> BlockEntityType.Builder.of(TileAnvilMagma::new, BlockRegistry.ANVIL_MAGMA.get()).build(null));
    public static final RegistryObject<BlockEntityType<TilePotionBeacon>> BEACON = TILES.register("beacon", () -> BlockEntityType.Builder.of(TilePotionBeacon::new, BlockRegistry.BEACON.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileBatteryInfinite>> BATTERY_INFINITE = TILES.register("battery_infinite", () -> BlockEntityType.Builder.of(TileBatteryInfinite::new, BlockRegistry.BATTERY_INFINITE.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileCask>> CASK = TILES.register("cask", () -> BlockEntityType.Builder.of(TileCask::new, BlockRegistry.CASK.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileRedstoneClock>> CLOCK = TILES.register("clock", () -> BlockEntityType.Builder.of(TileRedstoneClock::new, BlockRegistry.CLOCK.get()).build(null));
     public static final RegistryObject<BlockEntityType<TileDetectorItem>> DETECTOR_ITEM = TILES.register("detector_item", () -> BlockEntityType.Builder.of(TileDetectorItem::new, BlockRegistry.DETECTOR_ITEM.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileDetector>> DETECTOR_ENTITY = TILES.register("detector_entity", () -> BlockEntityType.Builder.of(TileDetector::new, BlockRegistry.DETECTOR_ENTITY.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileTank>> TANK = TILES.register("tank", () -> BlockEntityType.Builder.of(TileTank::new, BlockRegistry.TANK.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileBattery>> BATTERY = TILES.register("battery", () -> BlockEntityType.Builder.of(TileBattery::new, BlockRegistry.BATTERY.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileClayBattery>> BATTERY_CLAY = TILES.register("battery_clay", () -> BlockEntityType.Builder.of(TileClayBattery::new, BlockRegistry.BATTERY_CLAY.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileCableEnergy>> ENERGY_PIPE = TILES.register("energy_pipe", () -> BlockEntityType.Builder.of(TileCableEnergy::new, BlockRegistry.ENERGY_PIPE.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileCableItem>> ITEM_PIPE = TILES.register("item_pipe", () -> BlockEntityType.Builder.of(TileCableItem::new, BlockRegistry.ITEM_PIPE.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileCableFluid>> FLUID_PIPE = TILES.register("fluid_pipe", () -> BlockEntityType.Builder.of(TileCableFluid::new, BlockRegistry.FLUID_PIPE.get()).build(null));

    public static final RegistryObject<BlockEntityType<TileAnvilAuto>> ANVIL = TILES.register("anvil", () -> BlockEntityType.Builder.of(TileAnvilAuto::new, BlockRegistry.ANVIL.get()).build(null));
    public static final RegistryObject<BlockEntityType<UnbreakablePoweredTile>> UNBREAKABLE_REACTIVE = TILES.register("unbreakable_reactive", () -> BlockEntityType.Builder.of(UnbreakablePoweredTile::new, BlockRegistry.UNBREAKABLE_REACTIVE.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileLaser>> LASER = TILES.register("laser", () -> BlockEntityType.Builder.of(TileLaser::new, BlockRegistry.LASER.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileWorkbench>> WORKBENCH = TILES.register("workbench", () -> BlockEntityType.Builder.of(TileWorkbench::new, BlockRegistry.WORKBENCH.get()).build(null));
    //
    public static final RegistryObject<BlockEntityType<TileAntiBeacon>> ANTI_BEACON = TILES.register("anti_beacon", () -> BlockEntityType.Builder.of(TileAntiBeacon::new, BlockRegistry.ANTI_BEACON.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileBeaconRedstone>> BEACON_REDSTONE = TILES.register("beacon_redstone", () -> BlockEntityType.Builder.of(TileBeaconRedstone::new, BlockRegistry.BEACON_REDSTONE.get()).build(null));
}
