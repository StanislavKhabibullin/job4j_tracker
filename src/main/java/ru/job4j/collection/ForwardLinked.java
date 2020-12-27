package ru.job4j.collection;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> rev;
    private int count = 0;

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public void add(T value) {
        count++;
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

    public void revert() {

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

    public static void main(String[] args) {
        ForwardLinked<Integer> numbers = new ForwardLinked<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.println("var = " + iterator.next());
        }
        numbers.revert();
        Iterator<Integer> iterator1 = numbers.iterator();
        while (iterator1.hasNext()) {
            System.out.println("varRevert = " + iterator1.next());
        }
    }
}
