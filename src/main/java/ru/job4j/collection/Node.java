package ru.job4j.collection;

public class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    public Node(E item, Node<E> next, Node<E> prev) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Node{"
                + "item=" + item
                + ", next=" + next
                + ", prev=" + prev
                + '}';
    }

    public Node() {

    }
}
