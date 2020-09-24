package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class MatrixToList {
    public static void main(String[] args) {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2, 3),
                List.of(9, 8, 7)
        );
        System.out.println(matrix);
        List<Integer> result = matrix.stream().flatMap(element -> element.stream()).collect(Collectors.toList());
        System.out.println(result);
    }
}
