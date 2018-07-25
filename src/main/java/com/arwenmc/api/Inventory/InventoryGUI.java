package com.arwenmc.api.Inventory;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class InventoryGUI {

    private UUID id;
    private String name;
    private int size;
    private onClick click;
    private ArrayList<UUID> viewing = new ArrayList<>();
    private ItemStack[] itemStacks;

    public InventoryGUI(String name, int rows, onClick click) {
        this.id = UUID.randomUUID();
        this.name = format(name);
        this.click = click;
        this.size = rows * 9; // there are 9 slots on a row
        this.itemStacks = new ItemStack[this.size];
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

    private ItemStack getItem(ItemStack itemStack, String name, String... lore) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
