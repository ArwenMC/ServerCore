package com.arwenmc.commands;

import com.arwenmc.ServerCore;
import com.arwenmc.api.EntityBuilder.EntityBuilder;
import com.arwenmc.api.VillagerTradeBuilder.VillagerTradeBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;

public class EntitySpawnCommand implements CommandExecutor {

    ServerCore plugin;

    public EntitySpawnCommand(ServerCore instance) {
        plugin = instance;
    }

    //Test Command For EntityBuilder (API)

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {

        Player player = (Player) sender;
        if ((!(sender instanceof Player)) || (
                (cmd.getName().equalsIgnoreCase("entityspawn"))))

        {
            Entity entity = new EntityBuilder(EntityType.VILLAGER, player.getLocation())
                    .setAge(EntityBuilder.EntityAge.ADULT)
                    .setCustomName("Villager")
                    .setCustomNameVisible(true)
                    .spawn();


            Entity otherEntity = new EntityBuilder(EntityType.COW, player.getLocation())
                    .setAge(EntityBuilder.EntityAge.BABY)
                    .setCustomName("Baby Cow")
                    .setCustomNameVisible(true)
                    .spawn();

            ItemStack diamond = new ItemStack(Material.DIAMOND, 1);
            ItemStack diamonds = new ItemStack(Material.DIAMOND, 100);

            VillagerTradeBuilder vtb = new VillagerTradeBuilder()
                    .setExperienceReward(false)
                    .setMaxUses(999)
                    .setUses(0);
            vtb.clearTrades((Villager) entity);
            vtb.addTrade(diamond, diamonds);
            vtb.setTrades((Villager) entity);
            player.openMerchant((Villager) entity, true);

        }

        return true;
    }
}