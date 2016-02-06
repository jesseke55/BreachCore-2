package com.breachuniverse.core;

import com.breachuniverse.core.guis.Menus;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

/**
 * Created by Beheerder on 2/5/2016.
 */
public class AllCmds implements Listener, CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args)
    {
if(cmd.getName().equalsIgnoreCase("website")){
    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Basic.Website")));
}
        if(cmd.getName().equalsIgnoreCase("ts")){
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Basic.TS")));
        }

        if(cmd.getName().equalsIgnoreCase("help")){
            if(sender instanceof Player){
                sender.sendMessage("You are not a player!");
            }
            else{
                Player p=(Player)sender;
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Opening help menu for you!"));
                p.openInventory(new Menus().help());
            }
        }

        if(cmd.getName().equalsIgnoreCase("server")){
            if(sender instanceof Player){
                sender.sendMessage("You are not a player!");
            }else{
                Player p = (Player)sender;
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Opening server menu for you!"));
                p.openInventory(new Menus().servers());
            }

        }

        if(cmd.getName().equalsIgnoreCase("about")){
            if(sender instanceof Player){
                sender.sendMessage("You are not a player!");
            }else{
                Player p = (Player)sender;
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "Opening about menu for you!"));
                p.openInventory(new Menus().about());
            }
        }












        if(cmd.getName().equalsIgnoreCase("breachcore")){
            if(args.length ==0){
                sender.sendMessage("Please use a arg!");
            }
            if(args[1].equalsIgnoreCase("reloadconfig")){
                Main.getPlugin().reloadConfig();
                sender.sendMessage("The config has been reloaded!");
            }
        }

        return true;
    }
}
