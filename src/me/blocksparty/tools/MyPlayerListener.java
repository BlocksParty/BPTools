package me.blocksparty.tools;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

public class MyPlayerListener implements Listener{
	public static Tools plugin;
	
	@EventHandler
	public void handle(PlayerInteractEvent event) {
	ItemStack is = event.getItem();
	ItemStack beans = new MaterialData(Material.INK_SACK, (byte) 3).toItemStack();
	if (is.equals(beans)) {
		Player player = event.getPlayer();
		
		player.sendMessage("YOU ARE FUNNY!");
	}
	}
}