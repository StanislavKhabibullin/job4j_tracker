package ru.job4j.tracker;

public class ByBy implements UserAction {
    private final Output out;

    public ByBy(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("See you soon!");
        return false;
    }
}
