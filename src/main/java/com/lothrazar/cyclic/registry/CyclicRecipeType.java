package com.lothrazar.cyclic.registry;

import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.block.generatorfluid.RecipeGeneratorFluid;
import com.lothrazar.cyclic.block.generatorfluid.RecipeGeneratorFluid.SerializeGenerateFluid;
import com.lothrazar.cyclic.block.generatoritem.RecipeGeneratorItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CyclicRecipeType {

  public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, ModCyclic.MODID);
  public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ModCyclic.MODID);

  public static final RegistryObject<RecipeType<RecipeGeneratorItem>> GENERATOR_ITEM = RECIPE_TYPES.register("generator_item", () -> new RecipeType<RecipeGeneratorItem>() {});
  public static final RegistryObject<RecipeGeneratorItem.SerializeGenerateItem> GENERATOR_ITEM_S = RECIPE_SERIALIZERS.register("generator_item", () -> new RecipeGeneratorItem.SerializeGenerateItem());
  //
  public static final RegistryObject<RecipeType<RecipeGeneratorFluid>> GENERATOR_FLUID = RECIPE_TYPES.register("generator_fluid", () -> new RecipeType<RecipeGeneratorFluid>() {});
  public static final RegistryObject<SerializeGenerateFluid> GENERATOR_FLUID_S = RECIPE_SERIALIZERS.register("generator_fluid", () -> new SerializeGenerateFluid());
}
