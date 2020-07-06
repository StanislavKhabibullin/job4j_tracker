package ru.job4j.tracker;

public class ShowItems implements UserAction {
    @Override
    public String name() {
        return "Show all Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] mas = tracker.findAll();
        for (int i = 0; i < mas.length; i++) {
            System.out.println("id: " + mas[i].getId() +
                    " name: " + mas[i].getName());
        }
        return true;
    }
}
