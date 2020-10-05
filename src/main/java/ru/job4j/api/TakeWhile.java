package ru.job4j.api;

import java.util.List;
import java.util.stream.Stream;

public class TakeWhile {
    public static void main(String[] args) {
        System.out.println("takeWhile - demonstration");
        List.of(1, 2, 3, 4).stream().
                takeWhile(v -> v < 3).map(v -> String.format(" %s", v + " number ")).
                forEach(System.out::println);
        System.out.println("dropWhile - demonstration");
        List.of(1, 2, 3, 4).stream()
                .dropWhile(x -> x < 3)
                .map(v -> String.format(" %s", v))
                .forEach(System.out::println);
        System.out.println("Stream.ofNullable - demonstration");
        Stream.of(1, null, 2, null, 3)
                .flatMap(Stream::ofNullable)
        .map(x -> String.format(" %s", x))
        .forEach(System.out::println);
    }
}
