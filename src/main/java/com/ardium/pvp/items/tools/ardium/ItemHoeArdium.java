package com.ardium.pvp.items.tools.ardium;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;
import com.ardium.pvp.init.ItemsRegistry;

import net.minecraft.item.ItemHoe;

public class ItemHoeArdium extends ItemHoe {
	private float ardiumAttackDamage = ItemsRegistry.ardiumToolMaterial.getDamageVsEntity();
	public ItemHoeArdium(ToolMaterial ardiumToolMaterial) {
		super(ardiumToolMaterial);
		this.setCreativeTab(Ardium.tabArdium);
		this.ardiumAttackDamage = ardiumToolMaterial.getDamageVsEntity();
		this.setTextureName(References.MOD_ID + ":ardium_hoe");
		this.setUnlocalizedName("ardium_hoe");
	}
}