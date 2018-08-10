package com.arwenmc;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public class SCPermission {

    public boolean permissionCheck(Player player, ConfigPath configPath) {
        Permission permission = getCommandPermission(configPath);
        if (player.hasPermission(permission)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean permissionCheck(Player player, GroupPermission groupPermission) {
        if (player.hasPermission(groupPermission.getPermission())) {
            return true;
        } else {
            return false;
        }
    }

    private Permission getCommandPermission(ConfigPath configPath) {
        switch (configPath.getConfigPath()) {
            case "admin":
                return GroupPermission.ADMIN.getPermission();
            case "staff":
                return GroupPermission.STAFF.getPermission();
            case "donator":
                return GroupPermission.DONATOR.getPermission();
            case "member":
                return GroupPermission.MEMBER.getPermission();
            case "player":
                return GroupPermission.PLAYER.getPermission();
            default:
                Bukkit.getLogger().severe("That group doesn't exist, and so the command may work without any permission checks. I'd highly suggest checking your config.");
                Bukkit.getLogger().severe("Offending path is " + configPath);
                throw new IllegalArgumentException("That group doesn't exist, please check your config.");
        }
    }

    /**
     * A much easier way for getting paths from config.
     */
    public enum ConfigPath {
        GAMEMODE("gamemode.gamemode_permission"),
        CHAT("chat.chat_permission"),
        CHAT_BYPASS("chat.chat_bypass_permission"),
        HELP("help.help_permission");

        private String configPath;

        ConfigPath(String configPath) {
            this.configPath = configPath;
        }

        public String getConfigPath() {
            return this.configPath;
        }
    }

    public enum GroupPermission {
        ADMIN("sc.admin"),
        STAFF("sc.staff"),
        DONATOR("sc.donator"),
        MEMBER("sc.member"),
        PLAYER("sc.player");

        private String permissionNode;

        GroupPermission(String permissionNode) {
            this.permissionNode = permissionNode;
        }

        public Permission getPermission() {
            return new Permission(this.permissionNode);
        }
    }
}
