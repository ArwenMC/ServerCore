package com.arwenmc;

import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;

public class SCPermission {

    public Permission getCommandPermission(String configPath) {
        switch (new ServerCore().getConfig().getString(configPath)) {
            case "admin":
                return groupPermissions.ADMIN.getPermission();
            case "staff":
                return groupPermissions.STAFF.getPermission();
            case "donator":
                return groupPermissions.DONATOR.getPermission();
            case "member":
                return groupPermissions.MEMBER.getPermission();
            case "player":
                return groupPermissions.PLAYER.getPermission();
            default:
                Bukkit.getLogger().severe("That group doesn't exist, and so the command may work without any permission checks. I'd highly suggest checking your config.");
                throw new IllegalArgumentException("That group doesn't exist, please check your config.");
        }
    }

    public enum configPath {
        FLY("fly.fly_permission"),
        GAMEMODE("gamemode.gamemode_permission"),
        CHAT("chat.chat_permission"),
        HELP("help.help_permission");

        private String configPath;

        configPath(String configPath) {
            this.configPath = configPath;
        }

        public String getConfigPath() {
            return this.configPath;
        }
    }

    private enum groupPermissions {
        ADMIN("sc.admin"),
        STAFF("sc.staff"),
        DONATOR("sc.donator"),
        MEMBER("sc.member"),
        PLAYER("sc.player");

        private String permissionNode;

        groupPermissions(String permissionNode) {
            this.permissionNode = permissionNode;
        }

        public Permission getPermission() {
            return new Permission(this.permissionNode);
        }
    }
}
