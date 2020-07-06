package ru.job4j.tracker;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "Create a new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String inp = input.askStr("Input request");
        Item next = new Item(inp);
        tracker.add(next);
        return true;
    }
}
