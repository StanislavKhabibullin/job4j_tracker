package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Replase action";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int promt = input.askInt("Input id elements you want to edit: ");
        String inp = input.askStr("Input the new request");
        Item zamena = new Item(inp);
        if (tracker.replace(promt, zamena)) {
            System.out.println("Replace succes");
        } else {
            System.out.println("Error no such id");
        }
        return true;
    }
}
