package com.arwenmc.commands;

import com.arwenmc.SCPermission;
import com.arwenmc.ServerCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatCommand implements CommandExecutor, Listener {

    ServerCore plugin;
    public ChatCommand(ServerCore instance) {
        plugin = instance;
    }

    private boolean isChatMuted;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {

        } else {
            Player player = (Player) commandSender;
            if (new SCPermission().permissionCheck(player, SCPermission.ConfigPath.CHAT)) {
                if (isChatMuted) {
                    player.sendMessage("");
                }
            } else {
                player.sendMessage(plugin.NO_PERMISSION);
                return true;
            }
        }
    }

    @EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent event) {
        if (isChatMuted) {
            if (!(new SCPermission().permissionCheck(event.getPlayer(), SCPermission.ConfigPath.CHAT_BYPASS))) {
                event.setCancelled(true);
            }
        }

    }
}