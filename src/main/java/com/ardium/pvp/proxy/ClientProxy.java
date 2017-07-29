package com.ardium.pvp.proxy;

import org.apache.logging.log4j.Logger;

import com.ardium.pvp.entities.projectiles.EntityDynamite;
import com.ardium.pvp.entities.projectiles.EntityStickyDynamite;
import com.ardium.pvp.gui.screens.MainMenuArdium;
import com.ardium.pvp.items.dynamite.RenderDynamite;
import com.ardium.pvp.items.dynamite.RenderStickyDynamite;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.common.MinecraftForge;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy 
{
	public static ClientProxy instance;
	public static Logger logger;
	private World world;

	public ClientProxy() 
	{
		instance = this;
		MinecraftForge.EVENT_BUS.register(this);
		RenderingRegistry.registerEntityRenderingHandler(EntityDynamite.class, new RenderDynamite());
		RenderingRegistry.registerEntityRenderingHandler(EntityStickyDynamite.class, new RenderStickyDynamite());
	}

	@Override
	public void registerRenders() 
	{

	}

	@SubscribeEvent
	public void removeVanillaButtons(InitGuiEvent.Post event) {
		if (event.gui instanceof GuiMainMenu) {
			for (Object b : event.buttonList) {
				if (((GuiButton) b).id == 14) {
					((GuiButton) b).visible = false;
				} else if (((GuiButton) b).id == 1) {
					((GuiButton) b).visible = false;
				} else if (((GuiButton) b).id == 2) {
					((GuiButton) b).visible = false;
				} else if (((GuiButton) b).id == 3) {
					((GuiButton) b).visible = false;
				} else if (((GuiButton) b).id == 4) {
					((GuiButton) b).visible = false;
				} else if (((GuiButton) b).id == 5) {
					((GuiButton) b).visible = false;
				} else if (((GuiButton) b).id == 6) {
					((GuiButton) b).visible = false;
				}

				int par1 = event.gui.height / 4 + 18;
				int par2 = 24;

			}
		}
	}
	
	 @SideOnly(Side.CLIENT)
	  @SubscribeEvent(priority=EventPriority.HIGHEST)
	  public void openGuiEvent(GuiOpenEvent v1)
	  {
	    if ((v1.gui instanceof net.minecraft.client.gui.GuiMainMenu)) 
	    {
	      v1.gui = new MainMenuArdium();
	    }
    }
}