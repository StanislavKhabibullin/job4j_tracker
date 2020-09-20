package ru.job4j.stream;

import java.util.HashMap;
import java.util.Objects;

public class Student {
    private int scope;
    private String surname;

    public Student(int scope, String surname) {
        this.scope = scope;
        this.surname = surname;
    }

    public int getScope() {
        return scope;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{"
                + "scope=" + scope
                + ", surname='" + surname
                + '\'' + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student stud = (Student) obj;
        return scope == stud.scope && Objects.equals(surname, stud.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scope, surname);
    }
}
