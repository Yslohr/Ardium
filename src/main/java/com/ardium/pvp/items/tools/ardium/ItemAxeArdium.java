package com.ardium.pvp.items.tools.ardium;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.init.ItemsRegister;
import com.ardium.pvp.utils.References;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemAxeArdium extends ItemAxe {

	public ItemAxeArdium(ToolMaterial ardiumToolMaterial) {
		super(ardiumToolMaterial);
		setCreativeTab(Ardium.ardiumTab);
		setUnlocalizedName("ardium_axe");
		setTextureName(References.MOD_ID + ":" + getUnlocalizedName().substring(5));
		
	}

	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair) {
		if (repair.getItem() == ItemsRegister.ardium_ingot) {
			return true;
		}
		return false;
	}
}
