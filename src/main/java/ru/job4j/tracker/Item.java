package ru.job4j.tracker;

public class Item {
    private String id;
    private String name;

    public Item() {
    }

    public Item(String id1, String name1) {
        this.id = id1;
        this.name = name1;
    }

    public Item(String name1) {
        this.id = name1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Item item = new Item();
    }
}