package com.ardium.pvp.items;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;
import com.ardium.pvp.init.ItemsRegistry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemIngotPlatinum extends Item {
	public ItemIngotPlatinum() {
		this.setCreativeTab(Ardium.tabArdium);
		this.setUnlocalizedName("platinum_ingot");
		this.setTextureName(References.MOD_ID + ":platinum_ingot");
		this.isBeaconPayment(new ItemStack(ItemsRegistry.platinum_ingot));
	}
}
