package com.ardium.pvp.init;

import com.ardium.pvp.blocks.walls.BlockWallObsidian;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class OreDictionaryRegistry {

	public static void register() {
		// Blocks
		OreDictionary.registerOre("blockArdium", BlocksRegistry.ardium_ingot_block);
		OreDictionary.registerOre("oreArdium", BlocksRegistry.ardium_ore);
		OreDictionary.registerOre("blockEnchantingTable", Blocks.enchanting_table);
		OreDictionary.registerOre("blockEnchantingTableBase", BlocksRegistry.enchanting_table_base);
		OreDictionary.registerOre("blockObsidian", Blocks.obsidian);
		OreDictionary.registerOre("blockStairsObsidian", BlocksRegistry.obsidian_stairs);
		OreDictionary.registerOre("blockWallObsidian", BlocksRegistry.obsidian_wall);
		OreDictionary.registerOre("blockPlatinum", BlocksRegistry.platinum_block);
		OreDictionary.registerOre("orePlatinum", BlocksRegistry.platinum_ore);
		OreDictionary.registerOre("tnt", Blocks.tnt);
		// Items
		OreDictionary.registerOre("backpack", ItemsRegistry.backpack);
		OreDictionary.registerOre("book", Items.book);
		OreDictionary.registerOre("gemDiamond", Items.diamond);
		OreDictionary.registerOre("starNether", Items.nether_star);
		OreDictionary.registerOre("leather", Items.leather);
		OreDictionary.registerOre("ingotArdium", ItemsRegistry.ardium_ingot);
		OreDictionary.registerOre("ingotPlatinum", ItemsRegistry.platinum_ingot);
		OreDictionary.registerOre("skullSkeleton", new ItemStack(Items.skull, 1, 0));
		OreDictionary.registerOre("skullSkeletonWither", new ItemStack(Items.skull, 1, 1));
		OreDictionary.registerOre("stickWood", Items.stick);
		OreDictionary.registerOre("string", Items.string);
		OreDictionary.registerOre("stringArdium", ItemsRegistry.ardium_string);
		OreDictionary.registerOre("stringSticky", ItemsRegistry.sticky_string);
		OreDictionary.registerOre("slimeBall", Items.slime_ball);
		
		OreDictionary.registerOre("shovelPlatinum", ItemsRegistry.platinum_shovel);
		OreDictionary.registerOre("pickaxePlatinum", ItemsRegistry.platinum_pickaxe);
		OreDictionary.registerOre("axePlatinum", ItemsRegistry.platinum_axe);
		OreDictionary.registerOre("hoePlatinum", ItemsRegistry.platinum_hoe);
	}

	public static void crafting() {

		// Blocks
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(BlocksRegistry.ardium_ingot_block), "ingotArdium",
				"ingotArdium", "ingotArdium", "ingotArdium", "ingotArdium", "ingotArdium", "ingotArdium", "ingotArdium",
				"ingotArdium"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemsRegistry.ardium_ingot, 9), "blockArdium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlocksRegistry.enchanting_table_base), " O ", "OOO",
				'O', "blockObsidian"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.enchanting_table), " B ", "DTD", 'B', "book",
				'D', "gemDiamond", 'T', "blockEnchantingTableBase"));
		GameRegistry.addRecipe(
				new ShapelessOreRecipe(new ItemStack(BlocksRegistry.enchanting_table_base, 1), "blockEnchantingTable"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemsRegistry.ardium_ingot, 1), "oreArdium"));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(BlocksRegistry.obsidian_wall, 6), "blockObsidian",
				"blockObsidian", "blockObsidian", "blockObsidian", "blockObsidian", "blockObsidian"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.obsidian, 6), "blockWallObsidian"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlocksRegistry.obsidian_stairs, 4), "O  ", "OO ",
				"OOO", 'O', "blockObsidian"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.obsidian, 4), "blockStairsObsidian"));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(BlocksRegistry.platinum_block),
				"ingotPlatinum", "ingotPlatinum", "ingotPlatinum", "ingotPlatinum", "ingotPlatinum",
						"ingotPlatinum", "ingotPlatinum", "ingotPlatinum", "ingotPlatinum"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemsRegistry.platinum_ingot, 9),
				new Object[] { "blockPlatinum" }));

		// Tools
		GameRegistry.addRecipe(
				new ShapedOreRecipe(ItemsRegistry.ardium_sword, "A", "A", "B", 'A', "ingotArdium", 'B', "stickWood"));
		GameRegistry.addRecipe(
				new ShapedOreRecipe(ItemsRegistry.ardium_shovel, "A", "B", "B", 'A', "ingotArdium", 'B', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsRegistry.ardium_pickaxe, "AAA", " B ", " B ", 'A',
				"ingotArdium", 'B', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsRegistry.ardium_axe, " AA", " BA", " B ", 'A', "ingotArdium",
				'B', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsRegistry.ardium_hoe, " AA", " B ", " B ", 'A', "ingotArdium",
				'B', "stickWood"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemsRegistry.ardium_multitools, 1),
				new Object[] { "hoeArdium", "pickaxeArdium", "shovelArdium", "axeArdium" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemsRegistry.platinum_multitools, 1),
				new Object[] { "hoePlatinum", "pickaxePlatinum", "shovelPlatinum", "axePlatinum" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsRegistry.platinum_sword, "P", "P", "B", 'P', "ingotPlatinum",
				'B', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsRegistry.platinum_shovel, "P", "B", "B", 'P', "ingotPlatinum",
				'B', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsRegistry.platinum_pickaxe, "PPP", " B ", " B ", 'P',
				"ingotPlatinum", 'B', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsRegistry.platinum_axe, " PP", " BP", " B ", 'P',
				"ingotPlatinum", 'B', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsRegistry.platinum_hoe, " PP", " B ", " B ", 'P',
				"ingotPlatinum", 'B', "stickWood"));

		// Armors
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsRegistry.ardium_helmet, "AAA", "A A", 'A', "ingotArdium"));
		GameRegistry.addRecipe(
				new ShapedOreRecipe(ItemsRegistry.ardium_chestplate, "A A", "AAA", "AAA", 'A', "ingotArdium"));
		GameRegistry
				.addRecipe(new ShapedOreRecipe(ItemsRegistry.ardium_leggings, "AAA", "A A", "A A", 'A', "ingotArdium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsRegistry.ardium_boots, "A A", "A A", 'A', "ingotArdium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsRegistry.platinum_helmet, "PPP", "P P", 'P', "ingotPlatinum"));
		GameRegistry.addRecipe(
				new ShapedOreRecipe(ItemsRegistry.platinum_chestplate, "P P", "PPP", "PPP", 'P', "ingotPlatinum"));
		GameRegistry.addRecipe(
				new ShapedOreRecipe(ItemsRegistry.platinum_leggings, "PPP", "P P", "P P", 'P', "ingotPlatinum"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ItemsRegistry.platinum_boots, "P P", "P P", 'P', "ingotPlatinum"));

		// Items
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsRegistry.backpack), "LAL", "A A", "LAL", 'L',
				"leather", 'A', "ingotArdium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.skull, 1, 1), "NNN", "NSN", "NNN", 'N',
				"starNether", 'S', "skullSkeleton"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsRegistry.ardium_string, 3), "SAS", "SAS", "SAS",
				'A', "ingotArdium", 'S', "string"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsRegistry.sticky_string, 3), "SBS", "SBS", "SBS",
				'S', "string", 'B', "slimeBall"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsRegistry.dynamite, 4), "S", "T", "T", 'S',
				"stringArdium", 'T', "tnt"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemsRegistry.sticky_dynamite, 4), "S", "T", "T", 'S',
				"stringSticky", 'T', "tnt"));
	}
}