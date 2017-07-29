package com.ardium.pvp.utils;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;

public class LogHelper {

	public static void logger(Level logLevel, Object object) {
		FMLLog.log(References.MOD_ID, logLevel, String.valueOf(object));
	}

	public static void all(Object object) { logger(Level.ALL, object); }
	public static void debug(Object object) { logger(Level.DEBUG, object);}
	public static void error(Object object) { logger(Level.ERROR, object); }
	public static void fatal(Object object) { logger(Level.FATAL, object); }
	public static void info(Object object) { logger(Level.INFO, object); }
	public static void off(Object object) { logger(Level.OFF, object); }
	public static void trace(Object object) { logger(Level.TRACE, object); }
	public static void warn(Object object) { logger(Level.WARN, object); }
}
