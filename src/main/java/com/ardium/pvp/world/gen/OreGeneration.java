package com.ardium.pvp.world.gen;

import java.util.Random;

import com.ardium.pvp.init.BlocksRegistry;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class OreGeneration implements IWorldGenerator {

	private int maxVeinSize;

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case 1:
			generateEnd(world, random, chunkX, chunkZ);
			break;
		case 0:
			generateOverWorld(world, random, chunkX, chunkZ);
			break;
		case -1:
			generateNether(world, random, chunkX, chunkZ);
			break;
		default:
			generateOverWorld(world, random, chunkX, chunkZ);
			break;
		}
	}

	public void generateEnd(World world, Random rand, int x, int z) {
	}

	public void generateOverWorld(World world, Random random, int x, int z) {
		generateOre(BlocksRegistry.platinum_ore, world, random, x, z, 1, 8, 7, 4, 20, Blocks.stone);
		generateOre(BlocksRegistry.ardium_ore, world, random, x, z, 1, 4, 6, 4, 20, Blocks.stone);
	}

	public void generateNether(World world, Random rand, int x, int z) {
	}

	public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVienSize,
			int maxVienSize, int spawnChance, int minY, int maxY, Block generateIn) {
		int vienSize = minVienSize + random.nextInt(maxVienSize - minVienSize);
		int heightRange = maxY - minY;
		WorldGenMinable gen = new WorldGenMinable(block, vienSize, generateIn);
		for (int i = 0; i < spawnChance; i++) {
			int xRand = chunkX * 16 + random.nextInt(16);
			int yRand = random.nextInt(heightRange) + minY;
			int zRand = chunkZ * 16 + random.nextInt(16);
			gen.generate(world, random, xRand, yRand, zRand);
		}
	}

	public int getMaxVeinSize() {
		return maxVeinSize;
	}

	public void setMaxVeinSize(int maxVeinSize) {
		this.maxVeinSize = maxVeinSize;
	}

	public static void registerWorldGen() {
		GameRegistry.registerWorldGenerator(new OreGeneration(), 0);
	}
}