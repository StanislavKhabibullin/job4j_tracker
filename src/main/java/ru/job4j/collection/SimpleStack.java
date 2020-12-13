package ru.job4j.collection;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class SimpleStack<T> implements Iterable<T> {
    private ForwardLinked<T> linked = new ForwardLinked<>();

    public T pop() {

        return linked.deleteLast();
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public T poll() {
        return linked.deleteFirst();
    }

    public void push(T value) {
    linked.add(value);
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return linked.iterator();
    }
}
