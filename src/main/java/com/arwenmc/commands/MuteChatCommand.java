package com.arwenmc.commands;

import com.arwenmc.ServerCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


//Please note that this command is not working

public class MuteChatCommand implements CommandExecutor, Listener {

    ServerCore plugin;

    public MuteChatCommand(ServerCore instance) {
        plugin = instance;
    }

    Boolean muted = Boolean.valueOf(false);


    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args)
    {
        if (alias.equalsIgnoreCase("mutechat")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command may not be sent from the console.");
            } else if (sender.hasPermission(plugin.Admin))
            {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("MuteChat.NeedArg"));
                } else if (args[0].equalsIgnoreCase("on"))
                {
                    if (this.muted.booleanValue())
                    {
                        sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("MuteChat.ChatAlreadyMuted"));
                    }
                    else
                    {
                        this.muted = Boolean.valueOf(true);
                        sender.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("MuteChat.ChatMuted"));
                    }
                }
                else if (args[0].equalsIgnoreCase("off"))
                {
                    if (!this.muted.booleanValue())
                    {
                        sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("MuteChat.ChatNotMuted"));
                    }
                    else
                    {
                        this.muted = Boolean.valueOf(false);
                        sender.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("MuteChat.ChatUnmuted"));
                    }
                }
                else {
                    sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("MuteChat.UnknownArg"));
                }
            }
            else {
                sender.sendMessage(ChatColor.RED + plugin.noPermission);
            }
        }
        return true;
    }

    @EventHandler
    public void playerChat(AsyncPlayerChatEvent e)
    {
        Player player = e.getPlayer();
        if ((this.muted.booleanValue()) &&
                (!e.getMessage().startsWith("/")) &&
                (!player.hasPermission(plugin.Admin)))
        {

            Bukkit.getServer().broadcastMessage("Chat Event Works!");
            player.sendMessage(ChatColor.RED + plugin.getConfig().getString("MuteChat.ChatMuted"));
            e.setCancelled(true);
        }
    }
}


