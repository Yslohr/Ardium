package com.ardium.pvp.items;

import com.ardium.pvp.Ardium;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemArrowArdiumBase extends Item {
	private int arrowTypeID;
	
	public ItemArrowArdiumBase(String itemArrowName, String texture, int arrowTypeID) {
		this.setArrowTypeID(arrowTypeID);
		this.setCreativeTab(Ardium.tabArdium);
		this.setTextureName(itemArrowName);
		this.setUnlocalizedName(itemArrowName);
	}

	public int getArrowTypeID() {
		return arrowTypeID;
	}

	public void setArrowTypeID(int arrowTypeID) {
		this.arrowTypeID = arrowTypeID;
	}
}
