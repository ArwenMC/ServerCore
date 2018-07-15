package io.github.Arwen.events;

import io.github.Arwen.ServerCore;
import io.github.Arwen.commands.FlyCommand;
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

        if (!FlyCommand.flymode.contains(player)) {
            FlyCommand.flymode.remove(player);
            player.setFlying(false);

        } else {
            FlyCommand.flymode.remove(player);
            player.setFlying(false);
        }
    }

}
