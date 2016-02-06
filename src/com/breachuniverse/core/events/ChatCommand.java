package com.breachuniverse.core.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/**
 * Created by Beheerder on 2/6/2016.
 */
public class ChatCommand implements Listener {

    @EventHandler
    public void onChatCommand(PlayerCommandPreprocessEvent e){
        if(e.getMessage().contains("pb") || e.getMessage().contains("/pb")){
            e.setCancelled(true);
            e.getPlayer().performCommand("server pb");
        }
        if(e.getMessage().contains("paintball") || e.getMessage().contains("/paintball")){
            e.setCancelled(true);
            e.getPlayer().performCommand("server pb");
        }
        if(e.getMessage().contains("prison") || e.getMessage().contains("/prison")){
            e.setCancelled(true);
            e.getPlayer().performCommand("server prison");
        }
    }
}
