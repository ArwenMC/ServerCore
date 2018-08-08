package com.arwenmc.commands;

import com.arwenmc.SCPermission;
import com.arwenmc.ServerCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    ServerCore plugin;

    public FlyCommand(ServerCore instance) {
        plugin = instance;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(plugin.NOT_PLAYER);
            return true;
        } else {
            Player player = (Player) commandSender;
            if (new SCPermission().permissionCheck(player, SCPermission.ConfigPath.FLY)) {
                // flying logic here.
                return true;
            } else {
                player.sendMessage(plugin.NO_PERMISSION);
                return true;
            }
        }
    }

}
