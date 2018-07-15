package com.arwenmc.commands;

import com.arwenmc.ServerCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class HelpCommand implements CommandExecutor {

    ServerCore plugin;

    public HelpCommand(ServerCore instance) {
        plugin = instance;
    }
    public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("help")) {
            List<String> message = plugin.getConfig().getStringList("Help.Message");
            for (String msg : message)
            {
                msg =
                        msg.replace('&', '§');
                player.sendMessage( msg);
            }
        }
            return false;
        }
    }