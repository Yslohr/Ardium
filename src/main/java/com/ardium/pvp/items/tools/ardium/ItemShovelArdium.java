package com.ardium.pvp.items.tools.ardium;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;
import com.ardium.pvp.init.ItemsRegistry;

import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ItemShovelArdium extends ItemSpade {

	public ItemShovelArdium(ToolMaterial ardiumToolMaterial) {
		super(ardiumToolMaterial);
		this.setCreativeTab(Ardium.tabArdium);
		this.setTextureName(References.MOD_ID + ":ardium_shovel");
		this.setUnlocalizedName("ardium_shovel");
	}

	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair) {

		if (repair.getItem() == ItemsRegistry.ardium_ingot) {
			return true;
		}
		return false;
	}
}