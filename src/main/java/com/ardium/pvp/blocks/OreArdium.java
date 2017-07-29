package com.ardium.pvp.blocks;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.utils.References;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;

public class OreArdium extends BlockOre {
	public OreArdium(Material ardiumOre, int harvestLevel) {
		setBlockName("ardium_ore");
		setBlockTextureName(References.MOD_ID + ":ardium_ore");
		setCreativeTab(Ardium.ardiumTab);
		setHarvestLevel("pickaxe", harvestLevel);
		setHardness(4.0F);
		setResistance(5.0F);
	}
}