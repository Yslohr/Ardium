package com.ardium.pvp.items.tools.platinum;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;
import com.ardium.pvp.init.ItemsRegistry;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemAxePlatinum extends ItemAxe {

	public ItemAxePlatinum(ToolMaterial platinumToolMaterial) {
		super(platinumToolMaterial);
		this.setCreativeTab(Ardium.tabArdium);
		this.setUnlocalizedName("platinum_axe");
		this.setTextureName(References.MOD_ID + ":platinum_axe");
	}

	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair) {

		if (repair.getItem() == ItemsRegistry.platinum_ingot) {
			return true;
		}
		return false;
	}
}
