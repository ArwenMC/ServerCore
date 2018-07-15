package io.github.Arwen.events;

import io.github.Arwen.ServerCore;
import io.github.Arwen.api.ActionBar;
import io.github.Arwen.api.Title;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class FirstPlayerJoin implements Listener {

    ServerCore plugin;

    public FirstPlayerJoin(ServerCore instance) {
        plugin = instance;
    }

    @EventHandler
    public void onFirstPlayerJoinEvent(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        if (!player.hasPlayedBefore()) {
            ActionBar.send(player, plugin.actionbarwelcome);
            player.sendMessage(plugin.welcome);
        } else {

            if (player.hasPlayedBefore()) {
                ActionBar.send(player, plugin.actionbarwelcomeback);
                player.sendMessage(plugin.welcomeback);
            }
        }
    }
}
