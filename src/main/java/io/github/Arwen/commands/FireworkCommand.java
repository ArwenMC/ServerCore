package io.github.Arwen.commands;

import io.github.Arwen.Main;
import io.github.Arwen.api.FireworkBuilder.FireworkBuilder;
import io.github.Arwen.api.ItemBuilder.SpawnEggBuilder;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class FireworkCommand implements CommandExecutor {

    Main plugin;

    public FireworkCommand(Main instance) {
        plugin = instance;
    }

    //Test Command For Firework (API)

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {

        Player player = (Player) sender;
        if ((!(sender instanceof Player)) || (
                (cmd.getName().equalsIgnoreCase("fireworkspawn"))))

        {
            FireworkBuilder fb = new FireworkBuilder(player.getLocation(), FireworkEffect.Type.BALL_LARGE, Color.BLUE, Color.RED, false, true, 1).build();
        }

        return true;
    }
}




