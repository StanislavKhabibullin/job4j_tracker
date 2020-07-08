package ru.job4j.tracker;

public class ByBy implements UserAction {
    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("See you soon!");
        return false;
    }
}