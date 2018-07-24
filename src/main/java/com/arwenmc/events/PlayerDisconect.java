package com.arwenmc.events;

import com.arwenmc.ServerCore;
import com.arwenmc.commands.FlyCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerDisconect implements Listener {

    ServerCore plugin;

    public PlayerDisconect(ServerCore instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPlayerDisconect(PlayerQuitEvent event) {

        Player player = event.getPlayer();

        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());

        if (!FlyCommand.flymode.contains(player)) {
            FlyCommand.flymode.remove(player);
            player.setFlying(false);

        } else {
            FlyCommand.flymode.remove(player);
            player.setFlying(false);
        }
    }

}
