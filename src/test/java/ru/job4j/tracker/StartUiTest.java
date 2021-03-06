package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.List;

@SuppressWarnings("checkstyle:WhitespaceAround")
public class StartUiTest /*extends TestCase */ {
   /* @Test
    public void testCreateItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        MemTracker memTracker = new MemTracker();
        StartUi.createItem(input, memTracker);
        List<Item> created = memTracker.findAll();
        Item expected = new Item("Fix PC");
        assertThat(created.get(0).getName(), is(expected.getName()));
    }

    @Test
    public void testShowItems() {
        Output output = new StubOutPut();
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Replaced item");
        memTracker.add(item);
        Item replaced = new Item("New item name");
        memTracker.add(replaced);
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowItems(output),
                new ByBy(output)
        };
        new StartUi(output).init(in, memTracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0 .Show all Items" + System.lineSeparator()
                + "1 .Exit" + System.lineSeparator()
                + "id: 1 name: Replaced item" + System.lineSeparator()
                + "id: 2 name: New item name" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0 .Show all Items" + System.lineSeparator()
                + "1 .Exit" + System.lineSeparator()
                + "See you soon!" + System.lineSeparator()));
    }

    @Test
    public void testEditItem() {
        Output output = new StubOutPut();
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Replaced item");
        memTracker.add(item);
        Item replaced = new Item("New item name");
        memTracker.add(replaced);
        Input in = new StubInput(
                new String[] {"0", "1", replaced.getName(), "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ByBy(output)
        };
        new StartUi(output).init(in, memTracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0 .Replase action" + System.lineSeparator()
                + "1 .Exit" + System.lineSeparator()
                + "Replace succes" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0 .Replase action" + System.lineSeparator()
                + "1 .Exit" + System.lineSeparator()
                + "See you soon!" + System.lineSeparator()));
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    @Test
    public void testDeleteItem() {
        Output output = new StubOutPut();
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Replaced item");
        memTracker.add(item);
        Item replaced = new Item("New item name");
        memTracker.add(replaced);
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteItem(output),
                new ByBy(output)
        };
        new StartUi(output).init(in, memTracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0 .Delete Item" + System.lineSeparator()
                + "1 .Exit" + System.lineSeparator()
                + "Delete succes" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0 .Delete Item" + System.lineSeparator()
                + "1 .Exit" + System.lineSeparator()
                + "See you soon!" + System.lineSeparator()));
    }

    @Test
    public void testFindByItem() {
        Output output = new StubOutPut();
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Replaced item");
        memTracker.add(item);
        Item replaced = new Item("New item name");
        memTracker.add(replaced);
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new FindByItem(output),
                new ByBy(output)
        };
        new StartUi(output).init(in, memTracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0 .Find By Id" + System.lineSeparator()
                + "1 .Exit" + System.lineSeparator()
                + "id: 1 name: Replaced item" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0 .Find By Id" + System.lineSeparator()
                + "1 .Exit" + System.lineSeparator()
                + "See you soon!" + System.lineSeparator()));
    }

    @Test
    public void testFindByName() {
        Output output = new StubOutPut();
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Replaced item");
        memTracker.add(item);
        Item replaced = new Item("New item name");
        memTracker.add(replaced);
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new FindByName(output),
                new ByBy(output)
        };
        new StartUi(output).init(in, memTracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0 .Find By Name" + System.lineSeparator()
                + "1 .Exit" + System.lineSeparator()
                + "No such requests" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0 .Find By Name" + System.lineSeparator()
                + "1 .Exit" + System.lineSeparator()
                + "See you soon!" + System.lineSeparator()));
    }

    public void testByBy() {
    }

    @Test
    public void testInit() {
        Output output = new ConsoleOutPut();
        Input in = new StubInput(
                new String[] {"0", "Item Name", "1" }
        );
        MemTracker memTracker = new MemTracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ByBy(output)
        };
        new StartUi(output).init(in, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName(),
                is("Item Name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new ConsoleOutPut();
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Replaced item");
        memTracker.add(item);
        int index = item.getId();
        Item replaced = new Item("New item name");
        Input in = new StubInput(
                new String[] {"0", Integer.toString(index), replaced.getName(), "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ByBy(output)
        };
        new StartUi(output).init(in, memTracker, actions);
        assertThat(memTracker.findById(index).getName(), is(replaced.getName()));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutPut();
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Replaced item");
        memTracker.add(item);
        int index = item.getId();
        Item replaced = new Item("New item name");
        memTracker.add(replaced);
        Item rsl = null;
        Input in = new StubInput(
                new String[] {"1", "0", Integer.toString(index), "1", "2"}
        );
        UserAction[] actions = {
                new DeleteItem(output),
                new ShowItems(output),
                new ByBy(output)
        };
        new StartUi(output).init(in, memTracker, actions);
        assertThat(memTracker.findById(index), is(rsl));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutPut();
        Input in = new StubInput(
                new String[] {"0"}
        );
        MemTracker memTracker = new MemTracker();
        UserAction[] actions = {
                new ByBy(out)
        };
        new StartUi(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0 .Exit" + System.lineSeparator()
                        + "See you soon!" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutPut();
        Input in = new StubInput(
                new String[] {"7", "0"}
        );
        MemTracker memTracker = new MemTracker();
        UserAction[] actions = {
                new ByBy(out)
        };
        new StartUi(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0 .Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0 .Exit%n"
                                + "See you soon!%n"
                )
        ));
    }

    */

}