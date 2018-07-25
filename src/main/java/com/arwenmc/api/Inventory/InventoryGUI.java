package com.arwenmc.api.Inventory;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.UUID;

public class InventoryGUI {

    private UUID id;
    private int size;
    private onClick click;
    private ArrayList<UUID> viewing = new ArrayList<>();

    public InventoryGUI(int rows, onClick click) {
        this.id = new UUID();
        this.size = rows * 9 // there are 9 slots on a row
    }

    public interface onClick {
        boolean onClick(Player click, InventoryGUI menu, Row row, int slow, ItemStack itemStack);
    }
}
