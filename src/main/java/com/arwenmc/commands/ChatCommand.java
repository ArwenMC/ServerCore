package com.arwenmc.commands;

import com.arwenmc.ServerCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ChatCommand implements CommandExecutor {

    ServerCore plugin;
    public ChatCommand(ServerCore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        return false;
    }

}
