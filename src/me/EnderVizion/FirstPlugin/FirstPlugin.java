package me.EnderVizion.FirstPlugin;

import java.util.logging.Logger;

import me.confuser.barapi.BarAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public final class FirstPlugin extends JavaPlugin{
	public final Logger logger = Logger.getLogger("Minecraft");
	public static FirstPlugin plugin;
	public String[] playerList;
	
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info("[" + pdfFile.getName() + " V." + pdfFile.getVersion() + "]" + " DISABLED, Bye Bye!");
	}

	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info("[" + pdfFile.getName() + " V." + pdfFile.getVersion() + "]" + " ENABLED, Hi There!");
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("website")){
			sender.sendMessage(ChatColor.AQUA + "Join our website! Heres the link:");
			sender.sendMessage(ChatColor.GOLD + "http://legacy-raid.enjin.com");
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("stafflist")){
			sender.sendMessage(ChatColor.LIGHT_PURPLE + "--------------");
			sender.sendMessage(ChatColor.AQUA + "Staff List");
			sender.sendMessage(ChatColor.LIGHT_PURPLE + "--------------");
			sender.sendMessage(ChatColor.DARK_RED + "Owners:");
			sender.sendMessage(ChatColor.GOLD + "EnderVizion");
			sender.sendMessage(ChatColor.GOLD + "InfectedHumour");
			sender.sendMessage(ChatColor.RED + "Admins:");
			sender.sendMessage(ChatColor.GOLD + "dwarf_master97");
			sender.sendMessage(ChatColor.LIGHT_PURPLE + "--------------");
			return true;
			
		}
		if(cmd.getName().equalsIgnoreCase("helpme")){
			Player playersender = (Player) sender;
			Location location = playersender.getLocation();
			String xpos = "X:" + Math.round(location.getX()) + " ";
			String ypos = "Y:" + Math.round(location.getY()) + " ";
			String zpos = "Z:" + Math.round(location.getZ()) + " ";
			for (Player p : Bukkit.getOnlinePlayers()) {
			    if (p.isOp()) {
			    	p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 10, 1);
			    	p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.MAGIC + "XXX" +ChatColor.RED + "" +  playersender.getDisplayName() + " has asked for help at " + xpos + ypos + zpos + ChatColor.DARK_RED + "" + ChatColor.MAGIC + "XXX") ;
			    	sender.sendMessage(ChatColor.GREEN + "" + p.getName() + " has been sent your request! " + p.getName() + " should be with you soon!");
			    }
			}
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("rateserver")){
			if (args.length == 1){
				String rating = args[0];
					for (Player p : Bukkit.getOnlinePlayers()) {
						if(p.isOp()){
							p.sendMessage(ChatColor.GREEN + sender.getName() + " has rated the server " + rating);
							p.sendMessage(ChatColor.GREEN + "Maybe send " + sender.getName() + " 3 diamond?");
							return true;
						}
					}
				}
			else{
				sender.sendMessage(ChatColor.RED + "Incorrect Number of Arguments!");
				sender.sendMessage(ChatColor.RED + "Usage: /rateserver <comment>");
				return true;
			}
			
		}
		if(cmd.getName().equalsIgnoreCase("dropcountdown")){
			for (Player p : Bukkit.getOnlinePlayers()){
				p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 10, 1);
				p.sendMessage(ChatColor.GOLD + "DROPPARTY COUNTDOWN HAS STARTED!");
				BarAPI.setMessage(p, "DropParty Countdown!", 60);
				return true;
			}
		}
		return false;
	}
}