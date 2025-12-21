package com.iasdiaz.interviewprep.datastructures.lineardatastructures;

import com.iasdiaz.interviewprep.datastructures.Node;

public class LinkedList {

    public Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addToHead(final String data) {
        final Node newHead = new Node(data);
        final Node current = this.head;
        this.head = newHead;
        if (current != null) {
            this.head.setNext(current);
        }
    }

    public void addToTail(final String data) {
        Node newTail = this.head;
        if (newTail == null) {
            this.head = new Node(data);
        } else {
            while (newTail.getNext() != null) {
                newTail = newTail.getNext();
            }
            newTail.setNext(new Node(data));
        }
    }

    public String removeHead() {
        final Node current = this.head;
        if (current == null) {
            return null;
        }
        this.head = current.getNext();
        return current.getData();
    }

    public String printList() {
        final StringBuilder output = new StringBuilder("<head> ");
        Node current = this.head;
        while (current != null) {
            output.append(current.getData()).append(" -> ");
            current = current.getNext();
        }
        output.append("<tail>");
        return output.toString();
    }
}
