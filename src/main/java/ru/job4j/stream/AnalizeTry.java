package ru.job4j.stream;

import java.util.*;

public class AnalizeTry {
    public static void main(String[] args) {
        Analize rsl = new Analize();
        Analize.User first = new Analize.User(1, "Victor1");
        Analize.User first1 = new Analize.User(2, "Victor2");
        Analize.User first2 = new Analize.User(3, "Victor3");
        List<Analize.User> vikkks = Arrays.asList();
        vikkks.add(first);
        vikkks.add(first1);
        vikkks.add(first2);
        Analize.User first3 = new Analize.User(1, "Victor1");
        Analize.User first4 = new Analize.User(2, "Victor22");
        Analize.User first5 = new Analize.User(3, "Victor33");
        List<Analize.User> vikaks = Arrays.asList();
        vikaks.add(first3);
        vikaks.add(first4);
        vikaks.add(first5);
        Analize.Info result = rsl.diff(vikaks, vikkks);
        System.out.println(result);
    }
}
