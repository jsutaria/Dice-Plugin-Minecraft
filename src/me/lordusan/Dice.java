package me.lordusan;

import java.util.Random;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Dice extends JavaPlugin {
	Random rand = new Random(); 
	public void onEnable() {
		
	}
	@Override
	public void onDisable() {
		
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("dice") && sender instanceof Player) {
			Player player = (Player) sender;
			if (sender.hasPermission("dice.allow")) {
				if (args.length > 0) {
					try
				    {
				      // the String to int conversion happens here
				      int num = Integer.parseInt(args[0].trim());
				      if (num > 100 || num < 2) {
							sender.sendMessage(ChatColor.GRAY + "(" + ChatColor.BLUE + "Dice" + ChatColor.GRAY + ") " +  ChatColor.LIGHT_PURPLE + 
									"Error: you can only have a dice from 2 - 100 sides");
				      }
				      else {
				    	  try {
				    		  player.addAttachment(this, "essentials.chat.color", true);
				    		  player.chat(ChatColor.LIGHT_PURPLE + "rolled a " + ChatColor.BLUE  + 
					    			  Integer.toString(rand.nextInt(num) + 1) + ChatColor.LIGHT_PURPLE + " on a " + 
					    			  ChatColor.BLUE + args[0] + ChatColor.LIGHT_PURPLE + " sided dice");
				    		  player.addAttachment(this, "essentials.chat.color", false);
				    		  }
				    	  catch (Exception ex) {
				    	        ex.printStackTrace();
				    	      }
				    	  finally {player.addAttachment(this, "essentials.chat.color", false);}
				      }
				    }
				    catch (NumberFormatException nfe)
				    {
				      System.out.println("NumberFormatException: " + nfe.getMessage());
				      	sender.sendMessage(ChatColor.GRAY + "(" + ChatColor.BLUE + "Dice" + ChatColor.GRAY + ") " +  ChatColor.LIGHT_PURPLE + 
								"Error: we dont support non-number dice");
				    }
				}
				else {
					sender.sendMessage(ChatColor.GRAY + "(" + ChatColor.BLUE + "Dice" + ChatColor.GRAY + ") " +  ChatColor.LIGHT_PURPLE + 
							"Error: usage /dice <number>");

				}
			}
		}
		return true;
		
	}
}
