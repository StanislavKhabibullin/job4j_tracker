package ru.job4j.tracker;

import java.util.List;

public class FindByName implements UserAction {
    private final Output out;

    public FindByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find By Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String inp = input.askStr("Input the name of request you want to find");
        List<Item> temp = tracker.findByName(inp);
        if (temp.size() > 0) {
            for (int i = 0; i < temp.size(); i++) {
                out.println("id: " + temp.get(i).getId()
                        + " name: " + temp.get(i).getId());
            }
        } else {
            out.println("No such requests");
        }
        return true;
    }
}
