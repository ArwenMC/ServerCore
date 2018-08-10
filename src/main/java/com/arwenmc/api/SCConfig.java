package com.arwenmc.api;

import com.arwenmc.ServerCore;
import net.md_5.bungee.api.ChatColor;

public class SCConfig {

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
}
