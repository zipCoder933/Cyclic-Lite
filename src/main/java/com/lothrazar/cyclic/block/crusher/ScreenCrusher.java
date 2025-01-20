//package com.lothrazar.cyclic.block.crusher;
//
//import com.lothrazar.cyclic.gui.ButtonMachineField;
//import com.lothrazar.cyclic.gui.ScreenBase;
//import com.lothrazar.cyclic.registry.TextureRegistry;
//import com.lothrazar.library.gui.EnergyBar;
//import com.lothrazar.library.gui.TexturedProgress;
//import net.minecraft.client.gui.GuiGraphics;
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.entity.player.Inventory;
//
//public class ScreenCrusher extends ScreenBase<ContainerCrusher> {
//
//  private ButtonMachineField btnRedstone;
//  private EnergyBar energy;
//  private TexturedProgress progress;
//
//  public ScreenCrusher(ContainerCrusher screenContainer, Inventory inv, Component titleIn) {
//    super(screenContainer, inv, titleIn);
//  }
//
//  @Override
//  public void init() {
//    super.init();
//    this.energy = new EnergyBar(this.font, TileCrusher.MAX);
//    this.progress = new TexturedProgress(this.font, 78, 40, TextureRegistry.SAW);
//    progress.guiLeft = energy.guiLeft = leftPos;
//    progress.guiTop = energy.guiTop = topPos;
//    int x, y;
//    x = leftPos + 6;
//    y = topPos + 6;
//    btnRedstone = addRenderableWidget(new ButtonMachineField(x, y, TileCrusher.Fields.REDSTONE.ordinal(), menu.tile.getBlockPos()));
//  }
//
//  @Override
//  public void render(GuiGraphics ms, int mouseX, int mouseY, float partialTicks) {
//    this.renderBackground(ms);
//    super.render(ms, mouseX, mouseY, partialTicks);
//    this.renderTooltip(ms, mouseX, mouseY);
//    energy.renderHoveredToolTip(ms, mouseX, mouseY, menu.tile.getEnergy());
//    btnRedstone.onValueUpdate(menu.tile);
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
//    this.drawSlot(ms, 52, 34);
//    this.drawSlotLarge(ms, 104, 20);
//    this.drawSlot(ms, 108, 54);
//    energy.draw(ms, menu.tile.getEnergy());
//    final int max = menu.tile.getField(TileCrusher.Fields.TIMERMAX.ordinal());
//    progress.max = max;
//    progress.draw(ms, max - menu.tile.getField(TileCrusher.Fields.TIMER.ordinal()));
//  }
//}
