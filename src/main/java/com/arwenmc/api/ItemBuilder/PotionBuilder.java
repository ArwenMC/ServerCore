package io.github.Arwen.api.ItemBuilder;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/*
 Example For PotionBuilder

 ItemStack itemstack = new PotionBuilder(Material.POTION, 1)
            .addCustomEffect(PotionEffectType.REGENERATION, durationInTicks, 0)
            .setColor(Color.RED)
            .build();
 */


public class PotionBuilder
        extends ItemBuilder
{
    private PotionMeta pm;

    public PotionBuilder(ItemStack itemStack)
    {
        super(itemStack);
    }

    public PotionBuilder(Material material, int amount)
    {
        super(material, amount);
    }

    public PotionBuilder(int id, int amount)
    {
        super(id, amount);
    }

    @Deprecated
    public PotionBuilder(Material material, int amount, int subid)
    {
        super(material, amount, subid);
    }

    @Deprecated
    public PotionBuilder(int id, int amount, int subid)
    {
        super(id, amount, subid);
    }

    public PotionBuilder setColor(Color color)
    {
        this.pm = ((PotionMeta)this.is.getItemMeta());
        this.pm.setColor(color);
        this.is.setItemMeta(this.pm);
        return this;
    }

    public PotionBuilder addCustomEffect(PotionEffectType type, int duration, int amplifier)
    {
        this.pm = ((PotionMeta)this.is.getItemMeta());
        PotionEffect effect = new PotionEffect(type, duration, amplifier, true);
        this.pm.addCustomEffect(effect, true);
        this.is.setItemMeta(this.pm);
        return this;
    }
}