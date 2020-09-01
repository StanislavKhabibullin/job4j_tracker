package ru.job4j.collection;

import java.util.Comparator;

public class JobDeskByPriority implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return o2.getPriority().compareTo(o1.getPriority());
    }
}
