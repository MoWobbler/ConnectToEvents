package net.simpvp.ConnectToEvents;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class EventCommand implements CommandExecutor{
	private PluginMessage pluginMessage = new PluginMessage();
	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
						
			if (command.getName().equalsIgnoreCase("event")) {
					pluginMessage.connect(player, "EventWorld");
			}
		}
		
		return true;
	}
}
