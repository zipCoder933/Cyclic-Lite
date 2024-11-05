package com.lothrazar.cyclic.block.facade;

import com.lothrazar.cyclic.block.cable.TileCableBase;
import com.lothrazar.cyclic.config.ConfigRegistry;
import com.lothrazar.cyclic.util.FacadeUtil;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;

public class RenderCableFacade extends TileEntityRenderer<TileCableBase> {

  public RenderCableFacade(TileEntityRendererDispatcher d) {
    super(d);
  }

  @Override
  public boolean isGlobalRenderer(TileCableBase te) {
    return true;
  }

  @Override
  public void render(TileCableBase te, float v, MatrixStack matrixStack, IRenderTypeBuffer ibuffer, int packedLight, int packedOverlay) {
    if (te.getFacade() != null
        && ConfigRegistry.CABLE_FACADES.get()) {
      BlockState facadeState = te.getFacadeState(te.getWorld());
      BlockRendererDispatcher brd = Minecraft.getInstance().getBlockRendererDispatcher();
      FacadeUtil.renderBlockState(brd, matrixStack, facadeState, packedLight, packedOverlay);
    }
  }
}
