package net.simpvp.ConnectToEvents;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Zombie;
import org.bukkit.potion.PotionEffectType;

public class EventCommand implements CommandExecutor{
	private PluginMessage pluginMessage = new PluginMessage();
	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			/* Checks that they do not fail the teleportCheck (combatlog check) */
			String tCheck = teleportCheck(player);
			if (tCheck != null) {
				player.sendMessage(tCheck);
				return true;
			}
			
			if (command.getName().equalsIgnoreCase("event")) {
					pluginMessage.connect(player, "EventWorld");
			}
		}
		
		return true;
	}
	
	//Teleport check code from c4k3 PvPTeleport
	private static String teleportCheck(Player player) {

		Location pLoc = player.getLocation();

		World world = player.getWorld();

		/* Check if there are any players within 50 blocks */
		for (Player p : world.getPlayers()) {

			if (!p.equals(player)
					&& p.getLocation().distance(pLoc) < 50
					&& player.canSee(p)
					&& !p.isDead()) {
				return ChatColor.RED + "You cannot use this command while within 50 blocks of any other players.";
			}

		}

		/* Check if there are any hostile mobs within 5 blocks */
		for (Entity entity : world.getEntitiesByClasses(
					Blaze.class,
					CaveSpider.class,
					Creeper.class,
					Enderman.class,
					Ghast.class,
					MagmaCube.class,
					PigZombie.class,
					Skeleton.class,
					Silverfish.class,
					Slime.class,
					Spider.class,
					Witch.class,
					Zombie.class)) {

			if (entity.getLocation().distance(pLoc) < 5) {
				return ChatColor.RED + "You cannot use this command while within 5 blocks of any hostile mobs.";
			}

		}

		/* Check if the player is falling */
		if (player.getVelocity().getY() < -0.079
				|| player.getVelocity().getY() > 0.08) {
			return ChatColor.RED + "You cannot use this command while falling.";
		}

		/* Check if the player is burning */
		if (player.getFireTicks() > 0
				&& !player.hasPotionEffect(
					PotionEffectType.FIRE_RESISTANCE)) {
			return ChatColor.RED + "You cannot use this command while on fire.";
		}

		/* Default to allow teleport */
		return null;

	}
	
	
}
