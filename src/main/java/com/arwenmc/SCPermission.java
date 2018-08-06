package com.arwenmc;

public enum SCPermission {

    ADMIN("sc_admin"),
    STAFF("sc.staff"),
    MEMBER("sc.member"),
    PLAYER("sc.player");

    private String permissionNode;

    SCPermission(String permissionNode) {
        this.permissionNode = permissionNode;
    }

    public String getPermission() {
        return this.permissionNode;
    }
}
