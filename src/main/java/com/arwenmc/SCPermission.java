package com.arwenmc;

import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;

public class SCPermission {

    public Permission SC_ADMIN = new Permission("sc.admin");
    public Permission SC_STAFF = new Permission("sc.staff");
    public Permission SC_MEMBER = new Permission("sc.member");
    public Permission SC_PLAYER = new Permission("sc.player");

    Permission[] allPermissions = {
            SC_ADMIN, SC_STAFF, SC_MEMBER, SC_PLAYER
    };


    ServerCore plugin;
    public SCPermission(ServerCore instance) {
        plugin = instance;

        updatePermissions(); // when the server is loaded this will be ran but I will put in a command so that you can update them.
    }

    public void updatePermissions() {
        for (Permission permission : allPermissions) {
            Bukkit.getPluginManager().addPermission(permission);
        }
    }

    public Permission getPermission(String config) throws IllegalAccessException {
        switch (plugin.getConfig().getString(config)) {
            case "player":
                return this.SC_PLAYER;
            case "member":
                return this.SC_MEMBER;
            case "staff":
                return this.SC_STAFF;
            case "admin":
                return this.SC_ADMIN;
            default:
                throw new IllegalAccessException();
        }
    }
}