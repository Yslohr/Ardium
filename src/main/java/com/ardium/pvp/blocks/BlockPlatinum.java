package com.ardium.pvp.blocks;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;
import com.ardium.pvp.init.BlocksRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class BlockPlatinum extends Block {

	public BlockPlatinum(Material platinumMaterial, int harvestLevel) {
		super(platinumMaterial);
		this.setBlockName("platinum_block");
		this.setBlockTextureName(References.MOD_ID + ":platinum_block");
		this.setCreativeTab(Ardium.tabArdium);
		this.setHardness(10.0F);
		this.setHarvestLevel("pickaxe", harvestLevel);
		this.setResistance(20.0F);
		this.setStepSound(soundTypeMetal);
	}

	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
		return this == BlocksRegistry.platinum_block;
	}
}
