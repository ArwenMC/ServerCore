package com.arwenmc.api.ItemBuilder;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;


/*
 Example For the BannerBuilder

  ItemStack itemstack = new BannerBuilder(1)
            .setBaseColor(DyeColor.WHITE)
            .addPattern(DyeColor.BLUE, PatternType.BORDER)
            .build();
 */

public class BannerBuilder
        extends ItemBuilder {
    private BannerMeta bm;

    public BannerBuilder(ItemStack itemStack) {
        super(itemStack);
    }

    public BannerBuilder(int amount) {
        super(Material.BANNER, amount);
    }

    public BannerBuilder setBaseColor(DyeColor color) {
        this.bm = ((BannerMeta) this.is.getItemMeta());
        this.bm.setBaseColor(color); // why is the deprecated?
        this.is.setItemMeta(this.bm);
        return this;
    }

    public BannerBuilder addPattern(DyeColor color, PatternType pattern) {
        this.bm = ((BannerMeta) this.is.getItemMeta());
        this.bm.addPattern(new Pattern(color, pattern));
        this.is.setItemMeta(this.bm);
        return this;
    }
}
