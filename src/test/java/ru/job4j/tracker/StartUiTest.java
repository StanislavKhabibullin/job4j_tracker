package ru.job4j.tracker;

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
    }

    public void testDeleteItem() {
    }

    public void testFindByItem() {
    }

    public void testFindByName() {
    }

    public void testByBy() {
    }
}