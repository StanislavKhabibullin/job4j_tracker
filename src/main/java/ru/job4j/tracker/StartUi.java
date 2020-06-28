package ru.job4j.tracker;

import java.util.Scanner;

public class StartUi {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("Input request");
                String inp = scanner.nextLine();
                Item next = new Item(inp);
                tracker.add(next);
            } else if (select == 1) {
                Item[] mas = new Item[tracker.findAll().length];
                mas = tracker.findAll();
                for (int i = 0; i < mas.length; i++) {
                    System.out.println("id: " + mas[i].getId() +
                            " name: " + mas[i].getName());
                }
            }
            else if (select == 2) {
                System.out.println("Input id elements you want to edit: ");
                int promt = Integer.valueOf(scanner.nextLine());
                    Item zamena = new Item();
                    System.out.println("Input the new request");
                    String inp = new String();
                    inp = scanner.nextLine();
                    zamena.setName(inp);
                    zamena.setId(promt);
                    if (tracker.replace(zamena.getId(), zamena)) {
                    System.out.println("Replace succes");
                } else {
                    System.out.println("Error no such id");
                }
            }
            else if (select == 3) {
                System.out.println("Input id elements you want to delete: ");
                int promt = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(promt)) {
                    System.out.println("Delete succes");
                } else {
                    System.out.println("Error no such id");
                }
            }
            else if (select == 4) {
                System.out.println("Input id elements you want to find: ");
                int promt = Integer.valueOf(scanner.nextLine());
                Item temp = new Item();
                temp = tracker.findById(promt);
                if (temp != null) {
                    System.out.println("id: " + temp.getId() +
                            " name: " + temp.getName());
                } else {
                    System.out.println("No such id");
                }
            }
            else if (select == 5) {
                System.out.println("Input the name of request you want to find");
                String inp = new String();
                inp = scanner.nextLine();
                Item[] temp = new Item[tracker.findByName(inp).length];
                temp = tracker.findByName(inp);
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
       Scanner scanner = new Scanner(System.in);
       Tracker temp = new Tracker();
       new StartUi().init(scanner, temp);

    }
}
