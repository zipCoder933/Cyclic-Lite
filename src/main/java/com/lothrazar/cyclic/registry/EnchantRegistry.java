package com.lothrazar.cyclic.registry;

import com.lothrazar.cyclic.ModCyclic;
//import com.lothrazar.cyclic.enchant.AutoSmeltEnchant;
import com.lothrazar.cyclic.enchant.BeekeeperEnchant;
import com.lothrazar.cyclic.enchant.BeheadingEnchant;
import com.lothrazar.cyclic.enchant.DisarmEnchant;
import com.lothrazar.cyclic.enchant.EnderPearlEnchant;
//import com.lothrazar.cyclic.enchant.ExcavationEnchant;
import com.lothrazar.cyclic.enchant.GloomCurseEnchant;
import com.lothrazar.cyclic.enchant.GrowthEnchant;
//import com.lothrazar.cyclic.enchant.LastStandEnchant;
import com.lothrazar.cyclic.enchant.LifeLeechEnchant;
import com.lothrazar.cyclic.enchant.MagnetEnchant;
import com.lothrazar.cyclic.enchant.MultiBowEnchant;
import com.lothrazar.cyclic.enchant.MultiJumpEnchant;
import com.lothrazar.cyclic.enchant.QuickdrawEnchant;
import com.lothrazar.cyclic.enchant.ReachEnchant;
import com.lothrazar.cyclic.enchant.SteadyEnchant;
import com.lothrazar.cyclic.enchant.StepEnchant;
import com.lothrazar.cyclic.enchant.TravellerEnchant;
import com.lothrazar.cyclic.enchant.VenomEnchant;
//import com.lothrazar.cyclic.enchant.XpEnchant;
import com.lothrazar.library.enchant.EnchantmentFlib;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnchantRegistry {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, ModCyclic.MODID);
    private static final EquipmentSlot[] ARMOR_SLOTS = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};

//    public static final RegistryObject<MultiJumpEnchant> LAUNCH = ENCHANTMENTS.register(MultiJumpEnchant.ID, () -> new MultiJumpEnchant(Enchantment.Rarity.RARE, EnchantmentCategory.WEARABLE, new EquipmentSlot[]{EquipmentSlot.CHEST, EquipmentSlot.FEET}));
//    public static final RegistryObject<MultiBowEnchant> MULTIBOW = ENCHANTMENTS.register(MultiBowEnchant.ID, () -> new MultiBowEnchant(Enchantment.Rarity.COMMON, EnchantmentCategory.BOW, EquipmentSlot.MAINHAND));
//    public static final RegistryObject<ExcavationEnchant> EXCAVATE = ENCHANTMENTS.register(ExcavationEnchant.ID, () -> new ExcavationEnchant(Enchantment.Rarity.RARE, EnchantmentCategory.DIGGER, EquipmentSlot.MAINHAND));
//    public static final RegistryObject<BeheadingEnchant> BEHEADING = ENCHANTMENTS.register(BeheadingEnchant.ID, () -> new BeheadingEnchant(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
//    public static final RegistryObject<GrowthEnchant> GROWTH = ENCHANTMENTS.register(GrowthEnchant.ID, () -> new GrowthEnchant(Enchantment.Rarity.COMMON, EnchantmentCategory.DIGGER, EquipmentSlot.MAINHAND));
//    public static final RegistryObject<LifeLeechEnchant> LIFELEECH = ENCHANTMENTS.register(LifeLeechEnchant.ID, () -> new LifeLeechEnchant(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
//    public static final RegistryObject<QuickdrawEnchant> QUICKDRAW = ENCHANTMENTS.register(QuickdrawEnchant.ID, () -> new QuickdrawEnchant(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.BOW, EquipmentSlot.MAINHAND));
//    public static final RegistryObject<ReachEnchant> REACH = ENCHANTMENTS.register(ReachEnchant.ID, () -> new ReachEnchant(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEARABLE, ARMOR_SLOTS));
//    public static final RegistryObject<VenomEnchant> VENOM = ENCHANTMENTS.register(VenomEnchant.ID, () -> new VenomEnchant(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
////    public static final RegistryObject<AutoSmeltEnchant> AUTOSMELT = ENCHANTMENTS.register(AutoSmeltEnchant.ID, () -> new AutoSmeltEnchant(Enchantment.Rarity.RARE, EnchantmentCategory.DIGGER, EquipmentSlot.MAINHAND));
//    public static final RegistryObject<DisarmEnchant> DISARM = ENCHANTMENTS.register(DisarmEnchant.ID, () -> new DisarmEnchant(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
//    public static final RegistryObject<GloomCurseEnchant> CURSE = ENCHANTMENTS.register(GloomCurseEnchant.ID, () -> new GloomCurseEnchant(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR, EquipmentSlot.CHEST));
//    public static final RegistryObject<EnderPearlEnchant> PEARL = ENCHANTMENTS.register(EnderPearlEnchant.ID, () -> new EnderPearlEnchant(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
//    public static final RegistryObject<LastStandEnchant> STAND = ENCHANTMENTS.register(LastStandEnchant.ID, () -> new LastStandEnchant(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.ARMOR_LEGS, EquipmentSlot.LEGS));
//    public static final RegistryObject<EnchantmentFlib> EXPERIENCE_BOOST = ENCHANTMENTS.register(XpEnchant.ID, () -> new XpEnchant(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.DIGGER, EquipmentSlot.MAINHAND));

    public static final RegistryObject<TravellerEnchant> TRAVELLER = ENCHANTMENTS.register(TravellerEnchant.ID, () -> new TravellerEnchant(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR_LEGS, EquipmentSlot.LEGS));
    public static final RegistryObject<SteadyEnchant> STEADY = ENCHANTMENTS.register(SteadyEnchant.ID, () -> new SteadyEnchant(Enchantment.Rarity.RARE, EnchantmentCategory.WEARABLE, new EquipmentSlot[]{EquipmentSlot.CHEST, EquipmentSlot.LEGS}));
    public static final RegistryObject<MagnetEnchant> MAGNET = ENCHANTMENTS.register(MagnetEnchant.ID, () -> new MagnetEnchant(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.BREAKABLE, EquipmentSlot.MAINHAND));

    //Allows you to step up (like step up apple)
    public static final RegistryObject<StepEnchant> STEP = ENCHANTMENTS.register(StepEnchant.ID, () -> new StepEnchant(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR_FEET, EquipmentSlot.FEET));

    public static final RegistryObject<BeekeeperEnchant> BEEKEEPER = ENCHANTMENTS.register(BeekeeperEnchant.ID, () -> new BeekeeperEnchant(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.ARMOR_HEAD, EquipmentSlot.HEAD));
}
