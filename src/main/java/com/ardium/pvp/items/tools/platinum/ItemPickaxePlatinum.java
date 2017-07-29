package com.ardium.pvp.items.tools.platinum;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;
import com.ardium.pvp.init.ItemsRegistry;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemPickaxePlatinum extends ItemPickaxe {

	public ItemPickaxePlatinum(ToolMaterial platinumToolMaterial) {
		super(platinumToolMaterial);
		this.setCreativeTab(Ardium.tabArdium);
		this.setUnlocalizedName("platinum_pickaxe");
		this.setTextureName(References.MOD_ID + ":platinum_pickaxe");
	}

	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair) {

		if (repair.getItem() == ItemsRegistry.platinum_ingot) {
			return true;
		}
		return false;
	}
}
