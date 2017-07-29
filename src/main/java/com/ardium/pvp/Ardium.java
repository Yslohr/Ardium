package com.ardium.pvp;

import com.ardium.pvp.entities.projectiles.EntityDynamite;
import com.ardium.pvp.entities.projectiles.EntityStickyDynamite;
import com.ardium.pvp.events.BackpackPickupEvent;
import com.ardium.pvp.gui.handlers.BackpackGUIHandler;
import com.ardium.pvp.init.BlocksRegistry;
import com.ardium.pvp.init.ItemsRegistry;
import com.ardium.pvp.init.OreDictionaryRegistry;
import com.ardium.pvp.proxy.ClientProxy;
import com.ardium.pvp.proxy.CommonProxy;
import com.ardium.pvp.world.gen.OreGeneration;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = References.MOD_ID, name = References.MOD_NAME, version = References.MOD_VERSION)
public class Ardium 
{
	@Instance(References.MOD_ID)
	public static Ardium instance;
	public Ardium() {instance = this;}
	@SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.COMMON_PROXY, modId = References.MOD_ID)
	public static CommonProxy proxy;
	public static CreativeTabs tabArdium = new TabArdium("tabArdium");

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		ItemsRegistry.init();
		ItemsRegistry.register();
		BlocksRegistry.init();
		BlocksRegistry.register();
		OreDictionaryRegistry.register();
		OreDictionaryRegistry.crafting();
		OreGeneration.registerWorldGen();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerRenders();
		NetworkRegistry.INSTANCE.registerGuiHandler(Ardium.instance, new BackpackGUIHandler());
		MinecraftForge.EVENT_BUS.register(new BackpackPickupEvent());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		BlocksRegistry.postRegister();
		EntityRegistry.registerModEntity(EntityDynamite.class, "Dynamite", 6, Ardium.instance, 40, 3, true);
		EntityRegistry.registerModEntity(EntityStickyDynamite.class, "Sticky_Dynamite", 8, Ardium.instance, 60, 4, true);
	}
}