package ru.job4j.tracker;


import java.sql.SQLException;
import java.util.List;

public class StartUi {

    private final Output out;

    public StartUi(Output out) {
        this.out = out;
    }

    public static void createItem(Input input, MemTracker memTracker) {
        String inp = input.askStr("Input request");
        Item next = new Item(inp);
        memTracker.add(next);
    }

    public static void showItems(MemTracker memTracker) {
        List<Item> mas = memTracker.findAll();
        for (int i = 0; i < mas.size(); i++) {
            System.out.println("id: " + mas.get(i).getId()
                    + " name: " + mas.get(i).getName());
        }
    }

    public static void editItem(Input input, MemTracker memTracker) {
        int promt = input.askInt("Input id elements you want to edit: ");
        String inp = input.askStr("Input the new request");
        Item zamena = new Item(inp);
        if (memTracker.replace(promt, zamena)) {
            System.out.println("Replace succes");
        } else {
            System.out.println("Error no such id");
        }
    }

    public static void deleteItem(Input input, MemTracker memTracker) {
        int promt = input.askInt("Input id elements you want to delete: ");
        if (memTracker.delete(promt)) {
            System.out.println("Delete succes");
        } else {
            System.out.println("Error no such id");
        }
    }

    public static void findByItem(Input input, MemTracker memTracker) {
        int promt = input.askInt("Input id elements you want to find: ");
        Item temp = memTracker.findById(promt);
        if (temp != null) {
            System.out.println("id: " + temp.getId()
                    + " name: " + temp.getName());
        } else {
            System.out.println("No such id");
        }
    }

    public static void findByName(Input input, MemTracker memTracker) {
        String inp = input.askStr("Input the name of request you want to find");
        List<Item> temp = memTracker.findByName(inp);
        if (temp.size() > 0) {
            for (int i = 0; i < temp.size(); i++) {
                System.out.println("id: " + temp.get(i).getId()
                        + " name: " + temp.get(i).getId());
            }
        } else {
            System.out.println("No such requests");
        }
    }

    public static void byBy() {
        System.out.println("See you soon!");
    }

    public void init(Input input, Store memTracker, UserAction[] actions) throws SQLException {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("INPUT YOUR CHOICE");
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }

            UserAction action = actions[select];
            run = action.execute(input, memTracker);
           /* if (select == 0) {
                StartUi.createItem(input, tracker);
            } else if (select == 1) {
                StartUi.showItems(tracker);
            }
            else if (select == 2) {
                StartUi.editItem(input, tracker);
            }
            else if (select == 3) {
                StartUi.deleteItem(input, tracker);
            }
            else if (select == 4) {
                StartUi.findByItem(input, tracker);
            }
            else if (select == 5) {
                StartUi.findByName(input, tracker);
            }
            else if (select == 6) {
                StartUi.byBy();
                run = false;
            } */

        }

    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int i = 0; i < actions.length; i++) {
            out.println(i + " ." + actions[i].name());
        }
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public static void main(String[] args) {
     /*   Output output = new ConsoleOutPut();
       Input input = new ValidateInput(output, new ConsoleInput());
       MemTracker temp = new MemTracker();
       UserAction[] actions = {
               new CreateAction(output),
               new ShowItems(output),
               new ReplaceAction(output),
               new DeleteItem(output),
               new FindByName(output),
               new FindByItem(output),
               new ByBy(output)
       };
       new StartUi(output).init(input, temp, actions);

      */
        Output output = new ConsoleOutPut();
        Input validate = new ValidateInput(output,
                new ConsoleInput()
        );
        try (Store tracker = new SqlTracker()) {
            tracker.init();
            UserAction[] actions = {
                    new CreateAction(output),
                    new ShowItems(output),
                    new ReplaceAction(output),
                    new DeleteItem(output),
                    new FindByName(output),
                    new FindByItem(output),
                    new ByBy(output)

            };
            new StartUi(output).init(validate, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
