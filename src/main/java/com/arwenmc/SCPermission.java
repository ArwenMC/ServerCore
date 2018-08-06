package com.arwenmc;

import org.bukkit.permissions.Permission;

public class SCPermission {

    public Permission SC_ADMIN = new Permission("sc.admin");
    public Permission SC_PLAYER = new Permission("sc.player");


    ServerCore plugin;
    public SCPermission(ServerCore instance) {
        plugin = instance;
    }

    



}
