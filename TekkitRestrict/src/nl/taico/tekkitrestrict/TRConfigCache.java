package nl.taico.tekkitrestrict;

import java.util.ArrayList;
import java.util.List;

import nl.taico.tekkitrestrict.Log.Warning;
import nl.taico.tekkitrestrict.lib.config.TRFileConfiguration;
import nl.taico.tekkitrestrict.objects.TRDupeSettings;
import nl.taico.tekkitrestrict.objects.TRHackSettings;
import nl.taico.tekkitrestrict.objects.TREnums.ConfigFile;
import nl.taico.tekkitrestrict.objects.TREnums.SSMode;

import com.griefcraft.lwc.LWCPlugin;

public class TRConfigCache {
	@SuppressWarnings("rawtypes")
	public static void loadConfigCache(){
		TRFileConfiguration config = tekkitrestrict.config;
		Hacks.flys = new TRHackSettings();
		Hacks.flys.enable = config.getBoolean2(ConfigFile.HackDupe, "Anti-Hacks.Fly.Enabled", true);
		Hacks.flys.kick = config.getBoolean2(ConfigFile.HackDupe, "Anti-Hacks.Fly.Kick", true);
		Hacks.flys.broadcast = config.getBoolean2(ConfigFile.HackDupe, "Anti-Hacks.Fly.Broadcast", true);
		Hacks.flys.tolerance = config.getInt2(ConfigFile.HackDupe, "Anti-Hacks.Fly.Tolerance", 40);
		Hacks.flys.value = (int) Math.round(config.getDouble2(ConfigFile.HackDupe, "Anti-Hacks.Fly.MinHeight", 3));
		Hacks.flys.useCommand = config.getBoolean2(ConfigFile.HackDupe, "Anti-Hacks.Fly.ExecuteCommand.Enabled", false);
		Hacks.flys.command = config.getString2(ConfigFile.HackDupe, "Anti-Hacks.Fly.ExecuteCommand.Command", "");
		Hacks.flys.triggerAfter = config.getInt2(ConfigFile.HackDupe, "Anti-Hacks.Fly.ExecuteCommand.TriggerAfter", 1);
		
		Hacks.forcefields = new TRHackSettings();
		Hacks.forcefields.enable = config.getBoolean2(ConfigFile.HackDupe, "Anti-Hacks.Forcefield.Enabled", true);
		Hacks.forcefields.kick = config.getBoolean2(ConfigFile.HackDupe, "Anti-Hacks.Forcefield.Kick", true);
		Hacks.forcefields.broadcast = config.getBoolean2(ConfigFile.HackDupe, "Anti-Hacks.Forcefield.Broadcast", true);
		Hacks.forcefields.tolerance = config.getInt2(ConfigFile.HackDupe, "Anti-Hacks.Forcefield.Tolerance", 20);
		Hacks.forcefields.value = config.getDouble2(ConfigFile.HackDupe, "Anti-Hacks.Forcefield.Angle", 40);
		Hacks.forcefields.useCommand = config.getBoolean2(ConfigFile.HackDupe, "Anti-Hacks.Forcefield.ExecuteCommand.Enabled", false);
		Hacks.forcefields.command = config.getString2(ConfigFile.HackDupe, "Anti-Hacks.Forcefield.ExecuteCommand.Command", "");
		Hacks.forcefields.triggerAfter = config.getInt2(ConfigFile.HackDupe, "Anti-Hacks.Forcefield.ExecuteCommand.TriggerAfter", 1);
		
		Hacks.speeds = new TRHackSettings();
		Hacks.speeds.enable = config.getBoolean2(ConfigFile.HackDupe, "Anti-Hacks.MoveSpeed.Enabled", true);
		Hacks.speeds.kick = config.getBoolean2(ConfigFile.HackDupe, "Anti-Hacks.MoveSpeed.Kick", true);
		Hacks.speeds.broadcast = config.getBoolean2(ConfigFile.HackDupe, "Anti-Hacks.MoveSpeed.Broadcast", true);
		Hacks.speeds.tolerance = config.getInt2(ConfigFile.HackDupe, "Anti-Hacks.MoveSpeed.Tolerance", 30);
		Hacks.speeds.value = config.getDouble2(ConfigFile.HackDupe, "Anti-Hacks.MoveSpeed.MaxMoveSpeed", 2.5d);
		Hacks.speeds.useCommand = config.getBoolean2(ConfigFile.HackDupe, "Anti-Hacks.MoveSpeed.ExecuteCommand.Enabled", false);
		Hacks.speeds.command = config.getString2(ConfigFile.HackDupe, "Anti-Hacks.MoveSpeed.ExecuteCommand.Command", "");
		Hacks.speeds.triggerAfter = config.getInt2(ConfigFile.HackDupe, "Anti-Hacks.MoveSpeed.ExecuteCommand.TriggerAfter", 1);
		
		Hacks.broadcastFormat = config.getString2(ConfigFile.HackDupe, "Anti-Hacks.BroadcastString", "&9{PLAYER} &ctried to &a{TYPE}&c-hack!");
		
		Dupes.alcBags = new TRDupeSettings();
		Dupes.alcBags.prevent = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.AlchemyBagDupe.Prevent", true);
		Dupes.alcBags.broadcast = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.AlchemyBagDupe.Broadcast", true);
		Dupes.alcBags.kick = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.AlchemyBagDupe.Kick", false);
		Dupes.alcBags.useCommand = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.AlchemyBagDupe.ExecuteCommand.Enabled", false);
		Dupes.alcBags.command = config.getString2(ConfigFile.HackDupe, "Anti-Dupes.AlchemyBagDupe.ExecuteCommand.Command", "");
		Dupes.alcBags.triggerAfter = config.getInt2(ConfigFile.HackDupe, "Anti-Dupes.AlchemyBagDupe.ExecuteCommand.TriggerAfter", 1);
		
		Dupes.rmFurnaces = new TRDupeSettings();
		Dupes.rmFurnaces.prevent = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.RMFurnaceDupe.Prevent", true);
		Dupes.rmFurnaces.broadcast = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.RMFurnaceDupe.Broadcast", true);
		Dupes.rmFurnaces.kick = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.RMFurnaceDupe.Kick", false);
		Dupes.rmFurnaces.useCommand = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.RMFurnaceDupe.ExecuteCommand.Enabled", false);
		Dupes.rmFurnaces.command = config.getString2(ConfigFile.HackDupe, "Anti-Dupes.RMFurnaceDupe.ExecuteCommand.Command", "");
		Dupes.rmFurnaces.triggerAfter = config.getInt2(ConfigFile.HackDupe, "Anti-Dupes.RMFurnaceDupe.ExecuteCommand.TriggerAfter", 1);
		
		Dupes.transmutes = new TRDupeSettings();
		Dupes.transmutes.prevent = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.TransmuteDupe.Prevent", true);
		Dupes.transmutes.broadcast = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.TransmuteDupe.Broadcast", true);
		Dupes.transmutes.kick = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.TransmuteDupe.Kick", false);
		Dupes.transmutes.useCommand = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.TransmuteDupe.ExecuteCommand.Enabled", false);
		Dupes.transmutes.command = config.getString2(ConfigFile.HackDupe, "Anti-Dupes.TransmuteDupe.ExecuteCommand.Command", "");
		Dupes.transmutes.triggerAfter = config.getInt2(ConfigFile.HackDupe, "Anti-Dupes.TransmuteDupe.ExecuteCommand.TriggerAfter", 1);
		
		Dupes.tankcarts = new TRDupeSettings();
		Dupes.tankcarts.prevent = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.TankCartDupe.Prevent", true);
		Dupes.tankcarts.broadcast = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.TankCartDupe.Broadcast", true);
		Dupes.tankcarts.kick = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.TankCartDupe.Kick", false);
		Dupes.tankcarts.useCommand = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.TankCartDupe.ExecuteCommand.Enabled", false);
		Dupes.tankcarts.command = config.getString2(ConfigFile.HackDupe, "Anti-Dupes.TankCartDupe.ExecuteCommand.Command", "");
		Dupes.tankcarts.triggerAfter = config.getInt2(ConfigFile.HackDupe, "Anti-Dupes.TankCartDupe.ExecuteCommand.TriggerAfter", 1);
		
		Dupes.tankcartGlitchs = new TRDupeSettings();
		Dupes.tankcartGlitchs.prevent = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.TankCartGlitch.Prevent", true);
		Dupes.tankcartGlitchs.broadcast = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.TankCartGlitch.Broadcast", true);
		Dupes.tankcartGlitchs.kick = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.TankCartGlitch.Kick", false);
		Dupes.tankcartGlitchs.useCommand = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.TankCartGlitch.ExecuteCommand.Enabled", false);
		Dupes.tankcartGlitchs.command = config.getString2(ConfigFile.HackDupe, "Anti-Dupes.TankCartGlitch.ExecuteCommand.Command", "");
		Dupes.tankcartGlitchs.triggerAfter = config.getInt2(ConfigFile.HackDupe, "Anti-Dupes.TankCartGlitch.ExecuteCommand.TriggerAfter", 1);
		
		Dupes.teleports = new TRDupeSettings();
		Dupes.teleports.prevent = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.TeleportDupe.Prevent", true);
		Dupes.teleports.broadcast = false;
		Dupes.teleports.kick = false;
		Dupes.teleports.useCommand = false;
		Dupes.teleports.command = "";
		Dupes.teleports.triggerAfter = 1;
		
		Dupes.pedestals = new TRDupeSettings();
		Dupes.pedestals.prevent = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.PedestalEmcGen.Prevent", true);
		Dupes.pedestals.broadcast = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.PedestalEmcGen.Broadcast", true);
		Dupes.pedestals.kick = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.PedestalEmcGen.Kick", false);
		Dupes.pedestals.useCommand = config.getBoolean2(ConfigFile.HackDupe, "Anti-Dupes.PedestalEmcGen.ExecuteCommand.Enabled", false);
		Dupes.pedestals.command = config.getString2(ConfigFile.HackDupe, "Anti-Dupes.PedestalEmcGen.ExecuteCommand.Command", "");
		Dupes.pedestals.triggerAfter = config.getInt2(ConfigFile.HackDupe, "Anti-Dupes.PedestalEmcGen.ExecuteCommand.TriggerAfter", 1);
		
		Dupes.broadcastFormat = config.getString2(ConfigFile.HackDupe, "Anti-Dupes.BroadcastString", "&9{PLAYER} &ctried to dupe&6 {ITEM} &cusing &a{TYPE}&c!");
		
		Global.debug = config.getBoolean(ConfigFile.General, "ShowDebugMessages", false) ||
					   config.getBoolean(ConfigFile.Logging, "LogDebug", false);
		
		Global.kickFromConsole = config.getBoolean2(ConfigFile.General, "KickFromConsole", false);
		//Global.useNewBanSystem = config.getBoolean("UseNewBannedItemsSystem", false);
		
		Listeners.UseBlockLimit = config.getBoolean2(ConfigFile.General, "UseItemLimiter", true);
		Listeners.BlockCreativeContainer = config.getBoolean2(ConfigFile.LimitedCreative, "LimitedCreativeNoContainer", true);
		Listeners.UseNoItem = config.getBoolean2(ConfigFile.General, "UseNoItem", true);
		Listeners.UseLimitedCreative = config.getBoolean2(ConfigFile.General, "UseLimitedCreative", true);
		Listeners.useNoCLickPerms = config.getBoolean2(ConfigFile.DisableClick, "UseNoClickPermissions", false);
		
		LogFilter.replaceList = config.getStringList(ConfigFile.Logging, "LogFilter");
		LogFilter.splitLogs = config.getBoolean2(ConfigFile.Logging, "SplitLogs", true);
		LogFilter.filterLogs = config.getBoolean2(ConfigFile.Logging, "FilterLogs", true);
		LogFilter.logLocation = config.getString2(ConfigFile.Logging, "SplitLogsLocation", "log");
		LogFilter.fileFormat = config.getString2(ConfigFile.Logging, "FilenameFormat", "{TYPE}-{DAY}-{MONTH}-{YEAR}.log");
		LogFilter.logFormat = config.getString2(ConfigFile.Logging, "LogStringFormat", "[{HOUR}:{MINUTE}:{SECOND}] {INFO}");
		
		Threads.gemArmorSpeed = config.getInt2(ConfigFile.TPerformance, "GemArmorDThread", 120);
		Threads.inventorySpeed = config.getInt2(ConfigFile.TPerformance, "InventoryThread", 400);
		Threads.saveSpeed = config.getInt2(ConfigFile.TPerformance, "AutoSaveThreadSpeed", 11000);
		Threads.SSEntityRemoverSpeed = config.getInt2(ConfigFile.TPerformance, "SSEntityRemoverThread", 350);
		Threads.worldCleanerSpeed = config.getInt2(ConfigFile.TPerformance, "WorldCleanerThread", 15000);
		
		Threads.GAMovement = config.getBoolean2(ConfigFile.ModModifications, "AllowGemArmorDefensive", true);
		Threads.GAOffensive = config.getBoolean2(ConfigFile.ModModifications, "AllowGemArmorOffensive", false);
		
		Threads.SSDisableEntities = config.getBoolean2(ConfigFile.SafeZones, "InSafeZones.DisableEntities", false);
		Threads.SSDechargeEE = config.getBoolean2(ConfigFile.SafeZones, "InSafeZones.DechargeEE", true);
		Threads.SSDisableArcane = config.getBoolean2(ConfigFile.SafeZones, "InSafeZones.DisableRingOfArcana", true);
		List<String> exempt = config.getStringList(ConfigFile.SafeZones, "InSafeZones.ExemptEntityTypes");
		Threads.SSClassBypasses = new ArrayList<Class>();
		for (String s : exempt){
			try {
				Class cl = Class.forName("org.bukkit.entity."+s);
				Threads.SSClassBypasses.add(cl);
			} catch (Exception ex){
				try {
					Class cl = Class.forName("org.bukkit.entity."+Character.toUpperCase(s.charAt(0)) + s.substring(1));
					Threads.SSClassBypasses.add(cl);
				} catch (Exception ex2){
					Warning.config("Invalid value in ExemptEntityTypes in SafeZones.config: cannot find class org.bukkit.entity."+ s + "!", false);
					continue;
				}
			}
		}
		
		Threads.RMDB = config.getBoolean2(ConfigFile.DisableItems, "RemoveDisabledItemBlocks", false);
		//Threads.UseRPTimer = config.getBoolean(ConfigFile.General, "UseAutoRPTimer", false);
		Threads.ChangeDisabledItemsIntoId = config.getInt2(ConfigFile.DisableItems, "ChangeDisabledItemsIntoId", 3);
		//Threads.RPTickTime = (int) Math.round((config.getDouble(ConfigFile.ModModifications, "RPTimerMin", 0.2)-0.1d) * 20d);
		
		SafeZones.UseSafeZones = config.getBoolean2(ConfigFile.SafeZones, "UseSafeZones", true);
		SafeZones.UseFactions = config.getBoolean2(ConfigFile.SafeZones, "SSEnabledPlugins.Factions", true);
		SafeZones.UseGP = config.getBoolean2(ConfigFile.SafeZones, "SSEnabledPlugins.GriefPrevention", true);
		SafeZones.UsePS = config.getBoolean2(ConfigFile.SafeZones, "SSEnabledPlugins.PreciousStones", true);
		SafeZones.UseTowny = config.getBoolean2(ConfigFile.SafeZones, "SSEnabledPlugins.Towny", true);
		SafeZones.UseWG = config.getBoolean2(ConfigFile.SafeZones, "SSEnabledPlugins.WorldGuard", true);
		SafeZones.GPMode = SSMode.parse(config.getString2(ConfigFile.SafeZones, "GriefPreventionSafeZoneMethod", "admin"));
		SafeZones.WGMode = SSMode.parse(config.getString2(ConfigFile.SafeZones, "WorldGuardSafeZoneMethod", "specific"));
		
		//SafeZones.SSPlugins = config.getStringList("SSEnabledPlugins");
		//SafeZones.SSDisableFly = config.getBoolean("SSDisableFlying", false);
		//SafeZones.allGPClaimsAreSafezone = config.getBoolean("AllGriefPreventionClaimsAreSafezones", false);
		//SafeZones.allowNormalUser = config.getBoolean("SSAllowNormalUsersToHaveSafeZones", true);
		
		ChunkUnloader.enabled = config.getBoolean2(ConfigFile.TPerformance, "UseChunkUnloader", false);
		//ChunkUnloader.maxChunks = config.getInt2(ConfigFile.TPerformance, "MaxChunks", 3000);
		ChunkUnloader.maxChunksEnd = config.getInt2(ConfigFile.TPerformance, "MaxChunks.TheEnd", 200);
		ChunkUnloader.maxChunksNether = config.getInt2(ConfigFile.TPerformance, "MaxChunks.Nether", 400);
		ChunkUnloader.maxChunksNormal = config.getInt2(ConfigFile.TPerformance, "MaxChunks.Normal", 4000);
		ChunkUnloader.maxChunksTotal = config.getInt2(ConfigFile.TPerformance, "MaxChunks.Total", 4000);
		ChunkUnloader.unloadOrder = config.getInt2(ConfigFile.TPerformance, "UnloadOrder", 0);
		ChunkUnloader.maxRadii = config.getInt2(ConfigFile.TPerformance, "MaxRadii", 256);
		
		Logger.LogAmulets = config.getBoolean2(ConfigFile.Logging, "LogAmulets", false);
		Logger.LogRings = config.getBoolean2(ConfigFile.Logging, "LogRings", false);
		Logger.LogDMTools = config.getBoolean2(ConfigFile.Logging, "LogDMTools", false);
		Logger.LogRMTools = config.getBoolean2(ConfigFile.Logging, "LogRMTools", false);
		Logger.LogEEMisc = config.getBoolean2(ConfigFile.Logging, "LogEEMisc", false);
		Logger.LogEEDestructive = config.getBoolean2(ConfigFile.Logging, "LogEEDestructive", false);
	}

	public static class Global {
		public static boolean kickFromConsole, debug;
	}
	
	public static class Logger {
		public static boolean LogAmulets, LogRings, LogDMTools, LogRMTools, LogEEMisc, LogEEDestructive;
	}
	
	public static class Hacks {
		public static TRHackSettings flys, forcefields, speeds;
		public static String broadcastFormat;
	}
	
	public static class Dupes {
		public static TRDupeSettings alcBags, rmFurnaces, tankcarts, tankcartGlitchs, transmutes, pedestals, teleports;
		public static String broadcastFormat;
	}
	
	public static class SafeZones {
		//public static boolean SSDisableFly;
		public static boolean UseSafeZones;
		//public static List<String> SSPlugins;
		public static boolean UseGP, UseTowny, UsePS, UseFactions, UseWG;
		public static SSMode GPMode = SSMode.Admin;
		public static SSMode WGMode = SSMode.Specific;
	}
	
	public static class Listeners {
		public static boolean UseBlockLimit, BlockCreativeContainer;
		public static boolean UseNoItem, UseLimitedCreative, useNoCLickPerms;
	}
	
	public static class LogFilter {
		public static List<String> replaceList = new ArrayList<String>();
		public static boolean splitLogs, filterLogs;
		public static String logLocation, fileFormat, logFormat;
	}
	
	public static class Threads {
		public static int saveSpeed, worldCleanerSpeed, inventorySpeed, SSEntityRemoverSpeed, gemArmorSpeed;
		public static boolean GAMovement, GAOffensive;
		public static boolean SSDisableEntities, SSDechargeEE, SSDisableArcane;
		public static boolean RMDB;//, UseRPTimer;
		public static int ChangeDisabledItemsIntoId;
		//public static int RPTickTime;
		
		@SuppressWarnings("rawtypes")
		public static ArrayList<Class> SSClassBypasses = new ArrayList<Class>();
	}
	
	public static class LWC {
		public static LWCPlugin lwcPlugin;
	}
	
	public static class ChunkUnloader {
		public static int maxRadii;
		public static boolean enabled;
		public static int maxChunksEnd, maxChunksNether, maxChunksNormal;//TODO
		public static int maxChunksTotal;//TODO
		public static int unloadOrder;
	}
}
