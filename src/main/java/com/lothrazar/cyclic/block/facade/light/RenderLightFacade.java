package com.lothrazar.cyclic.block.facade.light;

import com.lothrazar.cyclic.util.FacadeUtil;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;

public class RenderLightFacade extends TileEntityRenderer<TileLightFacade> {

  public RenderLightFacade(TileEntityRendererDispatcher d) {
    super(d);
  }

  @Override
  public boolean isGlobalRenderer(TileLightFacade te) {
    return true;
  }

  @Override
  public void render(TileLightFacade te, float v, MatrixStack matrixStack, IRenderTypeBuffer ibuffer, int partialTicks, int destroyStage) {
    if (te.getFacade() != null) {
      BlockState facadeState = te.getFacadeState(te.getWorld());
      BlockRendererDispatcher brd = Minecraft.getInstance().getBlockRendererDispatcher();
      FacadeUtil.renderBlockState(brd, matrixStack, facadeState);
    }
  }
}
