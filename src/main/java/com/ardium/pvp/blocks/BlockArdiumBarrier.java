package com.ardium.pvp.blocks;

import com.ardium.pvp.Ardium;
import com.ardium.pvp.References;
import com.ardium.pvp.init.BlocksRegistry;

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
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockArdiumBarrier extends Block {
	private IIcon creativeIcon;

	public BlockArdiumBarrier(Material blockBedrockInvisible, int harvestLevel) {
		super(blockBedrockInvisible);
		setBlockName("ardium_barrier");
		setBlockTextureName(References.MOD_ID + ":ardium_barrier");
		setBlockUnbreakable();
		setCreativeTab(Ardium.tabArdium);
		setHarvestLevel("pickaxe", harvestLevel);
		setLightOpacity(100);
		setStepSound(Block.soundTypeStone);
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
				|| entity instanceof EntityCreeper || entity instanceof EntityGhast) {
			return this != BlocksRegistry.ardium_barrier;
		}
		return false;
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

	public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_,
			int p_149646_5_) {
		return false;
	}

}