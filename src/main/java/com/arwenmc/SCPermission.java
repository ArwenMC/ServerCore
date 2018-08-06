package com.arwenmc;

import org.bukkit.permissions.Permission;

public enum SCPermission {

    ADMIN("sc.admin"),
    STAFF("sc.staff"),
    DONATOR("sc.donator"),
    MEMBER("sc.member"),
    PLAYER("sc.player");

    private String permissionNode;

    SCPermission(String permissionNode) {
        this.permissionNode = permissionNode;
    }

    public Permission getPermission() {
        return new Permission(this.permissionNode);
    }

}
