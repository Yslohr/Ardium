package com.ardium.pvp.blocks.stairs;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.init.BlocksRegister;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.world.IBlockAccess;

public class BlockStairsObsidian extends BlockStairs {

	public BlockStairsObsidian(Block obsidian, int harvestLevel) {
		super(obsidian, harvestLevel);
		setCreativeTab(Ardium.ardiumTab);
		setBlockName("obsidian_stairs");
		setBlockTextureName("minecraft:obsidian");
		setHardness(50.0F);
		setHarvestLevel("pickaxe", harvestLevel);
		setLightOpacity(255);
		setResistance(1500.0F);
		setStepSound(soundTypePiston);
	}

	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
		if (entity instanceof EntityDragon) {
			return this != BlocksRegister.obsidian_stairs;
		}
		return true;
	}

	/**
	 * Returns the mobility information of the block, 0 = free, 1 = can't push
	 * but can move over, 2 = total immobility and stop pistons
	 */
	@Override
	public int getMobilityFlag() {
		return 2;
	}
}