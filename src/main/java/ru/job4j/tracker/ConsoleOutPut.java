package ru.job4j.tracker;

public class ConsoleOutPut implements Output {
    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
}