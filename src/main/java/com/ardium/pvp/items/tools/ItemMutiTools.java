package com.ardium.pvp.items.tools;

import java.util.Set;

import com.ardium.pvp.init.ItemsRegister;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import cpw.mods.fml.common.eventhandler.Event.Result;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class ItemMutiTools extends ItemPickaxe {
	public ItemMutiTools(ToolMaterial toolMaterial) {
		super(toolMaterial);
	}

	private Set<Block> effectiveAgainst = Sets.newHashSet(Block.blockRegistry);

	@Override
	public Set<String> getToolClasses(ItemStack stack) {
		return ImmutableSet.of("pickaxe", "spade", "axe", "hoe");
	}

	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack) {
		return effectiveAgainst.contains(block) ? true : super.canHarvestBlock(block, stack);
	}

	@Override
	public float func_150893_a(ItemStack stack, Block block) {
		return (effectiveAgainst.contains(block) ? this.efficiencyOnProperMaterial : super.func_150893_a(stack, block));
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int p_77648_4_, int p_77648_5_,
			int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
		if (!player.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, stack)) {
			return false;
		} else {
			UseHoeEvent event = new UseHoeEvent(player, stack, world, p_77648_4_, p_77648_5_, p_77648_6_);
			if (MinecraftForge.EVENT_BUS.post(event)) {
				return false;
			}
			if (event.getResult() == Result.ALLOW) {
				stack.damageItem(1, player);
				return true;
			}
			Block block = world.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);

			if (p_77648_7_ != 0 && world.getBlock(p_77648_4_, p_77648_5_ + 1, p_77648_6_).isAir(world, p_77648_4_,
					p_77648_5_ + 1, p_77648_6_) && (block == Blocks.grass || block == Blocks.dirt)) {
				Block block1 = Blocks.farmland;
				world.playSoundEffect((double) ((float) p_77648_4_ + 0.5F), (double) ((float) p_77648_5_ + 0.5F),
						(double) ((float) p_77648_6_ + 0.5F), block1.stepSound.getStepResourcePath(),
						(block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);
				if (world.isRemote) {
					return true;
				} else {
					world.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, block1);
					stack.damageItem(1, player);
					return true;
				}
			} else {
				return false;
			}
		}
	}
}