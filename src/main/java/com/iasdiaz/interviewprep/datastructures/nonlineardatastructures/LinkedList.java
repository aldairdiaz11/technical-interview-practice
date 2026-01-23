package com.iasdiaz.interviewprep.datastructures.nonlineardatastructures;


public class LinkedList<K, V> {

    private Node<K, V> head;

    public LinkedList() {
        this.head = null;
    }

    public V peekHead() {
        final Node<K, V> current = this.head;
        if (current == null) {
            return null;
        }
        return current.getData();
    }

    public Node<K, V> getHead() {
        return this.head;
    }

    public boolean put(K key, V data) {

        if (this.getHead() == null) {
            this.head = new Node<>(key, data);
            return true;
        }

        Node<K, V> current = this.head;
        while (true) {
            if (current.getKey().equals(key)) {
                current.setData(data);
                return false; // update
            }

            if (current.getNext() == null) {
                current.setNext(new Node<>(key, data));
                return true; // new insertion
            }
            current = current.getNext();
        }
    }

    public V get(K key){

        Node<K, V> current = getHead();
        while (current != null) {
            if (current.getKey().equals(key)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    public V remove(K key) {
        Node<K, V> current = getHead();
        Node<K, V> prev = null;

        while (current != null) {
            if (current.getKey().equals(key)) {
                if (prev == null) {
                    this.head = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
                return current.getData();
            }
            prev = current;
            current = current.getNext();
        }
        return null;
    }

    public boolean containsKey(K key){
        Node<K, V> current = getHead();

        while (current != null) {
            if (current.getKey().equals(key)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
}
