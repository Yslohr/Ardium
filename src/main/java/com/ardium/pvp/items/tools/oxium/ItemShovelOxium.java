package com.ardium.pvp.items.tools.oxium;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;

import net.minecraft.item.ItemSpade;

public class ItemShovelOxium extends ItemSpade {

	public ItemShovelOxium(ToolMaterial oxiumToolMaterial) {
		super(oxiumToolMaterial);
		this.setCreativeTab(Ardium.tabArdium);
		this.setTextureName(References.MOD_ID + ":oxium_shovel");
		this.setUnlocalizedName("oxium_shovel");
	}
}