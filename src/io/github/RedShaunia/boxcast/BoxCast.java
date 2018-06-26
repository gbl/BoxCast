package io.github.RedShaunia.boxcast;

import java.io.File;
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
	
	public void onEnable() {
		PluginDescriptionFile pdffile = getDescription();
		Logger logger = getLogger();
		logger.info(pdffile.getName() + " has been enabled (V." + pdffile.getVersion() + ")");
		config = getConfig();
		config.options().copyDefaults(true);
		saveConfig();
		cFile = new File(getDataFolder(), "config.yml");
	}
	
	public void onDisable() {
		PluginDescriptionFile pdffile = getDescription();
		Logger logger = getLogger();
		logger.info(pdffile.getName() + " has been disabled (V." + pdffile.getVersion() + ")");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
	    if (!(sender instanceof Player)) {
		    sender.sendMessage("You must be a player to use this command!");
		    return false;
	}
	
	    Player player = (Player) sender;
	    player.sendMessage(ChatColor.DARK_AQUA + "BoxCast Server Infomation");
	    
	    if (cmd.getName().equalsIgnoreCase("DisplayBirthday")) {
		    player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("DisplayBirthday")));
	    }
		    
		    else
		    	
		    	if (cmd.getName().equalsIgnoreCase("DisplayDonate")) {
				    player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("DisplayDonate")));
		    	}
	    
		    	else
		    		
		    	    if (cmd.getName().equalsIgnoreCase("DisplayEmail")) {
		    		    player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("DisplayEmail")));
		    	    }
		    
			    	else
			    		
			    	    if (cmd.getName().equalsIgnoreCase("DisplayForum")) {
			    		    player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("DisplayForum")));
			    	    }
	    
				    	else
				    		
				    	    if (cmd.getName().equalsIgnoreCase("DisplayIP")) {
				    		    player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("DisplayIP")));
				    	    }
					    	else
					    		
					    	    if (cmd.getName().equalsIgnoreCase("DisplayTS")) {
					    		    player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("DisplayTS")));
					    	    }
						    	else
						    		
						    	    if (cmd.getName().equalsIgnoreCase("DisplayTwitch")) {
						    		    player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("DisplayTwitch")));
						    	    }
							    	else
							    		
							    	    if (cmd.getName().equalsIgnoreCase("DisplayTwitter")) {
							    		    player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("DisplayTwitter")));
							    	    }
								    	else
								    		
								    	    if (cmd.getName().equalsIgnoreCase("DisplayWebsite")) {
								    		    player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("DisplayWebsite")));
								    	    }
									    	else
									    		
									    	    if (cmd.getName().equalsIgnoreCase("DisplayYoutube")) {
									    		    player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("DisplayYoutube")));
									    	    }
										    	else
										    		
										    	    if (cmd.getName().equalsIgnoreCase("DisplayClaiming")) {
										    		    player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("DisplayClaiming")));
										    	    }
											    	else
											    		
											    	    if (cmd.getName().equalsIgnoreCase("DisplayGitHub")) {
											    		    player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("DisplayGitHub")));
											    	    }
												    	else
												    		
												    	    if (cmd.getName().equalsIgnoreCase("DisplayRules")) {
												    		    player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("DisplayRules")));
												    	    }
												    	    else
												    			if (cmd.getName().equalsIgnoreCase("BoxCastReload")) {
												    				reloadConfig();
												    				sender.sendMessage(ChatColor.GREEN + "Reloaded BoxCast config!");
												    			}

		return true;

		
	  }
		


	}


