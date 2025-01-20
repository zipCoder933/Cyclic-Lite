//package com.lothrazar.cyclic.block.crate;
//
//import com.lothrazar.cyclic.gui.ScreenBase;
//import com.lothrazar.cyclic.registry.TextureRegistry;
//import net.minecraft.client.gui.GuiGraphics;
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.entity.player.Inventory;
//
//public class ScreenCrate extends ScreenBase<ContainerCrate> {
//
//  public ScreenCrate(ContainerCrate screenContainer, Inventory inv, Component titleIn) {
//    super(screenContainer, inv, titleIn);
//    this.imageHeight = 256;
//  }
//
//  @Override
//  public void init() {
//    super.init();
//  }
//
//  @Override
//  public void render(GuiGraphics ms, int mouseX, int mouseY, float partialTicks) {
//    this.renderBackground(ms);
//    super.render(ms, mouseX, mouseY, partialTicks);
//    this.renderTooltip(ms, mouseX, mouseY);
//  }
//
//  @Override
//  protected void renderLabels(GuiGraphics ms, int mouseX, int mouseY) {}
//
//  @Override
//  protected void renderBg(GuiGraphics ms, float partialTicks, int mouseX, int mouseY) {
//    this.drawBackground(ms, TextureRegistry.INVENTORY_LARGE);
//  }
//}
