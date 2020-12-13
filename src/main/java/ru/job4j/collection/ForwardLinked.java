package ru.job4j.collection;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {

    private Node<T> head;

    public void add(T value) {
        if (head == null) {
            head = new Node<>(value, null);
            return;
        }
        Node<T> rsl = head;
        while (rsl.next != null) {
            rsl = rsl.next;
        }
        rsl.next = new Node<>(value, null);
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T value = head.item;
        Node<T> rsl = head.next;
        head = rsl;
    return value;
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> rsl = head;
        Node<T> fin = head;
        while (rsl.next != null) {
            fin = rsl;
            rsl = rsl.next;
        }
        T value = rsl.item;
        fin.next = null;
        return value;
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T vlue = node.item;
                node = node.next;
                return vlue;
            }
        };

    }
}
