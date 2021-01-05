package ru.job4j.collection;

public class Node<E> {

    private E item;
    private Node<E> next;

    public Node(E item, Node<E> next) {
        this.setItem(item);
        this.setNext(next);

    }

    @Override
    public String toString() {
        return "Node{"
                + "item=" + getItem()
                + ", next=" + getNext().getItem()
                + '}';
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
