package com.breachuniverse.core.guis;

import com.breachuniverse.core.Main;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Created by Beheerder on 2/6/2016.
 */
public class ClickEvents implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){

final FileConfiguration config = Main.getPlugin().getConfig();

        if (e.getInventory().getName().equals(new Menus().help().getName())) {
            Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName()
                    .equals(ChatColor.translateAlternateColorCodes('&', config.getString("Help.About.Name")))) p.performCommand("about");
            if (e.getCurrentItem().getItemMeta().getDisplayName()
                    .equals(ChatColor.translateAlternateColorCodes('&', config.getString("Help.Servers.Name")))) p.performCommand("server");
        }




        if(e.getInventory().getName().equals(new Menus().about().getName())){
            e.setCancelled(true);
            Player p = (Player) e.getWhoClicked();

            if(e.getCurrentItem().getItemMeta().getDisplayName()
                    .equals(ChatColor.translateAlternateColorCodes('&', config.getString("About.Hardware.Name"))))
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("About.Hardware.URL")));
        }




        if(e.getInventory().getName().equals(new Menus().servers().getName())){
            e.setCancelled(true);
            Player p = (Player) e.getWhoClicked();

           if(e.getCurrentItem().getItemMeta().getDisplayName()
                   .equals(ChatColor.translateAlternateColorCodes('&', config.getString("Servers.Paintball.Name"))))
               send(p, config.getString("Servers.Paintball.Server"));
        }


















    }



    private void send(Player p, String server) {
        p.playSound(p.getLocation(), Sound.NOTE_PLING, 1, 1);
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(server);
        p.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", out.toByteArray());
    }
}
