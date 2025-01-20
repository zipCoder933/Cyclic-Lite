//package com.lothrazar.cyclic.block.endershelf;
//
//import com.lothrazar.cyclic.block.TileBlockEntityCyclic;
//import com.lothrazar.cyclic.registry.TileRegistry;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraftforge.common.capabilities.Capability;
//import net.minecraftforge.common.capabilities.ForgeCapabilities;
//import net.minecraftforge.common.util.LazyOptional;
//
//public class TileEnderShelf extends TileBlockEntityCyclic {
//
//  public final EnderShelfItemHandler inventory = new EnderShelfItemHandler(this);
//  private final LazyOptional<EnderShelfItemHandler> inventoryCap = LazyOptional.of(() -> inventory);
//  public RenderTextType renderStyle = RenderTextType.TEXT;
//
//  public static enum RenderTextType {
//    TEXT, STACK, NONE;
//  }
//
//  public TileEnderShelf(BlockPos pos, BlockState state) {
//    super(TileRegistry.ENDER_SHELF.get(), pos, state);
//  }
//
//  @Override
//  public void setField(int field, int value) {}
//
//  @Override
//  public int getField(int field) {
//    return 0;
//  }
//
//  @Override
//  public void invalidateCaps() {
//    inventoryCap.invalidate();
//    super.invalidateCaps();
//  }
//
//  @Override
//  public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
//    if (cap == ForgeCapabilities.ITEM_HANDLER) {
//      return inventoryCap.cast();
//    }
//    return super.getCapability(cap, side);
//  }
//
//  @Override
//  public void load(CompoundTag tag) {
//    inventory.deserializeNBT(tag.getCompound(NBTINV));
//    if (tag.contains("RenderTextType")) {
//      int rt = tag.getInt("RenderTextType");
//      this.renderStyle = RenderTextType.values()[rt];
//    }
//    inventory.resetNameCache();
//    super.load(tag);
//  }
//
//  @Override
//  public void saveAdditional(CompoundTag tag) {
//    tag.put(NBTINV, inventory.serializeNBT());
//    tag.putInt("RenderTextType", this.renderStyle.ordinal());
//    super.saveAdditional(tag);
//  }
//
//  public void toggleShowText() {
//    int ord = renderStyle.ordinal() + 1;
//    if (ord == RenderTextType.values().length) {
//      ord = 0;
//    }
//    this.renderStyle = RenderTextType.values()[ord];
//  }
//}
