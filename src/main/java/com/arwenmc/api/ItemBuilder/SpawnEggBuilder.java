package com.arwenmc.api.ItemBuilder;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SpawnEggMeta;

/*
 Example For SpawnEggBuilder

 ItemStack itemstack = new SpawnEggBuilder(1)
            .setSpawnType(EntityType.CHICKEN)
            .build();
 */

@Deprecated
public class SpawnEggBuilder
        extends ItemBuilder {
    private SpawnEggMeta sem;

    public SpawnEggBuilder(ItemStack itemStack) {
        super(itemStack);
    }

    public SpawnEggBuilder(int amount) {
        super(Material.LEGACY_MONSTER_EGG., amount);
    }

    public SpawnEggBuilder setSpawnType(EntityType entity) {
        this.sem = ((SpawnEggMeta) this.is.getItemMeta());
        this.sem.setSpawnedType(entity);
        this.is.setItemMeta(this.sem);
        return this;
    }
}
