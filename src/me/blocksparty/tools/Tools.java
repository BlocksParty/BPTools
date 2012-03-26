package me.blocksparty.tools;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Tools extends JavaPlugin{
		public static Tools plugin;
		public final Logger logger = Logger.getLogger("Minecraft");
		private MyPluginCommandExecutor myExecutor;
		public static MyMethodsStorage myMethodsStorage;
		public final MyPlayerListener pl = new MyPlayerListener();
		public final MyBlockListener bl = new MyBlockListener();
				
			@Override
			public void onDisable() {
				PluginDescriptionFile pdfFile = this.getDescription();
				this.logger.info(pdfFile.getName() + " Has Been Disabled!");
			}
			
			@Override
			public void onEnable() {
				PluginDescriptionFile pdfFile = this.getDescription();
				this.logger.info(pdfFile.getName() + ", Version " + pdfFile.getVersion() + ", Has Been Enabled!");
				myExecutor = new MyPluginCommandExecutor(this);
				getCommand("bptools").setExecutor(myExecutor);
				PluginManager pm = getServer().getPluginManager();
				pm.registerEvents(this.pl, this);
				pm.registerEvents(this.bl, this);
			}
}