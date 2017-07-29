package com.ardium.pvp;

import com.ardium.pvp.entity.EntityDynamite;
import com.ardium.pvp.init.BlocksRegister;
import com.ardium.pvp.init.ItemsRegister;
import com.ardium.pvp.init.RecipesRegister;
import com.ardium.pvp.init.WorldRegister;
import com.ardium.pvp.proxy.CommonProxy;
import com.ardium.pvp.utils.ArdiumTab;
import com.ardium.pvp.utils.LogHelper;
import com.ardium.pvp.utils.References;
import com.google.common.base.Throwables;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;

import java.io.File;

@Mod(modid = References.MOD_ID, name = References.MOD_NAME, version = References.VERSION)
public class Ardium {
	@Mod.Instance("ardium")
	public static Ardium instance;
	@SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.COMMON_PROXY)
	public static CommonProxy commonProxy;

	public static CreativeTabs ardiumTab = new ArdiumTab("ardiumTab");

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		LogHelper.info("PreInitialization Started");
		
		if (event.getSide().isClient()) {
			if ((!Minecraft.getMinecraft().mcDataDir.getAbsolutePath().contains("ardium7"))
					&& (!Minecraft.getMinecraft().mcDataDir.equals(new File(".")))) {
				Throwables.propagate(new Exception("Mod is locked"));
			}
		}
		
		ItemsRegister.init();
		BlocksRegister.init();
		RecipesRegister.init();
		WorldRegister.MainRegistry();
		
		LogHelper.info("PreInitialization Completed Sucessfully !");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		LogHelper.info("Initialization Started");
		
		LogHelper.info("CommonProxy RendersRegistering Started");
		commonProxy.registerRenders();
		LogHelper.info("CommonProxy RendersRegistering Finished");
		LogHelper.info("OreDictionary List Printing");
		RecipesRegister.printOreDictionaryList();
		LogHelper.info("Initialization Completed Sucessfully !");
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		LogHelper.info("PostInitialization Started");
		EntityRegistry.registerModEntity(EntityDynamite.class, "dynamite", 6, Ardium.instance, 40, 3, true);
		LogHelper.info("Entitys Initialization Completed Sucessfully !");
		LogHelper.info("PostInitialization Completed Sucessfully !");
	}
}
