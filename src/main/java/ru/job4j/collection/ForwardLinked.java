package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {

    private Node<T> head;

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public void add(T value) {
        if (head == null) {
            head = new Node<>(value, null);
            return;
        }
        Node<T> rsl = head;
        while (rsl.getNext() != null) {
            rsl = rsl.getNext();
        }
        rsl.setNext(new Node<>(value, null));
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T value = head.getItem();
        head.setItem(null);
        head = head.getNext();
    return value;
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> rsl = head;
        Node<T> fin = head;
        while (rsl.getNext() != null) {
            fin = rsl;
            rsl = rsl.getNext();
        }
        T value = rsl.getItem();
        fin.setNext(null);
        return value;
    }

    public void revert() {
        if (head == null) {
            throw new NoSuchElementException();
        }
       if (head != null && head.getNext() != null) {
           Node<T> current = head.getNext();
           head.setNext(null);
           while (current != null) {
               Node<T> next = current.getNext();
               current.setNext(head);
               head = current;
               current = next;
           }
       }
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.getItem();
                node = node.getNext();
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
