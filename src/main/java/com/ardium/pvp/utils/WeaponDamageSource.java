package com.ardium.pvp.utils;

import com.ardium.pvp.entities.projectiles.EntityProjectile;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.ResourceLocation;

public class WeaponDamageSource extends EntityDamageSourceIndirect 
{
	private EntityProjectile projectileEntity;
	private Entity shooterEntity;

	public WeaponDamageSource(String s, EntityProjectile projectile, Entity entity) 
	{
		super(s, projectile, entity);
		this.projectileEntity = projectile;
		this.shooterEntity = entity;
	}

	public Entity getProjectile() 
	{
		return this.projectileEntity;
	}

	public Entity getEntity() 
	{
		return this.shooterEntity;
	}

	public static DamageSource causeProjectileWeaponDamage(EntityProjectile projectile, Entity entity) 
	{
		return new WeaponDamageSource("weapon", projectile, entity).setProjectile();
	}

	public static abstract class Textures 
	{
		public static final ResourceLocation DYNAMITE = new ResourceLocation("ardium", "textures/entity/dynamite.png");
		
		public static final ResourceLocation STICKY_DYNAMITE = new ResourceLocation("ardium", "textures/entity/sticky_dynamite.png");
	}
}