package ru.job4j.set;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UsageSet {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<String>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("one");
        strings.addAll(List.of("two", "four", "five one"));
        strings.stream().
                filter(s -> s.contains("one")).
                forEach(s -> System.out.println("Elements contains one: " + s));
        strings.removeIf(s -> s.contains("e"));
        for (String s:strings
             ) {
            System.out.println("Current element: " + s);
        }
    }
}
