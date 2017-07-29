package com.ardium.pvp.init;

import com.ardium.pvp.blocks.BlockArdium;
import com.ardium.pvp.blocks.BlockArdiumBarrier;
import com.ardium.pvp.blocks.BlockEnchantingTableBase;
import com.ardium.pvp.blocks.BlockObsidianGlass;
import com.ardium.pvp.blocks.BlockPlatinum;
import com.ardium.pvp.blocks.OreArdium;
import com.ardium.pvp.blocks.OrePlatinum;
import com.ardium.pvp.blocks.slabs.BlockSlabObsidian;
import com.ardium.pvp.blocks.stairs.BlockStairsObsidian;
import com.ardium.pvp.blocks.walls.BlockWallObsidian;
import com.ardium.pvp.items.slabs.ItemSlabObsidian;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class BlocksRegistry {

	public static Block ardium_ingot_block;
	public static Block ardium_barrier;
	public static Block ardium_ore;

	public static Block enchanting_table_base;

	public static BlockSlab obsidian_slab_single;
	public static BlockSlab obsidian_slab_double;
	public static Block obsidian_glass;
	public static Block obsidian_stairs;
	public static Block obsidian_wall;

	public static Block platinum_block;
	public static Block platinum_bar;
	public static Block platinum_door;
	public static Block platinum_ore;

	public static void init() {
		ardium_barrier = new BlockArdiumBarrier(Material.rock, 999999);
		ardium_ingot_block = new BlockArdium(Material.iron, 3);
		ardium_ore = new OreArdium(Material.rock, 3);

		enchanting_table_base = new BlockEnchantingTableBase(Material.rock, 3);

		obsidian_glass = new BlockObsidianGlass(3);
		obsidian_slab_single = (BlockSlab) new BlockSlabObsidian(false).setHardness(50.0F);
		obsidian_slab_double = (BlockSlab) new BlockSlabObsidian(true).setHardness(50.0F);
		obsidian_stairs = new BlockStairsObsidian(Blocks.obsidian, 3);
		obsidian_wall = new BlockWallObsidian(Blocks.obsidian);

		platinum_block = new BlockPlatinum(Material.iron, 3);
		platinum_ore = new OrePlatinum(Material.rock, 3);
	}

	public static void register() {
		GameRegistry.registerBlock(ardium_ingot_block, ardium_ingot_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ardium_ore, ardium_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ardium_barrier, ardium_barrier.getUnlocalizedName().substring(5));

		GameRegistry.registerBlock(enchanting_table_base, enchanting_table_base.getUnlocalizedName().substring(5));

		GameRegistry.registerBlock(obsidian_stairs, obsidian_stairs.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(obsidian_wall, obsidian_wall.getUnlocalizedName().substring(5));

		GameRegistry.registerBlock(platinum_block, platinum_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(platinum_ore, platinum_ore.getUnlocalizedName().substring(5));

		GameRegistry.addSmelting(ardium_ore, new ItemStack(ItemsRegistry.ardium_ingot, 1), 1.0F);
		GameRegistry.addSmelting(platinum_ore, new ItemStack(ItemsRegistry.platinum_ingot, 1), 0.75F);
	}

	public static void postRegister() {
		GameRegistry.registerBlock(obsidian_slab_single, ItemSlabObsidian.class, "obsidian_slab_single");
		GameRegistry.registerBlock(obsidian_slab_double, ItemSlabObsidian.class, "obsidian_slab_double");
	}
}