package com.ardium.pvp.items;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;
import com.ardium.pvp.entities.projectiles.EntityDynamite;
import com.ardium.pvp.entities.projectiles.EntityStickyDynamite;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDynamite extends Item {
	public ItemDynamite(String id) {
		this.setCreativeTab(Ardium.tabArdium);
		this.setTextureName(References.MOD_ID + ":dynamite");
		this.setUnlocalizedName("dynamite");
		this.maxStackSize = 64;
	}

	public int getItemEnchantability() {
		return 0;
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		if (entityplayer.inventory.consumeInventoryItem(this)) {
			world.playSoundAtEntity(entityplayer, "game.tnt.primed", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isRemote) {
				world.spawnEntityInWorld(new EntityDynamite(world, entityplayer, 40 + itemRand.nextInt(10)));
			}
		}
		return itemstack;
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldRotateAroundWhenRendering() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}
}
