package ru.job4j.tracker;


public class StartUi {
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

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("INPUT YOUR CHOICE");
            if (select == 0) {
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
            }

        }

    }

    private void showMenu() {
        System.out.println("Menu." +
                System.lineSeparator() + "0. Add new Item" +
                System.lineSeparator() + "1. Show all items" +
                System.lineSeparator() + "2. Edit item" +
                System.lineSeparator() + "3. Delete item" +
                System.lineSeparator() + "4. Find item by Id" +
                System.lineSeparator() + "5. Find items by name" +
                System.lineSeparator() + "6. Exit Program" +
                System.lineSeparator() + "Select:");
    }



    public static void main(String[] args) {
       Input input = new ConsoleInput();
       Tracker temp = new Tracker();
       new StartUi().init(input, temp);

    }
}
