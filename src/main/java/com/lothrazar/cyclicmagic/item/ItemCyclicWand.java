package com.lothrazar.cyclicmagic.item;

import java.util.List;
import org.lwjgl.input.Keyboard;
import com.lothrazar.cyclicmagic.Const;
import com.lothrazar.cyclicmagic.PlayerPowerups;
import com.lothrazar.cyclicmagic.SpellRegistry;
import com.lothrazar.cyclicmagic.spell.ISpell;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCyclicWand extends Item {

	
	public ItemCyclicWand() {
		this.setMaxStackSize(1);
		this.setHasSubtypes(true);
		this.setCreativeTab(CreativeTabs.tabAllSearch);//TODO: remove this for release
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	@Override
    public String getUnlocalizedName(ItemStack stack)
    {
		String name = "";
		try{
			name = super.getUnlocalizedName() + "_" + Variants.values()[stack.getMetadata()].name().toLowerCase();
		}
		catch(Exception e){
			//will never happen... unless some external tool or mod forces the metadata to invalid state
			//ex: nbt editor
			name = super.getUnlocalizedName();
		}
        return name;
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        for (int i = 0; i <= Variants.values().length; i++){
            subItems.add(new ItemStack(itemIn, 1, i));
        }
    }
    
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {

		PlayerPowerups props = PlayerPowerups.get(playerIn);
		ISpell spell = SpellRegistry.getSpellFromID(props.getSpellCurrent());

		tooltip.add(spell.getName());
		tooltip.add(StatCollector.translateToLocal("spell.cost") + spell.getCost());
		int max = (int) SpellRegistry.caster.MAXMANA;
		tooltip.add(props.getMana() + "/" + max);

		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			tooltip.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal("wand.gui.info"));
			tooltip.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal("wand.recharge.info"));
			tooltip.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal("wand.wheel.info"));
		}
		else {
			tooltip.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal("item.shift"));
		}

		super.addInformation(stack, playerIn, tooltip, advanced);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.EPIC;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {

		// so this only happens IF either onItemUse did not fire at all, or it
		// fired and casting failed
		SpellRegistry.caster.tryCastCurrent(worldIn, playerIn, null, null);
		return super.onItemRightClick(itemStackIn, worldIn, playerIn);
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		// if held by something not a player? such as custom npc/zombie/etc
		if (entityIn instanceof EntityPlayer == false) {
			return;
		}

		if (worldIn.isRemote == false && worldIn.getWorldTime() % Const.TICKS_PER_SEC == 0) {

			EntityPlayer p = (EntityPlayer) entityIn;
			PlayerPowerups props = PlayerPowerups.get(p);
			props.setMana(props.getMana() + 1);
		}
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		// If onItemUse returns false onItemRightClick will be called.
		// http://www.minecraftforge.net/forum/index.php?topic=31966.0
		// so if this casts and succeeds, the right click is cancelled
		return SpellRegistry.caster.tryCastCurrent(worldIn, playerIn, pos, side);
	}
	
	public enum Variants{
		QUARTZ,
		GOLD,
		DIAMOND,
		EMERALD;
		
		public int getMetadata() {
			return ordinal();
		}

		public String getResource() {
			
			return Const.TEXTURE_LOCATION + "cyclic_wand_" + this.name().toLowerCase();
		}
	}
}
