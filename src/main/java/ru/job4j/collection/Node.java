package ru.job4j.collection;

public class Node<E> {
   E item;
   Node<E> next;

    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;

    }

    @Override
    public String toString() {
        return "Node{"
                + "item=" + item
                + ", next=" + next.item
                + '}';
    }
}
