package com.lothrazar.cyclic.block.peatfarm;

import com.lothrazar.cyclic.config.ClientConfigCyclic;
import com.lothrazar.cyclic.data.PreviewOutlineType;
import com.lothrazar.cyclic.render.RenderUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;

public class RenderPeatFarm implements BlockEntityRenderer<TilePeatFarm> {

  public RenderPeatFarm(BlockEntityRendererProvider.Context d) {}

  @Override
  public void render(TilePeatFarm te, float v, PoseStack matrixStack, MultiBufferSource iRenderTypeBuffer, int partialTicks, int destroyStage) {
    int previewType = te.getField(TilePeatFarm.Fields.RENDER.ordinal());
    if (PreviewOutlineType.SHADOW.ordinal() == previewType) {
      RenderUtils.renderOutline(te.getBlockPos(), te.getShape(), matrixStack, 0.4F, ClientConfigCyclic.getColor(te));
    }
    else if (PreviewOutlineType.WIREFRAME.ordinal() == previewType) {
      for (BlockPos crd : te.getShapeHollow()) {
        RenderUtils.createBox(matrixStack, crd, Vec3.atLowerCornerOf(te.getBlockPos()));
      }
    }
  }
}
