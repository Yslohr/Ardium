package com.ardium.pvp.init;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.items.ItemAppleArdium;
import com.ardium.pvp.items.ItemDynamite;
import com.ardium.pvp.items.armors.ItemArmorArdium;
import com.ardium.pvp.items.tools.ardium.ItemAxeArdium;
import com.ardium.pvp.items.tools.ardium.ItemHoeArdium;
import com.ardium.pvp.items.tools.ardium.ItemMutiToolsArdium;
import com.ardium.pvp.items.tools.ardium.ItemPickaxeArdium;
import com.ardium.pvp.items.tools.ardium.ItemShovelArdium;
import com.ardium.pvp.items.tools.ardium.ItemSwordArdium;
import com.ardium.pvp.utils.LogHelper;
import com.ardium.pvp.utils.References;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ItemsRegister {
	/* Items */
	public static Item ardium_ingot, ardium_apple, dynamite, coin_10, coin_100, coin_1000, coin_10000, coin_100000,
			coin_1000000;
	/* Tools */
	public static ToolMaterial ardiumToolMaterial = EnumHelper.addToolMaterial("ardiumToolMaterial", 3, 4999, 30.0F,
			6.0F, 35);
	public static Item ardium_sword, ardium_pickaxe, ardium_axe, ardium_shovel, ardium_hoe, ardium_batte_axe, ardium_multitools;
	/* Armors */
	public static ItemArmor.ArmorMaterial ardiumArmor = EnumHelper.addArmorMaterial("ardiumarmor", 320,
			new int[] { 4, 7, 5, 6 }, 21);
	public static Item ardium_helmet, ardium_chestplate, ardium_leggings, ardium_boots;

	public static void init() {
		/* Items */
		ardium_ingot = new Item().setUnlocalizedName("ardium_ingot").setCreativeTab(Ardium.ardiumTab)
				.setTextureName(References.MOD_ID + ":ardium");
		ardium_apple = new ItemAppleArdium(10, 10.0F, false).setAlwaysEdible().setUnlocalizedName("ardium_apple")
				.setCreativeTab(Ardium.ardiumTab).setTextureName(References.MOD_ID + ":ardium_apple");
		dynamite = new ItemDynamite().setUnlocalizedName("dynamite").setCreativeTab(Ardium.ardiumTab)
				.setTextureName(References.MOD_ID + ":dynamite");
		coin_10 = new Item().setUnlocalizedName("coin_10").setCreativeTab(Ardium.ardiumTab)
				.setTextureName(References.MOD_ID + ":coin_10");
		coin_100 = new Item().setUnlocalizedName("coin_100").setCreativeTab(Ardium.ardiumTab)
				.setTextureName(References.MOD_ID + ":coin_100");
		coin_1000 = new Item().setUnlocalizedName("coin_1000").setCreativeTab(Ardium.ardiumTab)
				.setTextureName(References.MOD_ID + ":coin_1000");
		coin_10000 = new Item().setUnlocalizedName("coin_10000").setCreativeTab(Ardium.ardiumTab)
				.setTextureName(References.MOD_ID + ":coin_10000");
		coin_100000 = new Item().setUnlocalizedName("coin_100000").setCreativeTab(Ardium.ardiumTab)
				.setTextureName("ardium:coin_100000");
		coin_1000000 = new Item().setCreativeTab(Ardium.ardiumTab).setUnlocalizedName("coin_1000000")
				.setTextureName(References.MOD_ID + ":coin_1000000");
		/* Tools */
		ardium_sword = new ItemSwordArdium(ardiumToolMaterial);
		ardium_pickaxe = new ItemPickaxeArdium(ardiumToolMaterial);
		ardium_axe = new ItemAxeArdium(ardiumToolMaterial);
		ardium_shovel = new ItemShovelArdium(ardiumToolMaterial);
		ardium_hoe = new ItemHoeArdium(ardiumToolMaterial);
		ardium_multitools = new ItemMutiToolsArdium(ardiumToolMaterial);
		/* Armors */
		ardium_helmet = new ItemArmorArdium(ardiumArmor, 0).setCreativeTab(Ardium.ardiumTab)
				.setUnlocalizedName("ardium_helmet").setTextureName(References.MOD_ID + ":ardium_helmet");
		ardium_chestplate = new ItemArmorArdium(ardiumArmor, 1).setCreativeTab(Ardium.ardiumTab)
				.setUnlocalizedName("ardium_chestplate").setTextureName(References.MOD_ID + ":ardium_chestplate");
		ardium_leggings = new ItemArmorArdium(ardiumArmor, 2).setCreativeTab(Ardium.ardiumTab)
				.setUnlocalizedName("ardium_leggings").setTextureName(References.MOD_ID + ":ardium_leggings");
		ardium_boots = new ItemArmorArdium(ardiumArmor, 3).setCreativeTab(Ardium.ardiumTab)
				.setUnlocalizedName("ardium_boots").setTextureName(References.MOD_ID + ":ardium_boots");
		register();
		LogHelper.info("Items Initialization Completed Sucessfully !");
	}

	public static void register() {
		/* Items */
		registerItems(ardium_apple);
		registerItems(ardium_ingot);
		registerItems(dynamite);
		registerItems(coin_10);
		registerItems(coin_100);
		registerItems(coin_1000);
		registerItems(coin_10000);
		registerItems(coin_100000);
		registerItems(coin_1000000);
		/* Tools */
		registerItems(ardium_sword);
		registerItems(ardium_pickaxe);
		registerItems(ardium_axe);
		registerItems(ardium_shovel);
		registerItems(ardium_hoe);
		registerItems(ardium_multitools);
		/* Armors */
		registerItems(ardium_helmet);
		registerItems(ardium_chestplate);
		registerItems(ardium_leggings);
		registerItems(ardium_boots);
	}

	public static void registerItems(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}
}
