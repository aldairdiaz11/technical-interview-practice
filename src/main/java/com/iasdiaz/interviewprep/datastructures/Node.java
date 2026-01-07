package com.iasdiaz.interviewprep.datastructures;

public class Node<T> {
    private T data;
    private Node<T> next;
    private Node<T> prev;

    public Node(final T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(final Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(final Node<T> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
