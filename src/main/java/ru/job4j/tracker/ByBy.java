package ru.job4j.tracker;

public class ByBy implements UserAction {
    private final Output out;

    public ByBy(Output out) {
        this.out = out;
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("See you soon!");
        return false;
    }
}
