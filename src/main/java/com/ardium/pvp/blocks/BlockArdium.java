package com.ardium.pvp.blocks;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;
import com.ardium.pvp.init.BlocksRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class BlockArdium extends Block {

	public BlockArdium(Material blockArdium, int harvestLevel) {
		super(blockArdium);
		this.setBlockName("ardium_block");
		this.setBlockTextureName(References.MOD_ID + ":ardium_block");
		this.setCreativeTab(Ardium.tabArdium);
		this.setHardness(5.0F);
		this.setHarvestLevel("pickaxe", harvestLevel);
		this.setResistance(10.0F);
		this.setStepSound(soundTypeMetal);
	}

	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
		return this == BlocksRegistry.ardium_ingot_block;
	}
}