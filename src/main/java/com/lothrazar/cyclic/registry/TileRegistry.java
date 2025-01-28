package com.lothrazar.cyclic.registry;

import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.block.anvil.TileAnvilAuto;
import com.lothrazar.cyclic.block.battery.TileBattery;
import com.lothrazar.cyclic.block.batteryclay.TileClayBattery;
import com.lothrazar.cyclic.block.batterycreative.TileBatteryInfinite;
import com.lothrazar.cyclic.block.bedrock.UnbreakablePoweredTile;
import com.lothrazar.cyclic.block.detectmoon.TileMoon;
import com.lothrazar.cyclic.block.detectorentity.TileDetector;
import com.lothrazar.cyclic.block.detectoritem.TileDetectorItem;
import com.lothrazar.cyclic.block.detectweather.TileWeather;
import com.lothrazar.cyclic.block.eye.TileEye;
import com.lothrazar.cyclic.block.eyetp.TileEyeTp;
import com.lothrazar.cyclic.block.laser.TileLaser;
import com.lothrazar.cyclic.block.spikes.TileDiamondSpikes;
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
    public static final RegistryObject<BlockEntityType<TileDiamondSpikes>> SPIKES_DIAMOND = TILES.register("spikes_diamond", () -> BlockEntityType.Builder.of(TileDiamondSpikes::new, BlockRegistry.SPIKES_DIAMOND.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileEye>> EYE_REDSTONE = TILES.register("eye_redstone", () -> BlockEntityType.Builder.of(TileEye::new, BlockRegistry.EYE_REDSTONE.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileEyeTp>> EYE_TELEPORT = TILES.register("eye_teleport", () -> BlockEntityType.Builder.of(TileEyeTp::new, BlockRegistry.EYE_TELEPORT.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileBatteryInfinite>> BATTERY_INFINITE = TILES.register("battery_infinite", () -> BlockEntityType.Builder.of(TileBatteryInfinite::new, BlockRegistry.BATTERY_INFINITE.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileDetectorItem>> DETECTOR_ITEM = TILES.register("detector_item", () -> BlockEntityType.Builder.of(TileDetectorItem::new, BlockRegistry.DETECTOR_ITEM.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileDetector>> DETECTOR_ENTITY = TILES.register("detector_entity", () -> BlockEntityType.Builder.of(TileDetector::new, BlockRegistry.DETECTOR_ENTITY.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileBattery>> BATTERY = TILES.register("battery", () -> BlockEntityType.Builder.of(TileBattery::new, BlockRegistry.BATTERY.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileClayBattery>> BATTERY_CLAY = TILES.register("battery_clay", () -> BlockEntityType.Builder.of(TileClayBattery::new, BlockRegistry.BATTERY_CLAY.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileAnvilAuto>> ANVIL = TILES.register("anvil", () -> BlockEntityType.Builder.of(TileAnvilAuto::new, BlockRegistry.ANVIL.get()).build(null));
    public static final RegistryObject<BlockEntityType<UnbreakablePoweredTile>> UNBREAKABLE_REACTIVE = TILES.register("unbreakable_reactive", () -> BlockEntityType.Builder.of(UnbreakablePoweredTile::new, BlockRegistry.UNBREAKABLE_REACTIVE.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileLaser>> LASER = TILES.register("laser", () -> BlockEntityType.Builder.of(TileLaser::new, BlockRegistry.LASER.get()).build(null));
    public static final RegistryObject<BlockEntityType<TileWorkbench>> WORKBENCH = TILES.register("workbench", () -> BlockEntityType.Builder.of(TileWorkbench::new, BlockRegistry.WORKBENCH.get()).build(null));
   }
