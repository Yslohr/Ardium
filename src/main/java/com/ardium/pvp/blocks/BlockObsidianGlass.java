package com.ardium.pvp.blocks;

import java.util.Random;

import com.ardium.pvp.References;
import com.ardium.pvp.Ardium;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockObsidianGlass extends Block {
	public BlockObsidianGlass(int harvestLevel) {
		super(Material.piston);
		this.setBlockName("obsidian_glass");
		this.setBlockTextureName(References.MOD_ID + ":obsidian_glass");
		this.setCreativeTab(Ardium.tabArdium);
		this.setHarvestLevel("pickaxe", harvestLevel);
		this.setHardness(50.0F);
		this.setResistance(2000.0F);
		this.setStepSound(soundTypeGlass);
	}

	@Override
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
		return true;
	}

	/**
	 * Return true if a player with Silk Touch can harvest this block directly,
	 * and not its normal drops.
	 */
	protected boolean canSilkHarvest() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 0;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	public int quantityDropped(Random random) {
		return 0;
	}
}