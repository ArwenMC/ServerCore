package com.arwenmc.events;

import com.arwenmc.api.ActionBar;
import com.arwenmc.ServerCore;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;

import java.util.Arrays;

public class FirstPlayerJoin implements Listener {

    ServerCore plugin;

    public FirstPlayerJoin(ServerCore instance) {
        plugin = instance;
    }

    @EventHandler
    public void onFirstPlayerJoinEvent(PlayerJoinEvent event) {

        Title Welcome = new Title(plugin.actionbarwelcome, "", 1, 100, 2);

        Player player = event.getPlayer();

        if (!player.hasPlayedBefore()) {
            ActionBar.send(player, plugin.actionbarwelcome);
            player.sendMessage(plugin.welcome);
            Welcome.send(player);

        } else {

            if (player.hasPlayedBefore()) {
                ActionBar.send(player, plugin.actionbarwelcomeback);
                player.sendMessage(plugin.welcomeback);
            }
        }
    }
}
