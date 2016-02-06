package com.breachuniverse.core.guis;

import com.breachuniverse.core.Main;
import com.breachuniverse.core.util.ItemBuilder;
import com.breachuniverse.core.util.MenuBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;

/**
 * Created by Beheerder on 2/6/2016.
 */
public class Menus {

    public Inventory help(){
        final FileConfiguration config = Main.getPlugin().getConfig();

        MenuBuilder menu = new MenuBuilder(45, ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Help.Main.Name")));




        menu.addItem(0, new ItemBuilder(Material.APPLE).name(ChatColor.translateAlternateColorCodes('&', config.getString("Help.About.Name"))).lore(ChatColor.translateAlternateColorCodes('&', config.getString("Help.About.Lore"))).getStack());

        menu.addItem(1, new ItemBuilder(Material.CHEST).name(ChatColor.translateAlternateColorCodes('&', config.getString("Help.Servers.Name"))).lore(ChatColor.translateAlternateColorCodes('&', config.getString("Help.Servers.Lore"))).getStack());


        // TODO: 2/5/2016 Ik moet wat items adden en ook nog lores



        return menu.getInventory();


    }

    public Inventory about(){

        final FileConfiguration config = Main.getPlugin().getConfig();
        MenuBuilder menu = new MenuBuilder(9, ChatColor.translateAlternateColorCodes('&', config.getString("Help.About.Name")));

        menu.addItem(0, new ItemBuilder(Material.SKULL)
                .name(ChatColor.translateAlternateColorCodes('&', config.getString("About.Founders.Name")))
                .lore(ChatColor.translateAlternateColorCodes('&', config.getString("About.Founders.Lore"))).getStack());

        menu.addItem(1, new ItemBuilder(Material.COMPASS)
        .name(ChatColor.translateAlternateColorCodes('&', config.getString("About.Hardware.Name")))
        .lore(ChatColor.translateAlternateColorCodes('&', config.getString("About.Hardware.Lore"))).getStack());

        return menu.getInventory();
    }


    public Inventory servers(){
        final FileConfiguration config = Main.getPlugin().getConfig();
        MenuBuilder menu = new MenuBuilder(9, ChatColor.translateAlternateColorCodes('&', config.getString("Help.Servers.Name")));



        menu.addItem(0, new ItemBuilder(Material.SNOW_BALL)
        .name(ChatColor.translateAlternateColorCodes('&', config.getString("Servers.Paintball.Name")))
        .lore(ChatColor.translateAlternateColorCodes('&', config.getString("Servers.Connect.Lore"))).getStack());



        return menu.getInventory();
    }



}
