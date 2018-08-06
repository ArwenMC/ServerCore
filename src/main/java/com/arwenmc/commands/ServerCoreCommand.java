package com.arwenmc.commands;

import com.arwenmc.SCPermission;
import com.arwenmc.ServerCore;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ServerCoreCommand implements CommandExecutor {

    ServerCore plugin;
    public ServerCoreCommand(ServerCore instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(plugin.NOT_PLAYER);
            return true;
        } else {
            Player player = (Player) commandSender;
            if (player.hasPermission(SCPermission.ADMIN)) {
                if (args.length == 0 ) {
                    player.sendMessage(plugin.MISSING_ARGUMENT);
                    return false;
                } else if (args.length == 1) {
                    switch (args[0]) {
                        case "reload":
                            player.sendMessage(ChatColor.GREEN + "Reload logic goes here.");
                        default:
                            player.sendMessage(plugin.UNKNOWN_ARGUMENT);
                            return false;
                    }
                }
                return true;
            } else {
                player.sendMessage(plugin.NO_PERMISSION);
                return true;
            }
        }
    }

}
