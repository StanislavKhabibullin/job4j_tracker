package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
       int[] numbers = {1, 2, 3};
       Integer total = 0;
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            Integer finalTotal = total;
            total = add(
                    () -> {
                        return finalTotal + num;
                    }
            );
        }
        System.out.println(total);

    }

    private static int add(Supplier<Integer> supplier) {
     return supplier.get();
    }
}
