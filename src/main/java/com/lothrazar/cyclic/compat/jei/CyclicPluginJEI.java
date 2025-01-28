package com.lothrazar.cyclic.compat.jei;

import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.block.workbench.ContainerWorkbench;
import com.lothrazar.cyclic.item.crafting.simple.CraftingStickContainer;
import com.lothrazar.cyclic.registry.BlockRegistry;
import com.lothrazar.cyclic.registry.ItemRegistry;
import com.lothrazar.cyclic.registry.MenuTypeRegistry;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.*;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

@JeiPlugin
public class CyclicPluginJEI implements IModPlugin {

  private static final int PLAYER_INV_SIZE = 4 * 9;
  private static final ResourceLocation ID = new ResourceLocation(ModCyclic.MODID, "jei");

  @Override
  public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {}

  @Override
  public ResourceLocation getPluginUid() {
    return ID;
  }

  @Override
  public void registerCategories(IRecipeCategoryRegistration registry) {
    IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();
  }

  @Override
  public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
    registration.addRecipeCatalyst(new ItemStack(ItemRegistry.CRAFTING_STICK.get()), RecipeTypes.CRAFTING);
    registration.addRecipeCatalyst(new ItemStack(BlockRegistry.WORKBENCH.get()), RecipeTypes.CRAFTING);
  }

  @Override
  public void registerRecipes(IRecipeRegistration registry) {
    ClientLevel world = Objects.requireNonNull(Minecraft.getInstance().level);
    RecipeManager rm = world.getRecipeManager();

    registry.addRecipes(RecipeTypes.CRAFTING, rm.getAllRecipesFor(RecipeType.CRAFTING));
//    registry.addRecipes(GenitemRecipeCategory.TYPE, List.copyOf(rm.getAllRecipesFor(CyclicRecipeType.GENERATOR_ITEM.get())));
//    registry.addRecipes(GenfluidRecipeCategory.TYPE, List.copyOf(rm.getAllRecipesFor(CyclicRecipeType.GENERATOR_FLUID.get())));
//    registry.addRecipes(CrusherRecipeCategory.TYPE, List.copyOf(rm.getAllRecipesFor(CyclicRecipeType.CRUSHER.get())));
//    registry.addRecipes(PackagerRecipeCategory.TYPE, List.copyOf(rm.getAllRecipesFor(RecipeType.CRAFTING)));
    for (RegistryObject<Item> item : ItemRegistry.ITEMS.getEntries()) {
      ItemStack st = new ItemStack(item.get());
      if (!st.isEmpty() && (st.getItem() instanceof BucketItem == false)) {
        registry.addIngredientInfo(st, VanillaTypes.ITEM_STACK, Component.translatable(item.get().getDescriptionId() + ".guide"));
      }
    }
  }

  @Override
  public void registerGuiHandlers(IGuiHandlerRegistration registry) {
  }

  @Override
  public void registerRecipeTransferHandlers(IRecipeTransferRegistration registry) {
    registry.addRecipeTransferHandler(CraftingStickContainer.class, MenuTypeRegistry.CRAFTING_STICK.get(), RecipeTypes.CRAFTING,
        1, 9, //recipeSLotStart, recipeSlotCount
        10, PLAYER_INV_SIZE); // inventorySlotStart, inventorySlotCount
    registry.addRecipeTransferHandler(ContainerWorkbench.class, MenuTypeRegistry.WORKBENCH.get(), RecipeTypes.CRAFTING,
        1, 9, //recipeSLotStart, recipeSlotCount
        10, PLAYER_INV_SIZE);
  }
}
