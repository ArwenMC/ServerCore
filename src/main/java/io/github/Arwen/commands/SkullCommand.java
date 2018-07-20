package io.github.Arwen.commands;

import io.github.Arwen.Main;
import io.github.Arwen.api.ActionBar;
import io.github.Arwen.api.ItemBuilder.SkullBuilder;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class SkullCommand implements CommandExecutor {

    Main plugin;

    public SkullCommand(Main instance) {
        plugin = instance;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("skull")) {
            if (player.hasPermission(plugin.Admin)) {
                if (args.length == 0) {
                    List<String> message = plugin.getConfig().getStringList("Gamemode.Usage");
                    for (String msg : message) {
                        msg =
                                msg.replace('&', '§');
                        player.sendMessage(plugin.prefix + msg);
                    }
                } else if (args.length == 1) {
                    ItemStack itemstack = new SkullBuilder(1)
                            .setOwner(args[1])
                            .build();

                    player.getInventory().addItem(new ItemStack(itemstack));
                }
            }
            return true;
        }
        return false;
    }
}