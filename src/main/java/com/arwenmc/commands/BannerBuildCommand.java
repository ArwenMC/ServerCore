package com.arwenmc.commands;

import com.arwenmc.ServerCore;
import com.arwenmc.api.ItemBuilder.BannerBuilder;
import org.bukkit.DyeColor;
import org.bukkit.block.banner.PatternType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BannerBuildCommand implements CommandExecutor {

    ServerCore plugin;

    public BannerBuildCommand(ServerCore instance) {
        plugin = instance;
    }


    //Test Command for BannerBuilder (API)

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {

        Player player = (Player) sender;
        if ((!(sender instanceof Player)) || (
                (cmd.getName().equalsIgnoreCase("bannerbuild"))))

        {
            ItemStack itemstack = new BannerBuilder(1)
                    .setBaseColor(DyeColor.WHITE)
                    .addPattern(DyeColor.RED, PatternType.CIRCLE_MIDDLE)
                    .build();

            player.getInventory().addItem(new ItemStack(itemstack));

        }

        return true;
    }
}