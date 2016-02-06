package com.breachuniverse.core;

import com.breachuniverse.core.guis.ClickEvents;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Beheerder on 2/5/2016.
 */
public class Main extends JavaPlugin implements Listener{

    private static Plugin plugin;

    public static Plugin getPlugin(){
        return plugin;
    }

    public void onEnable(){
        plugin = this;
        config();
        registerCommands();
        registerListener();
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

    }
    public void onDisable(){
        plugin = null;
    }
    private void config(){
        getConfig().addDefault("Basic.Website", "&a>> &b&lhttps://www.beachuniverse.com");
        getConfig().addDefault("Basic.TS", "&a>> &b&lbreachuniverse.com");
        getConfig().addDefault("Help.Main.Name", "&5Help Menu.");

        getConfig().addDefault("Help.About.Name","&5About Breach Universe.");
        getConfig().addDefault("Help.About.Lore", "&bDo you want to know the secrets of Breach Universe?\nOr do you want to know who the founders are?\n&2It`s possibile to see if you click me :D");

        getConfig().addDefault("Help.Servers.Name", "&6Server inventory.");
        getConfig().addDefault("Help.Servers.Lore", "&b&lConnect quick to a server!");

        getConfig().addDefault("About.Founders.Name", "&aFounders");
        getConfig().addDefault("About.Founders.Lore", "&3The founders of Breach Universe are:\n&bHeadhunterz\n&cExperminator");

        getConfig().addDefault("About.Hardware.Name", "&bServer Hardware");
        getConfig().addDefault("About.Hardware.Lore", "&bCPU: Intel Core I7-4790K Overclocked to 5.0Ghz\nRAM: 32GB\nMotherboard: Asus Z97-P\nDrives: 2x Samsung 850 EVO 500GB SSD and 1x WD RED 4TB\nPower Supply: Cooler Master GM650 (650 watt)\n&cClick here to get the URL and gain more information about the server hardware!");
        getConfig().addDefault("About.Hardware.URL", "https://breachuniverse.com/pages/Server-Hardware/");




        getConfig().addDefault("Servers.Connect.Lore","&bClick to join!");


        getConfig().addDefault("Servers.Paintball.Name", "&bPaintball");
        getConfig().addDefault("Servers.Paintball.Server", "pb");



        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

    private void registerCommands(){
        getCommand("ts").setExecutor(new AllCmds());
        getCommand("website").setExecutor(new AllCmds());
        getCommand("help").setExecutor(new AllCmds());
        getCommand("server").setExecutor(new AllCmds());
        getCommand("breachcore").setExecutor(new AllCmds());
    }
    private void registerListener(){
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new ClickEvents(), this);
    }
}
