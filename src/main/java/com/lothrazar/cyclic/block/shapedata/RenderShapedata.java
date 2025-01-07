package com.lothrazar.cyclic.block.shapedata;

import java.awt.Color;
import com.lothrazar.cyclic.data.PreviewOutlineType;
import com.lothrazar.library.util.RenderBlockUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;

public class RenderShapedata implements BlockEntityRenderer<TileShapedata> {

  public RenderShapedata(BlockEntityRendererProvider.Context d) {}

  @Override
  public void render(TileShapedata te, float v, PoseStack matrixStack, MultiBufferSource ibuffer, int partialTicks, int destroyStage) {
    int previewType = te.getField(TileShapedata.Fields.RENDER.ordinal());
    if (PreviewOutlineType.NONE.ordinal() == previewType) {
      return;
    }
    BlockPos targetA = te.getTarget(0);
    BlockPos targetB = te.getTarget(1);
    if (PreviewOutlineType.SHADOW.ordinal() == previewType) {
      if (targetA != null) {
        RenderBlockUtils.renderOutline(te.getBlockPos(), targetA, matrixStack, 1.05F, Color.BLUE);
      }
      if (targetB != null) {
        RenderBlockUtils.renderOutline(te.getBlockPos(), targetB, matrixStack, 1.05F, Color.RED);
      }
    }
    else if (PreviewOutlineType.WIREFRAME.ordinal() == previewType) {
      if (targetA != null) {
        RenderBlockUtils.createBox(matrixStack, targetA, Vec3.atLowerCornerOf(te.getBlockPos()));
      }
      if (targetB != null) {
        RenderBlockUtils.createBox(matrixStack, targetB, Vec3.atLowerCornerOf(te.getBlockPos()));
      }
    }
  }
}
