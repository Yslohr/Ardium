package com.ardium.pvp;

import com.ardium.pvp.init.ItemsRegistry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabArdium extends CreativeTabs {

	public TabArdium(String tabName) {
		super(tabName);
		//this.setBackgroundImageName("item_search.png");
	}

	@Override
	public Item getTabIconItem() {
		return ItemsRegistry.ardium_sword;
	}
	
	@Override
	public boolean hasSearchBar() {
		return false;
	}
}
