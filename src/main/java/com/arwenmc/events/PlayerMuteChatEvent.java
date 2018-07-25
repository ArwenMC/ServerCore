package com.arwenmc.events;

import com.arwenmc.ServerCore;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerMuteChatEvent implements Listener {

    ServerCore plugin;

    public PlayerMuteChatEvent(ServerCore instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPlayerMuteChatEvent(AsyncPlayerChatEvent event) {
        if (plugin.isChatMuted) {
            event.setCancelled(true);
            Player player = event.getPlayer();
            player.sendMessage(ChatColor.RED + "The chat is currently muted, further attempts to talk with result in a punishment.");
        }
    }

}