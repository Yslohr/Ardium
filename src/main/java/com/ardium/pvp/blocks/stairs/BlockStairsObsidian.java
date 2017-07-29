package com.ardium.pvp.blocks.stairs;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.init.BlocksRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.world.IBlockAccess;

public class BlockStairsObsidian extends BlockStairs {

	public BlockStairsObsidian(Block obsidian, int harvestLevel) {
		super(obsidian, harvestLevel);
		this.setCreativeTab(Ardium.tabArdium);
		this.setBlockName("obsidian_stairs");
		this.setBlockTextureName("minecraft:obsidian");
		this.setHardness(50.0F);
		this.setHarvestLevel("pickaxe", harvestLevel);
		this.setLightOpacity(255);
		this.setResistance(1500.0F);
		this.setStepSound(soundTypePiston);
	}

	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
		if (entity instanceof EntityDragon) {
			return this != BlocksRegistry.obsidian_wall;
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