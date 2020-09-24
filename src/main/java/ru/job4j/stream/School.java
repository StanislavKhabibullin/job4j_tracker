package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    public Map<String, Student> listToMap(List<Student> students) {
        List<String> surnames = students.stream().
                map(student -> student.getSurname()).
                collect(Collectors.toList());
        Map<String, Student> studentMap = students.stream().
                collect(Collectors.toMap(student -> student.getSurname(),
                        student -> student));

        return studentMap;
    }
}
