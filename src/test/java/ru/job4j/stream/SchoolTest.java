package ru.job4j.stream;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SchoolTest {
    private List<Student> students = new ArrayList<>();

    @Before
    public void setUp() {
        students.add(new Student(10, "Surname1"));
        students.add(new Student(20, "Surname2"));
        students.add(new Student(30, "Surname3"));
        students.add(new Student(40, "Surname4"));
        students.add(new Student(50, "Surname5"));
        students.add(new Student(60, "Surname6"));
        students.add(new Student(70, "Surname7"));
        students.add(new Student(80, "Surname8"));
        students.add(new Student(90, "Surname9"));
    }

    @Test
    public void collectA() {
        School sc = new School();
        Predicate<Student> pr = x -> x.getScope() >= 70;
        List<Student> rezult = sc.collect(students, pr);
        List<Student> expect = new ArrayList<>();
        expect.add(new Student(70, "Surname7"));
        expect.add(new Student(80, "Surname8"));
        expect.add(new Student(90, "Surname9"));
        assertThat(rezult, is(expect));

    }

    @Test
    public void collectC() {
        School sc = new School();
        Predicate<Student> pr = x -> x.getScope() < 50;
        List<Student> rezult = sc.collect(students, pr);
        List<Student> expect = new ArrayList<>();
        expect.add(new Student(10, "Surname1"));
        expect.add(new Student(20, "Surname2"));
        expect.add(new Student(30, "Surname3"));
        expect.add(new Student(40, "Surname4"));
        assertThat(rezult, is(expect));

    }

    @Test
    public void collectBV() {
        School sc = new School();
        Predicate<Student> pr = x -> x.getScope() >= 50 && x.getScope() < 70;
        List<Student> rezult = sc.collect(students, pr);
        List<Student> expect = new ArrayList<>();
        expect.add(new Student(50, "Surname5"));
        expect.add(new Student(60, "Surname6"));
        assertThat(rezult, is(expect));

    }

    @Test
    public void inMap() {
        School sc = new School();
        Predicate<Student> pr = x -> x.getScope() >= 50 && x.getScope() < 70;
        List<Student> rezult = sc.collect(students, pr);
        Map<String, Student> result = sc.listToMap(rezult);
        Map<String, Student> expect = new HashMap<>();
        expect.put("Surname5", new Student(50, "Surname5"));
        expect.put("Surname6", new Student(60, "Surname6"));
        assertThat(result, is(expect));
    }
}