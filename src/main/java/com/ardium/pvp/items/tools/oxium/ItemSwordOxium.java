package com.ardium.pvp.items.tools.oxium;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;

import net.minecraft.item.ItemSword;

public class ItemSwordOxium extends ItemSword {
	public ItemSwordOxium(ToolMaterial oxiumToolMaterial) {
		super(oxiumToolMaterial);
		this.setCreativeTab(Ardium.tabArdium);
		this.setTextureName(References.MOD_ID + ":oxium_sword");
		this.setUnlocalizedName("oxium_sword");
		this.setNoRepair();
	}
}
