package com.ardium.pvp.items.tools.oxium;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;

import net.minecraft.item.ItemAxe;

public class ItemAxeOxium extends ItemAxe {

	public ItemAxeOxium(ToolMaterial oxiumToolMaterial) {
		super(oxiumToolMaterial);
		this.setNoRepair();
		this.setCreativeTab(Ardium.tabArdium);
		this.setTextureName(References.MOD_ID + ":oxium_axe");
		this.setUnlocalizedName("oxium_axe");	
	}
}
