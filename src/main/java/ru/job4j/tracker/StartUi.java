package ru.job4j.tracker;


public class StartUi {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("INPUT YOUR CHOICE");
            if (select == 0) {
                String inp = input.askStr("Input request");
                Item next = new Item(inp);
                tracker.add(next);
            } else if (select == 1) {
                Item[] mas = tracker.findAll();
                for (int i = 0; i < mas.length; i++) {
                    System.out.println("id: " + mas[i].getId() +
                            " name: " + mas[i].getName());
                }
            }
            else if (select == 2) {
                int promt = input.askInt("Input id elements you want to edit: ");
                    String inp = input.askStr("Input the new request");
                Item zamena = new Item(inp);
                    if (tracker.replace(promt, zamena)) {
                    System.out.println("Replace succes");
                } else {
                    System.out.println("Error no such id");
                }
            }
            else if (select == 3) {
                int promt = input.askInt("Input id elements you want to delete: ");
                if (tracker.delete(promt)) {
                    System.out.println("Delete succes");
                } else {
                    System.out.println("Error no such id");
                }
            }
            else if (select == 4) {
                int promt = input.askInt("Input id elements you want to find: ");
                Item temp = tracker.findById(promt);
                if (temp != null) {
                    System.out.println("id: " + temp.getId() +
                            " name: " + temp.getName());
                } else {
                    System.out.println("No such id");
                }
            }
            else if (select == 5) {
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
            else if (select == 6) {
                System.out.println("See you soon!");
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
