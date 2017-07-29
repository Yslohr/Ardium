package com.ardium.pvp.items.tools.oxium;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;

import net.minecraft.item.ItemPickaxe;

public class ItemPickaxeOxium extends ItemPickaxe {
	public ItemPickaxeOxium(ToolMaterial oxiumToolMaterial) {
		super(oxiumToolMaterial);
		this.setCreativeTab(Ardium.tabArdium);
		this.setTextureName(References.MOD_ID + ":oxium_pickaxe");
		this.setUnlocalizedName("oxium_pickaxe");
		this.setNoRepair();
	}
}
