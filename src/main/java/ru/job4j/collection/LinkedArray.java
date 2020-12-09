package ru.job4j.collection;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedArray<E> implements Iterable<E> {
    private int count = 0;
    private int modcount = 0;
    private Node<E>[] nodes = new Node[10];

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public void add(E element) {
        if (count == 0) {
            nodes[count] = new Node<>(element, null, null);
        } else {
            nodes[count] = new Node<>(element, null, nodes[count - 1]);
            nodes[count - 1].next = nodes[count];
        }
        count++;
        modcount++;
        if (count == nodes.length) {
            nodes = Arrays.copyOf(nodes, count * 2);
        }
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public E get(int index) {
        Objects.checkIndex(index, count);
        return nodes[index].item;
    }

    @Override
    public Iterator<E> iterator() {
        int expectModCount = modcount;
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
                return nodes[position++].item;
            }
        };
    }

    public static void main(String[] args) {
        LinkedArray<String> words = new LinkedArray<>();
        words.add("first");
        words.add("second");
        words.add("third");
        words.add("fourth");
        words.add("fifth");
        words.add("sixth");
        words.add("seventh");
        words.add("eighth");
        words.add("ninth");
        words.add("tenth");
        words.add("eleventh");

        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    }
