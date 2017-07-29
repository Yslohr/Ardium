package com.ardium.pvp.items.tools.ardium;

import com.ardium.pvp.References;
import com.ardium.pvp.Ardium;
import com.ardium.pvp.init.ItemsRegistry;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemAxeArdium extends ItemAxe {

	public ItemAxeArdium(ToolMaterial ardiumToolMaterial) {
		super(ardiumToolMaterial);
		this.setCreativeTab(Ardium.tabArdium);
		this.setTextureName(References.MOD_ID + ":ardium_axe");
		this.setUnlocalizedName("ardium_axe");
		
	}

	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair) {
		if (repair.getItem() == ItemsRegistry.ardium_ingot) {
			return true;
		}
		return false;
	}
}
