package com.breachuniverse.core.util;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Beheerder on 2/5/2016.
 */
public class MenuBuilder {
    private final Inventory inv;

    public MenuBuilder(final int size, final String title) {
        inv = Bukkit.createInventory(null, size, title);
    }

    public MenuBuilder addItem(final int slot, final ItemStack stack) {
        inv.setItem(slot, stack);
        return this;
    }

    public Inventory getInventory() {
        return inv;
    }
}
