package io.github.Arwen;

import io.github.Arwen.commands.*;
import io.github.Arwen.events.FirstPlayerJoin;
import io.github.Arwen.events.PlayerDisconect;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends JavaPlugin implements Listener {


    private Connection connection;


    public String notPlayer = ChatColor.RED + "You must be a player to use this command.";
    public String noPermission = ChatColor.RED + "You do not have permission to use this command.";
    public String prefix = getConfig().getString("Messages.Prefix").replace('&', '§');

    public boolean spawnSound = getConfig().getBoolean("Spawn.Explosion_Sound_On_Spawn");
    public String spawnMessage = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Spawn.Message"));
    public String setSpawnMessage = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Spawn.Set_Spawn_Message"));

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


    public String host = this.getConfig().getString("MySQL.Host");
    public int port = this.getConfig().getInt("MySQL.Port");
    public String database = this.getConfig().getString("MySQL.Database");
    public String username = this.getConfig().getString("MySQL.Username");
    public String password = this.getConfig().getString("MySQL.Password");


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

       /* try {
            openConnection();
            Statement statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */


        getConfig().options().copyDefaults(true);
        saveDefaultConfig();


        getCommand("fly").setExecutor(new FlyCommand(this));
        getCommand("gamemode").setExecutor(new GamemodeCommand(this));
        getCommand("help").setExecutor(new HelpCommand(this));
        getCommand("mutechat").setExecutor(new MuteChatCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getServer().getPluginManager().registerEvents(new PlayerDisconect(this), this);
        getServer().getPluginManager().registerEvents(new FirstPlayerJoin(this), this);
        getServer().getPluginManager().registerEvents(new MuteChatCommand(this), this);
    }


    @Override
    public void onDisable() {
        super.onDisable();
    }

    public void openConnection() throws SQLException, ClassNotFoundException {
        if (connection != null && !connection.isClosed()) {
            return;
        }

        synchronized (this) {
            if (connection != null && !connection.isClosed()) {
                return;
            }
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.username, this.password);

        }
    }
}

