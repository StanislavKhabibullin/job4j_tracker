package ru.job4j.tracker;

import java.sql.SQLException;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create a new Item";
    }

    @Override
    public boolean execute(Input input, Store memTracker) throws SQLException {
        String inp = input.askStr("Input request");
        Item next = new Item(inp);
        memTracker.add(next);
        return true;
    }
}
