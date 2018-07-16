package io.github.Arwen.api.ItemBuilder;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/*
 Example For TippedArrowBuilder

 ItemStack itemstack = new TippedArrowBuilder(1)
            .addCustomEffect(PotionEffectType.REGENERATION, durationInTicks, 0)
            .setColor(Color.RED) // Only available in 1.11 - 1.12.2
            .build();
 */


public class TippedArrowBuilder
        extends ItemBuilder
{
    private PotionMeta pm;

    public TippedArrowBuilder(ItemStack itemStack)
    {
        super(itemStack);
    }

    public TippedArrowBuilder(int amount)
    {
        super(Material.TIPPED_ARROW, amount);
    }

    public TippedArrowBuilder setColor(Color color)
    {
        this.pm = ((PotionMeta)this.is.getItemMeta());
        this.pm.setColor(color);
        this.is.setItemMeta(this.pm);
        return this;
    }

    public TippedArrowBuilder addCustomEffect(PotionEffectType type, int duration, int amplifier)
    {
        this.pm = ((PotionMeta)this.is.getItemMeta());
        PotionEffect effect = new PotionEffect(type, duration, amplifier, true);
        this.pm.addCustomEffect(effect, true);
        this.is.setItemMeta(this.pm);
        return this;
    }
}
