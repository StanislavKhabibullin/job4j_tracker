package ru.job4j.tracker;

import org.hamcrest.Matcher;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
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
        Item bug = new Item("New Item");
        test.add(bug);
        Item expected = new Item("Replace Item");
        test.replace(bug.getId(),expected);
        Item result = test.findById(bug.getId());
        assertThat(
                result.getName(),
                is("Replace Item")
        );
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item("New Item");
        tracker.add(bug);
        String[] answers = {
                String.valueOf(bug.getId())
        };
        StartUi.deleteItem(new StubInput(answers), tracker);
        Item expected = null;
        assertThat(tracker.findById(bug.getId()),
                is(expected)
                );
    }
}