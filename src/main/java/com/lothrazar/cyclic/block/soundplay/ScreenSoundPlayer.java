//package com.lothrazar.cyclic.block.soundplay;
//
//import com.lothrazar.cyclic.gui.ScreenBase;
//import com.lothrazar.cyclic.registry.TextureRegistry;
//import net.minecraft.client.gui.GuiGraphics;
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.entity.player.Inventory;
//
//public class ScreenSoundPlayer extends ScreenBase<ContainerSoundPlayer> {
//
//  public ScreenSoundPlayer(ContainerSoundPlayer screenContainer, Inventory inv, Component titleIn) {
//    super(screenContainer, inv, titleIn);
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
//  protected void renderLabels(GuiGraphics ms, int mouseX, int mouseY) {
//    this.drawButtonTooltips(ms, mouseX, mouseY);
//    this.drawName(ms, this.title.getString());
//  }
//
//  @Override
//  protected void renderBg(GuiGraphics ms, float partialTicks, int mouseX, int mouseY) {
//    this.drawBackground(ms, TextureRegistry.INVENTORY);
//    this.drawSlot(ms, 80, 34, TextureRegistry.SLOT_SOUND);
//  }
//}
