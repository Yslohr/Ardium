package com.ardium.pvp.inventory;

import com.ardium.pvp.items.ItemBackpack;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * @author SCAREX
 * 
 */
public class SlotBackpack extends Slot {
	public SlotBackpack(IInventory inv, int index, int x, int y) {
		super(inv, index, x, y);
	}

	/**
	 * Method used to prevent backpack-ception (backpacks inside backpacks)
	 */
	@Override
	public boolean isItemValid(ItemStack stack) {
		return !(stack.getItem() instanceof ItemBackpack)
				|| !(stack.getItem().getUnlocalizedName().toLowerCase().contains("backpack"))
				|| !(stack.getItem().getUnlocalizedName().toLowerCase().contains("back pack"))
				|| !(stack.getItem().getUnlocalizedName().toLowerCase().contains("bag"));
	}
}