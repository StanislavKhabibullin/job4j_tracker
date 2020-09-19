package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ApiInterfeise {
    public static void main(String[] args) {
        List<Integer> nouns = List.of(-1, 2, 3, 2, -25, 56, 77, 33);
        List<Integer> plusNouns = nouns.stream().filter(noun -> noun > 0).collect(Collectors.toList());
        System.out.println(plusNouns);

    }
}
