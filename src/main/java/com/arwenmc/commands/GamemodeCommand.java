package com.arwenmc.commands;


import com.arwenmc.ServerCore;
import com.arwenmc.api.ActionBar;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class GamemodeCommand implements CommandExecutor {
    ServerCore plugin;

    public GamemodeCommand(ServerCore instance) {
        plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args)
    {
        Player player = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("gamemode")) {
            if (player.hasPermission(plugin.Admin)) {
                if (args.length == 0)
                {
                    List<String> message = plugin.getConfig().getStringList("Gamemode.Usage");
                    for (String msg : message)
                    {
                        msg =
                                msg.replace('&', '§');
                        player.sendMessage(plugin.prefix + msg);
                    }
                }
                else if (args.length == 1)
                {
                    if ((args[0].equalsIgnoreCase("0")) || (args[0].equalsIgnoreCase("survival")) || (args[0].equalsIgnoreCase("s")))
                    {
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(plugin.prefix + plugin.gm0);
                        ActionBar.send(player, plugin.actionbar0);
                    }
                    if ((args[0].equalsIgnoreCase("1")) || (args[0].equalsIgnoreCase("creative")) || (args[0].equalsIgnoreCase("c")))
                    {
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(plugin.prefix + plugin.gm1);
                        ActionBar.send(player, plugin.actionbar1);
                    }
                    if ((args[0].equalsIgnoreCase("2")) || (args[0].equalsIgnoreCase("adventure")) || (args[0].equalsIgnoreCase("a")))
                    {
                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage(plugin.prefix + plugin.gm2);
                        ActionBar.send(player, plugin.actionbar2);
                    }
                    if ((args[0].equalsIgnoreCase("3")) || (args[0].equalsIgnoreCase("spectator")))
                    {
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(plugin.prefix+ plugin.gm3);
                        ActionBar.send(player, plugin.actionbar3);
                    }
                }
                else if (args.length == 2)
                {
                    Player t = Bukkit.getPlayer(args[1]);
                    if (t == null)
                    {
                        player.sendMessage(plugin.prefix + plugin.notOnline);
                        return true;
                    }
                    if ((args[0].equalsIgnoreCase("0")) || (args[0].equalsIgnoreCase("survival")) || (args[0].equalsIgnoreCase("s")))
                    {
                        t.setGameMode(GameMode.SURVIVAL);
                        t.sendMessage(plugin.prefix + plugin.gm0);
                        ActionBar.send(t, plugin.actionbar0);
                    }
                    if ((args[0].equalsIgnoreCase("1")) || (args[0].equalsIgnoreCase("creative")) || (args[0].equalsIgnoreCase("c")))
                    {
                        t.setGameMode(GameMode.CREATIVE);
                        t.sendMessage(plugin.prefix + plugin.gm1);
                        ActionBar.send(t, plugin.actionbar1);
                    }
                    if ((args[0].equalsIgnoreCase("2")) || (args[0].equalsIgnoreCase("adventure")) || (args[0].equalsIgnoreCase("a")))
                    {
                        t.setGameMode(GameMode.ADVENTURE);
                        t.sendMessage(plugin.prefix + plugin.gm2);
                        ActionBar.send(t, plugin.actionbar2);
                    }
                    if ((args[0].equalsIgnoreCase("3")) || (args[0].equalsIgnoreCase("spectator")))
                    {
                        t.setGameMode(GameMode.SPECTATOR);
                        t.sendMessage(plugin.prefix + plugin.gm3);
                        ActionBar.send(t, plugin.actionbar3);
                    }
                }
                else
                {
                    List<String> message = plugin.getConfig().getStringList("Gamemode.Usage");
                    for (String msg : message)
                    {
                        msg =
                                msg.replace('&', '§');
                        player.sendMessage(plugin.prefix + msg);
                    }
                }
            }
        }
        return false;
    }
}


