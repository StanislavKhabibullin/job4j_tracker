package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import junit.framework.TestCase;

public class StartUiTest /*extends TestCase */{

    public void testCreateItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUi.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void testShowItems() {
        Output output = new StubOutPut();
        Tracker tracker = new Tracker();
        Item item = new Item("Replaced item");
        tracker.add(item);
        Item replaced = new Item("New item name");
        tracker.add(replaced);
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowItems(output),
                new ByBy()
        };
        new StartUi(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator() +
                "0 .Show all Items" + System.lineSeparator() +
                "1 .Exit" + System.lineSeparator() +
                "id: 1 name: Replaced item" + System.lineSeparator() +
                "id: 2 name: New item name" + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0 .Show all Items" + System.lineSeparator() +
                "1 .Exit" + System.lineSeparator()));
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

    @Test
    public void testFindByItem() {
        Output output = new StubOutPut();
        Tracker tracker = new Tracker();
        Item item = new Item("Replaced item");
        tracker.add(item);
        Item replaced = new Item("New item name");
        tracker.add(replaced);
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new FindByItem(output),
                new ByBy()
        };
        new StartUi(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator() +
                "0 .Find By Id" + System.lineSeparator() +
                "1 .Exit" + System.lineSeparator() +
                "id: 1 name: Replaced item" + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0 .Find By Id" + System.lineSeparator() +
                "1 .Exit" + System.lineSeparator()));
    }

    @Test
    public void testFindByName() {
        Output output = new StubOutPut();
        Tracker tracker = new Tracker();
        Item item = new Item("Replaced item");
        tracker.add(item);
        Item replaced = new Item("New item name");
        tracker.add(replaced);
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new FindByName(output),
                new ByBy()
        };
        new StartUi(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator() +
                "0 .Find By Name" + System.lineSeparator() +
                "1 .Exit" + System.lineSeparator() +
                "No such requests" + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0 .Find By Name" + System.lineSeparator() +
                "1 .Exit" + System.lineSeparator()));
    }

    public void testByBy() {
    }

    @Test
    public void testInit() {
        Output output = new ConsoleOutPut();
        Input in = new StubInput(
                new String[] {"0", "Item Name", "1" }
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ByBy()
        };
        new StartUi(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(),
                is("Item Name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new ConsoleOutPut();
        Tracker tracker = new Tracker();
        Item item = new Item("Replaced item");
        tracker.add(item);
        int index = item.getId();
        Item replaced = new Item("New item name");
        Input in = new StubInput(
                new String[] {"0", Integer.toString(index), replaced.getName(), "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(),
                new ByBy()
        };
        new StartUi(output).init(in, tracker, actions);
        assertThat(tracker.findById(index).getName(), is(replaced.getName()));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutPut();
        Tracker tracker = new Tracker();
        Item item = new Item("Replaced item");
        tracker.add(item);
        int index = item.getId();
        Item replaced = new Item("New item name");
        tracker.add(replaced);
        Item rsl = null;
        Input in = new StubInput(
                new String[] {"1", "0", Integer.toString(index), "1", "2"}
        );
        UserAction[] actions = {
                new DeleteItem(),
                new ShowItems(output),
                new ByBy()
        };
        new StartUi(output).init(in, tracker, actions);
        assertThat(tracker.findById(index), is(rsl));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutPut();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ByBy()
        };
        new StartUi(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0 .Exit" + System.lineSeparator()
        ));
    }

}