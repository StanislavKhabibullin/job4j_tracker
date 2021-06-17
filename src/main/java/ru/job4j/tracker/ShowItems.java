package ru.job4j.tracker;

public class ShowItems implements UserAction {
    private final Output out;

    public ShowItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all Items";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        var  mas = memTracker.findAll();
        for (int i = 0; i < mas.size(); i++) {
            out.println("id: " + mas.get(i).getId()
                    + " name: " + mas.get(i).getName());
        }
        return true;
    }
}
