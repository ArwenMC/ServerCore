package com.arwenmc;

import com.arwenmc.api.Inventory.InventoryGUI;
import com.arwenmc.commands.ServerCoreCommand;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class ServerCore extends JavaPlugin {

    public ServerCore PLUGIN = this;
    public SCConfig scConfig = new SCConfig(PLUGIN);

    // Database
    public boolean DATABASE_ENABLED = getConfig().getBoolean("database.db_enabled");

    // General Config Values
    public String NOT_PLAYER = scConfig.getAndColour("general.not_player");
    public String NO_PERMISSION = scConfig.getAndColour("general.no_permission");
    public String MISSING_ARGUMENT = scConfig.getAndColour("general.missing_argument");
    public String UNKNOWN_ARGUMENT = scConfig.getAndColour("general.unknown_argument");
    public String PREFIX = scConfig.getAndColour("general.prefix");
    public String PLAYER_OFFLINE = scConfig.getAndColour("general.player_offline");
    public String COMMAND_DISABLED = scConfig.getAndColour("general.command_disabled");

    // Custom Permission System.
    public Permission ADMIN_PERMISSION = new Permission(getConfig().getString("general.admin_permission"));
    public Permission PLAYER_PERMISSION = new Permission(getConfig().getString("general.player_permission"));

    // Fly Config Values
    public boolean FLY_ENABLE = getConfig().getBoolean("features.fly.fly_enable");
    public String FLY_ENABLED = scConfig.getAndColour("features.fly.fly_enabled");
    public String FLY_DISABLED = scConfig.getAndColour("features.fly.fly_disabled");

    // Chat Config Values
    public boolean MUTECHAT_ENABLED = getConfig().getBoolean("features.chat.mutechat_enabled");
    public String CHAT_NOW_MUTED = scConfig.getAndColour("features.chat.chat_now_muted");
    public String CHAT_NOW_UNMUTED = scConfig.getAndColour("features.chat.chat_now_unmuted");

    // Help
    public boolean HELP_ENABLED = getConfig().getBoolean("features.help.help_enable");
    // Inventory GUI
    InventoryGUI toggleGUI;

    public List<String> HELP_MESSAGES() {
        ArrayList<String> temp = new ArrayList<>();
        for (String s : getConfig().getStringList("features.help.messages")) {
            temp.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        return temp;
    }

    public ServerCore getPlugin() {
        return this;
    }

    @Override
    public void onEnable() {
        // getCommand("help").setExecutor(new HelpCommand(this));
        getCommand("servercore").setExecutor(new ServerCoreCommand(this));
        getCommand("togglegui").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
                if (!(commandSender instanceof Player)) {
                    commandSender.sendMessage(NOT_PLAYER);
                    return true;
                } else {
                    Player player = (Player) commandSender;

                    ItemStack grayDye = new ItemStack(Material.GRAY_DYE);
                    ItemStack limeDye = new ItemStack(Material.LIME_DYE);

                    toggleGUI = new InventoryGUI("&aTest GUI", 4, PLUGIN, (clicker, menu, row, slot, item) -> {
                        if (item.getType().equals(Material.INK_SAC)) {
                            if (item.equals(grayDye)) {
                                toggleGUI.setSlot(toggleGUI.getRow(2), 4, limeDye, "&aEnabled", "&7Click to disable");
                                player.sendMessage(ChatColor.GREEN + "You enabled this");
                            } else if (item.equals(limeDye)) {
                                toggleGUI.setSlot(toggleGUI.getRow(2), 4, grayDye, "&cDisabled", "&7Click to enable");
                                player.sendMessage(ChatColor.RED + "You disabled this");
                            }
                        }

                        toggleGUI.refresh(player.getUniqueId());
                        return true;
                    });
                    toggleGUI.setSlot(toggleGUI.getRow(1), 4, new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE), "&aEnable or Disable");
                    toggleGUI.setSlot(toggleGUI.getRow(2), 4, grayDye, "&cDisabled", "&7Click to enable");
                    toggleGUI.open(player.getUniqueId());
                    return true;
                }
            }
        });
    }

    @Override
    public void onDisable() {
        // Disable Method
    }
}
