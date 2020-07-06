package ru.job4j.tracker;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
    /* булевая переменная нужна чтобы обозначить действие выхода из программы, если вернуло false
    то считается что из программы вышли
     */
}
