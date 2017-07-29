package com.ardium.pvp.utils;

import com.ardium.pvp.init.ItemsRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ArdiumTab extends CreativeTabs
{
	public ArdiumTab(String lable)
    {
        super(lable);
      //this.setBackgroundImageName("item_search.png");
    }

    @Override
    public Item getTabIconItem()
    {
        return ItemsRegister.ardium_ingot;
    }
    
    /*
    @Override
    public boolean hasSearchBar() {
    	return true;
    }*/
}
