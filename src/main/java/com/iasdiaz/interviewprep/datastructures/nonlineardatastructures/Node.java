package com.iasdiaz.interviewprep.datastructures.nonlineardatastructures;

public class Node<K, V> {
    private final K key;
    private V data;
    private Node<K, V> next;
    private Node<K, V> prev;

    public Node(final K key, final V data) {
        // Node constructor for hash map implementation
        this.key = key;
        this.data = data;
        this.next = null;
    }

    public K getKey() {
        return key;
    }

    public V getData() {
        return data;
    }

    public void setData(final V data) {
        this.data = data;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public void setNext(final Node<K, V> next) {
        this.next = next;
    }

    public Node<K, V> getPrev() {
        return prev;
    }

    public void setPrev(final Node<K, V> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
