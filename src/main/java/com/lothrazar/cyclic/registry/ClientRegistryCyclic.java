package com.lothrazar.cyclic.registry;

import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.block.BlockCyclic;
import com.lothrazar.cyclic.capabilities.ClientDataManager;
import com.lothrazar.cyclic.event.ClientInputEvents;
import com.lothrazar.cyclic.item.ItemBaseCyclic;
import com.lothrazar.cyclic.item.equipment.ShieldCyclicItem;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.client.settings.IKeyConflictContext;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegistryCyclic {

  //TODO: refactor split into keyboard registry, overlay registry, other renderers below 
  public static final KeyMapping CAKE = new KeyMapping("key." + ModCyclic.MODID + ".cake", new IKeyConflictContext() {

    @Override
    public boolean isActive() {
      //client side cant know when active. stored on server player file 
      //maybe when no gui is open 
      return true;
    }

    @Override
    public boolean conflicts(IKeyConflictContext other) {
      return this == other || KeyConflictContext.IN_GAME == other;
    }
  }, InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_X), "key." + ModCyclic.MODID + ".category");
  //IIngameOverlay
  public static final IGuiOverlay HUD_MANA = (gui, poseStack, partialTicks, width, height) -> {
    //cancel if turned off
    if (!FeatureRegistry.PLAYER_RENDER_CAPS) {
      return;
    }
    //ok go
    if (Minecraft.getInstance().player.getMainHandItem().is(ItemRegistry.CREATIVE_BATTERY.get())) {
      final String toDisplay = "P:" + ClientDataManager.getPlayerMana() + " CH:" + ClientDataManager.getChunkMana();
      int x = 10; // ManaConfig.MANA_HUD_X.get();
      int y = 10; // ManaConfig.MANA_HUD_Y.get(); //TODO: client-config
      if (x >= 0 && y >= 0) {
        poseStack.drawString(gui.getFont(), toDisplay, x, y, 0xFF0000);
        //        gui.getFont().draw(poseStack, toDisplay, x, y, 0xFF0000); // client config color
      }
    }
  };

  public ClientRegistryCyclic() {
    MinecraftForge.EVENT_BUS.register(new ClientInputEvents());
  }

  public static void setupClient(final FMLClientSetupEvent event) {
    for (BlockCyclic b : BlockRegistry.BLOCKSCLIENTREGISTRY) {
      b.registerClient();
    }
    for (ItemBaseCyclic i : ItemRegistry.ITEMSFIXME) {
      i.registerClient();
    }
    initShields();
  }

  @SubscribeEvent
  public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
//    event.registerBlockEntityRenderer(TileRegistry.DETECTOR_ENTITY.get(), RenderDetector::new);
//    event.registerBlockEntityRenderer(TileRegistry.DETECTOR_ITEM.get(), RenderDetectorItem::new);
//    event.registerBlockEntityRenderer(TileRegistry.LASER.get(), RenderLaser::new);
  }

  @SuppressWarnings("deprecation") //shield itemproperty
  private static void initShields() {
    //this matches up with ShieldCyclicItem where it calls startUsingItem() inside of use()
    net.minecraft.client.renderer.item.ItemPropertyFunction blockFn = (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F;
    ItemProperties.register(ItemRegistry.SHIELD_LEATHER.get(), ShieldCyclicItem.BLOCKING, blockFn);
//    ItemProperties.register(ItemRegistry.SHIELD_FLINT.get(), ShieldCyclicItem.BLOCKING, blockFn);
    ItemProperties.register(ItemRegistry.SHIELD_BONE.get(), ShieldCyclicItem.BLOCKING, blockFn);
    ItemProperties.register(ItemRegistry.SHIELD_OBSIDIAN.get(), ShieldCyclicItem.BLOCKING, blockFn);
  }

  //    OverlayRegistry.registerOverlayAbove(ForgeIngameGui.HOTBAR_ELEMENT, "data", HUD_MANA);
  @SubscribeEvent
  public static void onRegisterGuiOverlays(RegisterGuiOverlaysEvent event) {
    event.registerAbove(VanillaGuiOverlay.HOTBAR.id(), ModCyclic.MODID, HUD_MANA);
  }

  @SubscribeEvent
  public static void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
    //    net.minecraftforge.client.ClientRegistry.registerKeyBinding(CAKE);
    event.register(CAKE);
  }

  @OnlyIn(Dist.CLIENT)
  @SubscribeEvent
  public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
  }

  @OnlyIn(Dist.CLIENT)
  @SubscribeEvent
  public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
    event.registerEntityRenderer(EntityRegistry.SNOW_BOLT.get(), ThrownItemRenderer::new);
    event.registerEntityRenderer(EntityRegistry.TORCH_BOLT.get(), ThrownItemRenderer::new);
    event.registerEntityRenderer(EntityRegistry.EYE.get(), ThrownItemRenderer::new);
    event.registerEntityRenderer(EntityRegistry.FIRE_BOLT.get(), ThrownItemRenderer::new);
    event.registerEntityRenderer(EntityRegistry.DARKFIRE_BOLT.get(), ThrownItemRenderer::new);
    event.registerEntityRenderer(EntityRegistry.STONE_BOLT.get(), ThrownItemRenderer::new);
    event.registerEntityRenderer(EntityRegistry.LIGHTNING_BOLT.get(), ThrownItemRenderer::new);
    event.registerEntityRenderer(EntityRegistry.MAGIC_MISSILE.get(), ThrownItemRenderer::new);
  }
}
