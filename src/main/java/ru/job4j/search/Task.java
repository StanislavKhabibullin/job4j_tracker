package ru.job4j.search;

public class Task {
    private String desk;
    private int priopity;

    public Task(String desk, int priopity) {
        this.desk = desk;
        this.priopity = priopity;
    }

    public String getDesk() {
        return desk;
    }

    public int getPriopity() {
        return priopity;
    }
}
