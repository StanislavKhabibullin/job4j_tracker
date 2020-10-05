package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentLevel {

    public static List<Student> levelOf(List<Student> list, int bound) {
        return list.stream()
                .flatMap(Stream::ofNullable)
                .sorted((left, right) -> Integer.compare(left.getScope(), right.getScope()))
                .dropWhile(v -> v.getScope() < bound)
                .collect(Collectors.toList());
    }
}
