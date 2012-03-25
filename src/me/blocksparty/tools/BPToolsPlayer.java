package me.blocksparty.tools;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public final class BPToolsPlayer {

	private static HashMap<Player, BPToolsPlayer> players = null;

	static BPToolsPlayer getPlayer(Player player) {
		BPToolsPlayer r = getPlayers().get(player);
		if (r == null) {
			r = new BPToolsPlayer(player);
			players.put(player, r);
		}
		return r;
	}

	static HashMap<Player, BPToolsPlayer> getPlayers() {
		if (players == null) {
			players = new HashMap<>();
		}
		return new HashMap<>(players);
	}

	static void reset() {
		players = null;
	}

	private final Player player;

	private Tool selectedTool = null;

	private Location selectionOne = null;

	private Location selectionTwo = null;

	private BPToolsPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public Tool getSelectedTool() {
		return selectedTool;
	}

	public Location getSelectionOne() {
		return selectionOne;
	}

	public Location getSelectionTwo() {
		return selectionTwo;
	}

	public void setSelectedTool(Tool selectedTool) {
		this.selectedTool = selectedTool;
	}

	public void setSelectionOne(Location selectionOne) {
		this.selectionOne = selectionOne;
	}

	public void setSelectionTwo(Location selectionTwo) {
		this.selectionTwo = selectionTwo;
	}

}
