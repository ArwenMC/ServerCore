package com.arwenmc.api.Inventory;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class InventoryGUI implements Listener {

    private UUID id;
    private String name;
    private int size;
    private onClick click;
    private ArrayList<UUID> viewing = new ArrayList<>();
    private ItemStack[] itemStacks;

    public InventoryGUI(String name, int rows, onClick click, JavaPlugin plugin) {
        this.id = UUID.randomUUID();
        this.name = format(name);
        this.click = click;
        this.size = rows * 9; // there are 9 slots on a row
        this.itemStacks = new ItemStack[this.size];
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPluginDisable(PluginDisableEvent event) {
        for (UUID uuid : this.getViewers()) {
            this.close(uuid);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getSlotType().equals(InventoryType.SlotType.OUTSIDE)) {
            return;
        } else {
            if (viewing.contains(event.getWhoClicked().getUniqueId())) {
                event.setCancelled(true);
                Player player = (Player) event.getWhoClicked();
            }
        }
    }

    public InventoryGUI open(UUID uuid) {
        Bukkit.getPlayer(uuid).openInventory(this.createInventory(uuid));
        viewing.add(uuid);
        return this;
    }

    public InventoryGUI close(UUID uuid) {
        Player inventoryPlayer = Bukkit.getPlayer(uuid);
        if (inventoryPlayer.getOpenInventory().getTitle().equalsIgnoreCase(this.name)) {
            inventoryPlayer.closeInventory();
            viewing.remove(uuid);
        }
        return this;
    }

    private Inventory createInventory(UUID uuid) {
        Inventory inventory = Bukkit.createInventory(Bukkit.getPlayer(uuid), this.size, this.name);
        for (int i = 0; i < itemStacks.length; i++) {
            if (itemStacks[i] != null) {
                inventory.setItem(i, itemStacks[i]);
            }
        }
        return inventory;
    }

    public List<UUID> getViewers() {
        List<UUID> viewers = new ArrayList<>();
        for (UUID uuid : viewers) {
            viewers.add(uuid);
        }
        return viewers;
    }

    private String[] format(String[] toFormat) {
        for (int i = 0; i < toFormat.length; i++) {
            toFormat[i] = format(toFormat[i]);
        }
        return toFormat;
    }

    private String format(String toFormat) {
        return ChatColor.translateAlternateColorCodes('&', toFormat);
    }

    public interface onClick {
        boolean onClick(Player click, InventoryGUI menu, Row row, int slow, ItemStack itemStack);
    }

    public class Row {
        private ItemStack[] rowItems = new ItemStack[9];
        private int row;

        public Row(int row, ItemStack[] itemStacks) {
            this.row = row;
            for (int j = 0, i = (row * 9); i < (row * 9) + 9; i++, j++) {
                this.rowItems[j] = itemStacks[i];
            }
        }

        public ItemStack[] getRowItems() {
            return this.rowItems;
        }

        public ItemStack getRowItem(int item) {
            return rowItems[item] == null ? new ItemStack(Material.AIR) : rowItems[item];
        }

        public int getRow() {
            return this.row;
        }
    }

    private ItemStack createItem(ItemStack itemStack, String name, String... lore) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
