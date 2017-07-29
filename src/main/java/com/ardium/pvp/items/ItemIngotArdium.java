package com.ardium.pvp.items;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;

import net.minecraft.item.Item;

public class ItemIngotArdium extends Item 
{
	public ItemIngotArdium() {
		this.setCreativeTab(Ardium.tabArdium);
		this.setUnlocalizedName("ardium_ingot");
		this.setTextureName(References.MOD_ID + ":ardium_ingot");
	}
}
