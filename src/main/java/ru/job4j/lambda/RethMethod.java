package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class RethMethod {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ivan",
                "Petr yhe Great",
                "Nikolay unique");

       // Consumer<String> consumer = (name) -> cutout(name);
        Consumer<String> consumer = RethMethod::cutout;
        names.forEach(consumer);
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public static void cutout(String name) {
        if (name.length() > 10) {
            System.out.println(name.substring(0, 10) + "..");
        } else {
            System.out.println(name);
        }
    }
}
