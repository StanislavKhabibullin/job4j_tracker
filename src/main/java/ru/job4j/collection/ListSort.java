package ru.job4j.collection;

import java.util.*;

public class ListSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 2, 1, 8);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Integer fisrt = 5;
        Integer second = 2;
        int rsl = fisrt.compareTo(second);
        System.out.println(rsl);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }
}
