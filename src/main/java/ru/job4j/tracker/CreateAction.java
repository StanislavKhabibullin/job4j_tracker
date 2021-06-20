package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.Random;

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
     //   String inp = input.askStr("Input request");
        Item next = new Item(stringGenerator());
        memTracker.add(next);
        return true;
    }

    public String stringGenerator() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }
}
