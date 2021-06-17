package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    private final Output out;

    public DeleteItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        int promt = input.askInt("Input id elements you want to delete: ");
        if (memTracker.delete(promt)) {
            out.println("Delete succes");
        } else {
            out.println("Error no such id");
        }
        return true;
    }
}
