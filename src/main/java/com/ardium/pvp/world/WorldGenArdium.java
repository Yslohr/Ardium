package com.ardium.pvp.world;

import com.ardium.pvp.init.BlocksRegister;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class WorldGenArdium implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.dimensionId)
        {
            case -1:
              GenerateNether(world, chunkX * 16, chunkZ * 16, random);
            case 0:
              GenerateOverWorld(world, random, chunkX * 16, chunkZ * 16);
              break;
            case 1:
              GenerateEnd(world, chunkX * 16, chunkZ * 16, random);
        }
    }
    
    private void addOre(Block block, Block blockSpawn, Random random, World world, int posX, int posZ, int minY, int maxY, int minV, int maxV, int spawnChance)
    {
        for (int i = 0; i < spawnChance; i++)
        {
          int chunkSize = 16;
          int Xpos = posX + random.nextInt(chunkSize);
          int Ypos = minY + random.nextInt(maxY - minY);
          int Zpos = posZ + random.nextInt(chunkSize);
         
          new WorldGenMinable(block, maxV, blockSpawn).generate(world, random, Xpos, Ypos, Zpos);
        }
    }
 
    private void GenerateEnd(World world, int i, int j, Random random){}
 
    private void GenerateOverWorld(World world, Random random, int i, int j)
    {
        addOre(BlocksRegister.ardium_ore, Blocks.stone, random, world, i, j, 5, 8, 2, 4, 1);
    }
 
    private void GenerateNether(World world, int i, int j, Random random){}
}
