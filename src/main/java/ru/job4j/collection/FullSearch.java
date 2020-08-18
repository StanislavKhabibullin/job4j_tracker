package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public static HashSet<String> extractNumbers(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();
        for (Task strok:list
             ) {
            numbers.add(strok.getNumber());
        }
        return numbers;
    }
}
