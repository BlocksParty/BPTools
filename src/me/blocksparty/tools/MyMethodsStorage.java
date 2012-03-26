package me.blocksparty.tools;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MyMethodsStorage {
	private Tools plugin;
	
	Map<String, String> bptools = MyHashMapStorage.bptools;
	Map<String, String> secret = MyHashMapStorage.secret;
	Map<String, String> autopilot = MyHashMapStorage.autopilot;
	Map<String, String> normal = MyHashMapStorage.normal;
	Map<String, String> high = MyHashMapStorage.high;
	HashMap<Player, Material> paintbrush = MyHashMapStorage.paintbrush;
	HashMap<Player, Material> buildbrush = MyHashMapStorage.buildbrush;
	
	
	public MyMethodsStorage(Tools plugin) {
		this.plugin = plugin;
	}
	
	public void bptools(Player player){
		player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": Welcome to BPTools, brought to you by; " + ChatColor.BLUE + "BlocksParty" + ChatColor.WHITE + "!");
		player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": /bptools list" + " | " + ChatColor.BLUE + "The Tools List" + ChatColor.WHITE + "!");
		player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": /bptools enable" + " | " + ChatColor.BLUE + "Enable The Plugin" + ChatColor.WHITE + "!");
		player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": /bptools disable" + " | " + ChatColor.BLUE + "Disable The Plugin" + ChatColor.WHITE + "!");
		player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": /bptools reload" + " | " + ChatColor.BLUE + "Reload The Plugin" + ChatColor.WHITE + "!");
	}
	
	public void list(Player player){
		player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": Welcome to BPTools, " + ChatColor.BLUE + "List" + ChatColor.WHITE + "!");
		player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": (INK_SAC) The AutoPilot Tool; " + " | " + ChatColor.BLUE + "Turn On/Off AutoPilot" + ChatColor.WHITE + "!");
		player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": (ROSE_RED) The Teleport/Transport Tool; " + " | " + ChatColor.BLUE + "Teleports You, or Transport you" + ChatColor.WHITE + "!");
		player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": (CACTUS_GREEN) The Instante Block Break Tool; " + " | " + ChatColor.BLUE + "Break Blocks Instantly" + ChatColor.WHITE + "!");
		player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": (Cocoa_Beans) The GiveMe Tool; " + " | " + ChatColor.BLUE + "Give You The Item You Right Click" + ChatColor.WHITE + "!");
		player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": (Lapis_Lazuli) The Painting Tool; " + " | " + ChatColor.BLUE + "Paints The Block You Left Click, Whit The Block Type You Define Whit Right Click" + ChatColor.WHITE + "!");
		player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": (Purple_Dye) The Build Tool; " + " | " + ChatColor.BLUE + "Place The Block Above The Block You Left Click, Whit The Block Type You Define Whit Right Click" + ChatColor.WHITE + "!");
		player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": (Cyan_Dye) The Land Tool; " + " | " + ChatColor.BLUE + "Remove The Chunk Within The Clicked Block" + ChatColor.WHITE + "!");
	}
	
	public void enable(Player player){	
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
			onErrors(player);
		}
	}
	
	public void disable(Player player){
		if(bptools.containsKey(player.getName())){
			bptools.remove(player.getName());
			player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": The Tools Is " + ChatColor.BLUE + "DISABLE" + ChatColor.WHITE + "!");
			
		}else{
			onErrors(player);
		}
	}
	public void reload(Player player){
		bptools.clear();
		secret.clear();
		autopilot.clear();
		normal.clear();
		high.clear();
		paintbrush.clear();
		buildbrush.clear();
		
		player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": The Plugin Is " + ChatColor.BLUE + "RELOADED" + ChatColor.WHITE + "!");
	}
	
	public void secret(Player player){
		secret.put(player.getName(), "secret");
		ItemStack wbhead = new ItemStack(Material.WORKBENCH);
			player.getInventory().setHelmet(wbhead);
				player.sendMessage(ChatColor.GREEN + "[BPTools]" + ChatColor.WHITE + ": Goncratulations, You Found The Secret Of This Plugin: " + ChatColor.BLUE + "WORKBENCH HEAD" + ChatColor.WHITE + "! Enjoy Your New Helmet!");
	}
	
	public void onErrors(Player player){
		player.sendMessage(ChatColor.DARK_RED + "We are sorry, but something whent wrong!");
	}
}
