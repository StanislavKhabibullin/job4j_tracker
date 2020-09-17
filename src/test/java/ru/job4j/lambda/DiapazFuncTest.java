package ru.job4j.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class DiapazFuncTest {
    @Test
    public void whenLineFunction() {
        List<Double> result = DiapazFunc.diapazone(5, 8, (x) -> x * 2 + 1);
        List<Double> expect = Arrays.asList(11.0, 13.0, 15.0);
        assertThat(result, is(expect));
    }

    @Test
    public void whenXFunction() {
        List<Double> result = DiapazFunc.diapazone(5, 8, (x) -> x * x);
        List<Double> expect = Arrays.asList(25.0, 36.0, 49.0);
        assertThat(result, is(expect));
    }

    @Test
    public void whenPFunction() {
        List<Double> result = DiapazFunc.diapazone(2, 5, (x) -> Math.pow(2, x));
        List<Double> expect = Arrays.asList(4D, 8D, 16D);
        assertThat(result, is(expect));
    }
}