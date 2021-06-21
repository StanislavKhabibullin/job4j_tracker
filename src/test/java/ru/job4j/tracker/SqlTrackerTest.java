package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
    public void createItem() throws SQLException, IOException, ClassNotFoundException {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        tracker.add(new Item("name17"));
        assertThat(tracker.findByName("name17").size(), is(1));

    }

    @Test
    public void testEditItem() throws SQLException {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        tracker.replace(10, new Item("name17"));
        assertThat(tracker.findById(10).getName(), is("name17"));
    }

    @Test
    public void testDeleteItemO() throws SQLException {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        tracker.delete(8);
        assertThat(tracker.findById(8),
                is(nullValue));
    }

    @Test
    public void testFindById() throws SQLException {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        tracker.add(new Item("testRes"));
        List<Item> mas = tracker.findByName("testRes");
        Item result = mas.get(0);
        assertThat(tracker.findById(result.getId()).getName(),
                is("testRes"));
    }
}