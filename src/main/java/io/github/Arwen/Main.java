package io.github.Arwen;

import io.github.Arwen.commands.FlyCommand;
import io.github.Arwen.commands.GamemodeCommand;
import io.github.Arwen.commands.HelpCommand;
import io.github.Arwen.events.FirstPlayerJoin;
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


    public String actionbarwelcomeback = getConfig().getString("Messages.Actionbar_Welcome_Back").replace('&', '§');
    public String actionbarwelcome = getConfig().getString("Messages.Actionbar_Welcome").replace('&', '§');
    public String welcomeback = getConfig().getString("Messages.Welcome_Back").replace('&', '§');
    public String welcome = getConfig().getString("Messages.Welcome").replace('&', '§');
    public String notOnline = getConfig().getString("Messages.PlayerOffline").replace('&', '§');



    public String flyEnabled = getConfig().getString("Messages.FlyEnabled").replace('&', '§');
    public String flyDisabled = getConfig().getString("Messages.FlyDisabled").replace('&', '§');

    public String gm0 = getConfig().getString("Gamemode.GM0").replace('&', '§');
    public String gm1 = getConfig().getString("Gamemode.GM1").replace('&', '§');
    public String gm2 = getConfig().getString("Gamemode.GM2").replace('&', '§');
    public String gm3 = getConfig().getString("Gamemode.GM3").replace('&', '§');

    public String actionbar0 = getConfig().getString("Gamemode.GM0_ActionBar").replace('&', '§');
    public String actionbar1 = getConfig().getString("Gamemode.GM1_ActionBar").replace('&', '§');
    public String actionbar2 = getConfig().getString("Gamemode.GM2_ActionBar").replace('&', '§');
    public String actionbar3 = getConfig().getString("Gamemode.GM3_ActionBar").replace('&', '§');


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
        getCommand("gamemode").setExecutor(new GamemodeCommand(this));
        getCommand("help").setExecutor(new HelpCommand(this));
        getServer().getPluginManager().registerEvents(new PlayerDisconect(this), this);
        getServer().getPluginManager().registerEvents(new FirstPlayerJoin(this), this);
    }


    @Override
    public void onDisable() {
        super.onDisable();
    }
}
