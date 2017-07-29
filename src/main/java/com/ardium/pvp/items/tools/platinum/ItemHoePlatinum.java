package com.ardium.pvp.items.tools.platinum;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;
import com.ardium.pvp.init.ItemsRegistry;

import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class ItemHoePlatinum extends ItemHoe {

	public ItemHoePlatinum(ToolMaterial platinumToolMaterial) {
		super(platinumToolMaterial);
		this.setCreativeTab(Ardium.tabArdium);
		this.setUnlocalizedName("platinum_hoe");
		this.setTextureName(References.MOD_ID + ":platinum_hoe");
	}

	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair) {

		if (repair.getItem() == ItemsRegistry.platinum_ingot) {
			return true;
		}
		return false;
	}
}
