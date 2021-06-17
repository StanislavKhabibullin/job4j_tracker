package ru.job4j.tracker;

import java.util.Collections;

public class TrackerSort {
    public static void main(String[] args) {
        MemTracker test = new MemTracker();
        Item first = new Item("first");
        Item second = new Item("second");
        Item third = new Item("fird");
        test.add(first);
        test.add(second);
        test.add(third);
        for (Item var:test.findAll()
             ) {
            System.out.println(var.getName() + " id = " + var.getId());
        }
        System.out.println("Сортировка по имени по возрастанию");
        Collections.sort(test.findAll(), new TrackerSortById());
        for (Item var:test.findAll()
        ) {
            System.out.println(var.getName() + " id = " + var.getId());
        }
        System.out.println("Сортировка по имени по убыванию");
        Collections.sort(test.findAll(), new TrackerSortByIdDown());
        for (Item var:test.findAll()
        ) {
            System.out.println(var.getName() + " id = " + var.getId());
        }
    }
}
