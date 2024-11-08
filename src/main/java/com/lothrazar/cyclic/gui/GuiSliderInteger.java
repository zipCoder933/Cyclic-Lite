package com.lothrazar.cyclic.gui;

import com.lothrazar.cyclic.net.PacketTileData;
import com.lothrazar.cyclic.registry.PacketRegistry;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.AbstractSlider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class GuiSliderInteger extends AbstractSlider implements IHasTooltip {

  public static final int ARROW_LEFT = 263;
  public static final int ARROW_RIGHT = 262;
  static final int ESC = 256;
  private final double min;
  private final double max;
  private final BlockPos pos; // Tile entity location
  private final int field; // field ID for saving value
  private List<ITextComponent> tooltip;

  public GuiSliderInteger(int x, int y, int width, int height, int field, BlockPos pos, int min, int max, double initialVal) {
    super(x, y, width, height, StringTextComponent.EMPTY, 0);
    this.field = field;
    this.pos = pos;
    this.min = min;
    this.max = max;
    setSliderPercentageOfMax((int) initialVal);
    this.func_230979_b_();
  }

  public double getSliderValue() {
    return this.sliderValue;
  }

  public int getField() {
    return this.field;
  }

  /**
   * Call from Screen class to render tooltip during mouseover
   */
  @Override
  public List<ITextComponent> getTooltip() {
    return tooltip;
  }

  /**
   * Add a tooltip to first line (second line hardcoded)
   */
  @Override
  public void setTooltip(String tt) {
    this.tooltip = new ArrayList<>();
    this.tooltip.add(new TranslationTextComponent(tt));
    this.tooltip.add(new TranslationTextComponent("cyclic.gui.sliderkeys").mergeStyle(TextFormatting.DARK_GRAY));
  }

  /**
   * Mouse scrolling
   */
  @Override
  public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
    if (delta != 0) {
      moveSliderAndUpdate((int) delta);
      return true;
    }
    return super.mouseScrolled(mouseX, mouseY, delta);
  }

  /**
   * Fires when control is selected, also I call this from screen class whenever mouse is hovered for extra UX
   */
  @Override
  public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
    if (keyCode == ESC) {
      //close
      ClientPlayerEntity pl = Minecraft.getInstance().player;
      if (pl != null) {
        pl.closeScreen();
      }
      return true;
    }
    if (keyCode == ARROW_LEFT || keyCode == ARROW_RIGHT) {
      // move from arrow keys
      int delta = (keyCode == ARROW_LEFT) ? -1 : 1;
      if (Screen.hasShiftDown()) {
        delta = delta * 5;
      }
      else if (Screen.hasAltDown()) {
        delta = delta * 10;
      }
      moveSliderAndUpdate(delta);
      return true;
    }
    return super.keyPressed(keyCode, scanCode, modifiers);
  }

  /**
   * move position by delta and save and refresh
   * 
   * @param delta
   */
  private void moveSliderAndUpdate(int delta) {
    setSliderPercentageOfMax(this.getSliderAsInteger() + delta);
    this.func_230972_a_();
    this.func_230979_b_();
  }

  /**
   * Refresh display message
   */
  @Override
  protected void func_230979_b_() {
    int val = getSliderAsInteger();
    this.setMessage(new TranslationTextComponent("" + val));
  }

  /**
   * Save to tile entity with packet
   */
  @Override
  protected void func_230972_a_() {
    int val = getSliderAsInteger();
    PacketRegistry.INSTANCE.sendToServer(new PacketTileData(this.field, val, pos));
  }

  /**
   * Set inner [0,1] value relative to maximum and trigger save/ & refresh
   */
  private void setSliderPercentageOfMax(int val) {
    this.sliderValue = val / max;
  }

  /**
   * clamp sliderValue to an integer between min and max
   */
  public int getSliderAsInteger() {
    return MathHelper.floor(MathHelper.clampedLerp(min, max, this.getSliderValue()));
  }
}
