package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class JobSorterTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDeskByName().thenComparing(new JobDeskByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameandLength() {
        Comparator<Job> taskByNameLn = new JobDeskByName().thenComparing(new JobDeskByNameLn());
        int rsl = taskByNameLn.compare(
                new Job("Fix bug", 2),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, is(0));
    }

    @Test
    public void whenCompatorByProrityandLength() {
        Comparator<Job> taskByPriorityLn = new JobDeskByPriority().thenComparing(new JobDeskByNameLn());
        int rsl = taskByPriorityLn.compare(
                new Job("Fix bug", 2),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameDown() {
        Comparator<Job> taskByNameLnDown = new JobDeskByName().thenComparing(new JobDeskByNameDown());
        int rsl = taskByNameLnDown.compare(
                new Job("Fix bug", 2),
                new Job("Aix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenPriorityByDown() {
        Comparator<Job> taskByPriorityDown = new JobDeskByPriority().thenComparing(new JobDeskByNameDown());
        int rsl = taskByPriorityDown.compare(
                new Job("Fix bug", 2),
                new Job("Aix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenPriority() {
        Comparator<Job> comp = new JobDeskByPriority();
           int rsl = comp.compare(
                new Job("Fix bug", 2),
                new Job("Aix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenDeskByName() {
        Comparator<Job> comp = new JobDeskByName();
        int rsl = comp.compare(
                new Job("Fix bug", 2),
                new Job("Aix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenDeskByNameLn() {
        Comparator<Job> comp = new JobDeskByNameLn();
        int rsl = comp.compare(
                new Job("Fix bug", 2),
                new Job("Aix bug", 1)
        );
        assertThat(rsl, is(0));
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    @Test
    public void whenDeskByNameDown() {
        Comparator<Job> comp = new JobDeskByNameDown();
        int rsl = comp.compare(
                new Job("Fix bu", 2),
                new Job("Aix bug", 1)
        );
        assertThat(rsl, is(1));
    }

    @Test
    public void whenPriorityUp() {
        Comparator<Job> comp = new JobDeskByPriorityUp();
        int rsl = comp.compare(
                new Job("Fix bu", 1),
                new Job("Aix bug", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenDeskByNameUp() {
        Comparator<Job> comp = new JobDeskByNameUp();
        int rsl = comp.compare(
                new Job("Aix bu", 2),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}