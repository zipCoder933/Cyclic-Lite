//package com.lothrazar.cyclic.block.fishing;
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.MultiBufferSource;
//import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
//import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
//import net.minecraft.core.Direction;
//import net.minecraft.world.item.ItemDisplayContext;
//import net.minecraft.world.item.ItemStack;
//import net.minecraftforge.common.capabilities.ForgeCapabilities;
//import net.minecraftforge.items.IItemHandler;
//
//public class RenderFisher implements BlockEntityRenderer<TileFisher> {
//
//  public RenderFisher(BlockEntityRendererProvider.Context d) {}
//
//  @Override
//  public void render(TileFisher tankHere, float v, PoseStack matrixStack,
//      MultiBufferSource buffer, int light, int overlayLight) {
//    IItemHandler itemHandler = tankHere.getCapability(ForgeCapabilities.ITEM_HANDLER, Direction.UP).orElse(null);
//    if (itemHandler != null) {
//      ItemStack stack = itemHandler.getStackInSlot(0);
//      if (!stack.isEmpty()) {
//        matrixStack.pushPose();
//        //        matrixStack.scale(0.5f, 0.5f, 0.5f);
//        matrixStack.translate(0.4, 0.45, 0.4);
//        Minecraft.getInstance().getItemRenderer().renderStatic(stack, ItemDisplayContext.GROUND, 0x910911, 0, matrixStack, buffer, tankHere.getLevel(), light);
//        matrixStack.popPose();
//      }
//    }
//  }
//}
