package com.arwenmc.api;

public class SCConfig {

    public enum Database {
        DB_ENABLED("database.db_enabled"),
        DB_TYPE("database.database_type"),
        DB_HOST("database.host"),
        DB_PORT("database.port"), // should be int
        DB_DATABASE("database.database"),
        DB_USERNAME("database.username"),
        DB_PASSWORD("database.password");

        private String configPath;

        Database(String configPath) {
            this.configPath = configPath
        }

        public String getConfigPath() {
            return this.configPath;
        }

    }




}
