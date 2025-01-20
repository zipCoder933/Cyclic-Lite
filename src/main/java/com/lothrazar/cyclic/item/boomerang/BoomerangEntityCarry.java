//package com.lothrazar.cyclic.item.boomerang;
//
//import com.lothrazar.cyclic.item.boomerang.BoomerangItem.Boomer;
//import com.lothrazar.cyclic.registry.EntityRegistry;
//import com.lothrazar.cyclic.registry.ItemRegistry;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.level.Level;
//
//public class BoomerangEntityCarry extends BoomerangEntity {
//
//  public BoomerangEntityCarry(EntityType<? extends ThrowableItemProjectile> type, Level worldIn) {
//    super(type, worldIn);
//    boomerangType = Boomer.CARRY;
//  }
//
//  public BoomerangEntityCarry(LivingEntity throwerIn, Level worldIn) {
//    super(EntityRegistry.BOOMERANG_CARRY.get(), throwerIn, worldIn);
//    boomerangType = Boomer.CARRY;
//  }
//
//  @Override
//  protected Item getDefaultItem() {
//    return ItemRegistry.BOOMERANG_CARRY.get();
//  }
//}
