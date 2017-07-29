package com.ardium.pvp.init;

import com.ardium.pvp.blocks.BlockArdium;
import com.ardium.pvp.blocks.BlockBarrier;
import com.ardium.pvp.blocks.BlockBedFinder;
import com.ardium.pvp.blocks.BlockEnchantingTableBase;
import com.ardium.pvp.blocks.OreArdium;
import com.ardium.pvp.blocks.stairs.BlockStairsObsidian;
import com.ardium.pvp.blocks.walls.BlockWallObsidian;
import com.ardium.pvp.utils.LogHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class BlocksRegister {
	/* Blocks */
	public static Block ardium_ore, ardium_block, barrier_block, bed_finder,enchanting_table_base, obsidian_stairs, obsidian_wall;
	public static BlockSlab obsidian_slab_single, obsidian_slab_double;

	public static void init() {
		/* Blocks */
		ardium_ore = new OreArdium(Material.rock, 2);
		ardium_block = new BlockArdium(Material.iron, 2);
		barrier_block = new BlockBarrier(Material.rock, 2);
		bed_finder = new BlockBedFinder(Material.cloth, 1);
		enchanting_table_base = new BlockEnchantingTableBase(Material.rock, 3);
		obsidian_stairs = new BlockStairsObsidian(Blocks.obsidian, 3);
		obsidian_wall = new BlockWallObsidian(Blocks.obsidian);
		

		register();
		LogHelper.info("Blocks Initialization Completed Sucessfully !");
	}

	public static void register() {
		/* Blocks */
		GameRegistry.registerBlock(ardium_ore, ardium_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ardium_block, ardium_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(barrier_block, barrier_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(enchanting_table_base, enchanting_table_base.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(obsidian_stairs, obsidian_stairs.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(obsidian_wall, obsidian_wall.getUnlocalizedName().substring(5));
	}
}
