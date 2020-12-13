package ru.job4j.collection;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {

        return in.poll();
    }

    public void push(T value) {
        in.push(value);

    }

   public static void main(String[] args) {
        SimpleQueue<Integer> stick = new SimpleQueue<>();
        stick.push(1);
        stick.push(2);
        stick.push(3);
        stick.push(4);
       System.out.println("Stack:");
       System.out.println(stick.poll());
       System.out.println(stick.poll());
       System.out.println(stick.poll());
       System.out.println(stick.poll());
    }
}
