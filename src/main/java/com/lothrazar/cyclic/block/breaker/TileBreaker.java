package com.lothrazar.cyclic.block.breaker;

import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.block.TileBlockEntityCyclic;
import com.lothrazar.cyclic.data.DataTags;
import com.lothrazar.cyclic.item.datacard.BlockStateMatcher;
import com.lothrazar.cyclic.item.datacard.BlockstateCard;
import com.lothrazar.cyclic.registry.ItemRegistry;
import com.lothrazar.cyclic.registry.TileRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileBreaker extends TileBlockEntityCyclic implements MenuProvider {

  static enum Fields {
    REDSTONE, TIMER;
  }

  static final int MAX = 64000;
  public static final int TIMER_FULL = 500;
  ItemStackHandler inventory = new ItemStackHandler() {

    @Override
    public int getSlotLimit(int slot) {
      return 1;
    }

    @Override
    public boolean isItemValid(int slot, ItemStack stack) {
      return stack.getItem() == ItemRegistry.STATECARD.get();
    }
  };
  private LazyOptional<IItemHandler> inventoryCap = LazyOptional.of(() -> inventory);

  public TileBreaker(BlockPos pos, BlockState state) {
    super(TileRegistry.BREAKER.get(), pos, state);
  }

  public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, TileBreaker e) {
    e.tick();
  }

  public static <E extends BlockEntity> void clientTick(Level level, BlockPos blockPos, BlockState blockState, TileBreaker e) {
    e.tick();
  }

  @Override
  public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
    if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
      return inventoryCap.cast();
    }
    return super.getCapability(cap, side);
  }

  public void tick() {
    if (this.requiresRedstone() && !this.isPowered()) {
      setLitProperty(false);
      return;
    }
    setLitProperty(true);
    if (level.isClientSide) {
      return;
    }
    BlockPos target = this.worldPosition.relative(this.getCurrentFacing()); // offset -> relative
    if (this.isTargetValid(target)) {
      this.level.destroyBlock(target, true);
    }
  }

  @Override
  public void invalidateCaps() {
    inventoryCap.invalidate();
    super.invalidateCaps();
  }

  /**
   * Avoid mining source liquid blocks and unbreakable
   */
  private boolean isTargetValid(BlockPos targetPos) {
    BlockState targetState = level.getBlockState(targetPos);
    if (targetState.isAir()) {
      return false;
    }
    if (targetState.getDestroySpeed(level, targetPos) < 0) {
      return false;
    }
    //check the tag ignore list so modpack/datapack can filter this
    if (targetState.is(DataTags.BREAKER_IGNORED)) {
      ModCyclic.LOGGER.info("breaker/ignored tag skips " + targetPos);
      return false;
    }
    if (targetState.getFluidState() != null && targetState.getFluidState().isEmpty() == false) {
      //am i a solid waterlogged state block? 
      if (targetState.hasProperty(BlockStateProperties.WATERLOGGED) == false) {
        //pure liquid. but this will make canHarvestBlock go true  
        return false;
      }
    }
    if (!this.isValidFromDatacard(targetState)) {
      return false;
    }
    // else filter is empty
    return true;
  }

  private boolean isValidFromDatacard(BlockState targetState) {
    ItemStack filter = inventory.getStackInSlot(0);
    if (filter.isEmpty()) {
      return true; //ya go
    }
    for (BlockStateMatcher m : BlockstateCard.getSavedStates(filter)) {
      if (m.doesMatch(targetState)) {
        return true; // i am allowed to mine this
      }
    }
    return false; //filter is my allow list, and you aint in it so not allowed
  }

  @Override
  public Component getDisplayName() {
    return new TextComponent(getType().getRegistryName().getPath());
  }

  @Override
  public AbstractContainerMenu createMenu(int i, Inventory playerInventory, Player playerEntity) {
    return new ContainerBreaker(i, level, worldPosition, playerInventory, playerEntity);
  }

  @Override
  public void load(CompoundTag tag) {
    inventory.deserializeNBT(tag.getCompound(NBTINV));
    super.load(tag);
  }

  @Override
  public void saveAdditional(CompoundTag tag) {
    tag.put(NBTINV, inventory.serializeNBT());
    super.saveAdditional(tag);
  }

  @Override
  public void setField(int field, int value) {
    switch (Fields.values()[field]) {
      case REDSTONE:
        this.needsRedstone = value % 2;
      break;
      case TIMER:
        timer = value;
      break;
    }
  }

  @Override
  public int getField(int field) {
    switch (Fields.values()[field]) {
      case REDSTONE:
        return this.needsRedstone;
      case TIMER:
        return timer;
    }
    return 0;
  }

  public int getEnergyMax() {
    return MAX;
  }
}
