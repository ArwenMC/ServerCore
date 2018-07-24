package com.arwenmc.api.ItemBuilder;

import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

/*
 Example For Book Builder

  ItemStack itemstack = new BookBuilder(1)
            .setAuthor("yourName")
            .addPage("pageContent");
            .build();
 */

public class BookBuilder
        extends ItemBuilder
{
    private BookMeta bm;

    public BookBuilder(ItemStack itemStack)
    {
        super(itemStack);
    }

    public BookBuilder(int amount)
    {
        super(Material.BOOK, amount);
    }

    public BookBuilder setAuthor(String name)
    {
        this.bm = ((BookMeta)this.is.getItemMeta());
        this.bm.setAuthor(name);
        this.is.setItemMeta(this.bm);
        return this;
    }

    public BookBuilder addPage(String content)
    {
        this.bm = ((BookMeta)this.is.getItemMeta());
        this.bm.addPage(content);
        this.is.setItemMeta(this.bm);
        return this;
    }

    public BookBuilder addPages(List<String> contents)
    {
        this.bm = ((BookMeta)this.is.getItemMeta());
        for (String content : contents) {
            this.bm.addPage(content);
        }
        this.is.setItemMeta(this.bm);
        return this;
    }

    public int getPageCount()
    {
        return this.bm.getPageCount();
    }
}
