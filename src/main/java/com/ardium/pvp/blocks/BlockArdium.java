package com.ardium.pvp.blocks;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.init.BlocksRegister;
import com.ardium.pvp.utils.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class BlockArdium extends Block {

	public BlockArdium(Material blockArdium, int harvestLevel) {
		super(blockArdium);
		setBlockName("ardium_block");
		setBlockTextureName(References.MOD_ID + ":ardium_block");
		setCreativeTab(Ardium.ardiumTab);
		setHardness(5.0F);
		setHarvestLevel("pickaxe", harvestLevel);
		setResistance(10.0F);
		setStepSound(soundTypeMetal);
	}

	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
		return this == BlocksRegister.ardium_block;
	}
}