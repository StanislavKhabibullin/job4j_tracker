package ru.job4j.collection;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    private int count = 0;
    private int countOut = 0;

    public T poll() {
    if (countOut == 0) {
        for (int i = 0; i < count; i++) {
            T rsl = in.pop();
            out.push(rsl);
            System.out.println("var = " + rsl);
            countOut++;
            }
        count = 0;
    }

        T result = out.pop();
        countOut--;
        return result;

     }

      public void push(T value) {
        in.push(value);
        count++;
    }

   public static void main(String[] args) {
        SimpleQueue<Integer> stick = new SimpleQueue<>();
        stick.push(1);
        stick.push(2);
       System.out.println(stick.poll());
        stick.push(3);

        stick.push(4);
       System.out.println("Stack:");
       System.out.println(stick.poll());
       System.out.println(stick.poll());

       System.out.println(stick.poll());

    }
}
