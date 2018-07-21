package com.arwenmc;

import com.arwenmc.commands.*;
import com.arwenmc.events.FirstPlayerJoin;
import com.arwenmc.events.PlayerDisconect;
import com.arwenmc.events.PlayerJoin;
import com.arwenmc.events.PlayerMuteChatEvent;
import com.mongodb.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServerCore extends JavaPlugin implements Listener {


    static Connection connection;
    static DBCollection players;
    static DB Main;
    static MongoClient client;




    @Override
    public void onEnable() {
        for (Permission permission : permissions) {
            Bukkit.getServer().getPluginManager().addPermission(permission);
        }

        //MongoDB
       // connect("127.0.0.1", 27017);

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
        getServer().getPluginManager().registerEvents(new PlayerMuteChatEvent(this), this);

        getCommand("fly").setExecutor(new FlyCommand(this));
        getCommand("gamemode").setExecutor(new GamemodeCommand(this));
        getCommand("help").setExecutor(new HelpCommand(this));
        getCommand("mutechat").setExecutor(new MuteChatCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("entityspawn").setExecutor(new EntitySpawnCommand(this));
        getCommand("bannerbuild").setExecutor(new BannerBuildCommand(this));
        getCommand("potionbuild").setExecutor(new PotionBuildCommand(this));
        getCommand("spawnegg").setExecutor(new SpawnEggCommand(this));
        getCommand("firework").setExecutor(new FireworkCommand(this));
        getCommand("skull").setExecutor(new SkullCommand(this));
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
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
 /*  public static void connect(String ip, int port){
        //Connect to the specified ip and port
        //Default is localhost, 27017
       client = new MongoClient(ip, port);
       //Get the database called "mcserver"
        //If it does not exist it will be created automatically
        //once you save something in it
        Main = client.getDB("Main");
        //Get the collection called "players" in the database "mcserver"
        //Equivalent to the table in MySQL, you can store objects in here
        players = Main.getCollection("players");
    }

    public void storePlayer(UUID uuid, String name, long tokens, String rank){
        //Lets store our first player!
        //This player has never played before and we just want to create a object for him
        DBObject obj = new BasicDBObject("uuid", uuid);
        obj.put("name", name);
        obj.put("tokens", tokens);
        obj.put("rank", rank);
        //Lets insert it in our collection:
        players.insert(obj);
    } */
}
