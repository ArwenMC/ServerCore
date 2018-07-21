package com.arwenmc.database;

import com.mongodb.*;
import com.arwenmc.ServerCore;

/*

import java.net.UnknownHostException;
import java.util.UUID;

public class MongoDB {

    Main plugin;

    public MongoDB(Main instance) {
        plugin = instance;
    }

    private DBCollection players;
    private DB mcserverdb;
    private MongoClient client;


    public boolean connect(String ip, int port){
        //Connect to the specified ip and port
        //Default is localhost, 27017
        client = new MongoClient(ip, port);
        //Get the database called "mcserver"
        //If it does not exist it will be created automatically
        //once you save something in it
        mcserverdb = client.getDB("mcserver");
        //Get the collection called "players" in the database "mcserver"
        //Equivalent to the table in MySQL, you can store objects in here
        players = mcserverdb.getCollection("players");
        return true;
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
    }
}
*/