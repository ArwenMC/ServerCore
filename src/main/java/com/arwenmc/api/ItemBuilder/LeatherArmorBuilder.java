package com.arwenmc.api.ItemBuilder;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Random;

/*
 Example For Armor Builder

  ItemStack itemstack = new LeatherArmorBuilder(Material.LEATHER_HELMET, 1)
            .setColor(Color.BLUE)
            .setColor(red, green, blue)
            .setRandomColor()
            .build();
 */


public class LeatherArmorBuilder extends ItemBuilder {
    private LeatherArmorMeta leatherArmorMeta;
    private ItemStack itemStack;

    public LeatherArmorMeta(Material armor, int amount) {
        if (armor == Material.LEATHER_BOOTS || armor == Material.LEATHER_LEGGINGS || armor == Material.LEATHER_CHESTPLATE || armor == Material.LEATHER_HELMET) {

        }
    }

    public LeatherArmorBuilder(ItemStack itemStack) {
        super(itemStack);
    }

    public LeatherArmorBuilder(Material material, int amount) {
        super(material, amount);
    }

    public LeatherArmorBuilder(int id, int amount) {
        super(id, amount);
    }

    public LeatherArmorBuilder setColor(Color color) {
        this.leatherArmorMeta = ((LeatherArmorMeta) this.itemStack.getItemMeta());
        this.leatherArmorMeta.setColor(color);
        this.itemStack.setItemMeta(this.leatherArmorMeta);
        return this;
    }

    public LeatherArmorBuilder setColor(int red, int green, int blue) {
        this.leatherArmorMeta = ((LeatherArmorMeta) this.itemStack.getItemMeta());
        this.leatherArmorMeta.setColor(Color.fromRGB(red, green, blue));
        this.itemStack.setItemMeta(this.leatherArmorMeta);
        return this;
    }

    public LeatherArmorBuilder setRandomColor() {
        this.leatherArmorMeta = ((LeatherArmorMeta) this.itemStack.getItemMeta());
        this.leatherArmorMeta.setColor(Color.fromRGB(randomColor(255) + 1, randomColor(255) + 1, randomColor(255) + 1));
        this.itemStack.setItemMeta(this.leatherArmorMeta);
        return this;
    }

    private int randomColor(int max) {
        Random r = new Random();
        return r.nextInt(max);
    }
}
