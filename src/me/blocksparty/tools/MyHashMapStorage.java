package me.blocksparty.tools;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class MyHashMapStorage {

	public static Map<String, String> bptools = new HashMap<String, String>();
	public static Map<String, String> secret = new HashMap<String, String>();
	public static Map<String, String> autopilot = new HashMap<String, String>();
	public static Map<String, String> normal = new HashMap<String, String>();
	public static Map<String, String> high = new HashMap<String, String>();
	public static HashMap<Player, Material> paintbrush = new HashMap<Player, Material>();
	public static HashMap<Player, Material> buildbrush = new HashMap<Player, Material>();
}
