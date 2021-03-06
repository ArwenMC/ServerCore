package com.arwenmc;

import com.arwenmc.api.Inventory.InventoryGUI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class ServerCore extends JavaPlugin {

    public ServerCore PLUGIN = this;
    public SCConfig config = new SCConfig(PLUGIN);

    // Database
    public boolean DATABASE_ENABLED = getConfig().getBoolean("database.db_enabled");

    // General Config Values
    public String NOT_PLAYER = config.getAndColour("general.not_player");
    public String NO_PERMISSION = config.getAndColour("general.no_permission");
    public String MISSING_ARGUMENT = config.getAndColour("general.missing_argument");
    public String UNKNOWN_ARGUMENT = config.getAndColour("general.unknown_argument");
    public String PREFIX = config.getAndColour("general.prefix");
    public String PLAYER_OFFLINE = config.getAndColour("general.player_offline");
    public String COMMAND_DISABLED = config.getAndColour("general.command_disabled");

    // Custom Permission System.
    public Permission ADMIN_PERMISSION = new Permission(getConfig().getString("general.admin_permission"));
    public Permission PLAYER_PERMISSION = new Permission(getConfig().getString("general.player_permission"));

    // Fly Config Values
    public boolean FLY_ENABLE = getConfig().getBoolean("features.fly.fly_enable");
    public String FLY_ENABLED = config.getAndColour("features.fly.fly_enabled");
    public String FLY_DISABLED = config.getAndColour("features.fly.fly_disabled");

    // Chat Config Values
    public boolean MUTECHAT_ENABLED = getConfig().getBoolean("features.chat.mutechat_enabled");
    public String CHAT_NOW_MUTED = config.getAndColour("features.chat.chat_now_muted");
    public String CHAT_NOW_UNMUTED = config.getAndColour("features.chat.chat_now_unmuted");

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
        getCommand("togglegui").setExecutor((commandSender, command, s, strings) -> {
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
        });
    }

    @Override
    public void onDisable() {
        // Disable Method
    }
}
