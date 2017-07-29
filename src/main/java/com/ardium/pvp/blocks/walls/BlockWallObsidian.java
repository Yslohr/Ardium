package com.ardium.pvp.blocks.walls;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.init.BlocksRegister;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import java.util.List;

public class BlockWallObsidian extends BlockWall {

	public BlockWallObsidian(Block block) {
		super(block);
		this.setBlockName("obsidian_wall");
		this.setCreativeTab(Ardium.ardiumTab);
		this.setHardness(50.0F);
		this.setResistance(2000.0F);
		this.setHarvestLevel("pickaxe", 3);
		this.setStepSound(Block.soundTypePiston);
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		if(meta != 0){
			meta = 0;
			return Blocks.obsidian.getBlockTextureFromSide(side);
		}
		return Blocks.obsidian.getBlockTextureFromSide(side);
	}

	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		list.add(new ItemStack(item, 1, 0));
	}

	public boolean connectWallTo(IBlockAccess blockacc, int x, int y, int z) {
		Block l = blockacc.getBlock(x, y, z);
		if (l != Blocks.fence_gate && l != Blocks.fence && l != Blocks.nether_brick_fence) {
			Block block = blockacc.getBlock(x, y, z);
			return block != null && getMaterial().isOpaque() && block.renderAsNormalBlock()
					? block.getMaterial() != Material.ground : false;
		} else {
			return true;
		}
	}

	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
		if (entity instanceof EntityDragon) {
			return this != BlocksRegister.obsidian_wall;
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