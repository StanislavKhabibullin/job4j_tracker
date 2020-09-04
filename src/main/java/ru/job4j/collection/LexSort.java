package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftnumber = left.split(". ", 3);
        String[] rightnumber = right.split(". ", 3);
        Integer first = Integer.parseInt(leftnumber[0]);
        Integer second = Integer.parseInt(rightnumber[0]);
        return first.compareTo(second);
    }
}
