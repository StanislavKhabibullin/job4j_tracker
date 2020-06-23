package ru.job4j.tracker;

public class StartUi {

    public static void main(String[] args) {
       Item item = new Item(0, "job");
       Item result = new Item();
       Tracker temp = new Tracker();
        temp.add(item);
       result = temp.findById(item.getId());
        System.out.println("id - " + result.getId()
        + " name - " + result.getName());
    }
}
