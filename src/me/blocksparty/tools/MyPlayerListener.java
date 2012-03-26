package me.blocksparty.tools;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.util.Vector;

public class MyPlayerListener implements Listener{
	public static Tools plugin;
	
	static Map<String, String> bptools = MyHashMapStorage.bptools;
	static Map<String, String> secret = MyHashMapStorage.secret;
	static Map<String, String> autopilot = MyHashMapStorage.autopilot;
	static Map<String, String> normal = MyHashMapStorage.normal;
	static Map<String, String> high = MyHashMapStorage.high;
	static HashMap<Player, Material> paintbrush = MyHashMapStorage.paintbrush;
	static HashMap<Player, Material> buildbrush = MyHashMapStorage.buildbrush;

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		
		if (bptools.isEmpty()) return;
		if (!event.hasItem()) return;
		
			MaterialData materialdata = event.getItem().getData();
			MaterialData inksac = new MaterialData(Material.INK_SACK, (byte) 0);
			MaterialData rosered = new MaterialData(Material.INK_SACK, (byte) 1);
			MaterialData cactusgreen = new MaterialData(Material.INK_SACK, (byte) 2);
			MaterialData cocoabeans = new MaterialData(Material.INK_SACK, (byte) 3);
			MaterialData lapislazuli = new MaterialData(Material.INK_SACK, (byte) 4);
			MaterialData purpledye = new MaterialData(Material.INK_SACK, (byte) 5);
			MaterialData cyandye = new MaterialData(Material.INK_SACK, (byte) 6);
			
		if(materialdata.equals(inksac)){
				if(event.getAction() == Action.RIGHT_CLICK_AIR){
					event.setCancelled(true);
						if(!autopilot.containsKey(player.getName())){
							autopilot.put(player.getName(), "autopilot");
							player.sendMessage(ChatColor.LIGHT_PURPLE + "The AutoPilot is Enable, and the speed is set to; Slow!");
							event.setCancelled(true);
						}else if(autopilot.containsKey(player.getName())){
							if(!normal.containsKey(player.getName())){
								normal.put(player.getName(), "speed");
								player.sendMessage(ChatColor.LIGHT_PURPLE + "The AutoPilot speed is set to; Normal!");
							}else if(normal.containsKey(player.getName()) && !high.containsKey(player.getName())){
								high.put(player.getName(), "speed");
								player.sendMessage(ChatColor.LIGHT_PURPLE + "The AutoPilot speed is set to; High!");
							}else if(normal.containsKey(player.getName()) && high.containsKey(player.getName())){
								normal.remove(player.getName());
								high.remove(player.getName());
								player.sendMessage(ChatColor.LIGHT_PURPLE + "The AutoPilot speed is set to; Slow!");
							}
					}
			}else if(event.getAction() == Action.LEFT_CLICK_AIR){
				event.setCancelled(true);
					if(autopilot.containsKey(player.getName())){
						autopilot.remove(player.getName());
						normal.remove(player.getName());
						high.remove(player.getName());
						player.sendMessage(ChatColor.LIGHT_PURPLE + "The AutoPilot is Disable!");
						event.setCancelled(true);
				}
			}
		}else if(materialdata.equals(rosered)){
				if(event.getAction() == Action.LEFT_CLICK_AIR){
					Vector newVec = player.getLocation().getDirection().multiply(10.0);
		            newVec.setY(newVec.getY()/1.1);
		            player.setVelocity(newVec);
		            player.sendMessage(ChatColor.LIGHT_PURPLE + "Svosj!");
		            event.setCancelled(true);
				}else if(event.getAction() == Action.RIGHT_CLICK_AIR){
					Block targetblock = player.getTargetBlock(null, 50);
						if(targetblock instanceof Block){
							Block block = targetblock.getRelative(BlockFace.UP);
							Location location = block.getLocation();
							location.setYaw(player.getLocation().getYaw());
							location.setPitch(player.getLocation().getPitch());
							player.teleport(location);
							player.sendMessage(ChatColor.LIGHT_PURPLE + "Svisj!");
							event.setCancelled(true);
						}
				}
			
			
		}else if(materialdata.equals(cactusgreen)){
			event.setCancelled(true);
				if(event.getAction() == Action.RIGHT_CLICK_AIR){
					Block targetblock = player.getTargetBlock(null, 50);
					targetblock.setType(Material.AIR);
					event.setCancelled(true);
				}else if(event.getAction() == Action.LEFT_CLICK_BLOCK){
					Block clickedblock = event.getClickedBlock();
					clickedblock.setType(Material.AIR);
					event.setCancelled(true);
				}
		}else if(materialdata.equals(cocoabeans)){
			event.setCancelled(true);
				if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
					Block clickedblock = event.getClickedBlock();
					Material material = clickedblock.getType();
					ItemStack itemstack = new ItemStack(material, 64);
					player.getInventory().addItem(itemstack);
					player.updateInventory();
					player.sendMessage(ChatColor.LIGHT_PURPLE + "Enjoy Your; " + ChatColor.WHITE + material + ChatColor.LIGHT_PURPLE + "!");
				}
		}else if(materialdata.equals(lapislazuli)){
			event.setCancelled(true);
				if(event.getAction() == Action.LEFT_CLICK_BLOCK){
					Block clickedblock = event.getClickedBlock();
					Material material = clickedblock.getType();
					paintbrush.put(event.getPlayer(), event.getClickedBlock().getType());
					player.sendMessage(ChatColor.LIGHT_PURPLE + "The Paint Brush Is Set To; " + ChatColor.WHITE + material + ChatColor.LIGHT_PURPLE + "!");
				}else if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
					if (paintbrush.isEmpty()) return;
						event.getClickedBlock().setType(paintbrush.get(event.getPlayer()));
						player.sendMessage(ChatColor.LIGHT_PURPLE + "Splat!");
				}else if(event.getAction() == Action.RIGHT_CLICK_AIR){
					if (paintbrush.isEmpty()) return;
					Block targetblock = player.getTargetBlock(null, 50);
					Block block = targetblock;
					block.setType(paintbrush.get(event.getPlayer()));
					player.sendMessage(ChatColor.LIGHT_PURPLE + "Splat!");
			}
		}else if(materialdata.equals(purpledye)){
			event.setCancelled(true);
				if(event.getAction() == Action.LEFT_CLICK_BLOCK){
					Block clickedblock = event.getClickedBlock();
					Material material = clickedblock.getType();
					buildbrush.put(event.getPlayer(), event.getClickedBlock().getType());
					player.sendMessage(ChatColor.LIGHT_PURPLE + "The Build Brush Is Set To; " + ChatColor.WHITE + material + ChatColor.LIGHT_PURPLE + "!");
				}else if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
					if (buildbrush.isEmpty()) return;
						Block clickedblock = event.getClickedBlock();
						Block block = clickedblock.getRelative(BlockFace.UP);
						block.setType(buildbrush.get(event.getPlayer()));
						player.sendMessage(ChatColor.LIGHT_PURPLE + "Poof!");
				}else if(event.getAction() == Action.RIGHT_CLICK_AIR){
					if (buildbrush.isEmpty()) return;
					Block targetblock = player.getTargetBlock(null, 50);
					Block block = targetblock.getRelative(BlockFace.UP);
					block.setType(buildbrush.get(event.getPlayer()));
					player.sendMessage(ChatColor.LIGHT_PURPLE + "Poof!");
			}
		}else if(materialdata.equals(cyandye)){
			event.setCancelled(true);
				if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
					Block b = event.getClickedBlock();
					   Chunk chunk = b.getChunk();
					   int minX = chunk.getX() * 16;
					   int minZ = chunk.getZ() * 16;
					   int maxX = (chunk.getX() * 16) + 16;
					   int maxZ = (chunk.getZ() * 16) + 16;
					   for(int x = 0; x + minX < maxX; x++){
					    for(int z = 0; z + minZ < maxZ; z++){
					     for(int y = 0; y < b.getWorld().getMaxHeight(); y++){
					    	 b.getWorld().getBlockAt(x + minX, y, z + minZ).setType(Material.AIR);
					     }
					    }
					   }
					
				}else if(event.getAction() == Action.LEFT_CLICK_BLOCK){
					 Block b = event.getClickedBlock();
					 	Material origMat = b.getType();
				        Chunk chunk = b.getChunk();
				        int minX = chunk.getX() * 16;
				        int minZ = chunk.getZ() * 16;
				        int maxX = (chunk.getX() * 16) + 16;
				        int maxZ = (chunk.getZ() * 16) + 16;
				        for(int x = 0; x + minX < maxX; x++){
				         for(int z = 0; z + minZ < maxZ; z++){
				          for(int y = 0; y < b.getWorld().getMaxHeight(); y++){
				           Block selb = b.getWorld().getBlockAt(x + minX, y, z + minZ);
				           if(selb.getType().equals(origMat)){
				            selb.setType(Material.AIR);
				           }
				          }
				            }
				        }
				}
		}
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event){
		Player player = event.getPlayer();
		
		if(autopilot.containsKey(player.getName())){
			if(!normal.containsKey(player.getName())){
				Vector newVec = player.getLocation().getDirection().multiply(0.5);
				newVec.setY(newVec.getY()/1.1);
				player.setVelocity(newVec);
			}else if(normal.containsKey(player.getName()) && !high.containsKey(player.getName())){
				Vector newVec = player.getLocation().getDirection().multiply(2.5);
				newVec.setY(newVec.getY()/1.1);
				player.setVelocity(newVec);
			}else if(normal.containsKey(player.getName()) && high.containsKey(player.getName())){
				Vector newVec = player.getLocation().getDirection().multiply(5.0);
				newVec.setY(newVec.getY()/1.1);
				player.setVelocity(newVec);
			}
		}
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event){
		if(event.getEntity() instanceof Player){
			Player player = (Player) event.getEntity();
		    	if(bptools.containsKey(player.getName())){
		    		event.setCancelled(true);
		    	}
			}
	}
}