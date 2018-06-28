package io.github.RedShaunia.boxcast;

import java.io.File;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;



public class BoxCast extends JavaPlugin {
	
	FileConfiguration config;
	File cFile;
	
        @Override
	public void onEnable() {
		PluginDescriptionFile pdffile = getDescription();
		Logger logger = getLogger();
		logger.info(pdffile.getName() + " has been enabled (V." + pdffile.getVersion() + ")");
		config = getConfig();
		config.options().copyDefaults(true);
		saveConfig();
		cFile = new File(getDataFolder(), "config.yml");
	}
	
        @Override
	public void onDisable() {
		PluginDescriptionFile pdffile = getDescription();
		Logger logger = getLogger();
		logger.info(pdffile.getName() + " has been disabled (V." + pdffile.getVersion() + ")");
	}

        @Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            
                if (cmd.getName().equalsIgnoreCase("BoxCastReload")) {
                        reloadConfig();
                        sender.sendMessage(ChatColor.GREEN + "Reloaded BoxCast config!");
                        return true;
                }

                if (!(sender instanceof Player)) {
                        sender.sendMessage("You must be a player to use this command!");
                        return false;
                }
	
                Player player = (Player) sender;
                player.sendMessage(ChatColor.DARK_AQUA + "BoxCast Server Infomation");
                Set<String>entries=getConfig().getKeys(false);

                if (args.length==1) {
                        String configEntry=cmd.getName()+args[0];
                        for (String entry:entries) {
                                if (entry.equalsIgnoreCase(configEntry)) {
                                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString(entry)));
                                        return true;
                                }
                        }
                        player.sendMessage("I don't know what to make of "+args[0]);
                        return false;
                }
                else {
                        SortedSet<String> displayItems=new TreeSet<>();
                        for (String entry: entries) {
                                if (entry.toLowerCase().startsWith(cmd.getName().toLowerCase()))
                                        displayItems.add(entry.substring(cmd.getName().length()));
                        }
                        player.sendMessage("/display takes one parameter of "+String.join(", ", displayItems));
                        return true;
                }
	}
}
