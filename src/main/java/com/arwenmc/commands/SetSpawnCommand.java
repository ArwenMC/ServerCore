package io.github.Arwen.commands;

import io.github.Arwen.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    Main plugin;

    public SetSpawnCommand(Main instance) {
        plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (((sender instanceof Player)) &&
                (cmd.getName().equalsIgnoreCase("setspawn"))) {
            Player p = (Player) sender;
            if (p.hasPermission(plugin.Admin)) {
                p.sendMessage(plugin.setSpawnMessage);
                Location loc = player.getLocation();
                int x = loc.getBlockX();
                int y = loc.getBlockY();
                int z = loc.getBlockZ();
                player.getWorld().setSpawnLocation(x, y, z);
                return true;
            }
        }
        return false;
    }
}
