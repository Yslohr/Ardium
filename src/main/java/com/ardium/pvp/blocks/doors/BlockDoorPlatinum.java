package com.ardium.pvp.blocks.doors;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockDoorPlatinum extends BlockDoor {
	private static final String[] DOORS_TEXTURES_NAMES = { "door" };
	@SideOnly(Side.CLIENT)
	private IIcon[] topIcon;
	@SideOnly(Side.CLIENT)
	private IIcon[] lowerIcon;

	public BlockDoorPlatinum(Material platinum) {
		super(Material.iron);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int x, int y) {
		return this.lowerIcon[0];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		this.topIcon = new IIcon[2];
		this.lowerIcon = new IIcon[2];
		this.topIcon[0] = p_149651_1_.registerIcon(this.getTextureName() + "_upper");
		this.lowerIcon[0] = p_149651_1_.registerIcon(this.getTextureName() + "_lower");
		this.topIcon[1] = new IconFlipped(this.topIcon[0], true, false);
		this.lowerIcon[1] = new IconFlipped(this.lowerIcon[0], true, false);
	}
}
