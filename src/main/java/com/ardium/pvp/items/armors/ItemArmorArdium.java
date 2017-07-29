package com.ardium.pvp.items.armors;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;
import com.ardium.pvp.init.ItemsRegistry;
import com.ardium.pvp.items.ItemIngotArdium;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemArmorArdium extends ItemArmor {
	public ItemArmorArdium(ArmorMaterial oxiumArmorMaterial, int metaData) {
		super(oxiumArmorMaterial, 0, metaData);
		this.setMaxStackSize(1);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == ItemsRegistry.ardium_leggings) {
			return References.MOD_ID + ":textures/models/armor/ardium_layer_2.png";
		} else if (stack.getItem() == ItemsRegistry.ardium_helmet || stack.getItem() == ItemsRegistry.ardium_chestplate
				|| stack.getItem() == ItemsRegistry.ardium_boots) {
			return References.MOD_ID + ":textures/models/armor/ardium_layer_1.png";
		}
		return null;
	}

	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair) {
		if (repair.getItem() == new ItemIngotArdium() || repair.getItem() == ItemsRegistry.ardium_ingot) {
			return true;
		}
		return false;
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		/*
		 * 3 - Helmet 2 - Chestplate 1 - Leggings 0 - Boots
		 */
		if (player.getCurrentArmor(3) != null) {
			if (player.getCurrentArmor(3).getItem() == ItemsRegistry.ardium_helmet) {
				player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 220, 0, true));
			}
		}

		if (player.getCurrentArmor(2) != null) {
			if (player.getCurrentArmor(2).getItem() == ItemsRegistry.ardium_chestplate) {
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 1, 0, true));
			}
		}

		if (player.getCurrentArmor(1) != null) {
			if (player.getCurrentArmor(1).getItem() == ItemsRegistry.ardium_leggings) {
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 1, 0, false));
			}
		}

		if (player.getCurrentArmor(0) != null) {
			if (player.getCurrentArmor(0).getItem() == ItemsRegistry.ardium_boots) {
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 1, 0, false));
			}
		}
	}
}