package com.ardium.pvp.items.itemBlocks;

import com.ardium.pvp.init.BlocksRegister;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;

public class ItemSlabObsidian extends ItemSlab {

	private static boolean isFullBlock;
	private static BlockSlab singleSlab;
	private static BlockSlab doubleSlab;

	public ItemSlabObsidian(Block block) {
		super(block, singleSlab, doubleSlab, isFullBlock);
		this.singleSlab = BlocksRegister.obsidian_slab_single;
		this.doubleSlab = BlocksRegister.obsidian_slab_double;
		if (this != null && this == Item.getItemFromBlock(BlocksRegister.obsidian_slab_double)) {
			this.isFullBlock = true;
		} else {
			this.isFullBlock = false;
		}
		setUnlocalizedName("item_obsidian_slab");
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	public int getMetadata(int metadata) {
		return metadata;
	}

}