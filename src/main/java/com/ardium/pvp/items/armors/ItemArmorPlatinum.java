package com.ardium.pvp.items.armors;

import com.ardium.pvp.References;
import com.ardium.pvp.init.ItemsRegistry;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class ItemArmorPlatinum extends ItemArmor {
	public ItemArmorPlatinum(ArmorMaterial platinumArmorMaterial, int metaData) {
		super(platinumArmorMaterial, 0, metaData);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == ItemsRegistry.platinum_leggings) {
			return References.MOD_ID + ":textures/models/armor/platinum_layer_2.png";
		} else if (stack.getItem() == ItemsRegistry.platinum_helmet
				|| stack.getItem() == ItemsRegistry.platinum_chestplate
				|| stack.getItem() == ItemsRegistry.platinum_boots) {
			return References.MOD_ID + ":textures/models/armor/platinum_layer_1.png";
		}
		return null;
	}

	public boolean getIsRepairable(ItemStack input, ItemStack repair) {
		if (repair.getItem() == ItemsRegistry.platinum_ingot) {
			return true;
		}
		return false;
	}
}
