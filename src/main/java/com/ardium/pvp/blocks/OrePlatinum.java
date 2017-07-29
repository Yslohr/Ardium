package com.ardium.pvp.blocks;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;

import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;

public class OrePlatinum extends BlockOre {
	public OrePlatinum(Material rock, int harvestLevel) {
		this.setBlockName("platinum_ore");
		this.setBlockTextureName(References.MOD_ID + ":platinum_ore");
		this.setCreativeTab(Ardium.tabArdium);
		this.setHarvestLevel("pickaxe", harvestLevel);
		this.setHardness(6.0F);
		this.setResistance(10.0F);
	}
}
