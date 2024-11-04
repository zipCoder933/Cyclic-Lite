package com.lothrazar.cyclic.block.shapedata;

import java.awt.Color;
import com.lothrazar.cyclic.data.PreviewOutlineType;
import com.lothrazar.cyclic.render.RenderUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.phys.Vec3;

public class RenderShapedata implements BlockEntityRenderer<TileShapedata> {

  public RenderShapedata(BlockEntityRendererProvider.Context d) {}

  @Override
  public void render(TileShapedata te, float v, PoseStack matrixStack, MultiBufferSource ibuffer, int partialTicks, int destroyStage) {
    int previewType = te.getField(TileShapedata.Fields.RENDER.ordinal());
    if (PreviewOutlineType.SHADOW.ordinal() == previewType) {
      if (te.getTarget(0) != null) {
        RenderUtils.renderOutline(te.getBlockPos(), te.getTarget(0), matrixStack, 1.05F, Color.BLUE);
      }
      if (te.getTarget(1) != null) {
        RenderUtils.renderOutline(te.getBlockPos(), te.getTarget(1), matrixStack, 1.05F, Color.RED);
      }
    }
    else if (PreviewOutlineType.WIREFRAME.ordinal() == previewType) {
      //      for (BlockPos crd : te.getShapeHollow()) {
      RenderUtils.createBox(matrixStack, te.getTarget(0), Vec3.atLowerCornerOf(te.getBlockPos()));
      RenderUtils.createBox(matrixStack, te.getTarget(1), Vec3.atLowerCornerOf(te.getBlockPos()));
    }
  }
}
