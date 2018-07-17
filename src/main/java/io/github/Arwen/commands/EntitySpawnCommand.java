package io.github.Arwen.commands;

import io.github.Arwen.Main;
import io.github.Arwen.api.EntityBuilder.EntityBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class EntitySpawnCommand implements CommandExecutor {

    Main plugin;

    public EntitySpawnCommand(Main instance) {
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

        }

        return true;
    }
}