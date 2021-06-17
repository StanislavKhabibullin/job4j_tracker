package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MemTracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        size++;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                rsl = items.get(i);
                break;
            }
        }
        return rsl;
    }

    public List<Item> findAll() {
        return this.items;
    }

    public List<Item> findByName(String key) {
        int rex = 0;
        List<Item> temp = new ArrayList<>();
        for (int i = 0; i < this.size; i++) {
            if (items.get(i).getName().equals(key)) {
                temp.add(items.get(i));
            }
        }
        return temp;
    }

    private int indexOfId(int id) {
        int index = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
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
            items.set(exp, request);
            items.get(exp).setId(id);
            result = true;
        }
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        int index = indexOfId(id);
        if (index != -1) {
            items.remove(index);
            result = true;
        }
        return result;
    }
}