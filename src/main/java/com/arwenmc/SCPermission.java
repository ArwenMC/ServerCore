package com.arwenmc;

import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;

public enum SCPermission {

    ADMIN("sc.admin"),
    STAFF("sc.staff"),
    DONATOR("sc.donator"),
    MEMBER("sc.member"),
    PLAYER("sc.player");

    private String permissionNode;
    private Permission permission;

    SCPermission(String permissionNode) {
        this.permissionNode = permissionNode;
        this.permission = new Permission(this.permissionNode);
    }

    public Permission getPermission() {
        return new Permission(this.permissionNode);
    }

    public Permission getCommandPermission(String configPath) {
        switch (new ServerCore().getConfig().getString(configPath)) {
            case "admin":
                return ADMIN.getPermission();
            case "staff":
                return STAFF.getPermission();
            case "donator":
                return DONATOR.getPermission();
            case "member":
                return MEMBER.getPermission();
            case "player":
                return PLAYER.getPermission();
            default:
                Bukkit.getLogger().severe("That group doesn't exist, and so the command may work without any permission checks. I'd highly suggest checking your config.");
                throw new IllegalArgumentException("That group doesn't exist, please check your config.");
        }
    }
}
