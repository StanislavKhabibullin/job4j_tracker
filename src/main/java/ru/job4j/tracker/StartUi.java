package ru.job4j.tracker;


public class StartUi {

    private final Output out;

    public StartUi(Output out) {
        this.out = out;
    }

    public static void createItem(Input input, Tracker tracker) {
        String inp = input.askStr("Input request");
        Item next = new Item(inp);
        tracker.add(next);
    }

    public static void showItems(Tracker tracker) {
        Item[] mas = tracker.findAll();
        for (int i = 0; i < mas.length; i++) {
            System.out.println("id: " + mas[i].getId() +
                    " name: " + mas[i].getName());
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        int promt = input.askInt("Input id elements you want to edit: ");
        String inp = input.askStr("Input the new request");
        Item zamena = new Item(inp);
        if (tracker.replace(promt, zamena)) {
            System.out.println("Replace succes");
        } else {
            System.out.println("Error no such id");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        int promt = input.askInt("Input id elements you want to delete: ");
        if (tracker.delete(promt)) {
            System.out.println("Delete succes");
        } else {
            System.out.println("Error no such id");
        }
    }

    public static void findByItem(Input input, Tracker tracker) {
        int promt = input.askInt("Input id elements you want to find: ");
        Item temp = tracker.findById(promt);
        if (temp != null) {
            System.out.println("id: " + temp.getId() +
                    " name: " + temp.getName());
        } else {
            System.out.println("No such id");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        String inp = input.askStr("Input the name of request you want to find");
        Item[] temp = tracker.findByName(inp);
        if (temp.length > 0) {
            for (int i = 0; i < temp.length; i++) {
                System.out.println("id: " + temp[i].getId() +
                        " name: " + temp[i].getName());
            }
        } else {
            System.out.println("No such requests");
        }
    }

    public static void byBy() {
        System.out.println("See you soon!");
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("INPUT YOUR CHOICE");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
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



    public static void main(String[] args) {
        Output output = new ConsoleOutPut();
       Input input = new ConsoleInput();
       Tracker temp = new Tracker();
       UserAction[] actions = {
               new CreateAction(output),
               new ShowItems(output),
               new ReplaceAction(),
               new DeleteItem(),
               new FindByName(output),
               new FindByItem(output),
               new ByBy()
       };
       new StartUi(output).init(input, temp, actions);

    }
}
