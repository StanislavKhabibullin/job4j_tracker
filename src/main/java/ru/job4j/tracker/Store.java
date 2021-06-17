package ru.job4j.tracker;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface Store extends AutoCloseable {
    void init() throws IOException, ClassNotFoundException, SQLException;

    Item add(Item item) throws SQLException;

    boolean replace(int id, Item item) throws SQLException;

    boolean delete(int id);

    List<Item> findAll();

    List<Item> findByName(String key);

    Item findById(int id);
}
