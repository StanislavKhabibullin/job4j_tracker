package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int promt = input.askInt("Input id elements you want to delete: ");
        if (tracker.delete(promt)) {
            System.out.println("Delete succes");
        } else {
            System.out.println("Error no such id");
        }
        return true;
    }
}
