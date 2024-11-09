package com.lothrazar.cyclic.block.clock;

import com.lothrazar.cyclic.base.ScreenBase;
import com.lothrazar.cyclic.gui.ButtonMachineField;
import com.lothrazar.cyclic.gui.GuiSliderInteger;
import com.lothrazar.cyclic.registry.TextureRegistry;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

public class ScreenClock extends ScreenBase<ContainerClock> {

  private ButtonMachineField btnRedstone;

  public ScreenClock(ContainerClock screenContainer, PlayerInventory inv, ITextComponent titleIn) {
    super(screenContainer, inv, titleIn);
  }

  @Override
  public void init() {
    super.init();
    int x, y;
    int w = 160;
    int h = 18;
    x = guiLeft + 6;
    y = guiTop + 6;
    btnRedstone = addButton(new ButtonMachineField(x, y, TileRedstoneClock.Fields.REDSTONE.ordinal(), container.tile.getPos()));
    int f = TileRedstoneClock.Fields.DURATION.ordinal();
    x = guiLeft + 8;
    y = guiTop + 26;
    GuiSliderInteger dur = this.addButton(new GuiSliderInteger(x, y, w, h, f, container.tile.getPos(),
        1, 200, container.tile.getField(f)));
    dur.setTooltip("cyclic.clock.duration");
    y += h + 1;
    f = TileRedstoneClock.Fields.DELAY.ordinal();
    GuiSliderInteger delay = this.addButton(new GuiSliderInteger(x, y, w, h, f, container.tile.getPos(),
        1, 200, container.tile.getField(f)));
    delay.setTooltip("cyclic.clock.delay");
    y += h + 1;
    f = TileRedstoneClock.Fields.POWER.ordinal();
    GuiSliderInteger power = this.addButton(new GuiSliderInteger(x, y, w, h, f, container.tile.getPos(),
        1, 15, container.tile.getField(f)));
    power.setTooltip("cyclic.clock.power");
  }

  @Override
  public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
    this.renderBackground(ms);
    super.render(ms, mouseX, mouseY, partialTicks);
    this.renderHoveredTooltip(ms, mouseX, mouseY);
    btnRedstone.onValueUpdate(container.tile);
  }

  @Override
  protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
    this.drawButtonTooltips(ms, mouseX, mouseY);
    this.drawName(ms, this.title.getString());
  }

  @Override
  protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int mouseX, int mouseY) {
    this.drawBackground(ms, TextureRegistry.INVENTORY);
  }
}
