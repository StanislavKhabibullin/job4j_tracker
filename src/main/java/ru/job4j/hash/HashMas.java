package ru.job4j.hash;

import java.util.*;
import java.util.function.Consumer;

public class HashMas<K, V> implements Book<K, V> {
    private Node<K, V>[] hashtable;
    private int size;
    private int treshOld;
    private float loadFactor;

    public HashMas() {
        this.hashtable = new Node[16];
        loadFactor = (float) (hashtable.length * 0.75);
        this.treshOld = (int) (loadFactor);
    }

    @Override
    public boolean insert(K key, V value) {
        if (size + 1 >= treshOld) {
            doubleMapa();

        }
        Node<K, V> newNode = new Node<>(key, value);
        int index = hash(newNode.getKey());

        if (hashtable[index] == null) {
            hashtable[index] = new Node<>(null, null);
            hashtable[index].getNodes().add(newNode);
            size++;
            return true;
        }

        return false;
    }

    public void doubleMapa() {
        treshOld = treshOld * 2;
        Node[] rsl = hashtable;
        this.hashtable = new Node[hashtable.length * 2];
        loadFactor = (float) (hashtable.length * 0.75);
        size = 0;
        for (Node<K, V> node : rsl) {
            if (node != null) {
                insert(node.getKey(), node.getValue());
            }
        }
    }

    @Override
    public boolean delete(K key) {
        int index = hash(key);
        if (!hashtable[index].equals(null)) {
            hashtable[index] = null;
            return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        return hashtable[index].getNodes().get(0).getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int countArray = 0;

            @Override
            public boolean hasNext() {
                if (countArray == size) {
                    return false;
                }
                return hashtable[countArray].getNodes().iterator().hasNext();
            }

            @Override
            public V next() {
                return hashtable[countArray++].getNodes().iterator().next().getValue();
            }
        };
    }

    private int hash(final K key) {
            int hash = 31;
            hash = hash * 17 + key.hashCode();
            return hash % hashtable.length;
    }

    public void add(K key, V value) {
            Node<K, V> kvNode = new Node<>(key, value);
            int index = hash(key);
            hashtable[index].getNodes();
    }

}
