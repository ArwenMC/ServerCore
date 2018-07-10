package io.github.Arwen;

import io.github.Arwen.commands.FlyCommand;
import io.github.Arwen.events.PlayerDisconect;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {


    public String notPlayer = ChatColor.RED + "You must be a player to use this command.";
    public String noPermission = ChatColor.RED + "You do not have permission to use this command.";
    public String prefix = getConfig().getString("Messages.Prefix").replace('&', '§');

    public String flyEnabled = getConfig().getString("Messages.FlyEnabled").replace('&', '§');
    public String flyDisabled = getConfig().getString("Messages.FlyDisabled").replace('&', '§');

    public Permission staffFly = new Permission("core.fly");
    public Permission Admin = new Permission("core.admin");

    Permission[] permissions = {
            staffFly, Admin
    };



    @Override
    public void onEnable() {
        for (Permission permission : permissions) {
            Bukkit.getServer().getPluginManager().addPermission(permission);
        }

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        getCommand("fly").setExecutor(new FlyCommand(this));
        getServer().getPluginManager().registerEvents(new PlayerDisconect(this), this);

    }


    @Override
    public void onDisable() {
        super.onDisable();
    }
}
