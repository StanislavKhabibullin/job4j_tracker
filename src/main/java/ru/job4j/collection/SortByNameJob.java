package ru.job4j.collection;

import java.util.Comparator;

public class SortByNameJob implements Comparator<Job> {

    @Override
    public int compare(Job first, Job second) {
        return (first.getPriority().compareTo(second.getPriority()) * (1));
    }
}
