package ru.job4j.set;

import ru.job4j.collection.SimpleArray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<T> implements Iterable<T> {
    private int count = 0;
    private boolean mdcount = true;
    private Object[] container = new Object[10];

    public void add(T model) {
        if (count == container.length) {
            container = Arrays.copyOf(container, count * 2);
        }
        for (Object o : container) {
            if (o == model) {
                mdcount = false;
                break;
            }
        }
       if (mdcount) {
           container[count++] = model;
       } else {
           mdcount = true;
       }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < count;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[position++];
            }
        };
    }

    public static void main(String[] args) {
            SimpleSet<String> words = new SimpleSet<>();
            words.add("first");
            words.add("second");
            words.add("third");
            words.add("fourth");
            words.add("first");
            words.add("sixth");
            words.add("seventh");
            words.add("first");
            words.add("first");
            words.add("first");
            words.add("eleventh");

            Iterator<String> iterator = words.iterator();

            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

    }
}
