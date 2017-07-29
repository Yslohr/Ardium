package com.ardium.pvp.init;

import com.ardium.pvp.utils.LogHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RecipesRegister {

	public static void init() {
		shapedRecipes();
		shapelessRecipes();
		smeltingsRegister();
		oreDictionaryRegister();
		oreShapedRecipes();
		oreShapelessRecipe();
		LogHelper.info("Recipes Initialization Completed Sucessfully !");
	}

	public static void shapedRecipes() {
		GameRegistry.addShapedRecipe(new ItemStack(ItemsRegister.dynamite, 1), " # ", " D ", " D ", '#',
				ItemsRegister.ardium_ingot, 'D', Blocks.tnt);
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlocksRegister.obsidian_stairs, 4), "O  ", "OO ",
				"OOO", 'O', "blockObsidian"));
		// Tools
		GameRegistry.addRecipe(
				new ShapedOreRecipe(ItemsRegister.ardium_sword, "A", "A", "B", 'A', "ingotArdium", 'B', "stickWood"));
		GameRegistry.addRecipe(
				new ShapedOreRecipe(ItemsRegister.ardium_shovel, "A", "B", "B", 'A', "ingotArdium", 'B', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsRegister.ardium_pickaxe, "AAA", " B ", " B ", 'A',
				"ingotArdium", 'B', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsRegister.ardium_axe, " AA", " BA", " B ", 'A', "ingotArdium",
				'B', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsRegister.ardium_hoe, " AA", " B ", " B ", 'A', "ingotArdium",
				'B', "stickWood"));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsRegister.dynamite, 4), "S", "T", "T", 'S',
				"string", 'T', "tnt"));
		GameRegistry.addRecipe(new ItemStack(ItemsRegister.dynamite, 4), "S","T","T",'S', Items.string, 'T', Blocks.tnt);

	}

	public static void shapelessRecipes() {
	}

	public static void smeltingsRegister() {
		// Blocks
		GameRegistry.addSmelting(BlocksRegister.ardium_ore, new ItemStack(ItemsRegister.ardium_ingot), 5.0F);
	}

	public static void oreDictionaryRegister() {
		// Blocks
		OreDictionary.registerOre("blockArdium", BlocksRegister.ardium_block);
		OreDictionary.registerOre("oreArdium", BlocksRegister.ardium_ore);
		OreDictionary.registerOre("blockEnchantingTable", Blocks.enchanting_table);
		OreDictionary.registerOre("blockEnchantingTableBase", BlocksRegister.enchanting_table_base);
		OreDictionary.registerOre("blockObsidian", Blocks.obsidian);
		OreDictionary.registerOre("blockStairsObsidian", BlocksRegister.obsidian_stairs);
		OreDictionary.registerOre("blockWallObsidian", BlocksRegister.obsidian_wall);
		// Items
		OreDictionary.registerOre("appleArdium", ItemsRegister.ardium_apple);
		OreDictionary.registerOre("book", Items.book);
		OreDictionary.registerOre("gemDiamond", Items.diamond);
		OreDictionary.registerOre("starNether", Items.nether_star);
		OreDictionary.registerOre("ingotArdium", ItemsRegister.ardium_ingot);
		OreDictionary.registerOre("stickWood", Items.stick);

		// Tools
		OreDictionary.registerOre("shovelArdium", ItemsRegister.ardium_shovel);
		OreDictionary.registerOre("pickaxeArdium", ItemsRegister.ardium_pickaxe);
		OreDictionary.registerOre("axeArdium", ItemsRegister.ardium_axe);
		OreDictionary.registerOre("hoeArdium", ItemsRegister.ardium_hoe);

	}

	public static void oreShapedRecipes() {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlocksRegister.enchanting_table_base), " O ", "OOO",
				'O', "blockObsidian"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.enchanting_table), " B ", "DTD", 'B', "book",
				'D', "gemDiamond", 'T', "blockEnchantingTableBase"));
		// Tools
		GameRegistry.addRecipe(
				new ShapedOreRecipe(ItemsRegister.ardium_sword, "A", "A", "B", 'A', "ingotArdium", 'B', "stickWood"));
		GameRegistry.addRecipe(
				new ShapedOreRecipe(ItemsRegister.ardium_shovel, "A", "B", "B", 'A', "ingotArdium", 'B', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsRegister.ardium_pickaxe, "AAA", " B ", " B ", 'A',
				"ingotArdium", 'B', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsRegister.ardium_axe, " AA", " BA", " B ", 'A', "ingotArdium",
				'B', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsRegister.ardium_hoe, " AA", " B ", " B ", 'A', "ingotArdium",
				'B', "stickWood"));
		// Armors
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsRegister.ardium_helmet, "AAA", "A A", 'A', "ingotArdium"));
		GameRegistry.addRecipe(
				new ShapedOreRecipe(ItemsRegister.ardium_chestplate, "A A", "AAA", "AAA", 'A', "ingotArdium"));
		GameRegistry
				.addRecipe(new ShapedOreRecipe(ItemsRegister.ardium_leggings, "AAA", "A A", "A A", 'A', "ingotArdium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsRegister.ardium_boots, "A A", "A A", 'A', "ingotArdium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlocksRegister.enchanting_table_base), " O ", "OOO",
				'O', "blockObsidian"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlocksRegister.obsidian_stairs, 4), "O  ", "OO ",
				"OOO", 'O', "blockObsidian"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.enchanting_table), " B ", "DTD", 'B', "book",
				'D', "gemDiamond", 'T', "blockEnchantingTableBase"));
	}

	public static void oreShapelessRecipe() {

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemsRegister.ardium_ingot, 9), "blockArdium"));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemsRegister.ardium_multitools, 1),
				new Object[] { "hoeArdium", "pickaxeArdium", "shovelArdium", "axeArdium" }));
		// Blocks

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(BlocksRegister.ardium_block), "ingotArdium",
				"ingotArdium", "ingotArdium", "ingotArdium", "ingotArdium", "ingotArdium", "ingotArdium", "ingotArdium",
				"ingotArdium"));
		GameRegistry.addRecipe(
				new ShapelessOreRecipe(new ItemStack(BlocksRegister.enchanting_table_base, 1), "blockEnchantingTable"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemsRegister.ardium_ingot, 1), "oreArdium"));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(BlocksRegister.obsidian_wall, 6), "blockObsidian",
				"blockObsidian", "blockObsidian", "blockObsidian", "blockObsidian", "blockObsidian"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.obsidian, 6), "blockWallObsidian"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.obsidian, 4), "blockStairsObsidian"));
		GameRegistry.addRecipe(
				new ShapelessOreRecipe(new ItemStack(BlocksRegister.enchanting_table_base, 1), "blockEnchantingTable"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemsRegister.ardium_ingot, 1), "oreArdium"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(BlocksRegister.obsidian_wall, 6), "blockObsidian",
				"blockObsidian", "blockObsidian", "blockObsidian", "blockObsidian", "blockObsidian"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.obsidian, 6), "blockWallObsidian"));

	}

	public static void printOreDictionaryList() {
		String[] oreDictionaryList = OreDictionary.getOreNames();
		for (int i = 0; i < oreDictionaryList.length; i++) {
			LogHelper.info(oreDictionaryList[i]);
		}
		LogHelper.info("OreDictionary List Printed");
	}
}
