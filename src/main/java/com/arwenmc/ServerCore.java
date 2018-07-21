package com.arwenmc;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class ServerCore extends JavaPlugin {

    // General Config Values
    public String NOT_PLAYER = GAC("general.not_player");
    public String NO_PERMISSION = GAC("general.no_permission");
    public String MISSING_ARGUMENT = GAC("general.missing_argument");
    public String UNKNOWN_ARGUMENT = GAC("general.unknown_argument");
    public String PREFIX = GAC("general.prefix");
    public String PLAYER_OFFLINE = GAC("general.player_offline");

    // Custom Permission System.
    public Permission ADMIN_PERMISSION = new Permission(getConfig().getString("general.admin_permission"));
    public Permission PLAYER_PERMISSION = new Permission(getConfig().getString("general.player_permission"));

    // Fly Config Values
    public boolean FLY_ENABLE = getConfig().getBoolean("features.fly.fly_enable");
    public String FLY_ENABLED = GAC("features.fly.fly_enabled");
    public String FLY_DISABLED = GAC("features.fly.fly_disabled");

    // Welcome Config Values
/*    public boolean WELCOME_ENABLE = getConfig().getBoolean("features.welcome.welcome_enable");
    public boolean WELCOME_BACK_MESSAGE = getConfig().getBoolean("features.welcome.welcome_back_messages");
    public boolean WELCOME_ENABLE_ACTIONBAR = getConfig().getBoolean("features.welcome.welcome_actionbar_messages");
    public String WELCOME_ACTIONBAR_MESSAGE = GAC("features.welcome.");*/

    // Chat Config Values
    public boolean MUTECHAT_ENABLED = getConfig().getBoolean("features.chat.mutechat_enabled");
    public boolean isChatMuted;
    public String CHAT_NOW_MUTED = GAC("features.chat.chat_now_muted");
    public String CHAT_NOW_UNMUTED = GAC("features.chat.chat_now_unmuted");

    // Help
    public boolean HELP_ENABLED = getConfig().getBoolean("features.help.help_enable");
    public List<String> HELP_MESSAGES() {
        List<String> temp = new ArrayList<String>;
        for(String s : getConfig().getStringList("features.help.messages")) {
            temp.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        return temp;
    }

    @Override
    public void onEnable() {
        getCommand("help").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
                for (String message : getConfig().getStringList("features.help.messages")) {
                    commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                }
                return true;
            }
        });
    }

    @Override
    public void onDisable() {}

    private String GAC(String path) { // GAC = get and colour.
        String config = getConfig().getString(path);
        return ChatColor.translateAlternateColorCodes('&', config);
    }

}
