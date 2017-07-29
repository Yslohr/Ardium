package com.ardium.pvp.blocks.slabs;

import java.util.List;
import java.util.Random;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.init.BlocksRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSlabObsidian extends BlockSlab {

	public static final String[] StepTypes = new String[] { "obsidian" };

	public BlockSlabObsidian(boolean isDoubleSlab) {
		super(isDoubleSlab, Material.rock);
		this.useNeighborBrightness = true;
		this.setBlockName("obsidian_slab");
		this.setBlockTextureName("minecraft:obsidian");
		this.setHarvestLevel("pickaxe", 3);
		this.setResistance(1000.0F);
		this.setStepSound(soundTypePiston);
		this.setLightOpacity(0);

		if (!isDoubleSlab) {
			this.setLightOpacity(0);
		}
	}

	@Override
	public int getMobilityFlag() {
		return 2;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		if (item == item.getItemFromBlock(BlocksRegistry.obsidian_slab_single)) {
			list.add(new ItemStack(item, 1, 0));
		}
	}

	@SideOnly(Side.CLIENT)
	private static boolean isBlockSingleSlab(Block block) {
		return block == BlocksRegistry.obsidian_slab_single;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return isBlockSingleSlab(this) ? Item.getItemFromBlock(this)
				: (this == BlocksRegistry.obsidian_slab_double)
						? Item.getItemFromBlock(BlocksRegistry.obsidian_slab_single)
						: Item.getItemFromBlock(BlocksRegistry.obsidian_slab_single);
	}

	public Item getItemDropped(int metadatas, Random random, int fortune) {
		return Item.getItemFromBlock(BlocksRegistry.obsidian_slab_single);
	}

	protected ItemStack createdStackedBlock(int par1) {
		return new ItemStack(BlocksRegistry.obsidian_slab_single, 2, 0);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		this.blockIcon = icon.registerIcon("minecraft:obsidian");
	}

	public IIcon getIcon(int par1, int par2) {
		int par3 = par2 & 7;
		if (this.field_150004_a && (par2 & 2) != 0) {
			par1 = 1;
		}
		return par1 == 1 ? this.blockIcon : (par1 == 0 ? this.blockIcon : this.blockIcon);
	}

	@Override
	public String func_150002_b(int par1) {
		return this.getUnlocalizedName();
	}
	
	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
		if (entity instanceof EntityDragon) {
			return this != BlocksRegistry.obsidian_slab_single || this != BlocksRegistry.obsidian_slab_double;
		}
		return true;
	}
}