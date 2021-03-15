package net.simpvp.ConnectToEvents;

import org.bukkit.plugin.java.JavaPlugin;



public class ConnectToEvents extends JavaPlugin {

	private static ConnectToEvents instance;
	
	@Override
	public void onEnable( ) {
		setInstance(this);
		this.getServer().getMessenger().registerOutgoingPluginChannel(this,"BungeeCord");
		this.getCommand("event").setExecutor(new EventCommand());
	}
	
	public static ConnectToEvents getInstance() {
		return instance;
	}
	
	private static void setInstance(ConnectToEvents instance) {
		ConnectToEvents.instance = instance;
	}
}
