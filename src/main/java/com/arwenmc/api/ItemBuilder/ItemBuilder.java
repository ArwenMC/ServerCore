package com.arwenmc.api.ItemBuilder;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
    private Material material;
    private int amount;
    private ItemStack itemStack;
    private ItemMeta itemMeta;

    /**
     * Intial constructor to build an item.
     * @param material The material that you like the amount to help.
     * @param amount The amount for that item.
     */
    public ItemBuilder(Material material, int amount) {
        this.material = material;
        this.amount = amount;
        this.itemStack = new ItemStack(this.material);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    /**
     * Set the durability for the ItemStack
     * @param durability The int durability, it is casted to a short.
     */
    public ItemBuilder setDurability(int durability) {
        this.itemStack.setDurability((short) durability);
        return this;
    }

    /**
     * Set's the display name, you can pass this with ChatColor or & values
     * @param name The name of the item you would like to use.
     * @return
     */
    public ItemBuilder setDisplayName(String name) {
        this.itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        return this;
    }

    /**
     * Builds the Item with your custom options.
     * @return The ItemStack with the custom options.
     */
    public ItemStack build() {
        this.itemStack.setItemMeta(this.itemMeta);
        return this.itemStack;
    }
}
