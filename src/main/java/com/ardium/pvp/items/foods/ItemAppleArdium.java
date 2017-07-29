package com.ardium.pvp.items.foods;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemAppleArdium extends ItemFood {

	public ItemAppleArdium(int healHungerAmount, float saturation, boolean canBeFoodByWolves) {
		super(healHungerAmount, saturation, canBeFoodByWolves);
		this.setAlwaysEdible();
		this.setCreativeTab(Ardium.tabArdium);
		this.setUnlocalizedName("apple_ardium");
		this.setTextureName(References.MOD_ID + ":apple_ardium");
	}

	public void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 1200, 4));
		player.addPotionEffect(new PotionEffect(Potion.heal.getId(), 1, 10));
		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 2400, 0));
		player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 6000, 1));
		player.setAbsorptionAmount(10.0F);
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack itemStack) {
		return itemStack.getItemDamage() == 0;
	}

	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.epic;
	}

}
