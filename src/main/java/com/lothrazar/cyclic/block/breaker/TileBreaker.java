package com.lothrazar.cyclic.block.breaker;

import com.lothrazar.cyclic.ModCyclic;
import com.lothrazar.cyclic.base.TileEntityBase;
import com.lothrazar.cyclic.data.DataTags;
import com.lothrazar.cyclic.item.datacard.BlockStateMatcher;
import com.lothrazar.cyclic.item.datacard.BlockstateCard;
import com.lothrazar.cyclic.registry.ItemRegistry;
import com.lothrazar.cyclic.registry.TileRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileBreaker extends TileEntityBase implements INamedContainerProvider, ITickableTileEntity {

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

  public TileBreaker() {
    super(TileRegistry.breakerTile);
  }

  @Override
  public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
    if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
      return inventoryCap.cast();
    }
    return super.getCapability(cap, side);
  }

  @Override
  public void tick() {
    if (this.requiresRedstone() && !this.isPowered()) {
      setLitProperty(false);
      return;
    }
    setLitProperty(true);
    if (world.isRemote) {
      return;
    }
    BlockPos target = pos.offset(this.getCurrentFacing());
    if (this.isTargetValid(target)) {
      this.world.destroyBlock(target, true);
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
    World level = world;
    BlockState targetState = level.getBlockState(targetPos);
    if (targetState.getBlock() == Blocks.AIR) {
      return false;
    }
    if (targetState.getBlockHardness(level, targetPos) < 0) {
      return false;
    }
    //check the tag ignore list so modpack/datapack can filter this
    if (targetState.isIn(DataTags.BREAKER_IGNORED)) {
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
  public ITextComponent getDisplayName() {
    return new StringTextComponent(getType().getRegistryName().getPath());
  }

  @Override
  public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
    return new ContainerBreaker(i, world, pos, playerInventory, playerEntity);
  }

  @Override
  public void read(BlockState bs, CompoundNBT tag) {
    inventory.deserializeNBT(tag.getCompound(NBTINV));
    super.read(bs, tag);
  }

  @Override
  public CompoundNBT write(CompoundNBT tag) {
    tag.put(NBTINV, inventory.serializeNBT());
    return super.write(tag);
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
