package ru.job4j.collection;


import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private int count = 0;
    private int modcount = 0;

    private Object[] container = new Object[10];

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public T get(int index) {
        Objects.checkIndex(index, count);
        return (T) container[index];
    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public void add(T model) {
        if (count == container.length) {
            container = Arrays.copyOf(container, count * 2);
        }
            container[count++] = model;
            modcount++;

    }

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    @Override
    public Iterator<T> iterator() {
        int expectModCount = modcount;
        return new Iterator<T>() {
           private int position = 0;

            @Override
            public boolean hasNext() {
                if (expectModCount != modcount) {
                    throw new ConcurrentModificationException();
                }
                return position < count;
            }

            @Override
            public T next() {
                if (expectModCount != modcount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[position++];
            }
        };
    }

    public static void main(String[] args) {
        SimpleArray<String> words = new SimpleArray<>();
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
