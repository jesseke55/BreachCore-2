package com.breachuniverse.core.util;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.material.MaterialData;

import java.util.Arrays;

/**
 * Created by Beheerder on 2/5/2016.
 */
public class ItemBuilder {

        private final ItemStack stack;

        public ItemBuilder(final Material material) {
            stack = new ItemStack(material);
        }
        public ItemBuilder setAmount(final Integer amount) {
            stack.setAmount(amount);
            return this;
        }

        public ItemBuilder name(final String name) {
            final ItemMeta meta = stack.getItemMeta();
            meta.setDisplayName(name);
            stack.setItemMeta(meta);
            return this;
        }

        public ItemBuilder lore(final String... lore) {
            final ItemMeta meta = stack.getItemMeta();
            meta.setLore(Arrays.asList(lore));
            stack.setItemMeta(meta);
            return this;
        }

        public ItemBuilder addEnchant(final Enchantment enchant, final Integer level) {
            final ItemMeta meta = stack.getItemMeta();
            meta.addEnchant(enchant, level, true);
            stack.setItemMeta(meta);
            return this;
        }

        public ItemBuilder setColor(final Color color) {
            if (stack.equals(Material.LEATHER_BOOTS) || stack.equals(Material.LEATHER_LEGGINGS) || stack.equals(Material.LEATHER_CHESTPLATE) ||
                    stack.equals(Material.LEATHER_HELMET)) {
                final LeatherArmorMeta meta = (LeatherArmorMeta) stack.getItemMeta();
                meta.setColor(color);
                stack.setItemMeta(meta);
            }
            else {
                throw new IllegalArgumentException("setColor can only be used on leather armour!");
            }
            return this;
        }

        public ItemBuilder setDurability(final int durability) {
            if (durability >= Short.MIN_VALUE && durability <= Short.MAX_VALUE) {
                stack.setDurability((short)durability);
            }
            else {
                throw new IllegalArgumentException("The durability must be a short!");
            }
            return this;
        }

        @SuppressWarnings("deprecation")
        public ItemBuilder setData(final int data) {
            stack.setData(new MaterialData(data));
            return this;
        }

        public ItemBuilder addFlag(final ItemFlag flag) {
            final ItemMeta meta = stack.getItemMeta();
            meta.addItemFlags(flag);
            stack.setItemMeta(meta);
            return this;
        }

        public ItemBuilder setData(MaterialData data) {
            final ItemMeta meta = stack.getItemMeta();
            stack.setData(data);
            stack.setItemMeta(meta);
            return this;
        }

        public ItemStack getStack() {
            return stack;
        }
    }