package io.github.Arwen.commands;

import io.github.Arwen.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FlyCommand implements CommandExecutor {

    ArrayList<Player> flying = new ArrayList<Player>();

    Main plugin;

    public FlyCommand(Main instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("fly")) {
            if ((sender instanceof Player)) {
                Player player = (Player) sender;

                if (player.hasPermission(plugin.staffFly)) {
                    if (player.getAllowFlight()) {
                        player.setFlying(false);
                        player.setAllowFlight(false);
                        player.sendMessage("Disabled fly mode!");
                    } else {
                        player.setAllowFlight(true);
                        player.setFlySpeed(0.1F);
                        player.sendMessage("Enabled fly mode!");
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }
}