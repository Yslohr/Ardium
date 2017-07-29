package com.ardium.pvp.items.tools.witherknockers;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemWitherKnocker3 extends ItemSword {

	public ItemWitherKnocker3(ToolMaterial witherToolMaterial3) {
		super(witherToolMaterial3);
		
		this.setCreativeTab(Ardium.tabArdium);
		this.setTextureName(References.MOD_ID + ":wither_knocker_3");
		this.setUnlocalizedName("wither_knocker_3");
	}
	public void onUpdate(ItemStack stack, World world, Entity player, int p_776634, boolean p_776635)
	  {
	    if (!stack.isItemEnchanted()) {
	      stack.addEnchantment(Enchantment.knockback, 10);
	    }
	  }
	public void onCreated(ItemStack stack, World world, EntityPlayer player)
	  {
	    stack.addEnchantment(Enchantment.knockback, 10);

	    super.onCreated(stack, world, player);
	  }
	public boolean isBookEnchantable(ItemStack stack, ItemStack book)
	  {
	    return false;
	  }
}
