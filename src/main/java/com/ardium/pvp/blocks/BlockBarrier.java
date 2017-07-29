package com.ardium.pvp.blocks;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.utils.References;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityExplodeFX;
import net.minecraft.client.particle.EntityHugeExplodeFX;
import net.minecraft.client.particle.EntityLargeExplodeFX;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockBarrier extends Block {
	private IIcon creativeIcon;

	public BlockBarrier(Material material, int harvestLevel) {
		super(material);
		setBlockName("barrier_block");
		setBlockTextureName(References.MOD_ID + ":barrier_block");
		setBlockUnbreakable();
		setCreativeTab(Ardium.ardiumTab);
		setHarvestLevel("pickaxe", harvestLevel);
		setLightOpacity(100);
	}

	@Override
	public boolean canDropFromExplosion(Explosion explosion) {
		return false;
	}

	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
		if (entity instanceof EntityDragon || entity instanceof EntityDragonPart || entity instanceof EntityWither
				|| entity instanceof EntityWitherSkull || entity instanceof EntityHugeExplodeFX
				|| entity instanceof EntityLargeExplodeFX || entity instanceof EntityExplodeFX
				|| entity instanceof EntityCreeper || entity instanceof EntityGhast
				|| entity instanceof EntityEnderman) {
			return false;
		}
		return true;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 0;
	}

	public int getRenderType() {
		return super.getRenderType();
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
		return false;
	}

	public void registerBlockIcons(IIconRegister icon) {
		this.creativeIcon = icon.registerIcon(References.MOD_ID + ":barrier");
		super.registerBlockIcons(icon);
	}

	public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int x, int y, int z, int side) {
		return false;
	}

}