package com.arwenmc;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerCore extends JavaPlugin {

    private FileConfiguration config = this.getConfig();

    public String NOT_PLAYER = colour(config.getString("general.not_player"));
    public String NO_PERMISSION = colour(config.getString("general.no_permission"));
    public String MISSING_ARGUMENT = colour(config.getString("general.missing_argument"));
    public String UNKOWN_ARGUMENT = colour(config.getString("general.unknown_argument"));
    public String PREFIX = colour(config.getSTr)

    @Override
    public void onEnable() {}

    @Override
    public void onDisable() {}

    private String colour(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }

}
