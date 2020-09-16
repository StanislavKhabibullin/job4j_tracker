package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LazyLoading {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "first",
                "second"
        );

        Comparator<String> sortik = (left, right) -> {
            System.out.println("Execute");
           return left.length() - right.length();
        };
        list.sort(sortik);
    }
}