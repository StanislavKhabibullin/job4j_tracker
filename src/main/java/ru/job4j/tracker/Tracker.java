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
        return Arrays.copyOf(this.items, size);
    }

    public Item[] findByName(String key) {
        int rex = 0;
        Item[] temp = new Item[this.size];
        for (int i = 0; i < this.size; i++) {
            if (items[i].getName().equals(key)) {
                temp[rex++] = items[i];
            }
        }
        temp = Arrays.copyOf(temp, rex);
        return temp;
    }

    private int indexOfId(int id) {
        int index = -1;
        for (int i = 0; i < this.size; i++) {
            if (this.items[i].getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean replace(int id, Item request) {
        boolean result = false;
        int exp = indexOfId(id);
        if (exp != -1) {
            this.items[exp].setName(request.getName());
            result = true;
        }
        return result;
    }
}