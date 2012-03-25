package me.blocksparty.tools;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Tools extends JavaPlugin{
		public static Tools plugin;
		public final Logger logger = Logger.getLogger("Minecraft");
		public final MyPlayerListener pl = new MyPlayerListener();
		public final MyBlockListener bl = new MyBlockListener();
		
		public static Map<String, String> bptools = new HashMap<String, String>();
		public static Map<String, String> secret = new HashMap<String, String>();
		Map<String, String> autopilot = MyPlayerListener.autopilot;
		Map<String, String> normal = MyPlayerListener.normal;
		Map<String, String> high = MyPlayerListener.high;
		HashMap<Player, Material> paintbrush = MyPlayerListener.paintbrush;
		HashMap<Player, Material> buildbrush = MyPlayerListener.buildbrush;
		
		@Override
		public void onDisable() {
			PluginDescriptionFile pdfFile = this.getDescription();
			this.logger.info(pdfFile.getName() + " Has Been Disabled!");
			
		}
		
		@Override
		public void onEnable() {
			PluginDescriptionFile pdfFile = this.getDescription();
			this.logger.info(pdfFile.getName() + ", Version " + pdfFile.getVersion() + ", Has Been Enabled!");
			
			PluginManager pm = getServer().getPluginManager();
			pm.registerEvents(this.pl, this);
			pm.registerEvents(this.bl, this);
		}
		
		public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
			if (sender instanceof Player) {
				Player player = (Player) sender;
					if(commandLabel.equalsIgnoreCase("bptools")){
						if(args.length == 0){
							player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": Welcome to BPTools, brought to you by; " + ChatColor.BLUE + "BlocksParty" + ChatColor.WHITE + "!");
							player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": /bptools list" + " | " + ChatColor.BLUE + "The Tools List" + ChatColor.WHITE + "!");
							player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": /bptools enable" + " | " + ChatColor.BLUE + "Enable The Plugin" + ChatColor.WHITE + "!");
							player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": /bptools disable" + " | " + ChatColor.BLUE + "Disable The Plugin" + ChatColor.WHITE + "!");
							player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": /bptools reload" + " | " + ChatColor.BLUE + "Reload The Plugin" + ChatColor.WHITE + "!");
						
						}else if(args[0].equalsIgnoreCase("list") || args[0].equalsIgnoreCase("l")){	
							player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": Welcome to BPTools, " + ChatColor.BLUE + "List" + ChatColor.WHITE + "!");
							player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": (INK_SAC) The AutoPilot Tool; " + " | " + ChatColor.BLUE + "Turn On/Off AutoPilot" + ChatColor.WHITE + "!");
							player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": (ROSE_RED) The Teleport/Transport Tool; " + " | " + ChatColor.BLUE + "Teleports You, or Transport you" + ChatColor.WHITE + "!");
							player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": (CACTUS_GREEN) The Instante Block Break Tool; " + " | " + ChatColor.BLUE + "Break Blocks Instantly" + ChatColor.WHITE + "!");
							player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": (Cocoa_Beans) The GiveMe Tool; " + " | " + ChatColor.BLUE + "Give You The Item You Right Click" + ChatColor.WHITE + "!");
							player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": (Lapis_Lazuli) The Painting Tool; " + " | " + ChatColor.BLUE + "Paints The Block You Left Click, Whit The Block Type You Define Whit Right Click" + ChatColor.WHITE + "!");
							player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": (Purple_Dye) The Build Tool; " + " | " + ChatColor.BLUE + "Place The Block Above The Block You Left Click, Whit The Block Type You Define Whit Right Click" + ChatColor.WHITE + "!");
							player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": (Cyan_Dye) The Land Tool; " + " | " + ChatColor.BLUE + "Remove The Chunk Within The Clicked Block" + ChatColor.WHITE + "!");
							
						}else if(args[0].equalsIgnoreCase("enable") || args[0].equalsIgnoreCase("e")){
							if(!bptools.containsKey(player.getName())){
								bptools.put(player.getName(), "bptools");
								
									ItemStack inksack = new ItemStack(Material.INK_SACK, 1, (byte) 0);
									ItemStack rosered = new ItemStack(Material.INK_SACK, 1, (byte) 1);
									ItemStack cactusgreen = new ItemStack(Material.INK_SACK, 1, (byte) 2);
									ItemStack cocoabeans = new ItemStack(Material.INK_SACK, 1, (byte) 3);
									ItemStack lapislazuli = new ItemStack(Material.INK_SACK, 1, (byte) 4);
									ItemStack purpledye = new ItemStack(Material.INK_SACK, 1, (byte) 5);
									ItemStack cyandye = new ItemStack(Material.INK_SACK, 1, (byte) 6);
									
									player.getInventory().addItem(inksack, rosered, cactusgreen, cocoabeans, lapislazuli, purpledye, cyandye);
											player.updateInventory();
												player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": The Tools Is " + ChatColor.BLUE + "ENABLE" + ChatColor.WHITE + "!");
							}else{
								player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": The Tools Is " + ChatColor.BLUE + "ALREADY ENABLE" + ChatColor.WHITE + "! Plugin Failed To Enable!");
							}
							
						}else if(args[0].equalsIgnoreCase("disable") || args[0].equalsIgnoreCase("d")){
							if(bptools.containsKey(player.getName())){
								bptools.remove(player.getName());
									player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": The Tools Is " + ChatColor.BLUE + "DISABLE" + ChatColor.WHITE + "!");
							}else{
								player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": The Tools Is " + ChatColor.BLUE + "NOT YET ENABLE" + ChatColor.WHITE + "! Plugin Failed To Disable!");
							}
							
						}else if(args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("r")){
							bptools.clear();
							secret.clear();
							autopilot.clear();
							normal.clear();
							high.clear();
							paintbrush.clear();
							buildbrush.clear();
							
								player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": The Plugin Is " + ChatColor.BLUE + "RELOADED" + ChatColor.WHITE + "!");
						
						}else if(args[0].equalsIgnoreCase("secret")){
							secret.put(player.getName(), "secret");
								ItemStack wbhead = new ItemStack(Material.WORKBENCH);
									player.getInventory().setHelmet(wbhead);
										player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": Goncratulations, You Found The Secret Of This Plugin: " + ChatColor.BLUE + "WORKBENCH HEAD" + ChatColor.WHITE + "! Enjoy Your New Helmet!");
						}
					}
			}
			return false;
		}
}