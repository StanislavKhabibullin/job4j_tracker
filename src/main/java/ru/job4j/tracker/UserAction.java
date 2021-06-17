package ru.job4j.tracker;

import java.sql.SQLException;

public interface UserAction {
    String name();

    boolean execute(Input input, Store memTracker) throws SQLException;
    /* булевая переменная нужна чтобы обозначить действие выхода из программы, если вернуло false
    то считается что из программы вышли
     */
}
