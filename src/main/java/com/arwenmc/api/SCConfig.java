package com.arwenmc.api;

import com.arwenmc.ServerCore;
import net.md_5.bungee.api.ChatColor;

public class SCConfig {

    ServerCore plugin;
    public SCConfig(ServerCore plugin) {
        this.plugin = plugin;
    }

    public String getAndColour(Enum enumValue) {
        String value = new ServerCore().getConfig().getString(enumValue.toString());

        return ChatColor.translateAlternateColorCodes('&', value);
    }

    public boolean getConfigBoolean(Enum enumField) {
        return plugin.getConfig().getBoolean(enumField.toString());
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

    public enum Features {
        enum FLY {
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


        private String configPath;

        Features(String configPath) {
            this.configPath = configPath;
        }
    }
}