package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MatrixToList {
    public static void main(String[] args) {
       Integer[][] matrix = new Integer[][]{{1, 2, 3}, {9, 8, 7}};

        System.out.println(matrix);
        MatrixToList rsl = new MatrixToList();
        List<Integer> result = rsl.tranfer(matrix);
        System.out.println(result);
    }

    public List<Integer> tranfer(Integer[][] matrix) {
      return Arrays.stream(matrix).flatMap(Arrays::stream).collect(Collectors.toList());
    }
}
