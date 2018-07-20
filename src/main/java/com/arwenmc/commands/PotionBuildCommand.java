package com.arwenmc.commands;

import com.arwenmc.ServerCore;
import com.arwenmc.api.ItemBuilder.PotionBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public class PotionBuildCommand implements CommandExecutor {

    ServerCore plugin;

    public PotionBuildCommand(ServerCore instance) {
        plugin = instance;
    }

    //Test Command For PotionBuilder (API)

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {

        Player player = (Player) sender;
        if ((!(sender instanceof Player)) || (
                (cmd.getName().equalsIgnoreCase("potionbuild"))))

        {
            ItemStack itemstack = new PotionBuilder(Material.POTION, 1)
                    .addCustomEffect(PotionEffectType.REGENERATION, 200, 0)
                    .setColor(Color.RED)
                    .build();

            player.getInventory().addItem(new ItemStack(itemstack));
        }


        return true;
    }
}
