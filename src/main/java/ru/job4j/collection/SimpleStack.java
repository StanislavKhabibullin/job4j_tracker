package ru.job4j.collection;



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

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    @Override
    public Iterator<T> iterator() {
        return linked.iterator();
    }
}
