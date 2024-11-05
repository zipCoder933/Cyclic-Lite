package com.lothrazar.cyclic.item.datacard;

import net.minecraft.world.level.block.state.BlockState;

public class BlockStateMatcher {

  private BlockState state;
  private boolean exactProperties = true;

  // returns true if target state matches this
  public boolean doesMatch(BlockState targetState) {
    if (targetState.getBlock() == this.getState().getBlock()) {
      if (this.isExactProperties() == false) {
        // the blocks DO match, isExact is flagged as no, so we are good
        return true;
      }
      //tag DOES want to match Exactly on Properties
      return BlockstateCard.propertiesMatch(targetState, this.getState());
    }
    return false;
  }

  public BlockState getState() {
    return state;
  }

  public void setState(BlockState state) {
    this.state = state;
  }

  public boolean isExactProperties() {
    return exactProperties;
  }

  public void setExactProperties(boolean exactProperties) {
    this.exactProperties = exactProperties;
  }
}
