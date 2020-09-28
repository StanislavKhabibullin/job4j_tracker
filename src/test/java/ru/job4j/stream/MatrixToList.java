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
        MatrixToList rsl = new MatrixToList();
        List<Integer> result = rsl.tranfer(matrix);
        System.out.println(result);
    }

    public List<Integer> tranfer(List<List<Integer>> matrix) {
        return matrix.stream().flatMap(element -> element.stream()).collect(Collectors.toList());
    }
}
