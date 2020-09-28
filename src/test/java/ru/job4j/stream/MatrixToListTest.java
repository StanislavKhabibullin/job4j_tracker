package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class MatrixToListTest {

    @Test
    public void collectA() {
        Integer[][] matrix = new Integer[][]{{1, 2, 3}, {9, 8, 7}};
        MatrixToList rsl = new MatrixToList();
        List<Integer> result = rsl.tranfer(matrix);
        List<Integer> expect = List.of(1, 2, 3, 9, 8, 7);
        assertThat(result, is(expect));

    }

}