package ru.job4j.iterators;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {
    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 3, 7, 8, 9));
        ListUtils.addAfter(input, 3, 12);
        assertThat(Arrays.asList(1, 2, 3, 3, 12, 3, 7, 8, 9), Is.is(input));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 3, 7, 8, 9));
        ListUtils.femoveIf(input, (integer) -> {
            return integer.equals(3);
        });
        assertThat(Arrays.asList(1, 2, 7, 8, 9), Is.is(input));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 3, 7, 8, 9));
        ListUtils.replaceIf(input, (integer) -> {
            return integer.equals(3);
        }, 14);
        assertThat(Arrays.asList(1, 2, 14, 14, 14, 7, 8, 9), Is.is(input));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 3, 7, 8, 9));
        List<Integer> rsl = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListUtils.removeAll(input, rsl);
        assertThat(Arrays.asList(7, 8, 9), Is.is(input));
    }

}