package io.github.Arwen.commands;

import io.github.Arwen.Main;
import io.github.Arwen.api.ItemBuilder.PotionBuilder;
import io.github.Arwen.api.ItemBuilder.SpawnEggBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public class SpawnEggCommand implements CommandExecutor {

    Main plugin;

    public SpawnEggCommand(Main instance) {
        plugin = instance;
    }

    //Test Command For EggSpawn (API)

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {

        Player player = (Player) sender;
        if ((!(sender instanceof Player)) || (
                (cmd.getName().equalsIgnoreCase("spawnegg"))))

        {
            ItemStack itemstack = new SpawnEggBuilder(20)
                    .setSpawnType(EntityType.LLAMA)
                    .build();

            player.getInventory().addItem(new ItemStack(itemstack));
        }

        return true;
    }
}


