package io.github.Arwen.events;

import io.github.Arwen.Main;
import io.github.Arwen.api.ActionBar;
import io.github.Arwen.api.Title;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class FirstPlayerJoin implements Listener {

    Main plugin;

    public FirstPlayerJoin(Main instance) {
        plugin = instance;
    }

    @EventHandler
    public void onFirstPlayerJoinEvent(PlayerJoinEvent event) {

        Title Welcome = new Title(plugin.actionbarwelcome, "",1, 100, 2);

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
