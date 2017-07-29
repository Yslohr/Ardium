package com.ardium.pvp.gui.handlers;

import com.ardium.pvp.gui.GuiBackpack;
import com.ardium.pvp.gui.containers.ContainerBackpack;
import com.ardium.pvp.inventory.InventoryBackpack;
import com.ardium.pvp.items.ItemBackpack;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * @author SCAREX
 * 
 */
public class BackpackGUIHandler implements IGuiHandler {
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case 0:
			// The last parameter must be a multiple of 9 (e.g: 9, 18, 27, 54)
			// Condition to check if the player has the right item in hand
			if (player.getHeldItem() == null || !(player.getHeldItem().getItem() instanceof ItemBackpack))
				return null;
			return new ContainerBackpack(player.inventory, new InventoryBackpack(player.getHeldItem(), 54));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case 0:
			// The last parameter must be a multiple of 9 (e.g: 9, 18, 27, 54)
			// Condition to check if the player has the right item in hand
			if (player.getHeldItem() == null || !(player.getHeldItem().getItem() instanceof ItemBackpack))
				return null;
			return new GuiBackpack(player.inventory, new InventoryBackpack(player.getHeldItem(), 54));
		}
		return null;
	}
}