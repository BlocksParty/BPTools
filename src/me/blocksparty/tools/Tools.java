package me.blocksparty.tools;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
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
		//Map<Player, Material> blockpainting = MyPlayerListener.blockpainting;
		//Map<Player, Material> nothingpainting = MyPlayerListener.nothingpainting;
		
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
							player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": /bptools nportal" + " | " + ChatColor.BLUE + "Create NeatherPortal Infront Of You" + ChatColor.WHITE + "!");
						
						}else if(args[0].equalsIgnoreCase("list") || args[0].equalsIgnoreCase("l")){	
							player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": Welcome to BPTools, " + ChatColor.BLUE + "List" + ChatColor.WHITE + "!");
							player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": (WOOD_HOE) The Instant Block Break Tool; " + " | " + ChatColor.BLUE + "Breaks The Block You Clicked, Instantly" + ChatColor.WHITE + "!");
							player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": (STONE_HOE) The Give Me Tool; " + " | " + ChatColor.BLUE + "Gives You The Block, You Clicked" + ChatColor.WHITE + "!");
							player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": (IRON_HOE) The Block Painting Tool; " + " | " + ChatColor.BLUE + "Change The Block, You LEFT Clicked To The Block You RIGHT Clicked" + ChatColor.WHITE + "!");
							player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": (GOLD_HOE) The Nothing Painting Tool; " + " | " + ChatColor.BLUE + "Change The Block ABOVE, The Block, You LEFT Clicked To The Block You RIGHT Clicked" + ChatColor.WHITE + "!");

						}else if(args[0].equalsIgnoreCase("enable") || args[0].equalsIgnoreCase("e")){
							if(!bptools.containsKey(player.getName())){
								bptools.put(player.getName(), "bptools");
									ItemStack wood = new ItemStack(Material.WOOD_HOE, 1);
									ItemStack stone = new ItemStack(Material.STONE_HOE, 1);
									ItemStack iron = new ItemStack(Material.IRON_HOE, 1);
									ItemStack gold = new ItemStack(Material.GOLD_HOE, 1);
									ItemStack greenWool = new ItemStack(Material.WOOL, 1);
									ItemStack diamond = new ItemStack(Material.DIAMOND_HOE, 1);
										player.getInventory().addItem(wood, stone, iron, gold, diamond);
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
							//blockpainting.clear();
							//nothingpainting.clear();
							secret.clear();
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