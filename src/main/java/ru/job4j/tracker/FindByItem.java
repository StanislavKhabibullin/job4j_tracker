package ru.job4j.tracker;

public class FindByItem implements UserAction {
    private final Output out;

    public FindByItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find By Id";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        int promt = input.askInt("Input id elements you want to find: ");
        Item temp = memTracker.findById(promt);
        if (temp != null) {
            out.println("id: " + temp.getId()
                    + " name: " + temp.getName());
        } else {
            out.println("No such id");
        }
        return true;
    }
}
