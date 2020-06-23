package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item(0,"test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker test = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        test.add(bug);
        int id = bug.getId();
        Item budWithDesk = new Item();
        budWithDesk.setName("Bug with description");
        test.replace(id, budWithDesk);
        assertThat(
                test.findById(id).getName(),
                is("Bug with description")
        );
    }
}