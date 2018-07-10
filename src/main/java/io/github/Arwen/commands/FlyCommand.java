package io.github.Arwen.commands;

import io.github.Arwen.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FlyCommand implements CommandExecutor {

    Main plugin;

    public FlyCommand(Main instance) {
        plugin = instance;
    }

    public static ArrayList<Player> flymode = new ArrayList();

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {

            return true;
        }
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("fly")) {
            if (p.hasPermission(plugin.staffFly)) {
                if (!flymode.contains(p)) {
                    flymode.add(p);
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    p.sendMessage(plugin.prefix + plugin.flyEnabled);
                } else {
                    flymode.remove(p);
                    p.setAllowFlight(false);
                    p.setFlying(false);
                    p.sendMessage(plugin.prefix + plugin.flyDisabled);
                }
            }
            else {
                p.sendMessage(plugin.noPermission);
            }
                return true;
            }
        return false;
    }
}