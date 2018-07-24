package com.arwenmc.api.ItemBuilder;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.io.IOException;
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

    public LeatherArmorMeta(Material armor, int amount) throws IOException {
        switch (armor) {
            case LEATHER_BOOTS:
                super(Material.LEATHER_BOOTS, amount);
                break;
            case LEATHER_LEGGINGS:
                super(Material.LEATHER_LEGGINGS, amount);
                break;
            case LEATHER_CHESTPLATE:
                super(Material.LEATHER_CHESTPLATE, amount);
                break;
            case LEATHER_HELMET:
                super(Material.LEATHER_HELMET, amount);
                break;
            default:
                throw new IOException("The material must be leather armor.");
        }
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
