package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("jurist", 4),
                new Job("professor", 1),
                new Job("economist", 7)
        );
        System.out.println(jobs);
       /* Collections.sort(jobs);
        System.out.println(jobs); */
        Collections.sort(jobs, Collections.reverseOrder());
        System.out.println(jobs);
    }
}
