package com.ardium.pvp.items.armors;

import com.ardium.pvp.init.ItemsRegister;
import com.ardium.pvp.utils.References;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemArmorArdium extends ItemArmor {
	public ItemArmorArdium(ItemArmor.ArmorMaterial material, int armorSlot) {
		super(material, 0, armorSlot);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (slot == 2) {
			return References.MOD_ID + ":textures/models/armor/ardium_layer_2.png";
		}
		return References.MOD_ID + ":textures/models/armor/ardium_layer_1.png";
	}

	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		if (player.getCurrentArmor(3) != null) {
			if (player.getCurrentArmor(3).getItem() == ItemsRegister.ardium_helmet) {
				player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 220, 0, true));
			}
		}

		if (player.getCurrentArmor(2) != null) {
			if (player.getCurrentArmor(2).getItem() == ItemsRegister.ardium_chestplate) {
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 1, 0, true));
			}
		}

		if (player.getCurrentArmor(1) != null) {
			if (player.getCurrentArmor(1).getItem() == ItemsRegister.ardium_leggings) {
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 1, 0, false));
			}
		}

		if (player.getCurrentArmor(0) != null) {
			if (player.getCurrentArmor(0).getItem() == ItemsRegister.ardium_boots) {
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 1, 0, false));
			}
		}
	}

	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair) {
		if (input.getItem() == ItemsRegister.ardium_ingot) {
			return repair.getItem() == ItemsRegister.ardium_ingot;
		}
		return false;
	}
}