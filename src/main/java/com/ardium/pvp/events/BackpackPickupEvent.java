package com.ardium.pvp.events;

import com.ardium.pvp.items.ItemBackpack;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class BackpackPickupEvent {
	@SubscribeEvent
	public void onPickUp(EntityItemPickupEvent paramEntityItemPickupEvent) {
		if ((paramEntityItemPickupEvent.item.getEntityItem().getItem() instanceof ItemBackpack)) {
			EntityPlayer localEntityPlayer = paramEntityItemPickupEvent.entityPlayer;
			int i = 0;
			for (int j = 0; j < localEntityPlayer.inventory.getSizeInventory(); j++) {
				ItemStack localItemStack = localEntityPlayer.inventory.getStackInSlot(j);
				if ((localItemStack != null) && ((localItemStack.getItem() instanceof ItemBackpack))) {
					i++;
					if (i >= 1) {
						paramEntityItemPickupEvent.setCanceled(true);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onLiving(LivingEvent.LivingUpdateEvent paramLivingUpdateEvent) {
		if ((paramLivingUpdateEvent.entityLiving instanceof EntityPlayer)) {
			EntityPlayer localEntityPlayer = (EntityPlayer) paramLivingUpdateEvent.entityLiving;
			if (localEntityPlayer.worldObj.getWorldTime() % 100L == 0L) {
				int i = 0;
				for (int j = 0; j < localEntityPlayer.inventory.getSizeInventory(); j++) {
					ItemStack localItemStack = localEntityPlayer.inventory.getStackInSlot(j);
					if ((localItemStack != null) && ((localItemStack.getItem() instanceof ItemBackpack))) {
						i++;
						if (i > 1) {
							localEntityPlayer.inventory.setInventorySlotContents(j, null);
							EntityItem localEntityItem = new EntityItem(localEntityPlayer.worldObj,
									localEntityPlayer.posX, localEntityPlayer.posY, localEntityPlayer.posZ,
									localItemStack);
							if (!localEntityPlayer.worldObj.isRemote) {
								localEntityPlayer.worldObj.spawnEntityInWorld(localEntityItem);
							}
							if (localEntityPlayer.worldObj.isRemote) {
							}
						}
					}
				}
			}
		}
	}
}
