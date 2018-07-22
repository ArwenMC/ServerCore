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

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (plugin.HELP_ENABLED) {
            for (String msg : plugin.HELP_MESSAGES()) { // already coloured in the main class.
                commandSender.sendMessage(msg);
            }
        } else {
            commandSender.sendMessage(plugin.COMMAND_DISABLED);
        }
        return true;
    }
}