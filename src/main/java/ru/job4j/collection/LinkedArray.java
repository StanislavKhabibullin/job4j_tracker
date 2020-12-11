package ru.job4j.collection;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedArray<E> implements Iterable<E> {
    private int count = 0;
    private int modcount = 0;
    private Node<E> nodes;
    private Node<E> current;

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public void add(E element) {
        if (count == 0) {
            nodes = new Node<>(element, null);
        } else {
            Node<E> newNode = new Node<>(element, nodes);
            nodes = newNode;
        }
        count++;
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public E get(int index) {
        Objects.checkIndex(index, count);
        int i = 0;
        while (nodes.next != null) {
            if (i == index) {
                return nodes.item;
            }
            i++;
        }
       return null;
    }

    @Override
    public Iterator<E> iterator() {
        current = nodes;
        return new Iterator<E>() {
            private int position = 0;
            @Override
            public boolean hasNext() {
                return position < count;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                position++;
                E value = current.item;
                current = current.next;
                return value;
            }
        };
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public static void main(String[] args) {
        LinkedArray<String> words = new LinkedArray<>();
        words.add("first");
        words.add("second");
        words.add("third");

        Iterator<String> iterator1 = words.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        words.add("fourth");
        words.add("fifth");
        words.add("sixth");
        words.add("seventh");
        words.add("eighth");
        words.add("ninth");
        words.add("tenth");
        words.add("eleventh");
        System.out.println("Full test:");
        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    }
