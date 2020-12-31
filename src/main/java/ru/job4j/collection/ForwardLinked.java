package ru.job4j.collection;

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
        head.item = null;
        head = head.next;
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

    public void revert() {
        if (head == null) {
            throw new NoSuchElementException();
        }
       if (head != null && head.next != null) {
           Node<T> current = head.next;
           head.next = null;
           while (current != null) {
               Node<T> next = current.next;
               current.next = head;
               head = current;
               current = next;
           }
       }
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
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
                T value = node.item;
                node = node.next;
                return value;
            }
        };

    }

    public static void main(String[] args) {
        ForwardLinked<Integer> numbers = new ForwardLinked<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        for (Integer integer : numbers) {
            System.out.println("var = " + integer);
        }
        numbers.revert();
        for (Integer number : numbers) {
            System.out.println("varRevert = " + number);
        }
    }
}
