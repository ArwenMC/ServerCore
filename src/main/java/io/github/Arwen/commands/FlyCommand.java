package io.github.Arwen.commands;

import io.github.Arwen.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class FlyCommand implements CommandExecutor {

    ArrayList<UUID> flying = new ArrayList<>();

    Main plugin;
    public FlyCommand(Main instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.hasPermission(plugin.staffFly)) {
                if (flying.contains(player.getUniqueId())) {
                    player.setFlying(true);
                    player.sendMessage(ChatColor.GREEN + "You are now flying!");
                    return true;
                } else {
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    player.sendMessage(ChatColor.RED + "You are no longer flying!");
                    return true;
                }
            } else {
                player.sendMessage(plugin.noPermission);
                return true;
            }
        } else {
            commandSender.sendMessage(plugin.notPlayer);
            return true;
        }
    }
}
