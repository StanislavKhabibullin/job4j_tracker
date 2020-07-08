package ru.job4j.tracker;

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
        Item[] temp = tracker.findByName(inp);
        if (temp.length > 0) {
            for (int i = 0; i < temp.length; i++) {
                out.println("id: " + temp[i].getId() +
                        " name: " + temp[i].getName());
            }
        } else {
            out.println("No such requests");
        }
        return true;
    }
}
