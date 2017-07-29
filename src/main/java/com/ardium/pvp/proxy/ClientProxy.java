package com.ardium.pvp.proxy;

import com.ardium.pvp.entity.EntityDynamite;
import com.ardium.pvp.gui.menu.MenuHandler;
import com.ardium.pvp.render.RenderDynamite;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerRenders()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityDynamite.class, new RenderDynamite());
        
        MinecraftForge.EVENT_BUS.register(new MenuHandler());
    }
}
