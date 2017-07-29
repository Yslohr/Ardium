package com.ardium.pvp.items.tools.ardium;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;
import com.ardium.pvp.init.ItemsRegistry;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemSwordArdium extends ItemSword {

	public ItemSwordArdium(ToolMaterial ardiumToolMaterial) {
		super(ardiumToolMaterial);
		this.setCreativeTab(Ardium.tabArdium);
		this.setTextureName(References.MOD_ID + ":ardium_sword");
		this.setUnlocalizedName("ardium_sword");
	}

	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair) {

		if (repair.getItem() == ItemsRegistry.ardium_ingot) {
			return true;
		}
		return false;
	}

}