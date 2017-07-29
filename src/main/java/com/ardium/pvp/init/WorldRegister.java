package com.ardium.pvp.init;

import com.ardium.pvp.utils.LogHelper;
import com.ardium.pvp.world.WorldGenArdium;
import cpw.mods.fml.common.registry.GameRegistry;

public class WorldRegister
{
    public static void MainRegistry()
    {
        registerWorldGen(new WorldGenArdium(), -1);
        registerWorldGen(new WorldGenArdium(), 0);
        registerWorldGen(new WorldGenArdium(), 1);
        LogHelper.info("World Generation Initialization Completed Sucessfully !");
    }

    private static void registerWorldGen(WorldGenArdium worldGenArdium, int i) 
    {
        GameRegistry.registerWorldGenerator(worldGenArdium, i);
    }
}
