package com.lothrazar.cyclic.registry;

import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.block.anvil.ContainerAnvil;
import com.lothrazar.cyclic.block.battery.ContainerBattery;
import com.lothrazar.cyclic.block.batteryclay.ContainerClayBattery;
import com.lothrazar.cyclic.block.detectorentity.ContainerDetector;
import com.lothrazar.cyclic.block.detectoritem.ContainerDetectorItem;
import com.lothrazar.cyclic.block.laser.ContainerLaser;
import com.lothrazar.cyclic.block.workbench.ContainerWorkbench;
import com.lothrazar.cyclic.item.crafting.simple.CraftingStickContainer;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuTypeRegistry {

    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ModCyclic.MODID);
    public static final RegistryObject<MenuType<ContainerBattery>> BATTERY = CONTAINERS.register("battery", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerBattery(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
    public static final RegistryObject<MenuType<ContainerClayBattery>> BATTERY_CLAY = CONTAINERS.register("battery_clay", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerClayBattery(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
    public static final RegistryObject<MenuType<ContainerAnvil>> ANVIL = CONTAINERS.register("anvil", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerAnvil(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
    public static final RegistryObject<MenuType<ContainerDetector>> DETECTOR_ENTITY = CONTAINERS.register("detector_entity", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerDetector(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
    public static final RegistryObject<MenuType<ContainerDetectorItem>> DETECTOR_ITEM = CONTAINERS.register("detector_item", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerDetectorItem(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
    public static final RegistryObject<MenuType<ContainerWorkbench>> WORKBENCH = CONTAINERS.register("workbench", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerWorkbench(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
    public static final RegistryObject<MenuType<ContainerLaser>> LASER = CONTAINERS.register("laser", () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerLaser(windowId, inv.player.level(), data.readBlockPos(), inv, inv.player)));
    public static final RegistryObject<MenuType<CraftingStickContainer>> CRAFTING_STICK = CONTAINERS.register("crafting_stick", () -> IForgeMenuType.create((windowId, inv, data) -> new CraftingStickContainer(windowId, inv, inv.player, data.readInt())));
}
