package ru.job4j.tracker;

import java.sql.SQLException;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Replase action";
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    @Override
    public boolean execute(Input input, Store memTracker) throws SQLException {
        int promt = input.askInt("Input id elements you want to edit: ");
        String inp = input.askStr("Input the new request");
        Item zamena = new Item(inp);
        if (memTracker.replace(promt, zamena)) {
            out.println("Replace succes");
        } else {
            out.println("Error no such id");
        }
        return true;
    }
}
