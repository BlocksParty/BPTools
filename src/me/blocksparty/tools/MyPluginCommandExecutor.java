package me.blocksparty.tools;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MyPluginCommandExecutor implements CommandExecutor {	 
	public MyPluginCommandExecutor(Tools plugin) {
	}
 
			@Override
			public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
				Player player = null;
				
					if (sender instanceof Player) {
						player = (Player) sender;
					
							if(commandLabel.equalsIgnoreCase("bptools")){
								if(args.length == 0){
									MyMethodsStorage.bptools(player);
									
								}else if(args[0].equalsIgnoreCase("list") || args[0].equalsIgnoreCase("l")){
									MyMethodsStorage.list(player);
									
								}else if(args[0].equalsIgnoreCase("enable") || args[0].equalsIgnoreCase("e")){
									MyMethodsStorage.enable(player);
									
								}else if(args[0].equalsIgnoreCase("disable") || args[0].equalsIgnoreCase("d")){
									MyMethodsStorage.disable(player);
									
								}else if(args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("r")){
									MyMethodsStorage.reload(player);
									
								}else if(args[0].equalsIgnoreCase("secret")){
									MyMethodsStorage.secret(player);
								}
							}
					}
					return false;
			}
}