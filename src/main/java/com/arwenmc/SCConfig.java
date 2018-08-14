package com.arwenmc;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public class SCConfig {

    ServerCore plugin;
    FileConfiguration config;
    public SCConfig(ServerCore plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    public String getAndColour(String configPath) {
        String configValue = config.getString(configPath);
        return ChatColor.translateAlternateColorCodes('&', configValue);
    }

    public boolean permissionCheck(Player player, GroupPermissions permissionNode) {
        if (player.hasPermission(permissionNode.getPermission())) {
            return true;
        } else {
            return false;
        }
    }

    public enum GroupPermissions {
        TEST("test.test"),
        TEST2("test.test2");

        private Permission permission;

        public GroupPermissions(String permissionPath) {
            this.permission = new Permission(permissionPath);
        }

        public Permission getPermission() {
            return this.permission;
        }
    }
}
