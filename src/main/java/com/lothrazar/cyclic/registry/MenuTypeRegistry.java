package com.lothrazar.cyclic.registry;

import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.block.anvil.ContainerAnvil;
import com.lothrazar.cyclic.block.battery.ContainerBattery;
import com.lothrazar.cyclic.block.batteryclay.ContainerClayBattery;
import com.lothrazar.cyclic.block.beaconpotion.ContainerPotion;
import com.lothrazar.cyclic.block.cable.fluid.ContainerCableFluid;
import com.lothrazar.cyclic.block.cable.item.ContainerCableItem;
import com.lothrazar.cyclic.block.clock.ContainerClock;
import com.lothrazar.cyclic.block.detectorentity.ContainerDetector;
import com.lothrazar.cyclic.block.detectoritem.ContainerDetectorItem;
import com.lothrazar.cyclic.block.generatorfluid.ContainerGeneratorFluid;
import com.lothrazar.cyclic.block.generatorfood.ContainerGeneratorFood;
import com.lothrazar.cyclic.block.generatorfuel.ContainerGeneratorFuel;
import com.lothrazar.cyclic.block.generatoritem.ContainerGeneratorDrops;
import com.lothrazar.cyclic.block.generatorsolar.ContainerGeneratorSolar;
import com.lothrazar.cyclic.block.laser.ContainerLaser;
import com.lothrazar.cyclic.block.workbench.ContainerWorkbench;
import com.lothrazar.cyclic.item.crafting.simple.CraftingStickContainer;
import com.lothrazar.cyclic.item.datacard.filter.ContainerFilterCard;
import com.lothrazar.cyclic.item.enderbook.EnderBookContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuTypeRegistry {

  public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ModCyclic.MODID);
//  public static final RegistryObject<MenuType<ContainerItemCollector>> COLLECTOR = CONTAINERS.register("collector", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerItemCollector(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerBattery>> BATTERY = CONTAINERS.register("battery", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerBattery(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerClayBattery>> BATTERY_CLAY = CONTAINERS.register("battery_clay", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerClayBattery(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerHarvester>> HARVESTER = CONTAINERS.register("harvester", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerHarvester(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerAnvil>> ANVIL = CONTAINERS.register("anvil", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerAnvil(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerDetector>> DETECTOR_ENTITY = CONTAINERS.register("detector_entity", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerDetector(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerDetectorItem>> DETECTOR_ITEM = CONTAINERS.register("detector_item", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerDetectorItem(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerDisenchant>> DISENCHANTER = CONTAINERS.register("disenchanter", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerDisenchant(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerClock>> CLOCK = CONTAINERS.register("clock", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerClock(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerPotion>> BEACON = CONTAINERS.register("beacon", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerPotion(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerWorkbench>> WORKBENCH = CONTAINERS.register("workbench", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerWorkbench(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerFisher>> FISHER = CONTAINERS.register("fisher", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerFisher(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerLaser>> LASER = CONTAINERS.register("laser", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerLaser(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerCableItem>> ITEM_PIPE = CONTAINERS.register("item_pipe", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerCableItem(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerCableFluid>> FLUID_PIPE = CONTAINERS.register("fluid_pipe", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerCableFluid(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
//  public static final RegistryObject<MenuType<ContainerAnvilVoid>> ANVIL_VOID = CONTAINERS.register("anvil_void", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerAnvilVoid(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
   public static final RegistryObject<MenuType<ContainerGeneratorFuel>> GENERATOR_FUEL = CONTAINERS.register("generator_fuel", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerGeneratorFuel(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerGeneratorFood>> GENERATOR_FOOD = CONTAINERS.register("generator_food", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerGeneratorFood(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerGeneratorDrops>> GENERATOR_DROPS = CONTAINERS.register("generator_item", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerGeneratorDrops(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerGeneratorFluid>> GENERATOR_FLUID = CONTAINERS.register("generator_fluid", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerGeneratorFluid(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
  public static final RegistryObject<MenuType<ContainerGeneratorSolar>> GENERATOR_SOLAR = CONTAINERS.register("generator_solar", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerGeneratorSolar(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));

  public static final RegistryObject<MenuType<EnderBookContainer>> ENDER_BOOK = CONTAINERS.register("ender_book", () -> IForgeMenuType.create((windowId, inv, data) -> new EnderBookContainer(windowId, inv, inv.player)));
  public static final RegistryObject<MenuType<CraftingStickContainer>> CRAFTING_STICK = CONTAINERS.register("crafting_stick", () -> IForgeMenuType.create((windowId, inv, data) -> new CraftingStickContainer(windowId, inv, inv.player, data.readInt())));
  public static final RegistryObject<MenuType<ContainerFilterCard>> FILTER_DATA = CONTAINERS.register("filter_data", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerFilterCard(windowId, inv, inv.player)));
}
