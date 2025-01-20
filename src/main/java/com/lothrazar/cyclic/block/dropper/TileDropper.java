//package com.lothrazar.cyclic.block.dropper;
//
//import java.util.ArrayList;
//import java.util.List;
//import com.lothrazar.cyclic.block.TileBlockEntityCyclic;
//import com.lothrazar.cyclic.data.PreviewOutlineType;
//import com.lothrazar.cyclic.item.datacard.LocationGpsCard;
//import com.lothrazar.cyclic.registry.BlockRegistry;
//import com.lothrazar.cyclic.registry.TileRegistry;
//import com.lothrazar.library.cap.CustomEnergyStorage;
//import com.lothrazar.library.core.BlockPosDim;
//import com.lothrazar.library.util.ItemStackUtil;
//import com.lothrazar.library.util.LevelWorldUtil;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.MenuProvider;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.inventory.AbstractContainerMenu;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.phys.AABB;
//import net.minecraftforge.common.ForgeConfigSpec.IntValue;
//import net.minecraftforge.common.capabilities.Capability;
//import net.minecraftforge.common.capabilities.ForgeCapabilities;
//import net.minecraftforge.common.util.LazyOptional;
//import net.minecraftforge.energy.IEnergyStorage;
//import net.minecraftforge.items.IItemHandler;
//import net.minecraftforge.items.ItemStackHandler;
//
//public class TileDropper extends TileBlockEntityCyclic implements MenuProvider {
//
//  static enum Fields {
//    TIMER, REDSTONE, DROPCOUNT, DELAY, RENDER;
//  }
//
//  static final int MAX = 64000;
//  public static IntValue POWERCONF;
//  private CustomEnergyStorage energy = new CustomEnergyStorage(MAX, MAX);
//  private ItemStackHandler inventory = new ItemStackHandler(1);
//  private LazyOptional<IEnergyStorage> energyCap = LazyOptional.of(() -> energy);
//  private LazyOptional<IItemHandler> inventoryCap = LazyOptional.of(() -> inventory);
//  ItemStackHandler gpsSlots = new ItemStackHandler(1) {
//
//    @Override
//    public boolean isItemValid(int slot, ItemStack stack) {
//      return stack.getItem() instanceof LocationGpsCard;
//    }
//
//    @Override
//    public int getSlotLimit(int slot) {
//      return 1;
//    }
//  };
//  private int dropCount = 1;
//  private int delay = 10;
//
//  public TileDropper(BlockPos pos, BlockState state) {
//    super(TileRegistry.DROPPER.get(), pos, state);
//  }
//
//  public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, TileDropper e) {
//    e.tick();
//  }
//
//  public static <E extends BlockEntity> void clientTick(Level level, BlockPos blockPos, BlockState blockState, TileDropper e) {
//    e.tick();
//  }
//
//  public void tick() {
//    this.syncEnergy();
//    if (this.requiresRedstone() && !this.isPowered()) {
//      setLitProperty(false);
//      return;
//    }
//    timer--;
//    final int cost = POWERCONF.get();
//    if (energy.getEnergyStored() < cost) {
//      if (cost > 0) {
//        setLitProperty(false);
//        return; //out of energy so keep it rendered as off
//      }
//    }
//    setLitProperty(true);
//    if (timer > 0) {
//      return;
//    }
//    timer = delay;
//    ItemStack dropMe = inventory.getStackInSlot(0).copy();
//    BlockPos target = getTargetPos();
//    int amtDrop = Math.min(this.dropCount, dropMe.getCount());
//    if (amtDrop > 0) {
//      energy.extractEnergy(cost, false);
//      dropMe.setCount(amtDrop);
//      ItemStackUtil.dropItemStackMotionless(level, target, dropMe);
//      inventory.getStackInSlot(0).shrink(amtDrop);
//    }
//  }
//
//  @Override
//  public AABB getRenderBoundingBox() {
//    return BlockEntity.INFINITE_EXTENT_AABB;
//  }
//
//  @Override
//  public Component getDisplayName() {
//    return BlockRegistry.DROPPER.get().getName();
//  }
//
//  @Override
//  public AbstractContainerMenu createMenu(int i, Inventory playerInventory, Player playerEntity) {
//    return new ContainerDropper(i, level, worldPosition, playerInventory, playerEntity);
//  }
//
//  @Override
//  public void invalidateCaps() {
//    energyCap.invalidate();
//    inventoryCap.invalidate();
//    super.invalidateCaps();
//  }
//
//  @Override
//  public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
//    if (cap == ForgeCapabilities.ENERGY && POWERCONF.get() > 0) {
//      return energyCap.cast();
//    }
//    if (cap == ForgeCapabilities.ITEM_HANDLER) {
//      return inventoryCap.cast();
//    }
//    return super.getCapability(cap, side);
//  }
//
//  @Override
//  public void load(CompoundTag tag) {
//    energy.deserializeNBT(tag.getCompound(NBTENERGY));
//    inventory.deserializeNBT(tag.getCompound(NBTINV));
//    gpsSlots.deserializeNBT(tag.getCompound(NBTINV + "gps"));
//    this.delay = tag.getInt("delay");
//    this.dropCount = tag.getInt("dropCount");
//    super.load(tag);
//  }
//
//  @Override
//  public void saveAdditional(CompoundTag tag) {
//    tag.put(NBTENERGY, energy.serializeNBT());
//    tag.put(NBTINV, inventory.serializeNBT());
//    tag.put(NBTINV + "gps", gpsSlots.serializeNBT());
//    tag.putInt("delay", delay);
//    tag.putInt("dropCount", dropCount);
//    super.saveAdditional(tag);
//  }
//
//  private BlockPos getTargetPos() {
//    BlockPosDim loc = LocationGpsCard.getPosition(this.gpsSlots.getStackInSlot(0));
//    if (loc != null && LevelWorldUtil.dimensionIsEqual(loc, level)) {
//      return loc.getPos();
//    }
//    return this.getCurrentFacingPos().relative(this.getCurrentFacing(), 1);
//  }
//
//  @Override
//  public int getField(int id) {
//    switch (Fields.values()[id]) {
//      case TIMER:
//        return timer;
//      case REDSTONE:
//        return this.needsRedstone;
//      case DELAY:
//        return this.delay;
//      case DROPCOUNT:
//        return this.dropCount;
//      case RENDER:
//        return render;
//    }
//    return -1;
//  }
//
//  @Override
//  public void setField(int id, int value) {
//    switch (Fields.values()[id]) {
//      case TIMER:
//        this.timer = value;
//      break;
//      case REDSTONE:
//        this.needsRedstone = value % 2;
//      break;
//      case DELAY:
//        delay = Math.max(0, value);
//      break;
//      case DROPCOUNT:
//        dropCount = Math.max(1, value);
//      break;
//      case RENDER:
//        this.render = value % PreviewOutlineType.values().length;
//      break;
//    }
//  }
//
//  public List<BlockPos> getShapeHollow() {
//    return getShape();
//  }
//
//  public List<BlockPos> getShape() {
//    List<BlockPos> shape = new ArrayList<>();
//    shape.add(getTargetPos());
//    return shape;
//  }
//}
