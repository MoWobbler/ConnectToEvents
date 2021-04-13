package net.simpvp.ConnectToEvents;


import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
//
public class PluginMessage implements PluginMessageListener{
	private ConnectToEvents plugin = ConnectToEvents.getInstance();
	@Override
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
		
		if(!channel.equals("BungeeCord"))return;
		
	}
	
	public void connect(Player player, String server) {
		ByteArrayDataOutput output = ByteStreams.newDataOutput();
		output.writeUTF("Connect");
		output.writeUTF(server);
		
		player.sendPluginMessage(plugin,"BungeeCord",output.toByteArray());
	}
	
	
}

