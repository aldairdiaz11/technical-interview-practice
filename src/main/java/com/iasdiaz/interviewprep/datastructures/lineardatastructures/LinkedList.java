package com.iasdiaz.interviewprep.datastructures.lineardatastructures;

import com.iasdiaz.interviewprep.datastructures.Node;

public class LinkedList<T> {

    public Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    public void addToHead(final T data) {
        final Node<T> newHead = new Node<>(data);
        final Node<T> current = this.head;
        this.head = newHead;
        if (current != null) {
            this.head.setNext(current);
        }
    }

    public void addToTail(final T data) {
        Node<T> newTail = this.head;
        if (newTail == null) {
            this.head = new Node<>(data);
        } else {
            while (newTail.getNext() != null) {
                newTail = newTail.getNext();
            }
            newTail.setNext(new Node<>(data));
        }
    }

    public T removeHead() {
        final Node<T> current = this.head;
        if (current == null) {
            return null;
        }
        this.head = current.getNext();
        return current.getData();
    }

    public String printList() {
        final StringBuilder output = new StringBuilder("<head> ");
        Node<T> current = this.head;
        while (current != null) {
            output.append(current.getData()).append(" -> ");
            current = current.getNext();
        }
        output.append("<tail>");
        return output.toString();
    }

    public T peekHead() {
        final Node<T> current = this.head;
        if (current == null) {
            return null;
        }
        return current.getData();
    }
}
