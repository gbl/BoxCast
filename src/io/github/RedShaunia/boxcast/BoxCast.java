package io.github.RedShaunia.boxcast;

import java.io.File;
import java.util.Set;
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
                for (String entry:entries) {
                        if (entry.equalsIgnoreCase(cmd.getName())) {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString(entry)));
                                return true;
                        }
                }
                player.sendMessage("I don't know what to make of "+cmd.getName());
                return false;
	}
}
