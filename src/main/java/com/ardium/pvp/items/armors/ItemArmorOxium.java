package com.ardium.pvp.items.armors;

import com.ardium.pvp.References;
import com.ardium.pvp.init.ItemsRegistry;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemArmorOxium extends ItemArmor {
	public ItemArmorOxium(ArmorMaterial oxiumArmorMaterial, int metaData) {
		super(oxiumArmorMaterial, 0, metaData);
		this.setMaxStackSize(1);
		this.setNoRepair();
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {

		if (stack.getItem() == ItemsRegistry.oxium_leggings) {
			return References.MOD_ID + ":textures/models/armor/oxium_layer_2.png";
		} else if (stack.getItem() == ItemsRegistry.oxium_helmet || stack.getItem() == ItemsRegistry.oxium_chestplate
				|| stack.getItem() == ItemsRegistry.oxium_boots) {
			return References.MOD_ID + ":textures/models/armor/oxium_layer_1.png";
		}
		return null;
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		/*
		 * 3 - Helmet 2 - Chestplate 1 - Leggings 0 - Boots
		 */
		if (player.getCurrentArmor(3) != null) {
			if (player.getCurrentArmor(3).getItem() == ItemsRegistry.oxium_helmet) {
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 220, -1, true));
			}
		}
		if (player.getCurrentArmor(2) != null) {
			if (player.getCurrentArmor(2).getItem() == ItemsRegistry.oxium_chestplate) {
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1, 1, true));
			}
		}
		if (player.getCurrentArmor(1) != null) {
			if (player.getCurrentArmor(1).getItem() == ItemsRegistry.oxium_leggings) {
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 1, 1, false));
			}
		}
		if (player.getCurrentArmor(0) != null) {
			if (player.getCurrentArmor(0).getItem() == ItemsRegistry.oxium_boots) {
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1, 1, false));
			}
		}
		if (player.getCurrentArmor(3) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(1) != null
				&& player.getCurrentArmor(0) != null) {
			ItemStack helmet = player.getCurrentArmor(3);
			ItemStack chestplate = player.getCurrentArmor(2);
			ItemStack leggings = player.getCurrentArmor(1);
			ItemStack boots = player.getCurrentArmor(0);
			if (helmet.getItem() == ItemsRegistry.oxium_helmet && chestplate.getItem() == ItemsRegistry.oxium_chestplate
					&& leggings.getItem() == ItemsRegistry.oxium_leggings
					&& boots.getItem() == ItemsRegistry.oxium_boots) {
				player.addPotionEffect(new PotionEffect(Potion.invisibility.getId(), 2, 1, true));
			}

		}
	}
}