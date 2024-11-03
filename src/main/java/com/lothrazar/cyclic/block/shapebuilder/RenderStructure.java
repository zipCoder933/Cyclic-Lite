package com.lothrazar.cyclic.block.shapebuilder;

import com.lothrazar.cyclic.config.ClientConfigCyclic;
import com.lothrazar.cyclic.data.PreviewOutlineType;
import com.lothrazar.cyclic.render.RenderUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class RenderStructure implements BlockEntityRenderer<TileStructure> {

  public RenderStructure(BlockEntityRendererProvider.Context d) {}

  @Override
  public void render(TileStructure te, float v, PoseStack matrixStack, MultiBufferSource ibuffer, int partialTicks, int destroyStage) {
    int previewType = te.getField(TileStructure.Fields.RENDER.ordinal());
    if (PreviewOutlineType.SHADOW.ordinal() == previewType) {
      IItemHandler inv = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(null);
      if (inv == null) {
        return;
      }
      ItemStack stack = inv.getStackInSlot(0);
      if (stack.isEmpty()) {
        RenderUtils.renderOutline(te.getBlockPos(), te.getShape(), matrixStack, 0.4F, ClientConfigCyclic.getColor(te));
      }
      else {
        RenderUtils.renderAsBlock(te.getBlockPos(), te.getShape(), matrixStack, stack, 1, 1);
      }
    }
    else if (PreviewOutlineType.WIREFRAME.ordinal() == previewType) {
      for (BlockPos crd : te.getShape()) {
        RenderUtils.createBox(matrixStack, crd, Vec3.atLowerCornerOf(te.getBlockPos()));
      }
    }
  }
}
