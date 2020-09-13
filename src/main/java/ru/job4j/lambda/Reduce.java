package ru.job4j.lambda;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Reduce {
    public static int summation(int to) {
        int rsl = 0;
        for (int i = 0; i <= to; i++) {
            rsl += i;
        }
        return rsl;
    }

    public static int multiplication(int to) {
        int rsl = 1;
        for (int i = 1; i <= to; i++) {
            rsl *= i;
        }
        return rsl;
    }

    public static void main(String[] args) {
        System.out.println(summation(3));
        System.out.println(multiplication(3));
        System.out.println(summationLoop(5));
        System.out.println(multiplicationLoop(5));
    }

    public static int loop(int to, BiFunction<Integer, Integer, Integer> func, Supplier<Integer> initValue) {
        int rsl = initValue.get();
        for (int i = 1; i <= to; i++) {
            rsl = func.apply(rsl, i);
        }
        return rsl;
    }

    public static int summationLoop(int to) {
        BiFunction<Integer, Integer, Integer> func = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer left, Integer right) {
                return left + right;
            }
        };
        Supplier<Integer> initValue = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 0;
            }
        };
        return loop(to, func, initValue);
    }

    public static int multiplicationLoop(int to) {
        BiFunction<Integer, Integer, Integer> func = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer * integer2;
            }
        };

        Supplier<Integer> initValue = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 1;
            }
        };
        return loop(to, func, initValue);
    }
}
