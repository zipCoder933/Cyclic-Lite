package com.lothrazar.cyclic.registry;

import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.block.scaffolding.ItemScaffolding;
import com.lothrazar.cyclic.item.GemstoneItem;
import com.lothrazar.cyclic.item.ItemBaseCyclic;
import com.lothrazar.cyclic.item.bauble.AutoTorchItem;
import com.lothrazar.cyclic.item.bauble.CharmVoid;
import com.lothrazar.cyclic.item.bauble.ItemBaseToggle;
import com.lothrazar.cyclic.item.crafting.simple.CraftingStickItem;
import com.lothrazar.cyclic.item.elemental.DarkFireballItem;
import com.lothrazar.cyclic.item.elemental.FireballItem;
import com.lothrazar.cyclic.item.elemental.TorchThrowingItem;
import com.lothrazar.cyclic.item.ender.EnderBagItem;
import com.lothrazar.cyclic.item.equipment.*;
import com.lothrazar.cyclic.item.equipment.ShieldCyclicItem.ShieldType;
import com.lothrazar.cyclic.item.transporter.TileTransporterEmptyItem;
import com.lothrazar.cyclic.registry.MaterialRegistry.ToolMats;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;


/**
 * The key is to only keep items that are totally unique, no other mod has them
 */
public class ItemRegistry {

    public static List<ItemBaseCyclic> ITEMSFIXME = new ArrayList<>();
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModCyclic.MODID);

    //Really useful items
    public static final RegistryObject<Item> GLOWING_HELMET = ITEMS.register("glowing_helmet", () -> new GlowingHelmetItem(MaterialRegistry.ArmorMats.GLOWING, ArmorItem.Type.HELMET, (new Item.Properties())));
    public static final RegistryObject<Item> CHARM_STEALTHPOTION = ITEMS.register("charm_stealthpotion", () -> new ItemBaseToggle(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> DETECTORMOON = ITEMS.register("detector_moon", () -> new BlockItem(BlockRegistry.DETECTORMOON.get(), new Item.Properties()));
    //Glass
    //public static final RegistryObject<Item> TERRAGLASS = ITEMS.register("terra_glass", () -> new BlockItem(BlockRegistry.TERRAGLASS.get(), new Item.Properties()));
    //public static final RegistryObject<Item> GLASS_CONNECTED = ITEMS.register("glass_connected", () -> new BlockItem(BlockRegistry.GLASS_CONNECTED.get(), new Item.Properties()));
    public static final RegistryObject<Item> DARK_GLASS = ITEMS.register("dark_glass", () -> new BlockItem(BlockRegistry.DARK_GLASS.get(), new Item.Properties()));
    public static final RegistryObject<Item> DARK_GLASS_CONNECTED = ITEMS.register("dark_glass_connected", () -> new BlockItem(BlockRegistry.DARK_GLASS_CONNECTED.get(), new Item.Properties()));


    public static final RegistryObject<Item> SPIKES_DIAMOND = ITEMS.register("spikes_diamond", () -> new BlockItem(BlockRegistry.SPIKES_DIAMOND.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPIKES_IRON = ITEMS.register("spikes_iron", () -> new BlockItem(BlockRegistry.SPIKES_IRON.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPIKES_CURSE = ITEMS.register("spikes_curse", () -> new BlockItem(BlockRegistry.SPIKES_CURSE.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPIKES_FIRE = ITEMS.register("spikes_fire", () -> new BlockItem(BlockRegistry.SPIKES_FIRE.get(), new Item.Properties()));


    public static final RegistryObject<Item> GEM_OBSIDIAN = ITEMS.register("gem_obsidian", () -> new GemstoneItem(new Item.Properties()));
    public static final RegistryObject<Item> GEM_AMBER = ITEMS.register("gem_amber", () -> new GemstoneItem(new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_COBBLESTONE = ITEMS.register("compressed_cobblestone", () -> new BlockItem(BlockRegistry.COMPRESSED_COBBLESTONE.get(), new Item.Properties()));


    //If anything, we can just remove the item from the registry
    //  public static final RegistryObject<Item> EYE_REDSTONE = ITEMS.register("eye_redstone", () -> new BlockItem(BlockRegistry.EYE_REDSTONE.get(), new Item.Properties()));
    public static final RegistryObject<Item> EYE_TELEPORT = ITEMS.register("eye_teleport", () -> new BlockItem(BlockRegistry.EYE_TELEPORT.get(), new Item.Properties()));
     public static final RegistryObject<Item> ANVIL = ITEMS.register("anvil", () -> new BlockItem(BlockRegistry.ANVIL.get(), new Item.Properties()));
    public static final RegistryObject<Item> UNBREAKABLE_BLOCK = ITEMS.register("unbreakable_block", () -> new BlockItem(BlockRegistry.UNBREAKABLE_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> UNBREAKABLE_REACTIVE = ITEMS.register("unbreakable_reactive", () -> new BlockItem(BlockRegistry.UNBREAKABLE_REACTIVE.get(), new Item.Properties()));
    public static final RegistryObject<Item> WORKBENCH = ITEMS.register("workbench", () -> new BlockItem(BlockRegistry.WORKBENCH.get(), new Item.Properties()));

    //Durable shears
//    public static final RegistryObject<Item> SHEARS_OBSIDIAN = ITEMS.register("shears_obsidian", () -> new ShearsMaterial(new Item.Properties().durability(1024 * 1024)));

    //Scaffolding
    public static final RegistryObject<Item> SCAFFOLD_FRAGILE = ITEMS.register("scaffold_fragile", () -> new ItemScaffolding(BlockRegistry.SCAFFOLD_FRAGILE.get(), new Item.Properties()));
    public static final RegistryObject<Item> SCAFFOLD_RESPONSIVE = ITEMS.register("scaffold_responsive", () -> new ItemScaffolding(BlockRegistry.SCAFFOLD_RESPONSIVE.get(), new Item.Properties()));

    //Misc
    public static final RegistryObject<Item> ENDER_TORCH = ITEMS.register("ender_torch", () -> new TorchThrowingItem(new Item.Properties()));
    public static final RegistryObject<Item> FIREBALL_ORANGE = ITEMS.register("fireball", () -> new FireballItem(new Item.Properties()));
    public static final RegistryObject<Item> FIREBALL_DARK = ITEMS.register("fireball_dark", () -> new DarkFireballItem(new Item.Properties()));


    //Shields (Basically just regular shields with more durability)
    //Shield tier is as follows: Flint, Leather, Bone, Obsidian
    //A vanilla shield has 336 durability
    private static final int VANILLA_SHIELD_DURABILITY = 336;
    //public static final RegistryObject<Item> SHIELD_WOOD = ITEMS.register("shield_wood", () -> new ShieldCyclicItem(new Item.Properties().durability(84), ShieldType.WOOD));
    //More durable than vanilla shield
    public static final RegistryObject<Item> SHIELD_LEATHER = ITEMS.register("shield_leather", () -> new ShieldCyclicItem(
            new Item.Properties().durability((int) (VANILLA_SHIELD_DURABILITY * 1.25f)), ShieldType.LEATHER));

    //More durable than leather shield
    public static final RegistryObject<Item> SHIELD_BONE = ITEMS.register("shield_bone", () -> new ShieldCyclicItem(
            new Item.Properties().durability((int) (VANILLA_SHIELD_DURABILITY * 1.75f)), ShieldType.BONE));

    //Most durable
    public static final RegistryObject<Item> SHIELD_OBSIDIAN = ITEMS.register("shield_obsidian", () -> new ShieldCyclicItem(
            new Item.Properties().durability((int) (VANILLA_SHIELD_DURABILITY * 4f)), ShieldType.OBSIDIAN));


    /**
     * Armor and tools
     */
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(MaterialRegistry.ToolMats.COPPER, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe", () -> new HoeItem(ToolMats.COPPER, -4, 0F, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new SwordItem(MaterialRegistry.ToolMats.COPPER, 3, -2.4F, (new Item.Properties())));
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(MaterialRegistry.ToolMats.COPPER, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(MaterialRegistry.ToolMats.COPPER, 6.0F, -3.1F, new Item.Properties()));


    public static final RegistryObject<Item> AMETHYST_SHOVEL = ITEMS.register("amethyst_shovel", () -> new AmethystShovelItem(MaterialRegistry.ToolMats.AMETHYST, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_HOE = ITEMS.register("amethyst_hoe", () -> new AmethystHoeItem(ToolMats.AMETHYST, -4, 0F, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_SWORD = ITEMS.register("amethyst_sword", () -> new SwordItem(MaterialRegistry.ToolMats.AMETHYST, 3, -2.4F, (new Item.Properties())));
    public static final RegistryObject<Item> AMETHYST_PICKAXE = ITEMS.register("amethyst_pickaxe", () -> new AmethystPickaxeItem(MaterialRegistry.ToolMats.AMETHYST, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_AXE = ITEMS.register("amethyst_axe", () -> new AmethystAxeItem(MaterialRegistry.ToolMats.AMETHYST, 6.0F, -3.1F, new Item.Properties()));


    public static final RegistryObject<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots", () -> new ArmorItem(MaterialRegistry.ArmorMats.EMERALD, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet", () -> new ArmorItem(MaterialRegistry.ArmorMats.EMERALD, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate", () -> new ArmorItem(MaterialRegistry.ArmorMats.EMERALD, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings", () -> new ArmorItem(MaterialRegistry.ArmorMats.EMERALD, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel", () -> new ShovelItem(MaterialRegistry.ToolMats.EMERALD, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe", () -> new HoeItem(ToolMats.EMERALD, -4, 0F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword", () -> new SwordItem(MaterialRegistry.ToolMats.EMERALD, 3, -2.4F, (new Item.Properties())));
    public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", () -> new PickaxeItem(MaterialRegistry.ToolMats.EMERALD, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe", () -> new AxeItem(MaterialRegistry.ToolMats.EMERALD, 5.0F, -3.0F, new Item.Properties()));


    public static final RegistryObject<Item> CRYSTAL_BOOTS = ITEMS.register("crystal_boots", () -> new ArmorItem(MaterialRegistry.ArmorMats.GEMOBSIDIAN, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_HELMET = ITEMS.register("crystal_helmet", () -> new ArmorItem(MaterialRegistry.ArmorMats.GEMOBSIDIAN, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_CHESTPLATE = ITEMS.register("crystal_chestplate", () -> new ArmorItem(MaterialRegistry.ArmorMats.GEMOBSIDIAN, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_LEGGINGS = ITEMS.register("crystal_leggings", () -> new ArmorItem(MaterialRegistry.ArmorMats.GEMOBSIDIAN, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_SHOVEL = ITEMS.register("crystal_shovel", () -> new ShovelItem(MaterialRegistry.ToolMats.GEMOBSIDIAN, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_HOE = ITEMS.register("crystal_hoe", () -> new HoeItem(ToolMats.GEMOBSIDIAN, -4, 0F, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_SWORD = ITEMS.register("crystal_sword", () -> new SwordItem(MaterialRegistry.ToolMats.GEMOBSIDIAN, 3, -2.4F, (new Item.Properties())));
    public static final RegistryObject<Item> CRYSTAL_PICKAXE = ITEMS.register("crystal_pickaxe", () -> new PickaxeItem(MaterialRegistry.ToolMats.GEMOBSIDIAN, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_AXE = ITEMS.register("crystal_axe", () -> new AxeItem(MaterialRegistry.ToolMats.GEMOBSIDIAN, 5.0F, -3.0F, new Item.Properties()));

    //Creative gear
    public static final RegistryObject<Item> CREATIVE_SWORD = ITEMS.register("creative_sword", () -> new SwordItem(ToolMats.CREATIVE, 3, -2.4F, (new Item.Properties())));
    public static final RegistryObject<Item> CREATIVE_BATTERY = ITEMS.register("battery_infinite", () -> new BlockItem(BlockRegistry.BATTERY_INFINITE.get(), new Item.Properties()));


    /**
     * Redstone related items
     */
    public static final RegistryObject<Item> WAXED_REDSTONE = ITEMS.register("waxed_redstone", () -> new BlockItem(BlockRegistry.WAXED_REDSTONE.get(), new Item.Properties()));
    public static final RegistryObject<Item> WATER_CANDLE = ITEMS.register("water_candle", () -> new BlockItem(BlockRegistry.WATER_CANDLE.get(), new Item.Properties()));
    public static final RegistryObject<Item> ALTAR_DESTRUCTION = ITEMS.register("altar_destruction", () -> new BlockItem(BlockRegistry.ALTAR_DESTRUCTION.get(), new Item.Properties()));

    public static final RegistryObject<Item> CRAFTING_STICK = ITEMS.register("crafting_stick", () -> new CraftingStickItem(new Item.Properties().stacksTo(1).setNoRepair()));
    public static final RegistryObject<Item> TILE_TRANSPORTER_EMPTY = ITEMS.register("tile_transporter_empty", () -> new TileTransporterEmptyItem(new Item.Properties()));

    //Ender stuff
    public static final RegistryObject<Item> ENDER_BAG = ITEMS.register("ender_bag", () -> new EnderBagItem(new Item.Properties()));
    public static final RegistryObject<Item> CHARM_MAGICDEF = ITEMS.register("charm_magicdefense", () -> new ItemBaseToggle(new Item.Properties().durability(256 * 4)));
    public static final RegistryObject<Item> CHARM_STARVATION = ITEMS.register("charm_starvation", () -> new ItemBaseToggle(new Item.Properties().durability(256 * 256)));
    public static final RegistryObject<Item> CHARM_LUCK = ITEMS.register("charm_luck", () -> new ItemBaseToggle(new Item.Properties().durability(256 * 4)));
    public static final RegistryObject<Item> CHARM_VOID = ITEMS.register("charm_void", () -> new CharmVoid(new Item.Properties().durability(64)));
    public static final RegistryObject<Item> CHARM_TORCH = ITEMS.register("charm_torch", () -> new AutoTorchItem(new Item.Properties().durability(256 * 4)));


    //Flowers
//    public static final RegistryObject<Item> FLOWER_CYAN = ITEMS.register("flower_cyan", () -> new BlockItem(BlockRegistry.FLOWER_CYAN.get(), new Item.Properties()));
//    public static final RegistryObject<Item> FLOWER_PURPLE = ITEMS.register("flower_purple_tulip", () -> new BlockItem(BlockRegistry.FLOWER_PURPLE_TULIP.get(), new Item.Properties()));
//    public static final RegistryObject<Item> FLOWER_BROWN = ITEMS.register("flower_absalon_tulip", () -> new BlockItem(BlockRegistry.FLOWER_ABSALON_TULIP.get(), new Item.Properties()));
//    public static final RegistryObject<Item> FLOWER_LIME = ITEMS.register("flower_lime_carnation", () -> new BlockItem(BlockRegistry.FLOWER_LIME_CARNATION.get(), new Item.Properties()));

}
