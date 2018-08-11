package com.arwenmc.api;

import com.arwenmc.SCPermission;
import com.arwenmc.ServerCore;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;

public class SCConfig {

    ServerCore plugin;
    public SCConfig(ServerCore plugin) {
        this.plugin = plugin;
    }

    public SCConfig() {}

    public String getAndColour(Enum enumValue) {
        String value = new ServerCore().getConfig().getString(enumValue.toString());

        return ChatColor.translateAlternateColorCodes('&', value);
    }

    public boolean getConfigBoolean(Enum enumField) {
        return plugin.getConfig().getBoolean(enumField.toString());
    }

    private Permission getCommandPermission(SCPermission.ConfigPath configPath) {
        switch (configPath.getConfigPath()) {
            case "admin":
                return SCPermission.GroupPermission.ADMIN.getPermission();
            case "staff":
                return SCPermission.GroupPermission.STAFF.getPermission();
            case "donator":
                return SCPermission.GroupPermission.DONATOR.getPermission();
            case "member":
                return SCPermission.GroupPermission.MEMBER.getPermission();
            case "player":
                return SCPermission.GroupPermission.PLAYER.getPermission();
            default:
                Bukkit.getLogger().severe("That group doesn't exist, and so the command may work without any permission checks. I'd highly suggest checking your config.");
                Bukkit.getLogger().severe("Offending path is " + configPath);
                throw new IllegalArgumentException("That group doesn't exist, please check your config.");
        }
    }

    public enum Database {
        ENABLED("database.db_enabled"),
        TYPE("database.database_type"),
        HOST("database.host"),
        PORT("database.port"), // should be int
        DATABASE("database.database"),
        USERNAME("database.username"),
        PASSWORD("database.password");

        private String configPath;

        Database(String configPath) {
            this.configPath = configPath;
        }

        public String getConfigPath() {
            return this.configPath;
        }
    }

    public enum General {
        NOT_PLAYER("general.not_player"),
        NO_PERMISSION("general.no_permission"),
        MISSING_ARUGMENT("general.missing_argment");

        private String configPath;

        General(String configPath) {
            this.configPath = configPath;
        }
    }

    public static class Features {
        public enum FLY {
            PERMISSION("features.fly.fly_permission"),
            ENABLE("features.fly.fly_enable"),
            M_ENABLED("features.fly.fly_enabled"),
            M_DISABLED("features.fly.fly_disabled");

            private String configPath;

            FLY(String configPath) {
                this.configPath = configPath;
            }

            public String getConfigPath() {
                return this.configPath;
            }
        }
        enum GAMEMODE {
            TEST("test.test");


        }
    }

    public boolean DEBUG = plugin.getConfig().getBoolean("debug");
}