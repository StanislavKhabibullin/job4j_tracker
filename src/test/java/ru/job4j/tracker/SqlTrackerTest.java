package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {
    private String nullValue = "";

    @Before
    public void clearNullValue() {
        nullValue = null;
    }

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() {
        SqlTracker tracker = null;
        try {
            tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            tracker.add(new Item("name17"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        assertThat(tracker.findByName("name17").size(), is(1));

    }

    @Test
    public void testEditItem() {
        SqlTracker tracker = null;
        try {
            tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Item masik = null;
        try {
            masik = tracker.add(new Item("name17"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            tracker.replace(masik.getId(), new Item("name27"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        assertThat(tracker.findById(masik.getId()).getName(), is("name27"));
    }

    @Test
    public void testDeleteItemO() {
        SqlTracker tracker = null;
        try {
            tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Item item = new Item("item");
        try {
            item = tracker.add(item);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId()),
                is(nullValue));
    }

    @Test
    public void testFindById() {
        SqlTracker tracker = null;
        try {
            tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            tracker.add(new Item("testRes"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<Item> mas = tracker.findByName("testRes");
        Item result = mas.get(0);
        assertThat(tracker.findById(result.getId()).getName(),
                is("testRes"));
    }

    @Test
    public void testFindByName() {
        SqlTracker tracker = null;
        try {
            tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Item masik = null;
        try {
            masik = tracker.add(new Item("testRes"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        assertThat(tracker.findByName("testRes").get(0).getId(),
                is(masik.getId()));
    }

    @Test
    public void testFindAll() {
        SqlTracker tracker = null;
        try {
            tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Item masik = null;
        try {
            masik = tracker.add(new Item("testRes"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Item masik1 = null;
        try {
            masik1 = tracker.add(new Item("testRes1"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<Item> result = new ArrayList<>();
        result.add(masik);
        result.add(masik1);
        var mas = tracker.findAll();
        var e = 0;
        for (Item ite
             :mas) {
            assertThat(ite, is(result.get(e)));
            e++;
        }

    }
}