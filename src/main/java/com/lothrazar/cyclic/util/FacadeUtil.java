package com.lothrazar.cyclic.util;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.texture.OverlayTexture;

public class FacadeUtil {

  @SuppressWarnings("deprecation")
  public static void renderBlockState(BlockRendererDispatcher brd, MatrixStack matrixStack, BlockState facadeState) {
    IBakedModel model = brd.getModelForState(facadeState);
    int color = Minecraft.getInstance().getBlockColors().getColor(facadeState, null, null, 0);
    float r = (color >> 16 & 255) / 255.0F;
    float g = (color >> 8 & 255) / 255.0F;
    float b = (color & 255) / 255.0F;
    IRenderTypeBuffer.Impl buffers = Minecraft.getInstance().getRenderTypeBuffers().getBufferSource();
    IVertexBuilder buffer = buffers.getBuffer(RenderType.getSolid());
    // this changes in new versions
    brd.getBlockModelRenderer().renderModelBrightnessColor(matrixStack.getLast(), buffer, facadeState, model, r, g, b, 0xF000F0, OverlayTexture.NO_OVERLAY);
  }
}
