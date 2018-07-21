package com.arwenmc;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerCore extends JavaPlugin {

    private FileConfiguration config = this.getConfig();

    public String NOT_PLAYER = GAC("general.not_player");
    public String NO_PERMISSION = GAC("general.no_permission");
    public String MISSING_ARGUMENT = GAC("general.missing_argument");
    public String UNKNOWN_ARGUMENT = GAC("general.unknown_argument");
    public String PREFIX = GAC("general.prefix");
    public String PLAYER_OFFLINE = GAC("general.player_offline");

    public Permission ADMIN_PERMISSION = new Permission(getConfig().getString("general.admin_permission"));
    public Permission PLAYER_PERMISSION = new Permission(getConfig().getString("general.player_permission"));

    

    @Override
    public void onEnable() {}

    @Override
    public void onDisable() {}

    private String GAC(String path) { // GAC = get and colour.
        String config = getConfig().getString(path);
        return ChatColor.translateAlternateColorCodes('&', config);
    }

}
