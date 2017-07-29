package com.ardium.pvp.items.tools.platinum;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;
import com.ardium.pvp.init.ItemsRegistry;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemSwordPlatinum extends ItemSword {

	public ItemSwordPlatinum(ToolMaterial platinumToolMaterial) {
		super(platinumToolMaterial);
		this.setCreativeTab(Ardium.tabArdium);
		this.setTextureName(References.MOD_ID + ":platinum_sword");
		this.setUnlocalizedName("platinum_sword");
	}

	@Override
	public boolean getIsRepairable(ItemStack input, ItemStack repair) {

		if (repair.getItem() == ItemsRegistry.platinum_ingot) {
			return true;
		}
		return false;
	}
}
