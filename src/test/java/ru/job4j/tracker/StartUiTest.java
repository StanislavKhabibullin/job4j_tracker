package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import junit.framework.TestCase;

public class StartUiTest extends TestCase {

    public void testCreateItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUi.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    public void testShowItems() {
    }

    public void testEditItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("first");
        tracker.add(first);
        String[] answers = {String.valueOf(first.getId()), "second"};
        Input input = new StubInput(answers);

        StartUi.editItem(input, tracker);
        Item rezult = tracker.findById(first.getId());
        Item expected = new Item("second");
        assertThat(rezult.getName(), is(expected.getName()));
    }

    public void testDeleteItem() {
            Tracker tracker = new Tracker();
            Item bug = new Item("New Item");
            tracker.add(bug);
            String[] answers = {
                    String.valueOf(bug.getId())
            };
            StartUi.deleteItem(new StubInput(answers), tracker);
            Item expected = null;
            assertThat(tracker.findById(bug.getId()),
                    Matchers.is(expected)
            );
    }

    public void testFindByItem() {
    }

    public void testFindByName() {
    }

    public void testByBy() {
    }
}