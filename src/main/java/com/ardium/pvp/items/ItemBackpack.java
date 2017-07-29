package com.ardium.pvp.items;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBackpack extends Item {
	public static final String NAME = "backpack";

	public ItemBackpack() {
		this.setCreativeTab(Ardium.tabArdium);
		this.setMaxStackSize(1);
		this.setUnlocalizedName(NAME);
		this.setTextureName(References.MOD_ID + ":" + NAME);
	}
	
	/**
	 * Used to open the gui
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		player.openGui(Ardium.instance, 0, world, (int) player.posX, (int) player.posY, (int) player.posZ);
		return stack;
	}
}