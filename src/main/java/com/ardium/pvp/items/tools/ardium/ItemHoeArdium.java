package com.ardium.pvp.items.tools.ardium;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.init.ItemsRegister;
import com.ardium.pvp.utils.References;
import net.minecraft.item.ItemHoe;

public class ItemHoeArdium extends ItemHoe {
	private float ardiumAttackDamage = ItemsRegister.ardiumToolMaterial.getDamageVsEntity();
	public ItemHoeArdium(ToolMaterial ardiumToolMaterial) {
		super(ardiumToolMaterial);
		setCreativeTab(Ardium.ardiumTab);
		ardiumAttackDamage = ardiumToolMaterial.getDamageVsEntity();
		setUnlocalizedName("ardium_hoe");
		setTextureName(References.MOD_ID + ":" + getUnlocalizedName().substring(5));
	}
}