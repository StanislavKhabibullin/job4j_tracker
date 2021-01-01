package ru.job4j.set;

import ru.job4j.collection.SimpleArray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<T> implements Iterable<T> {
    private int count = 0;
    private SimpleArray<T> arraySimple = new SimpleArray<>();

    public void add(T model) {
       if (contains(model)) {
           arraySimple.add(model);
       }
    }

    public boolean contains(T element) {
        Iterator<T> iterator = arraySimple.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == element) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return arraySimple.iterator();
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
