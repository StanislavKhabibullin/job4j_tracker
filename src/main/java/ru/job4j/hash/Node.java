package ru.job4j.hash;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Node<K, V> {
        private List<Node<K, V>> nodes;
        private int hash;
        private K key;
        private V value;

        public Node(K key, V value) {
            this.nodes = new LinkedList<Node<K, V>>();
            this.key = key;
            this.value = value;
        }

        public List<Node<K, V>> getNodes() {
            return nodes;
        }

      //  public int hash() {
      //      return hashCode() % hashtable.length;
      //  }

        public K getKey() {
            return key;
        }

        @SuppressWarnings("checkstyle:EmptyLineSeparator")
        public V getValue() {
            return value;
        }
}
