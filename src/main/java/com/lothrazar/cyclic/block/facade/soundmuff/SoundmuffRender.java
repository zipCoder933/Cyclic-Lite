package com.lothrazar.cyclic.block.facade.soundmuff;

import com.lothrazar.cyclic.util.FacadeUtil;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;

public class SoundmuffRender extends TileEntityRenderer<SoundmuffTileFacade> {

  public SoundmuffRender(TileEntityRendererDispatcher d) {
    super(d);
  }

  @Override
  public boolean isGlobalRenderer(SoundmuffTileFacade te) {
    return true;
  }

  @Override
  public void render(SoundmuffTileFacade te, float v, MatrixStack matrixStack, IRenderTypeBuffer ibuffer, int partialTicks, int destroyStage) {
    if (te.getFacade() != null) {
      BlockState facadeState = te.getFacadeState(te.getWorld());
      BlockRendererDispatcher brd = Minecraft.getInstance().getBlockRendererDispatcher();
      FacadeUtil.renderBlockState(brd, matrixStack, facadeState);
    }
  }
}
