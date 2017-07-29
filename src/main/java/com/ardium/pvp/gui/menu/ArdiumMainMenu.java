package com.ardium.pvp.gui.menu;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.resources.I18n;
import net.minecraft.realms.RealmsBridge;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.demo.DemoWorldServer;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.WorldInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

import java.io.BufferedReader;
import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class ArdiumMainMenu extends GuiScreen implements GuiYesNoCallback
{
    private static final Logger logger = LogManager.getLogger();
    private static final Random rand = new Random();
    private float updateCounter;
    public static boolean play = true;
    private GuiButton buttonResetDemo;
    private DynamicTexture viewportTexture;
    private final Object field_104025_t = new Object();
    private String field_92025_p, field_146972_A, field_104024_v;
    private static final ResourceLocation backGround = new ResourceLocation("ardium:textures/gui/mainmenu.png");
    public static final String field_96138_a = "Please click " + EnumChatFormatting.UNDERLINE + "here" + EnumChatFormatting.RESET + " for more information.";
    private int field_92024_r, field_92023_s, field_92022_t, field_92021_u, field_92020_v, field_92019_w;
    private ResourceLocation field_110351_G;
    private static final String __OBFID = "CL_00001154";
    
    /*private static ServerData serverData = new ServerData("ardium", "");
    private static OldServerPinger serverPing = new OldServerPinger();*/
    
    public ArdiumMainMenu()
    {
        
        /*serverData.func_152583_a(serverData);
        try
        {
            serverPing.func_147224_a(serverData);
        }
        catch(UnknownHostException e)
        {
            e.printStackTrace();
        }
        //serverData.populationInfo;*/
        
        this.field_146972_A = field_96138_a;
        BufferedReader bufferedreader = null;
        
        this.updateCounter = rand.nextFloat();
        this.field_92025_p = "";
        if ((!GLContext.getCapabilities().OpenGL20) && (!OpenGlHelper.func_153193_b()))
        {
          this.field_92025_p = I18n.format("title.oldgl1", new Object[0]);
          this.field_146972_A = I18n.format("title.oldgl2", new Object[0]);
          this.field_104024_v = "https://help.mojang.com/customer/portal/articles/325948?ref=game";
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void renderBackground()
    {
      GL11.glViewport(0, 0, 256, 256);
      this.mc.getTextureManager().bindTexture(this.backGround);
      GL11.glDisable(3553);
      GL11.glEnable(3553);
      GL11.glViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
      Tessellator tessellator = Tessellator.instance;
      tessellator.startDrawingQuads();
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F);
      int k = this.width;
      int l = this.height;
      tessellator.addVertexWithUV(0.0D, 0.0D, this.zLevel, 0.0D, 0.0D);
      tessellator.addVertexWithUV(0.0D, l, this.zLevel, 0.0D, 1.0D);
      tessellator.addVertexWithUV(k, l, this.zLevel, 1.0D, 1.0D);
      tessellator.addVertexWithUV(k, 0.0D, this.zLevel, 1.0D, 0.0D);
      tessellator.draw();
    }

    public void initGui()
    {
        this.viewportTexture = new DynamicTexture(256, 256);
        this.field_110351_G = this.mc.getTextureManager().getDynamicTextureLocation("background", this.viewportTexture);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        
        boolean flag = true;
        int i = this.height / 4 + 48;

        if (this.mc.isDemo())
        {
            this.addDemoButtons(i, 24);
        }
        else
        {
            this.addSingleplayerMultiplayerButtons(i, 24);
        }

      
        
        Object object = this.field_104025_t;

        synchronized (this.field_104025_t)
        {
            this.field_92023_s = this.fontRendererObj.getStringWidth(this.field_92025_p);
            this.field_92024_r = this.fontRendererObj.getStringWidth(this.field_146972_A);
            int j = Math.max(this.field_92023_s, this.field_92024_r);
            this.field_92022_t = (this.width - j) / 2;
            this.field_92021_u = ((GuiButton)this.buttonList.get(0)).yPosition - 24;
            this.field_92020_v = this.field_92022_t + j;
            this.field_92019_w = this.field_92021_u + 24;
        }
    }
    
    private void addSingleplayerMultiplayerButtons(int p_73969_1_, int p_73969_2_)
    {
         int bn1 =  this.height/ 4 + 18 ;
         this.buttonList.add(new GuiButton(999, this.width / 2 - 100, bn1 - 20 + 24 * 2, EnumChatFormatting.DARK_PURPLE + "Rejoindre Ardium"));
         this.buttonList.add(new GuiButton(1000, this.width / 2 - 100, bn1 + 50, 98, 20, EnumChatFormatting.GOLD + "" + "Options"));
         this.buttonList.add(new GuiButton(1001, this.width / 2 + 2, bn1 + 50, 98, 20, EnumChatFormatting.DARK_RED + "" + "Quitter"));
    }
         

    private void addDemoButtons(int p_73972_1_, int p_73972_2_)
    {
        this.buttonList.add(new GuiButton(11, this.width / 2 - 100, p_73972_1_, I18n.format("menu.playdemo", new Object[0])));
        this.buttonList.add(this.buttonResetDemo = new GuiButton(12, this.width / 2 - 100, p_73972_1_ + p_73972_2_ * 1, I18n.format("menu.resetdemo", new Object[0])));
        ISaveFormat isaveformat = this.mc.getSaveLoader();
        WorldInfo worldinfo = isaveformat.getWorldInfo("Demo_World");

        if (worldinfo == null)
        {
            this.buttonResetDemo.enabled = false;
        }
    }

    protected void actionPerformed(GuiButton guiButton)
    {

        if (guiButton.id == 999)
        {
            this.mc.displayGuiScreen(new GuiSelectWorld(this));
            //FMLClientHandler.instance().connectToServerAtStartup("minecraft226.omgserv.com", 10653);
        }

        if (guiButton.id == 1000)
        {
            this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
        }

        if (guiButton.id == 1001)
        {
            this.mc.shutdown();
        }

        if (guiButton.id == 1002)
        {
            this.mc.displayGuiScreen(new GuiSelectWorld(this));
        }

        if (guiButton.id == 1003)
        {
            this.mc.launchIntegratedServer("Demo_World", "Demo_World", DemoWorldServer.demoWorldSettings);
        }

        if (guiButton.id == 1004)
        {
            ISaveFormat isaveformat = this.mc.getSaveLoader();
            WorldInfo worldinfo = isaveformat.getWorldInfo("Demo_World");

            if (worldinfo != null)
            {
                GuiYesNo guiyesno = GuiSelectWorld.func_152129_a(this, worldinfo.getWorldName(), 12);
                this.mc.displayGuiScreen(guiyesno);
            }
        }
    }

    private void func_140005_i()
    {
        RealmsBridge realmsbridge = new RealmsBridge();
        realmsbridge.switchToRealms(this);
    }

    public void confirmClicked(boolean isClickConfirmed, int id)
    {
        if (isClickConfirmed && id == 12)
        {
            ISaveFormat isaveformat = this.mc.getSaveLoader();
            isaveformat.flushCache();
            isaveformat.deleteWorldDirectory("Demo_World");
            this.mc.displayGuiScreen(this);
        }
        else if (id == 13)
        {
            if (isClickConfirmed)
            {
                try
                {
                    Class oclass = Class.forName("java.awt.Desktop");
                    Object object = oclass.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
                    oclass.getMethod("browse", new Class[] {URI.class}).invoke(object, new Object[] {new URI(this.field_104024_v)});
                }
                catch (Throwable throwable)
                {
                    logger.error("Couldn\'t open link", throwable);
                }
            }

            this.mc.displayGuiScreen(this);
        }
    }

  

    private void rotateAndBlurSkybox(float p_73968_1_)
    {
        this.mc.getTextureManager().bindTexture(this.field_110351_G);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        GL11.glCopyTexSubImage2D(GL11.GL_TEXTURE_2D, 0, 0, 0, 0, 0, 256, 256);
        GL11.glEnable(GL11.GL_BLEND);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glColorMask(true, true, true, false);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        byte b0 = 3;

        for (int i = 0; i < b0; ++i)
        {
            tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F / (float)(i + 1));
            int j = this.width;
            int k = this.height;
            float f1 = (float)(i - b0 / 2) / 256.0F;
            tessellator.addVertexWithUV((double)j, (double)k, (double)this.zLevel, (double)(0.0F + f1), 1.0D);
            tessellator.addVertexWithUV((double)j, 0.0D, (double)this.zLevel, (double)(1.0F + f1), 1.0D);
            tessellator.addVertexWithUV(0.0D, 0.0D, (double)this.zLevel, (double)(1.0F + f1), 0.0D);
            tessellator.addVertexWithUV(0.0D, (double)k, (double)this.zLevel, (double)(0.0F + f1), 0.0D);
        }

        tessellator.draw();
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glColorMask(true, true, true, true);
    }

    private void renderSkybox(int p_73971_1_, int p_73971_2_, float p_73971_3_)
    {
        this.mc.getFramebuffer().unbindFramebuffer();
        GL11.glViewport(0, 0, 256, 256);
        this.rotateAndBlurSkybox(p_73971_3_);
        this.rotateAndBlurSkybox(p_73971_3_);
        this.rotateAndBlurSkybox(p_73971_3_);
        this.rotateAndBlurSkybox(p_73971_3_);
        this.rotateAndBlurSkybox(p_73971_3_);
        this.rotateAndBlurSkybox(p_73971_3_);
        this.rotateAndBlurSkybox(p_73971_3_);
        this.mc.getFramebuffer().bindFramebuffer(true);
        GL11.glViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        float f1 = this.width > this.height ? 120.0F / (float)this.width : 120.0F / (float)this.height;
        float f2 = (float)this.height * f1 / 256.0F;
        float f3 = (float)this.width * f1 / 256.0F;
        tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F);
        int k = this.width;
        int l = this.height;
        tessellator.addVertexWithUV(0.0D, (double)l, (double)this.zLevel, (double)(0.5F - f2), (double)(0.5F + f3));
        tessellator.addVertexWithUV((double)k, (double)l, (double)this.zLevel, (double)(0.5F - f2), (double)(0.5F - f3));
        tessellator.addVertexWithUV((double)k, 0.0D, (double)this.zLevel, (double)(0.5F + f2), (double)(0.5F - f3));
        tessellator.addVertexWithUV(0.0D, 0.0D, (double)this.zLevel, (double)(0.5F + f2), (double)(0.5F + f3));
        tessellator.draw();
    }
    
    public void drawScreen(int par1, int par2, float par3)
    {
         renderSkybox(par2, par2, par3);
          Tessellator tessellator = Tessellator.instance;
          short short1 = 274;
          int k = this.width / 2 - short1 / 2;
          byte b0 = 30;
            
          GL11.glPushMatrix();
          GL11.glTranslatef(this.width / 2 + 90, 70.0F, 0.0F);
          GL11.glRotatef(-20.0F, 0.0F, 0.0F, 1.0F);
          float f1 = 1.8F - MathHelper.abs(MathHelper.sin((float)(Minecraft.getSystemTime() % 1000L) / 1000.0F * 3.1415927F * 2.0F) * 0.1F);
          GL11.glScalef(f1, f1, f1);
          GL11.glPopMatrix();
          String string = "";
          GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
          if (this.updateCounter < 1.0E-4D)
          {
              drawTexturedModalRect(k + 0, b0 + 0, 0, 0, 99, 44);
              drawTexturedModalRect(k + 99, b0 + 0, 129, 0, 27, 44);
              drawTexturedModalRect(k + 99 + 26, b0 + 0, 126, 0, 3, 44);
              drawTexturedModalRect(k + 99 + 26 + 3, b0 + 0, 99, 0, 26, 44);
              drawTexturedModalRect(k + 155, b0 + 0, 0, 45, 155, 44);
          }
          else
          {
              drawTexturedModalRect(k + 0, b0 + 0, 0, 0, 155, 44);
              drawTexturedModalRect(k + 155, b0 + 0, 0, 45, 155, 44);
          }
          renderBackground();
          String string1 = EnumChatFormatting.RED + "Copyright Mojang AB et Ardium !";
          drawString(this.fontRendererObj, string1, this.width - this.fontRendererObj.getStringWidth(string1) - 2, this.height - 10, 13898001);
          drawRect(0, 0, this.width, 15, new java.awt.Color(3, 169, 244, 50).getRGB());
          String string2 = "Bienvenue "+Minecraft.getMinecraft().getSession().getUsername()+" sur Ardium !!";
          drawString(this.fontRendererObj, string2, (this.width/2)-(fontRendererObj.getStringWidth(string2)/2), 2, new java.awt.Color(0, 255, 0).getRGB());
          {
              super.drawScreen(par1, par2, par3);
          }
    }  
}
