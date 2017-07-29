package com.ardium.pvp.items.tools.oxium;

import java.util.Set;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;
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

public class ItemMultiToolsOxium extends ItemPickaxe {

	public ItemMultiToolsOxium(ToolMaterial oxiumToolMaterial) {
		super(oxiumToolMaterial);
		this.setCreativeTab(Ardium.tabArdium);
		this.setFull3D();
		this.setNoRepair();
		this.setTextureName(References.MOD_ID + ":oxium_multitools");
		this.setUnlocalizedName("oxium_multitools");
	}

	private Set<Block> effectiveAgainst = Sets.newHashSet(new Block[] { Blocks.acacia_stairs, Blocks.birch_stairs,
			Blocks.bookshelf, Blocks.brown_mushroom, Blocks.brown_mushroom_block, Blocks.cactus, Blocks.cake,
			Blocks.carrots, Blocks.cauldron, Blocks.chest, Blocks.clay, Blocks.cocoa, Blocks.crafting_table,
			Blocks.dark_oak_stairs, Blocks.daylight_detector, Blocks.deadbush, Blocks.detector_rail, Blocks.dirt,
			Blocks.double_plant, Blocks.double_stone_slab, Blocks.double_wooden_slab, Blocks.dragon_egg,
			Blocks.farmland, Blocks.fence, Blocks.fence_gate, Blocks.fire, Blocks.flower_pot, Blocks.glass,
			Blocks.glass_pane, Blocks.glowstone, Blocks.golden_rail, Blocks.grass, Blocks.gravel, Blocks.hardened_clay,
			Blocks.hay_block, Blocks.jukebox, Blocks.jungle_stairs, Blocks.ladder, Blocks.leaves, Blocks.leaves2,
			Blocks.lever, Blocks.light_weighted_pressure_plate, Blocks.lit_pumpkin, Blocks.lit_pumpkin,
			Blocks.lit_redstone_lamp, Blocks.log, Blocks.log2, Blocks.melon_block, Blocks.melon_stem,
			Blocks.mob_spawner, Blocks.monster_egg, Blocks.mycelium, Blocks.nether_brick_fence,
			Blocks.nether_brick_stairs, Blocks.nether_wart, Blocks.noteblock, Blocks.oak_stairs, Blocks.piston,
			Blocks.piston_extension, Blocks.piston_head, Blocks.planks, Blocks.potatoes, Blocks.pumpkin,
			Blocks.pumpkin_stem, Blocks.red_flower, Blocks.red_mushroom, Blocks.red_mushroom_block,
			Blocks.redstone_lamp, Blocks.redstone_torch, Blocks.redstone_wire, Blocks.reeds, Blocks.sand,
			Blocks.sapling, Blocks.skull, Blocks.snow, Blocks.snow_layer, Blocks.soul_sand, Blocks.sponge,
			Blocks.spruce_stairs, Blocks.stained_glass, Blocks.stained_glass_pane, Blocks.standing_sign,
			Blocks.sticky_piston, Blocks.tallgrass, Blocks.tnt, Blocks.torch, Blocks.trapdoor, Blocks.trapped_chest,
			Blocks.tripwire, Blocks.tripwire_hook, Blocks.unlit_redstone_torch, Blocks.vine, Blocks.wall_sign,
			Blocks.waterlily, Blocks.web, Blocks.wheat, Blocks.wooden_button, Blocks.wooden_door, Blocks.wooden_slab,
			Blocks.wool });

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