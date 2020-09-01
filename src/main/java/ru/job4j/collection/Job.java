package ru.job4j.collection;

public class Job implements Comparable<Job> {
    private String name;
    private Integer priority;

    public Job(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public Integer getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Job{"
                + "name='" + name + '\''
                + ", priority=" + priority
                + '}';
    }

    @Override
    public int compareTo(Job obj) {
        return Integer.compare(priority, obj.getPriority());
    }

}
