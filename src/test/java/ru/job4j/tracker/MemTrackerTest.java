package ru.job4j.tracker;

import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class MemTrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item(0, "test1");
        memTracker.add(item);
        Item result = memTracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        MemTracker test = new MemTracker();
        Item bug = new Item("New Item");
        test.add(bug);
        Item expected = new Item("Replace Item");
        test.replace(bug.getId(), expected);
        Item result = test.findById(bug.getId());
        assertThat(
                result.getName(),
                is("Replace Item")
        );
    }

    @Test
    public void whenDelete() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("New Item");
        memTracker.add(bug);
        String[] answers = {
                String.valueOf(bug.getId())
        };
        StartUi.deleteItem(new StubInput(answers), memTracker);
        Item expected = null;
        assertThat(memTracker.findById(bug.getId()),
                is(expected)
                );
    }

    @Test
    public void whenSortUp() {
        MemTracker test = new MemTracker();
        Item first = new Item("first");
        Item second = new Item("second");
        Item third = new Item("fird");
        test.add(first);
        test.add(second);
        test.add(third);
        Collections.sort(test.findAll(), new TrackerSortById());
        MemTracker expected = new MemTracker();
        expected.add(third);
        expected.add(first);
        expected.add(second);
        assertThat(test.findAll(),
                is(expected.findAll())
        );
    }

    @Test
    public void whenSortDown() {
        MemTracker test = new MemTracker();
        Item first = new Item("first");
        Item second = new Item("second");
        Item third = new Item("fird");
        test.add(first);
        test.add(second);
        test.add(third);
        Collections.sort(test.findAll(), new TrackerSortByIdDown());
        MemTracker expected = new MemTracker();
        expected.add(second);
        expected.add(first);
        expected.add(third);
        assertThat(test.findAll(),
                is(expected.findAll())
        );
    }
}