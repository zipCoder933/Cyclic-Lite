package com.lothrazar.cyclic.registry;

import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.block.anvil.ContainerAnvil;
//import com.lothrazar.cyclic.block.anvilmagma.ContainerAnvilMagma;
//import com.lothrazar.cyclic.block.anvilvoid.ContainerAnvilVoid;
import com.lothrazar.cyclic.block.battery.ContainerBattery;
import com.lothrazar.cyclic.block.batteryclay.ContainerClayBattery;
import com.lothrazar.cyclic.block.beaconpotion.ContainerPotion;
//import com.lothrazar.cyclic.block.breaker.ContainerBreaker;
import com.lothrazar.cyclic.block.cable.fluid.ContainerCableFluid;
import com.lothrazar.cyclic.block.cable.item.ContainerCableItem;
import com.lothrazar.cyclic.block.clock.ContainerClock;
import com.lothrazar.cyclic.block.collectfluid.ContainerFluidCollect;
//import com.lothrazar.cyclic.block.collectitem.ContainerItemCollector;
import com.lothrazar.cyclic.block.crafter.ContainerCrafter;
//import com.lothrazar.cyclic.block.crate.ContainerCrate;
//import com.lothrazar.cyclic.block.cratemini.ContainerCrateMini;
import com.lothrazar.cyclic.block.crusher.ContainerCrusher;
import com.lothrazar.cyclic.block.detectorentity.ContainerDetector;
import com.lothrazar.cyclic.block.detectoritem.ContainerDetectorItem;
//import com.lothrazar.cyclic.block.disenchant.ContainerDisenchant;
//import com.lothrazar.cyclic.block.dropper.ContainerDropper;
import com.lothrazar.cyclic.block.expcollect.ContainerExpPylon;
//import com.lothrazar.cyclic.block.fan.ContainerFan;
//import com.lothrazar.cyclic.block.fishing.ContainerFisher;
//import com.lothrazar.cyclic.block.forester.ContainerForester;
import com.lothrazar.cyclic.block.generatorfluid.ContainerGeneratorFluid;
import com.lothrazar.cyclic.block.generatorfood.ContainerGeneratorFood;
import com.lothrazar.cyclic.block.generatorfuel.ContainerGeneratorFuel;
import com.lothrazar.cyclic.block.generatoritem.ContainerGeneratorDrops;
import com.lothrazar.cyclic.block.generatorsolar.ContainerGeneratorSolar;
//import com.lothrazar.cyclic.block.harvester.ContainerHarvester;
import com.lothrazar.cyclic.block.laser.ContainerLaser;
import com.lothrazar.cyclic.block.melter.ContainerMelter;
import com.lothrazar.cyclic.block.miner.ContainerMiner;
//import com.lothrazar.cyclic.block.packager.ContainerPackager;
import com.lothrazar.cyclic.block.peatfarm.ContainerPeatFarm;
//import com.lothrazar.cyclic.block.placer.ContainerPlacer;
import com.lothrazar.cyclic.block.placerfluid.ContainerPlacerFluid;
import com.lothrazar.cyclic.block.screen.ContainerScreentext;
import com.lothrazar.cyclic.block.shapebuilder.ContainerStructure;
import com.lothrazar.cyclic.block.shapedata.ContainerShapedata;
import com.lothrazar.cyclic.block.solidifier.ContainerSolidifier;
//import com.lothrazar.cyclic.block.soundplay.ContainerSoundPlayer;
//import com.lothrazar.cyclic.block.soundrecord.ContainerSoundRecorder;
//import com.lothrazar.cyclic.block.tp.ContainerTeleport;
//import com.lothrazar.cyclic.block.uncrafter.ContainerUncraft;
//import com.lothrazar.cyclic.block.user.ContainerUser;
import com.lothrazar.cyclic.block.wireless.energy.ContainerWirelessEnergy;
import com.lothrazar.cyclic.block.wireless.fluid.ContainerWirelessFluid;
import com.lothrazar.cyclic.block.wireless.item.ContainerWirelessItem;
import com.lothrazar.cyclic.block.wireless.redstone.ContainerTransmit;
import com.lothrazar.cyclic.block.workbench.ContainerWorkbench;
//import com.lothrazar.cyclic.item.crafting.CraftingBagContainer;
import com.lothrazar.cyclic.item.crafting.simple.CraftingStickContainer;
import com.lothrazar.cyclic.item.datacard.filter.ContainerFilterCard;
import com.lothrazar.cyclic.item.enderbook.EnderBookContainer;
//import com.lothrazar.cyclic.item.food.inventorycake.ContainerCake;
import com.lothrazar.cyclic.item.lunchbox.ContainerLunchbox;
//import com.lothrazar.cyclic.item.storagebag.ContainerStorageBag;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuTypeRegistry {

  public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ModCyclic.MODID);
//  public static final RegistryObject<MenuType<ContainerItemCollector>> COLLECTOR = CONTAINERS.register("collector", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerItemCollector(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerPeatFarm>> PEAT_FARM = CONTAINERS.register("peat_farm", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerPeatFarm(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerBattery>> BATTERY = CONTAINERS.register("battery", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerBattery(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerClayBattery>> BATTERY_CLAY = CONTAINERS.register("battery_clay", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerClayBattery(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerHarvester>> HARVESTER = CONTAINERS.register("harvester", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerHarvester(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerAnvil>> ANVIL = CONTAINERS.register("anvil", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerAnvil(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerPlacer>> PLACER = CONTAINERS.register("placer", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerPlacer(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerStructure>> STRUCTURE = CONTAINERS.register("structure", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerStructure(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerMelter>> MELTER = CONTAINERS.register("melter", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerMelter(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerSolidifier>> SOLIDIFIER = CONTAINERS.register("solidifier", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerSolidifier(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerBreaker>> BREAKER = CONTAINERS.register("breaker", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerBreaker(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerExpPylon>> EXPERIENCE_PYLON = CONTAINERS.register("experience_pylon", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerExpPylon(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerUser>> USER = CONTAINERS.register("user", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerUser(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerDetector>> DETECTOR_ENTITY = CONTAINERS.register("detector_entity", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerDetector(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerDetectorItem>> DETECTOR_ITEM = CONTAINERS.register("detector_item", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerDetectorItem(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerDisenchant>> DISENCHANTER = CONTAINERS.register("disenchanter", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerDisenchant(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerTransmit>> WIRELESS_TRANSMITTER = CONTAINERS.register("wireless_transmitter", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerTransmit(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerClock>> CLOCK = CONTAINERS.register("clock", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerClock(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerCrate>> CRATE = CONTAINERS.register("crate", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerCrate(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerCrateMini>> CRATE_MINI = CONTAINERS.register("crate_mini", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerCrateMini(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerPlacerFluid>> PLACER_FLUID = CONTAINERS.register("placer_fluid", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerPlacerFluid(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerFluidCollect>> COLLECTOR_FLUID = CONTAINERS.register("collector_fluid", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerFluidCollect(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerFan>> FAN = CONTAINERS.register("fan", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerFan(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerPotion>> BEACON = CONTAINERS.register("beacon", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerPotion(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerDropper>> DROPPER = CONTAINERS.register("dropper", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerDropper(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerForester>> FORESTER = CONTAINERS.register("forester", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerForester(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerMiner>> MINER = CONTAINERS.register("miner", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerMiner(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerScreentext>> SCREEN = CONTAINERS.register("screen", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerScreentext(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerAnvilMagma>> ANVIL_MAGMA = CONTAINERS.register("anvil_magma", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerAnvilMagma(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerUncraft>> UNCRAFTER = CONTAINERS.register("uncrafter", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerUncraft(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerCrafter>> CRAFTER = CONTAINERS.register("crafter", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerCrafter(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerShapedata>> COMPUTER_SHAPE = CONTAINERS.register("computer_shape", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerShapedata(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerWorkbench>> WORKBENCH = CONTAINERS.register("workbench", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerWorkbench(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerFisher>> FISHER = CONTAINERS.register("fisher", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerFisher(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerLaser>> LASER = CONTAINERS.register("laser", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerLaser(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerCableItem>> ITEM_PIPE = CONTAINERS.register("item_pipe", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerCableItem(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerCableFluid>> FLUID_PIPE = CONTAINERS.register("fluid_pipe", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerCableFluid(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerAnvilVoid>> ANVIL_VOID = CONTAINERS.register("anvil_void", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerAnvilVoid(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerWirelessEnergy>> WIRELESS_ENERGY = CONTAINERS.register("wireless_energy", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerWirelessEnergy(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerWirelessItem>> WIRELESS_ITEM = CONTAINERS.register("wireless_item", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerWirelessItem(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerWirelessFluid>> WIRELESS_FLUID = CONTAINERS.register("wireless_fluid", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerWirelessFluid(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerGeneratorFuel>> GENERATOR_FUEL = CONTAINERS.register("generator_fuel", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerGeneratorFuel(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerGeneratorFood>> GENERATOR_FOOD = CONTAINERS.register("generator_food", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerGeneratorFood(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerGeneratorDrops>> GENERATOR_DROPS = CONTAINERS.register("generator_item", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerGeneratorDrops(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerGeneratorFluid>> GENERATOR_FLUID = CONTAINERS.register("generator_fluid", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerGeneratorFluid(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerGeneratorSolar>> GENERATOR_SOLAR = CONTAINERS.register("generator_solar", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerGeneratorSolar(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerPackager>> PACKAGER = CONTAINERS.register("packager", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerPackager(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerSoundRecorder>> SOUND_RECORDER = CONTAINERS.register("sound_recorder", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerSoundRecorder(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerSoundPlayer>> SOUND_PLAYER = CONTAINERS.register("sound_player", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerSoundPlayer(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerCrusher>> CRUSHER = CONTAINERS.register("crusher", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerCrusher(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerTeleport>> TELEPORT = CONTAINERS.register("teleport", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerTeleport(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  //  Items with containers
  public static final RegistryObject<MenuType<EnderBookContainer>> ENDER_BOOK = CONTAINERS.register("ender_book", () -> IForgeMenuType.create((windowId, inv, data) -> new EnderBookContainer(windowId, inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerStorageBag>> STORAGE_BAG = CONTAINERS.register("storage_bag", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerStorageBag(windowId, inv, inv.player, data.readInt())));
//  public static final RegistryObject<MenuType<CraftingBagContainer>> CRAFTING_BAG = CONTAINERS.register("crafting_bag", () -> IForgeMenuType.create((windowId, inv, data) -> new CraftingBagContainer(windowId, inv, inv.player, data.readInt())));
  public static final RegistryObject<MenuType<CraftingStickContainer>> CRAFTING_STICK = CONTAINERS.register("crafting_stick", () -> IForgeMenuType.create((windowId, inv, data) -> new CraftingStickContainer(windowId, inv, inv.player, data.readInt())));
  public static final RegistryObject<MenuType<ContainerFilterCard>> FILTER_DATA = CONTAINERS.register("filter_data", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerFilterCard(windowId, inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerCake>> INVENTORY_CAKE = CONTAINERS.register("inventory_cake", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerCake(windowId, inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerLunchbox>> LUNCHBOX = CONTAINERS.register("lunchbox", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerLunchbox(windowId, inv, inv.player)));
}
