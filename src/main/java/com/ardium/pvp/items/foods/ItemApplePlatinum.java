package com.ardium.pvp.items.foods;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemApplePlatinum extends ItemFood {

	public ItemApplePlatinum(int healHungerAmount, float saturation, boolean canBeFoodByWolves) {
		super(healHungerAmount, saturation, canBeFoodByWolves);
		this.setAlwaysEdible();
		this.setCreativeTab(Ardium.tabArdium);
		this.setUnlocalizedName("platinum_apple");
		this.setTextureName(References.MOD_ID + ":platinum_apple");
	}

	public void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack itemStack) {
		return itemStack.getItemDamage() == 0;
	}

	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.epic;
	}

}
