package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int i = 0; i < this.size; i++) {
            if (items[i].getId() == id) {
                rsl = items[i];
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] temp = new Item[this.size];
        temp = Arrays.copyOf(this.items, size);
        return temp;
    }

    public Item[] findByName(String key) {
        int rex = 0;
        Item[] temp = new Item[this.size];
        for (int i = 0; i < this.items.length; i++) {
            if (items[i].getName() == key) {
                temp[rex++] = items[i];
            }
        }
        temp = Arrays.copyOf(temp, rex);
        return temp;
    }


}