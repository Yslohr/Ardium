package com.ardium.pvp.items.tools.ardium;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.init.ItemsRegister;
import com.ardium.pvp.utils.References;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ItemShovelArdium extends ItemSpade {

	public ItemShovelArdium(ToolMaterial ardiumToolMaterial) {
		super(ardiumToolMaterial);
		setCreativeTab(Ardium.ardiumTab);
		setUnlocalizedName("ardium_shovel");
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