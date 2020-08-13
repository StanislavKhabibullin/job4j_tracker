package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.*;

public class PriorityQueueTest {

    @Test
    public void whenPutFirst() {
        PriorityQueue tes = new PriorityQueue();
        tes.put(new Task("low", 5));
        tes.put(new Task("Sequense", 1));
        tes.put(new Task("Priora", 3));
        Task result = tes.take();
        assertThat(result.getDesk(), is("Sequense"));

    }
}