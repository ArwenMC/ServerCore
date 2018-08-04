package com.arwenmc;

import com.arwenmc.api.Inventory.InventoryGUI;
import com.arwenmc.api.util.DyeColor;
import com.arwenmc.api.util.GlassColor;
import com.arwenmc.commands.TestCommand;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
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

    // General Config Values
    public String NOT_PLAYER = GAC("general.not_player");
    public String NO_PERMISSION = GAC("general.no_permission");
    public String MISSING_ARGUMENT = GAC("general.missing_argument");
    public String UNKNOWN_ARGUMENT = GAC("general.unknown_argument");
    public String PREFIX = GAC("general.prefix");
    public String PLAYER_OFFLINE = GAC("general.player_offline");
    public String COMMAND_DISABLED = GAC("general");

    // Custom Permission System.
    public Permission ADMIN_PERMISSION = new Permission(getConfig().getString("general.admin_permission"));
    public Permission PLAYER_PERMISSION = new Permission(getConfig().getString("general.player_permission"));

    // Fly Config Values
    public boolean FLY_ENABLE = getConfig().getBoolean("features.fly.fly_enable");
    public String FLY_ENABLED = GAC("features.fly.fly_enabled");
    public String FLY_DISABLED = GAC("features.fly.fly_disabled");

    // Chat Config Values
    public boolean MUTECHAT_ENABLED = getConfig().getBoolean("features.chat.mutechat_enabled");
    public boolean isChatMuted;
    public String CHAT_NOW_MUTED = GAC("features.chat.chat_now_muted");
    public String CHAT_NOW_UNMUTED = GAC("features.chat.chat_now_unmuted");

    // Help
    public boolean HELP_ENABLED = getConfig().getBoolean("features.help.help_enable");

    public List<String> HELP_MESSAGES() {
        ArrayList<String> temp = new ArrayList<String>();
        for (String s : getConfig().getStringList("features.help.messages")) {
            temp.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        return temp;
    }

    // Permissions
    // General Permissions
    public Permission SC_ADMIN = new Permission(getConfig().getString("general.admin_permission"));
    public Permission SC_PLAYER = new Permission(getConfig().getString("general.user_permission"));
    // Specific Permissions
    public Permission SC_TESTCOMMAND = new Permission("sc.commands.test");

    Permission[] permissions = new Permission[] {
            SC_ADMIN, SC_PLAYER,
            SC_TESTCOMMAND
    };

    // Inventory GUI
    InventoryGUI toggleGUI;

    @Override
    public void onEnable() {
        // getCommand("help").setExecutor(new HelpCommand(this));
        getCommand("servercoretest").setExecutor(new TestCommand(this));
        getCommand("togglegui").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
                if (!(commandSender instanceof Player)) {
                    commandSender.sendMessage(NOT_PLAYER);
                    return true;
                } else {
                    DyeColor lime = DyeColor.LIME;
                    DyeColor gray = DyeColor.GRAY;
                    Player player = (Player) commandSender;

                    ItemStack grayDye = new ItemStack(Material.GRAY_DYE);
                    ItemStack limeDye = new ItemStack(Material.LIME_DYE);

                    toggleGUI = new InventoryGUI("&aTest GUI", 4, (clicker, menu, row, slot, item) -> {
                        if(item.getType().equals(Material.INK_SAC)) {
                            if(item.equals(grayDye)) {
                                toggleGUI.setSlot(toggleGUI.getRow(2), 4, limeDye, "&aEnabled", "&7Click to disable");
                                player.sendMessage(ChatColor.GREEN + "You enabled this");
                            } else if(item.equals(limeDye)) {
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

        for (Permission permission : permissions) {
            Bukkit.getPluginManager().addPermission(permission);
        }
    }

    @Override
    public void onDisable() {
    }

    /**
     * A custom method to simplify the getting of config values and then colour it.
     *
     * @param path The path to the config value
     * @return String Colourised Config String
     */
    private String GAC(String path) { // GAC = get and colour.
        String config = getConfig().getString(path);
        return ChatColor.translateAlternateColorCodes('&', config);
    }

}
