package com.ardium.pvp.utils;

import java.util.Random;

import com.ardium.pvp.entities.projectiles.EntityDynamite;
import com.ardium.pvp.entities.projectiles.EntityStickyDynamite;
import com.ardium.pvp.items.ItemStickyDynamite;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public abstract class DispenseProjectile extends BehaviorProjectileDispense
{
  protected Random rand;
  
  public DispenseProjectile()
  {
    this.rand = new Random();
  }
  
  public ItemStack dispenseStack(IBlockSource blocksource, ItemStack itemstack)
  {
    World world = blocksource.getWorld();
    IPosition pos = BlockDispenser.func_149939_a(blocksource);
    EnumFacing face = BlockDispenser.func_149937_b(blocksource.getBlockMetadata());
    IProjectile projectile = getProjectileEntity(world, pos, itemstack);
    projectile.setThrowableHeading(face.getFrontOffsetX(), face.getFrontOffsetY() + getYVel(), face.getFrontOffsetZ(), getVelocity(), getDeviation());
    world.spawnEntityInWorld((Entity)projectile);
    itemstack.splitStack(1);
    return itemstack;
  }
  
  protected IProjectile getProjectileEntity(World world, IPosition pos, ItemStack itemstack)
  {
    return getProjectileEntity(world, pos);
  }
  
  public double getYVel()
  {
    return 0.1D;
  }
  
  public float getVelocity()
  {
    return func_82500_b();
  }
  
  public float getDeviation()
  {
    return func_82498_a();
  }
  
  protected void playDispenseSound(IBlockSource blocksource)
  {
    super.playDispenseSound(blocksource);
    blocksource.getWorld().playSoundEffect(blocksource.getX(), blocksource.getY(), blocksource.getZ(), "random.fuse", 1.0F, 1.2F);
  }
  
  protected void spawnDispenseParticles(IBlockSource blocksource, EnumFacing facing)
  {
    super.spawnDispenseParticles(blocksource, facing);
  }
  
  protected IProjectile getProjectileEntity(World world, IPosition pos)
  {
    return new EntityDynamite(world, pos.getX(), pos.getY(), pos.getZ());
  }
  
  protected IProjectile getProjectileEntity1(World world, IPosition pos)
  {
    return new EntityStickyDynamite(world, pos.getX(), pos.getY(), pos.getZ());
  }
}