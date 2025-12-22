package com.iasdiaz.interviewprep.datastructures.lineardatastructures;

import com.iasdiaz.interviewprep.datastructures.Node;

import java.util.Objects;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addToHead(final String data) {
        final Node newHead = new Node(data);
        final Node currentHead = getHead();
        if (currentHead != null) {
            currentHead.setPrev(newHead);
            newHead.setNext(currentHead);
        }
        this.head = newHead;
        this.size++;

        if (getTail() == null) {
            this.tail = getHead();
        }
    }

    public void addToTail(final String data) {
        final Node newTail = new Node(data);
        final Node currentTail = getTail();

        if (currentTail != null) {
            currentTail.setNext(newTail);
            newTail.setPrev(currentTail);
        }
        this.tail = newTail;
        this.size++;

        if (getHead() == null) {
            this.head = newTail;
        }
    }

    public String removeHead() {
        final Node removedHead = getHead();
        if (removedHead == null) {
            return null;
        }
        this.head = removedHead.getNext();
        if (getHead() != null) {
            this.head.setPrev(null);
        } else {
            this.tail = null;
        }
        this.size--;
        return removedHead.getData();
    }

    public String removeTail() {
        final Node removedTail = getTail();
        if (removedTail == null) {
            return null;
        }
        this.tail = removedTail.getPrev();

        if (getTail() != null ) {
            this.tail.setNext(null);
        } else {
            this.head = null;
        }
        this.size--;
        return removedTail.getData();
    }

    public Node removeByData(final String data) {
        Node nodeToRemove = null;
        Node currentNode = getHead();

        while (currentNode != null) {
            if (Objects.equals(currentNode.getData(), data)) {
                nodeToRemove = currentNode;
                break;
            }
            currentNode = currentNode.getNext();
        }

        if (nodeToRemove == null) {
            return null;
        }
        if (nodeToRemove == getHead()) {
            this.removeHead();
        } else if (nodeToRemove == getTail()) {
            this.removeTail();
        } else {
            Node nextNode = nodeToRemove.getNext();
            Node previousNode = nodeToRemove.getPrev();

            nextNode.setPrev(previousNode);
            previousNode.setNext(nextNode);
            this.size--;
        }
        return nodeToRemove;
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public String printList() {
        final StringBuilder output = new StringBuilder("<head> ");
        Node currentNode = getHead();
        while (currentNode != null) {
            output.append(currentNode.getData()).append(" -> ");
            currentNode = currentNode.getNext();
        }
        output.append("<tail>");
        System.out.println(output);
        return output.toString();
    }
}
