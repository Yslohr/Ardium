package com.ardium.pvp.gui.screens;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

import com.ardium.pvp.References;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.gui.GuiYesNoCallback;
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

public class MainMenuArdium extends GuiScreen implements GuiYesNoCallback 
{
	private static final Logger logger = LogManager.getLogger();
	private static final Random rand = new Random();
	private float updateCounter;
	public static boolean play = true;
	private String splashText;
	private GuiButton buttonResetDemo;
	private int panoramaTimer;
	private AudioInputStream audioIn;
	private Clip clip;
	private DynamicTexture viewportTexture;
	private final Object object = new Object();
	private String string_p;
	private String string_A;
	private String string_v;
	private static final ResourceLocation splashTexts = new ResourceLocation("texts/splashes.txt");
	private static final ResourceLocation minecraftTitleTextures = new ResourceLocation(
			"minecraft:textures/gui/title/minecraft.png");
	private static final ResourceLocation backGround = new ResourceLocation(
			References.MOD_ID + ":textures/gui/title/background/panorama_0.png");
	public static final String field_96138_a = "Please click " + EnumChatFormatting.UNDERLINE + "here"
			+ EnumChatFormatting.RESET + " for more information.";
	private int int_r;
	private int int_s;
	private int int_t;
	private int int_u;
	private int int_v;
	private int int_w;
	private ResourceLocation resourceLocation_G;
	private static final String __OBFID = "CL_00001154";
	private Loader loader;

	public MainMenuArdium() {
		this.string_A = field_96138_a;
		this.splashText = "missingno";
		BufferedReader bufferedreader = null;

		this.updateCounter = rand.nextFloat();
		this.string_p = "";
		if ((!GLContext.getCapabilities().OpenGL20) && (!OpenGlHelper.func_153193_b())) {
			this.string_p = I18n.format("title.oldgl1", new Object[0]);
			this.string_A = I18n.format("title.oldgl2", new Object[0]);
			this.string_v = "https://help.mojang.com/customer/portal/articles/325948?ref=game";
		}
	}

	@SideOnly(Side.CLIENT)
	public void renderBackground() {
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

	public void initGui() {
		this.viewportTexture = new DynamicTexture(256, 256);
		this.resourceLocation_G = this.mc.getTextureManager().getDynamicTextureLocation("background",
				this.viewportTexture);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		if (calendar.get(2) + 1 == 11 && calendar.get(5) == 9) {
			this.splashText = "Bienvenue Sur Ardium";
		} else if (calendar.get(2) + 1 == 6 && calendar.get(5) == 1) {
			this.splashText = "Happy birthday, Notch!";
		} else if (calendar.get(2) + 1 == 12 && calendar.get(5) == 24) {
			this.splashText = "Merry X-mas!";
		}

		boolean flag = true;
		int i = this.height / 4 + 48;

		if (this.mc.isDemo()) {
			this.addDemoButtons(i, 24);
		} else {
			this.addSingleplayerMultiplayerButtons(i, 24);
		}

		Object object = this.object;

		synchronized (this.object) {
			this.int_s = this.fontRendererObj.getStringWidth(this.string_p);
			this.int_r = this.fontRendererObj.getStringWidth(this.string_A);
			int j = Math.max(this.int_s, this.int_r);
			this.int_t = (this.width - j) / 2;
			this.int_u = ((GuiButton) this.buttonList.get(0)).yPosition - 24;
			this.int_v = this.int_t + j;
			this.int_w = this.int_u + 24;
		}
	}

	private void addSingleplayerMultiplayerButtons(int x, int y) {
		int par1 = this.height / 4 + 18;
		int par2 = 24;
		this.buttonList.add(new GuiButton(999, this.width / 2 - 214, par1 - 35, 98, 20,
				EnumChatFormatting.AQUA + "" + "Ardium v6"));
		this.buttonList.add(new GuiButton(1000, this.width / 2 - 214, par1 - 10, 98, 20,
				EnumChatFormatting.DARK_BLUE + "" + "TeamSpeak"));
		this.buttonList.add(new GuiButton(1001, this.width / 2 - 214, par1 + 15, 98, 20,
				EnumChatFormatting.DARK_AQUA + "" + "Site"));
		this.buttonList
				.add(new GuiButton(1002, this.width / 2 - 214, par1 + 40, 98, 20, EnumChatFormatting.BLUE + "Discord"));
		this.buttonList.add(new GuiButton(1003, this.width / 2 - 214, par1 + 65, 98, 20,
				EnumChatFormatting.RESET + "You" + EnumChatFormatting.DARK_RED + "Tube"));
		this.buttonList.add(new GuiButton(1004, this.width / 2 - 214, par1 + 90, 98, 20,
				EnumChatFormatting.DARK_PURPLE + "Options"));
		this.buttonList.add(new GuiButton(1005, this.width / 2 - 214, par1 + 115, 98, 20,
				EnumChatFormatting.DARK_RED + "" + "Quitter"));
	}

	private void addDemoButtons(int x, int y) {
		this.buttonList.add(new GuiButton(11, this.width / 2 - 100, x, I18n.format("menu.playdemo", new Object[0])));
		this.buttonList.add(this.buttonResetDemo = new GuiButton(12, this.width / 2 - 100, x + y * 1,
				I18n.format("menu.resetdemo", new Object[0])));
		ISaveFormat isaveformat = this.mc.getSaveLoader();
		WorldInfo worldinfo = isaveformat.getWorldInfo("Demo_World");

		if (worldinfo == null) {
			this.buttonResetDemo.enabled = false;
		}
	}

	protected void actionPerformed(GuiButton guiButton) {

		if (guiButton.id == 999) {
			this.mc.displayGuiScreen(new GuiSelectWorld(this));
			//FMLClientHandler.instance().connectToServerAtStartup("188.165.220.188", 25565);
		}

		if (guiButton.id == 1000) {
			try {
				Class oclass = Class.forName("java.awt.Desktop");
				Object object = oclass.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
				oclass.getMethod("browse", new Class[] { URI.class }).invoke(object,
						new Object[] { new URI("ts3server://ts.ardium-pvp.com") });
			} catch (Throwable throwable) {
				logger.error("Couldn't open TS3 application . Please download it !", throwable);
			}
		}

		if (guiButton.id == 1001) {
			try {
				Class oclass = Class.forName("java.awt.Desktop");
				Object object = oclass.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
				oclass.getMethod("browse", new Class[] { URI.class }).invoke(object,
						new Object[] { new URI("http://www.ardium-pvp.com/") });
			} catch (Throwable throwable) {
				logger.error("Couldn't open link", throwable);
			}
		}

		if (guiButton.id == 1002) {
			try {
				Desktop.getDesktop().browse(new URI("https://discord.gg/bxhYxGW"));
			} catch (Exception e) {
				logger.warn("Couldn\'t connect to iMot3k\'s Discord :( ", e);
			}
		}

		if (guiButton.id == 1003) {
			try {
				Class oclass = Class.forName("java.awt.Desktop");
				Object object = oclass.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
				oclass.getMethod("browse", new Class[] { URI.class }).invoke(object,
						new Object[] { new URI("https://youtube.fr/chetom21") });
			} catch (Throwable throwable) {
				logger.error("Couldn't open link", throwable);
			}
		}

		if (guiButton.id == 1004) {
			this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
		}

		if (guiButton.id == 1005) {
			this.mc.shutdown();
		}

		if (guiButton.id == 100) {
			this.mc.displayGuiScreen(new GuiSelectWorld(this));
		}

		if (guiButton.id == 101) {
			this.mc.launchIntegratedServer("Demo_World", "Demo_World", DemoWorldServer.demoWorldSettings);
		}

		if (guiButton.id == 102) {
			ISaveFormat isaveformat = this.mc.getSaveLoader();
			WorldInfo worldinfo = isaveformat.getWorldInfo("Demo_World");

			if (worldinfo != null) {
				GuiYesNo guiyesno = GuiSelectWorld.func_152129_a(this, worldinfo.getWorldName(), 12);
				this.mc.displayGuiScreen(guiyesno);
			}
		}
	}

	private void func_140005_i() {
		RealmsBridge realmsbridge = new RealmsBridge();
		realmsbridge.switchToRealms(this);
	}

	public void confirmClicked(boolean p_73878_1_, int p_73878_2_) {
		if (p_73878_1_ && p_73878_2_ == 12) {
			ISaveFormat isaveformat = this.mc.getSaveLoader();
			isaveformat.flushCache();
			isaveformat.deleteWorldDirectory("Demo_World");
			this.mc.displayGuiScreen(this);
		} else if (p_73878_2_ == 13) {
			if (p_73878_1_) {
				try {
					Class oclass = Class.forName("java.awt.Desktop");
					Object object = oclass.getMethod("getDesktop", new Class[0]).invoke((Object) null, new Object[0]);
					oclass.getMethod("browse", new Class[] { URI.class }).invoke(object,
							new Object[] { new URI(this.string_v) });
				} catch (Throwable throwable) {
					logger.error("Couldn\'t open link", throwable);
				}
			}

			this.mc.displayGuiScreen(this);
		}
	}

	private void rotateAndBlurSkybox(float p_73968_1_) {
		this.mc.getTextureManager().bindTexture(this.resourceLocation_G);
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

		for (int i = 0; i < b0; ++i) {
			tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F / (float) (i + 1));
			int j = this.width;
			int k = this.height;
			float f1 = (float) (i - b0 / 2) / 256.0F;
			tessellator.addVertexWithUV((double) j, (double) k, (double) this.zLevel, (double) (0.0F + f1), 1.0D);
			tessellator.addVertexWithUV((double) j, 0.0D, (double) this.zLevel, (double) (1.0F + f1), 1.0D);
			tessellator.addVertexWithUV(0.0D, 0.0D, (double) this.zLevel, (double) (1.0F + f1), 0.0D);
			tessellator.addVertexWithUV(0.0D, (double) k, (double) this.zLevel, (double) (0.0F + f1), 0.0D);
		}

		tessellator.draw();
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glColorMask(true, true, true, true);
	}

	private void renderSkybox(int p_73971_1_, int p_73971_2_, float p_73971_3_) {
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
		float f1 = this.width > this.height ? 120.0F / (float) this.width : 120.0F / (float) this.height;
		float f2 = (float) this.height * f1 / 256.0F;
		float f3 = (float) this.width * f1 / 256.0F;
		tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F);
		int k = this.width;
		int l = this.height;
		tessellator.addVertexWithUV(0.0D, (double) l, (double) this.zLevel, (double) (0.5F - f2), (double) (0.5F + f3));
		tessellator.addVertexWithUV((double) k, (double) l, (double) this.zLevel, (double) (0.5F - f2),
				(double) (0.5F - f3));
		tessellator.addVertexWithUV((double) k, 0.0D, (double) this.zLevel, (double) (0.5F + f2), (double) (0.5F - f3));
		tessellator.addVertexWithUV(0.0D, 0.0D, (double) this.zLevel, (double) (0.5F + f2), (double) (0.5F + f3));
		tessellator.draw();
	}

	public void drawScreen(int par1, int par2, float par3) {
		renderSkybox(par2, par2, par3);
		Tessellator tessellator = Tessellator.instance;
		short short1 = 274;
		int k = this.width / 2 - short1 / 2;
		byte b0 = 30;

		GL11.glPushMatrix();
		GL11.glTranslatef(this.width / 2 + 90, 70.0F, 0.0F);
		GL11.glRotatef(-20.0F, 0.0F, 0.0F, 1.0F);
		float f1 = 1.8F - MathHelper
				.abs(MathHelper.sin((float) (Minecraft.getSystemTime() % 1000L) / 1000.0F * 3.1415927F * 2.0F) * 0.1F);
		GL11.glScalef(f1, f1, f1);
		GL11.glPopMatrix();
		String s = "";
		this.mc.getTextureManager().bindTexture(minecraftTitleTextures);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		if (this.updateCounter < 1.0E-4D) {
			drawTexturedModalRect(k + 0, b0 + 0, 0, 0, 99, 44);
			drawTexturedModalRect(k + 99, b0 + 0, 129, 0, 27, 44);
			drawTexturedModalRect(k + 99 + 26, b0 + 0, 126, 0, 3, 44);
			drawTexturedModalRect(k + 99 + 26 + 3, b0 + 0, 99, 0, 26, 44);
			drawTexturedModalRect(k + 155, b0 + 0, 0, 45, 155, 44);
		} else {
			drawTexturedModalRect(k + 0, b0 + 0, 0, 0, 155, 44);
			drawTexturedModalRect(k + 155, b0 + 0, 0, 45, 155, 44);
		}
		renderBackground();
		String s1 = EnumChatFormatting.GOLD + "Bienvenue " + Minecraft.getMinecraft().getSession().getUsername()
				+ " sur Ardium !";
		drawString(this.fontRendererObj, s1, this.width - this.fontRendererObj.getStringWidth(s1) - 2, this.height - 31,
				13898001);
		String s2 = EnumChatFormatting.DARK_RED + "Developpeurs : Yslohr, NeroZbeub";
		drawString(this.fontRendererObj, s2, this.width - this.fontRendererObj.getStringWidth(s2) - 2, this.height - 21,
				13898001);
		String s3 = EnumChatFormatting.AQUA + "Copyright Mojang AB et Ardium !";
		drawString(this.fontRendererObj, s3, this.width - this.fontRendererObj.getStringWidth(s3) - 2, this.height - 10,
				13898001);
		{
			super.drawScreen(par1, par2, par3);
		}
	}
}