package ru.job4j.lambda;

import java.beans.Expression;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleFunction;

@SuppressWarnings("checkstyle:EmptyLineSeparator")
public class DiapazFunc {
    public static void main(String[] args) {
        System.out.println(DiapazFunc.diapazone(5, 8, (x) -> x * 2 + 1));
    }

    public static List<Double> diapazone(int start, int end, DoubleFunction<Double> func) {
        List<Double> rsl = new ArrayList<>();
        for (int i = start; i < end; i++) {
            rsl.add(func.apply(i));
        }
        return rsl;
    }
}