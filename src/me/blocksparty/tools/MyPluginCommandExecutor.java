package me.blocksparty.tools;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MyPluginCommandExecutor implements CommandExecutor {	 
	private Tools plugin;
	public static MyMethodsStorage myMethodsStorage;
	
		public MyPluginCommandExecutor(Tools plugin) {
			this.plugin = plugin;
		}
 
			@Override
			public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
				Player player = null;
				
					if (sender instanceof Player) {
						player = (Player) sender;
					
							if(commandLabel.equalsIgnoreCase("bptools")){
								if(args.length == 0){
									myMethodsStorage.bptools(player);
									
								}else if(args[0].equalsIgnoreCase("list") || args[0].equalsIgnoreCase("l")){
									myMethodsStorage.list(player);
									
								}else if(args[0].equalsIgnoreCase("enable") || args[0].equalsIgnoreCase("e")){
									myMethodsStorage.enable(player);
									
								}else if(args[0].equalsIgnoreCase("disable") || args[0].equalsIgnoreCase("d")){
									myMethodsStorage.disable(player);
									
								}else if(args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("r")){
									myMethodsStorage.reload(player);
									
								}else if(args[0].equalsIgnoreCase("secret")){
									myMethodsStorage.secret(player);
								}
							}
					}
					return false;
			}
}