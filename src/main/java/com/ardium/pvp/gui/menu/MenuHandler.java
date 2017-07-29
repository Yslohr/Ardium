package com.ardium.pvp.gui.menu;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;

public class MenuHandler
{
    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority=EventPriority.HIGHEST)
    public void openGuiEvent(GuiOpenEvent v1)
    {
      if ((v1.gui instanceof GuiMainMenu)) 
      {
        v1.gui = new ArdiumMainMenu();
      }
   }
   
   @SubscribeEvent
   public void removeVanillaButtons(InitGuiEvent.Post event)
   {
       if (event.gui instanceof GuiMainMenu)
      {           for (Object b : event.buttonList) 
        {
              if (((GuiButton) b).id == 14)
              {
                  ((GuiButton) b).visible = false;
              }
              else if (((GuiButton) b).id == 1)
              {
                  ((GuiButton) b).visible = false;
              }
              else if (((GuiButton) b).id == 2)
              {
                  ((GuiButton) b).visible = false;
              }
              else if (((GuiButton) b).id == 3)
              {
                  ((GuiButton) b).visible = false;
              }
              else if (((GuiButton) b).id == 4)
              {
                  ((GuiButton) b).visible = false;
              }
              else if (((GuiButton) b).id == 5)
              {
                  ((GuiButton) b).visible = false;
              }
              else if (((GuiButton) b).id == 6)
              {
                  ((GuiButton) b).visible = false;
              }
       }
     }
   }
}
