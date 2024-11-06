package com.lothrazar.cyclic.util;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexMultiConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class FacadeUtil {

  public static void renderBlockState(Level level, BlockPos pos, BlockRenderDispatcher brd, ModelBlockRenderer renderer,
      MultiBufferSource ibuffer, PoseStack matrixStack, BlockState facadeState, int packedLight, int packedOverlay) {
    if (facadeState == null) {
      return;
    }
    BakedModel model = brd.getBlockModel(facadeState);
    //    int color = Minecraft.getInstance().getBlockColors().getColor(facadeState, null, null, 0);
    //    float r = (color >> 16 & 255) / 255.0F;
    //    float g = (color >> 8 & 255) / 255.0F;
    //    float b = (color & 255) / 255.0F;
    //    IRenderTypeBuffer.Impl buffers = Minecraft.getInstance().getRenderTypeBuffers().getBufferSource();
    //    IVertexBuilder buffer = buffers.getBuffer(RenderType.getSolid());
    //    // this changes in new versions  
    //    renderer.renderModelBrightnessColor(matrixStack.getLast(), buffer, facadeState, model, r, g, b, packedLight, OverlayTexture.NO_OVERLAY);
    var MODELDATA_EMPTY = net.minecraftforge.client.model.data.EmptyModelData.INSTANCE;
    VertexConsumer vertexConsumer = VertexMultiConsumer.create(ibuffer.getBuffer(RenderType.solid()));
    renderer.tesselateBlock(level, model, facadeState, pos,
        matrixStack, vertexConsumer, false, level.random, packedLight, packedOverlay,
        MODELDATA_EMPTY //, RenderType.solid()
    );
  }
}
