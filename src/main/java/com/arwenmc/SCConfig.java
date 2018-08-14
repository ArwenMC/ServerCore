package com.arwenmc;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

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
}
