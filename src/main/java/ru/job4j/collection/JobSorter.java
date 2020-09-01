package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Aix bu", 4),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 4)
        );
        System.out.println(jobs);
       /* Collections.sort(jobs);
        System.out.println(jobs); */
        Collections.sort(jobs, new JobDeskByName().thenComparing(new JobDeskByPriority()));
        System.out.println(jobs);
        Comparator<Job> comp = new JobDeskByName().thenComparing(new JobDeskByPriority()).thenComparing(new JobDeskByNameLn());
        Collections.sort(jobs, comp);
        System.out.println(jobs);
        Comparator<Job> taskByNameLn = new JobDeskByName().thenComparing(new JobDeskByNameLn());
        Comparator<Job> taskByPriorityLn = new JobDeskByPriority().thenComparing(new JobDeskByNameLn());
        Comparator<Job> taskByNameLnDown = new JobDeskByName().thenComparing(new JobDeskByNameDown());
        Comparator<Job> taskByPriorityDown = new JobDeskByPriority().thenComparing(new JobDeskByNameDown());
        Collections.sort(jobs, taskByPriorityLn);
        System.out.println(jobs);

    }
}
