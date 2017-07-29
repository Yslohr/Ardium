package com.ardium.pvp.items.slabs;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.init.BlocksRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabObsidian extends ItemSlab {

	public ItemSlabObsidian(Block block) {
		super(block, BlocksRegistry.obsidian_slab_single, BlocksRegistry.obsidian_slab_double,
				block == BlocksRegistry.obsidian_slab_double);
		this.setUnlocalizedName("item_obsidian_slab");
	}
}