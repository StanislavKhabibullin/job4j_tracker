package ru.job4j.stream;

import java.util.Objects;

public class Tupil {
    private String name;
    private double score;

    public Tupil(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null && getClass() != obj.getClass()) {
            return false;
        }
        Tupil tupil = (Tupil) obj;
        return Double.compare(tupil.score, score) == 0 && Objects.equals(tupil.name, name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
