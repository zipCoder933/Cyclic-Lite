package com.lothrazar.cyclic.registry;

import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.block.*;
import com.lothrazar.cyclic.block.anvil.BlockAnvilAuto;
import com.lothrazar.cyclic.block.battery.BlockBattery;
import com.lothrazar.cyclic.block.batteryclay.ClayBattery;
import com.lothrazar.cyclic.block.batterycreative.BlockBatteryInfinite;
import com.lothrazar.cyclic.block.bedrock.UnbreakableBlock;
import com.lothrazar.cyclic.block.bedrock.UnbreakablePoweredBlock;
import com.lothrazar.cyclic.block.detectmoon.BlockMoon;
import com.lothrazar.cyclic.block.detectorentity.BlockDetector;
import com.lothrazar.cyclic.block.detectoritem.BlockDetectorItem;
import com.lothrazar.cyclic.block.detectweather.BlockWeather;
import com.lothrazar.cyclic.block.eye.BlockEye;
import com.lothrazar.cyclic.block.eyetp.BlockEyeTp;
import com.lothrazar.cyclic.block.glass.DarkGlassBlock;
import com.lothrazar.cyclic.block.glass.DarkGlassConnectedBlock;
import com.lothrazar.cyclic.block.laser.BlockLaser;
import com.lothrazar.cyclic.block.scaffolding.BlockScaffolding;
import com.lothrazar.cyclic.block.scaffolding.BlockScaffoldingResponsive;
import com.lothrazar.cyclic.block.spikes.EnumSpikeType;
import com.lothrazar.cyclic.block.spikes.SpikesBlock;
import com.lothrazar.cyclic.block.spikes.SpikesDiamond;
import com.lothrazar.cyclic.block.terraglass.BlockTerraGlass;
import com.lothrazar.cyclic.block.workbench.BlockWorkbench;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegistry {


    /*
     * Contains the creative mode tabs
     */
    //First we define these
    private static final ResourceKey<CreativeModeTab> TAB_ITEMS = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(ModCyclic.MODID, "items"));
    private static final ResourceKey<CreativeModeTab> TAB_BLOCKS = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(ModCyclic.MODID, "tab"));
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModCyclic.MODID);


    @SubscribeEvent
    public static void onCreativeModeTabRegister(RegisterEvent event) {
        event.register(Registries.CREATIVE_MODE_TAB, helper -> {

            //make just one creative mode tab for cyclic
            helper.register(TAB_ITEMS, CreativeModeTab.builder().icon(() -> new ItemStack(ItemRegistry.GEM_OBSIDIAN.get().asItem()))
                    .title(Component.translatable("itemGroup." + ModCyclic.MODID))
                    .displayItems((enabledFlags, populator) -> {
                        //Add items
                        for (RegistryObject<Item> itemHolder : ItemRegistry.ITEMS.getEntries()) {
                            ItemStack stupidForgeFiringEventsOutOfOrder = new ItemStack(itemHolder.get());
                            if (!stupidForgeFiringEventsOutOfOrder.isEmpty() && Block.byItem(itemHolder.get()) == Blocks.AIR)
                                populator.accept(stupidForgeFiringEventsOutOfOrder);
                        }
                        //Add blocks
                        for (RegistryObject<Block> b : BlockRegistry.BLOCKS.getEntries()) {
                            ItemStack stupidForgeFiringEventsOutOfOrder = new ItemStack(b.get());
                            if (!stupidForgeFiringEventsOutOfOrder.isEmpty())
                                populator.accept(stupidForgeFiringEventsOutOfOrder);
                        }
                    }).build());

//            helper.register(TAB_ITEMS, CreativeModeTab.builder().icon(() -> new ItemStack(ItemRegistry.GEM_AMBER.get().asItem()))
//                    .title(Component.translatable("itemGroup." + ModCyclic.MODID + "items"))
//                    .displayItems((enabledFlags, populator) -> {
//                        for (RegistryObject<Item> itemHolder : ItemRegistry.ITEMS.getEntries()) {
//                            ItemStack stupidForgeFiringEventsOutOfOrder = new ItemStack(itemHolder.get());
//                            if (!stupidForgeFiringEventsOutOfOrder.isEmpty() && Block.byItem(itemHolder.get()) == Blocks.AIR)
//                                populator.accept(stupidForgeFiringEventsOutOfOrder);
//                        }
//                    }).build());
//            helper.register(TAB_BLOCKS, CreativeModeTab.builder().icon(() -> new ItemStack(ItemRegistry.GEM_OBSIDIAN.get().asItem()))
//                    .title(Component.translatable("itemGroup." + ModCyclic.MODID))
//                    .displayItems((enabledFlags, populator) -> {
//                        for (RegistryObject<Block> b : BlockRegistry.BLOCKS.getEntries()) {
//                            ItemStack stupidForgeFiringEventsOutOfOrder = new ItemStack(b.get());
//                            if (!stupidForgeFiringEventsOutOfOrder.isEmpty())
//                                populator.accept(stupidForgeFiringEventsOutOfOrder);
//                        }
//                    }).build());
        });
    }

    public static List<BlockCyclic> BLOCKSCLIENTREGISTRY = new ArrayList<>(); // TODO: 1.19 ? refactor this
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModCyclic.MODID);
    public static final RegistryObject<Block> COMPRESSED_COBBLESTONE = BLOCKS.register("compressed_cobblestone", () -> new BlockSimple(Block.Properties.of().strength(1.0F, 7.0F)) {

        @Override
        public void appendHoverText(ItemStack stack, BlockGetter worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        }
    });
    public static final RegistryObject<Block> FLINT_BLOCK = BLOCKS.register("flint_block", () -> new BlockSimple(Block.Properties.of().strength(1.3F, 5.0F)) {

        @Override
        public void appendHoverText(ItemStack stack, BlockGetter worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        }
    });
    public static final RegistryObject<Block> SPIKES_IRON = BLOCKS.register("spikes_iron", () -> new SpikesBlock(Block.Properties.of(), EnumSpikeType.PLAIN));
    public static final RegistryObject<Block> SPIKES_FIRE = BLOCKS.register("spikes_fire", () -> new SpikesBlock(Block.Properties.of(), EnumSpikeType.FIRE));
    public static final RegistryObject<Block> SPIKES_CURSE = BLOCKS.register("spikes_curse", () -> new SpikesBlock(Block.Properties.of(), EnumSpikeType.CURSE));
    public static final RegistryObject<Block> SPIKES_DIAMOND = BLOCKS.register("spikes_diamond", () -> new SpikesDiamond(Block.Properties.of()));

    public static final RegistryObject<Block> DETECTORMOON = BLOCKS.register("detector_moon", () -> new BlockMoon(Block.Properties.of()));
    public static final RegistryObject<Block> DETECTORWEATHER = BLOCKS.register("detector_weather", () -> new BlockWeather(Block.Properties.of()));
    public static final RegistryObject<Block> TERRAGLASS = BLOCKS.register("terra_glass", () -> new BlockTerraGlass(Block.Properties.copy(Blocks.GLASS)));

    public static final RegistryObject<Block> DARK_GLASS_CONNECTED = BLOCKS.register("dark_glass_connected", () -> new DarkGlassConnectedBlock(Block.Properties.of()));
    //public static final RegistryObject<Block> GLASS_CONNECTED = BLOCKS.register("glass_connected", () -> new GlassConnectedBlock(Block.Properties.of().sound(SoundType.GLASS).strength(0.3F)));

    public static final RegistryObject<Block> LASER = BLOCKS.register("laser", () -> new BlockLaser(Block.Properties.of()));

//    public static final RegistryObject<Block> FLOWER_CYAN = BLOCKS.register("flower_cyan", () -> new FlowerSimpleBlock(Block.Properties.of()));
//    public static final RegistryObject<Block> FLOWER_PURPLE_TULIP = BLOCKS.register("flower_purple_tulip", () -> new FlowerSimpleBlock(Block.Properties.of()));
//    public static final RegistryObject<Block> FLOWER_LIME_CARNATION = BLOCKS.register("flower_lime_carnation", () -> new FlowerSimpleBlock(Block.Properties.of()));
//    public static final RegistryObject<Block> FLOWER_ABSALON_TULIP = BLOCKS.register("flower_absalon_tulip", () -> new FlowerSimpleBlock(Block.Properties.of()));

    public static final RegistryObject<Block> WORKBENCH = BLOCKS.register("workbench", () -> new BlockWorkbench(Block.Properties.of()));


    public static final RegistryObject<Block> WATER_CANDLE = BLOCKS.register("water_candle", () -> new CandleWaterBlock(Block.Properties.of()
            .lightLevel(p -> p.getValue(BlockCyclic.LIT) ? 1 : 0)));


    public static final RegistryObject<Block> SCAFFOLD_FRAGILE = BLOCKS.register("scaffold_fragile", () -> new BlockScaffolding(Block.Properties.of(), true));
    public static final RegistryObject<Block> SCAFFOLD_RESPONSIVE = BLOCKS.register("scaffold_responsive", () -> new BlockScaffoldingResponsive(Block.Properties.of(), false));


    public static final RegistryObject<Block> DARK_GLASS = BLOCKS.register("dark_glass", () -> new DarkGlassBlock(Block.Properties.of()));
    public static final RegistryObject<Block> PEAT_UNBAKED = BLOCKS.register("peat_unbaked", () -> new PeatBlock(Block.Properties.of().sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> PEAT_BAKED = BLOCKS.register("peat_baked", () -> new PeatFuelBlock(Block.Properties.of().sound(SoundType.GRAVEL)));


    public static final RegistryObject<Block> BATTERY = BLOCKS.register("battery", () -> new BlockBattery(Block.Properties.of()));
    public static final RegistryObject<Block> EYE_REDSTONE = BLOCKS.register("eye_redstone", () -> new BlockEye(Block.Properties.of()));
    public static final RegistryObject<Block> EYE_TELEPORT = BLOCKS.register("eye_teleport", () -> new BlockEyeTp(Block.Properties.of()));


    public static final RegistryObject<Block> ANVIL = BLOCKS.register("anvil", () -> new BlockAnvilAuto(Block.Properties.of().sound(SoundType.ANVIL)));


    public static final RegistryObject<Block> DETECTOR_ITEM = BLOCKS.register("detector_item", () -> new BlockDetectorItem(Block.Properties.of()));
    public static final RegistryObject<Block> DETECTOR_ENTITY = BLOCKS.register("detector_entity", () -> new BlockDetector(Block.Properties.of()));
    //    public static final RegistryObject<Block> PLATE_LAUNCH = BLOCKS.register("plate_launch", () -> new LaunchBlock(Block.Properties.of(), false));
//    public static final RegistryObject<Block> PLATE_LAUNCH_REDSTONE = BLOCKS.register("plate_launch_redstone", () -> new LaunchBlock(Block.Properties.of(), true));
    public static final RegistryObject<Block> BATTERY_INFINITE = BLOCKS.register("battery_infinite", () -> new BlockBatteryInfinite(Block.Properties.of()));
    public static final RegistryObject<Block> UNBREAKABLE_BLOCK = BLOCKS.register("unbreakable_block", () -> new UnbreakableBlock(Block.Properties.of())); //stable, only changes with player interaction
    public static final RegistryObject<Block> UNBREAKABLE_REACTIVE = BLOCKS.register("unbreakable_reactive", () -> new UnbreakablePoweredBlock(Block.Properties.of())); //reactive and unstable, ignores players and reads redstone
    public static final RegistryObject<Block> BUTTON_BASALT = BLOCKS.register("button_basalt", () -> new ButtonBlockMat(Block.Properties.of(), 30, true, 4));
    public static final RegistryObject<Block> BUTTON_BLACKSTONE = BLOCKS.register("button_blackstone", () -> new ButtonBlockMat(Block.Properties.of(), 20, true, 8));
    public static final RegistryObject<Block> BATTERY_CLAY = BLOCKS.register("battery_clay", () -> new ClayBattery(Block.Properties.of()));// NOGUI

    public static final RegistryObject<Block> ALTAR_DESTRUCTION = BLOCKS.register("altar_destruction", () -> new BlockDestruction(Block.Properties.of()));
    public static final RegistryObject<Block> WAXED_REDSTONE = BLOCKS.register("waxed_redstone", () -> new BlockWaxedRedstone(Block.Properties.of())); // , MaterialColor.FIRE


}
