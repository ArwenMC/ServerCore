package com.arwenmc.commands;

import com.arwenmc.ServerCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class SpawnCommand implements CommandExecutor {

    ServerCore plugin;

    public SpawnCommand(ServerCore instance) {
        plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if ((!(sender instanceof Player)) || (
                (cmd.getName().equalsIgnoreCase("spawn"))))

        {
            World w = (World) Bukkit.getWorlds().get(0);
            player.sendMessage(plugin.spawnMessage);
            player.teleport(w.getSpawnLocation());
            if (plugin.spawnSound) {
                player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 20.0F, 0.0F);
            }
        }
        return true;
    }
}
