package com.arwenmc;

public class SCPermission {
    public enum SCGroup {
        ADMIM, STAFF, DONATOR, MEMBER, PlAYER
    }
}



/*enum SCPermission {

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
        }
        return null; // this should never have been reached
    }
}*/
