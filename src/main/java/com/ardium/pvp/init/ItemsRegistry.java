package com.ardium.pvp.init;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;
import com.ardium.pvp.items.ItemBackpack;
import com.ardium.pvp.items.ItemBowArdium;
import com.ardium.pvp.items.ItemDynamite;
import com.ardium.pvp.items.ItemIngotArdium;
import com.ardium.pvp.items.ItemIngotPlatinum;
import com.ardium.pvp.items.ItemStickyDynamite;
import com.ardium.pvp.items.armors.ItemArmorArdium;
import com.ardium.pvp.items.armors.ItemArmorOxium;
import com.ardium.pvp.items.armors.ItemArmorPlatinum;
import com.ardium.pvp.items.tools.ardium.ItemAxeArdium;
import com.ardium.pvp.items.tools.ardium.ItemHoeArdium;
import com.ardium.pvp.items.tools.ardium.ItemMultiToolsArdium;
import com.ardium.pvp.items.tools.ardium.ItemPickaxeArdium;
import com.ardium.pvp.items.tools.ardium.ItemShovelArdium;
import com.ardium.pvp.items.tools.ardium.ItemSwordArdium;
import com.ardium.pvp.items.tools.oxium.ItemAxeOxium;
import com.ardium.pvp.items.tools.oxium.ItemMultiToolsOxium;
import com.ardium.pvp.items.tools.oxium.ItemPickaxeOxium;
import com.ardium.pvp.items.tools.oxium.ItemShovelOxium;
import com.ardium.pvp.items.tools.oxium.ItemSwordOxium;
import com.ardium.pvp.items.tools.platinum.ItemAxePlatinum;
import com.ardium.pvp.items.tools.platinum.ItemHoePlatinum;
import com.ardium.pvp.items.tools.platinum.ItemMultiToolsPlatinum;
import com.ardium.pvp.items.tools.platinum.ItemPickaxePlatinum;
import com.ardium.pvp.items.tools.platinum.ItemShovelPlatinum;
import com.ardium.pvp.items.tools.platinum.ItemSwordPlatinum;
import com.ardium.pvp.items.tools.witherknockers.ItemWitherKnocker1;
import com.ardium.pvp.items.tools.witherknockers.ItemWitherKnocker2;
import com.ardium.pvp.items.tools.witherknockers.ItemWitherKnocker3;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemsRegistry {
	public static ToolMaterial platinumToolMaterial = EnumHelper.addToolMaterial("platinumToolMaterial", 3, 1951, 16.0F,
			4.0F, 25);
	public static ToolMaterial ardiumToolMaterial = EnumHelper.addToolMaterial("ardiumToolMaterial", 3, 2342, 20.0F,
			5.0F, 30);
	public static ToolMaterial oxiumToolMaterial = EnumHelper.addToolMaterial("oxiumToolMaterial", 3, 3122, 30.0F, 6.0F,
			35);
	public static ToolMaterial witherKnockerToolMaterial1 = EnumHelper.addToolMaterial("witherKnockerToolMaterial1", 0,
			21, 0.0F, -4.0F, 0);
	public static ToolMaterial witherKnockerToolMaterial2 = EnumHelper.addToolMaterial("witherKnockerToolMaterial2", 0,
			41, 0.0F, -4.0F, 0);
	public static ToolMaterial witherKnockerToolMaterial3 = EnumHelper.addToolMaterial("witherKnockerToolMaterial3", 0,
			61, 0.0F, -4.0F, 0);

	public static ArmorMaterial platinumArmorMaterial = EnumHelper.addArmorMaterial("platinumArmorMaterial", 66,
			new int[] { 3, 7, 6, 3 }, 20);
	public static ArmorMaterial ardiumArmorMaterial = EnumHelper.addArmorMaterial("ardiumArmorMaterial", 132,
			new int[] { 4, 7, 5, 6 }, 25);
	public static ArmorMaterial oxiumArmorMaterial = EnumHelper.addArmorMaterial("oxiumArmorMaterial", 264,
			new int[] { 4, 7, 5, 6 }, 35);

	public static Item ardium_arrow;
	public static Item ardium_ingot;
	public static Item ardium_sword;
	public static Item ardium_bow;
	public static Item ardium_shovel;
	public static Item ardium_pickaxe;
	public static Item ardium_axe;
	public static Item ardium_hoe;
	public static Item ardium_multitools;
	public static Item ardium_battle_axe;
	public static Item ardium_helmet;
	public static Item ardium_chestplate;
	public static Item ardium_leggings;
	public static Item ardium_boots;

	public static Item platinum_ingot;
	public static Item platinum_sword;
	public static Item platinum_shovel;
	public static Item platinum_pickaxe;
	public static Item platinum_axe;
	public static Item platinum_hoe;
	public static Item platinum_multitools;
	public static Item platinum_helmet;
	public static Item platinum_chestplate;
	public static Item platinum_leggings;
	public static Item platinum_boots;

	public static Item oxium_sword;
	public static Item oxium_shovel;
	public static Item oxium_pickaxe;
	public static Item oxium_axe;
	public static Item oxium_multitools;
	public static Item oxium_helmet;
	public static Item oxium_chestplate;
	public static Item oxium_leggings;
	public static Item oxium_boots;

	public static Item backpack;
	public static Item dynamite;
	public static Item sticky_dynamite;
	public static Item ardium_string;
	public static Item sticky_string;
	// public static Item item_door_platinum;

	public static Item wither_knocker_1;
	public static Item wither_knocker_2;
	public static Item wither_knocker_3;

	public static void init() {
		// Ardium Item
		ardium_ingot = new ItemIngotArdium();
		// Ardium Tools
		ardium_sword = new ItemSwordArdium(ardiumToolMaterial);
		ardium_bow = new ItemBowArdium();
		ardium_pickaxe = new ItemPickaxeArdium(ardiumToolMaterial);
		ardium_shovel = new ItemShovelArdium(ardiumToolMaterial);
		ardium_axe = new ItemAxeArdium(ardiumToolMaterial);
		ardium_hoe = new ItemHoeArdium(ardiumToolMaterial);
		ardium_multitools = new ItemMultiToolsArdium(ardiumToolMaterial);

		// Ardium Armor
		ardium_helmet = new ItemArmorArdium(ardiumArmorMaterial, 0).setCreativeTab(Ardium.tabArdium)
				.setUnlocalizedName("ardium_helmet").setTextureName(References.MOD_ID + ":ardium_helmet");
		ardium_chestplate = new ItemArmorArdium(ardiumArmorMaterial, 1).setCreativeTab(Ardium.tabArdium)
				.setUnlocalizedName("ardium_chestplate").setTextureName(References.MOD_ID + ":ardium_chestplate");
		ardium_leggings = new ItemArmorArdium(ardiumArmorMaterial, 2).setCreativeTab(Ardium.tabArdium)
				.setUnlocalizedName("ardium_leggings").setTextureName(References.MOD_ID + ":ardium_leggings");
		ardium_boots = new ItemArmorArdium(ardiumArmorMaterial, 3).setCreativeTab(Ardium.tabArdium)
				.setUnlocalizedName("ardium_boots").setTextureName(References.MOD_ID + ":ardium_boots");

		// Platinum Ingot
		platinum_ingot = new ItemIngotPlatinum();
		// Platinum Tools
		platinum_sword = new ItemSwordPlatinum(platinumToolMaterial);
		platinum_pickaxe = new ItemPickaxePlatinum(platinumToolMaterial);
		platinum_shovel = new ItemShovelPlatinum(platinumToolMaterial);
		platinum_axe = new ItemAxePlatinum(platinumToolMaterial);
		platinum_hoe = new ItemHoePlatinum(platinumToolMaterial);
		platinum_multitools = new ItemMultiToolsPlatinum(platinumToolMaterial);

		// Platinum Armor
		platinum_helmet = new ItemArmorPlatinum(platinumArmorMaterial, 0).setCreativeTab(Ardium.tabArdium)
				.setUnlocalizedName("platinum_helmet").setTextureName(References.MOD_ID + ":platinum_helmet");
		platinum_chestplate = new ItemArmorPlatinum(platinumArmorMaterial, 1).setCreativeTab(Ardium.tabArdium)
				.setUnlocalizedName("platinum_chestplate").setTextureName(References.MOD_ID + ":platinum_chestplate");
		platinum_leggings = new ItemArmorPlatinum(platinumArmorMaterial, 2).setCreativeTab(Ardium.tabArdium)
				.setUnlocalizedName("platinum_leggings").setTextureName(References.MOD_ID + ":platinum_leggings");
		platinum_boots = new ItemArmorPlatinum(platinumArmorMaterial, 3).setCreativeTab(Ardium.tabArdium)
				.setUnlocalizedName("platinum_boots").setTextureName(References.MOD_ID + ":platinum_boots");

		// Oxium Tools
		oxium_sword = new ItemSwordOxium(oxiumToolMaterial);
		oxium_pickaxe = new ItemPickaxeOxium(oxiumToolMaterial);
		oxium_shovel = new ItemShovelOxium(oxiumToolMaterial);
		oxium_axe = new ItemAxeOxium(oxiumToolMaterial);
		oxium_multitools = new ItemMultiToolsOxium(oxiumToolMaterial);

		// Oxium Armor
		oxium_helmet = new ItemArmorOxium(oxiumArmorMaterial, 0).setCreativeTab(Ardium.tabArdium)
				.setUnlocalizedName("oxium_helmet").setTextureName(References.MOD_ID + ":oxium_helmet");
		oxium_chestplate = new ItemArmorOxium(oxiumArmorMaterial, 1).setCreativeTab(Ardium.tabArdium)
				.setUnlocalizedName("oxium_chestplate").setTextureName(References.MOD_ID + ":oxium_chestplate");
		oxium_leggings = new ItemArmorOxium(oxiumArmorMaterial, 2).setCreativeTab(Ardium.tabArdium)
				.setUnlocalizedName("oxium_leggings").setTextureName(References.MOD_ID + ":oxium_leggings");
		oxium_boots = new ItemArmorOxium(oxiumArmorMaterial, 3).setCreativeTab(Ardium.tabArdium)
				.setUnlocalizedName("oxium_boots").setTextureName(References.MOD_ID + ":oxium_boots");

		// Knockers
		wither_knocker_1 = new ItemWitherKnocker1(witherKnockerToolMaterial1);
		wither_knocker_2 = new ItemWitherKnocker2(witherKnockerToolMaterial2);
		wither_knocker_3 = new ItemWitherKnocker3(witherKnockerToolMaterial3);

		// Items
		backpack = new ItemBackpack();

		dynamite = new ItemDynamite("Dynamite");
		sticky_dynamite = new ItemStickyDynamite("Sticky_Dynamite");

		ardium_string = new Item().setCreativeTab(Ardium.tabArdium).setUnlocalizedName("ardium_string")
				.setTextureName(References.MOD_ID + ":ardium_string");
		sticky_string = new Item().setCreativeTab(Ardium.tabArdium).setUnlocalizedName("sticky_string")
				.setTextureName(References.MOD_ID + ":sticky_string");
	}

	public static void register() {
		itemsRegister(ardium_ingot);

		itemsRegister(ardium_sword);
		itemsRegister(ardium_bow);
		itemsRegister(ardium_shovel);
		itemsRegister(ardium_pickaxe);
		itemsRegister(ardium_axe);
		itemsRegister(ardium_hoe);
		itemsRegister(ardium_multitools);
		itemsRegister(ardium_battle_axe);

		itemsRegister(ardium_helmet);
		itemsRegister(ardium_chestplate);
		itemsRegister(ardium_leggings);
		itemsRegister(ardium_boots);

		itemsRegister(backpack);
		itemsRegister(dynamite);
		itemsRegister(sticky_dynamite);
		itemsRegister(ardium_string);
		itemsRegister(sticky_string);

		itemsRegister(platinum_ingot);
		itemsRegister(platinum_sword);
		itemsRegister(platinum_shovel);
		itemsRegister(platinum_pickaxe);
		itemsRegister(platinum_hoe);
		itemsRegister(platinum_axe);
		itemsRegister(platinum_multitools);

		itemsRegister(platinum_helmet);
		itemsRegister(platinum_chestplate);
		itemsRegister(platinum_leggings);
		itemsRegister(platinum_boots);

		itemsRegister(oxium_sword);
		itemsRegister(oxium_shovel);
		itemsRegister(oxium_pickaxe);
		itemsRegister(oxium_axe);
		itemsRegister(oxium_multitools);

		itemsRegister(oxium_helmet);
		itemsRegister(oxium_chestplate);
		itemsRegister(oxium_leggings);
		itemsRegister(oxium_boots);

		itemsRegister(wither_knocker_1);
		itemsRegister(wither_knocker_2);
		itemsRegister(wither_knocker_3);
	}
	
	protected static void itemsRegister(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}
}