package com.ardium.pvp.blocks;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.init.BlocksRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.world.IBlockAccess;

public class BlockEnchantingTableBase extends Block {
	public BlockEnchantingTableBase(Material material, int harvestLevel) {
		super(material);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
		this.setBlockName("enchanting_table_base");
		this.setBlockTextureName("minecraft:obsidian");
		this.setCreativeTab(Ardium.tabArdium);
		this.setHardness(50.0F);
		this.setResistance(2000.0F);
		this.setHarvestLevel("pickaxe", 3);
	}
	
	@Override
	public int getMobilityFlag() {
		return 2;
	}

	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
		if (entity instanceof EntityDragon) {
			return this != BlocksRegistry.enchanting_table_base;
		}
		return true;
	}
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
}
