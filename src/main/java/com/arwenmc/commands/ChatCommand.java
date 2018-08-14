package com.arwenmc.commands;

import com.arwenmc.SCConfig;
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
    public ChatCommand(ServerCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(plugin.NOT_PLAYER);
            return true;
        } else {
            Player player = (Player) commandSender;
            if (plugin.config.permissionCheck(player, SCConfig.CommandPermissions.CHAT)) {

            } else {
                player.sendMessage(plugin.NO_PERMISSION);
                return true;
            }
        }
        return false;
    }

    @EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent event) {
        //
    }

}
