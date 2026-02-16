package com.iasdiaz.interviewprep.datastructures.linear;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NodeTest {
    private Node<String> node;

    @BeforeEach
    void setUp() {
        node = new Node<>("Test Data");
    }

    @Test
    void testConstructor() {
        final Node<String> newNode = new Node<>("Constructor Test");
        assertEquals("Constructor Test", newNode.getData());
        assertNull(newNode.getNext());
        assertNull(newNode.getPrev());
    }

    @Test
    void testGetData() {
        assertEquals("Test Data", node.getData());
    }

    @Test
    void testSetData() {
        node.setData("Updated Data");
        assertEquals("Updated Data", node.getData());
    }

    @Test
    void testGetNext() {
        assertNull(node.getNext());
    }

    @Test
    void testSetNext() {
        final Node<String> nextNode = new Node<>("Next Data");
        node.setNext(nextNode);
        assertEquals(nextNode, node.getNext());
        assertEquals("Next Data", node.getNext().getData());
    }

    @Test
    void testGetPrev() {
        assertNull(node.getPrev());
    }

    @Test
    void testSetPrev() {
        Node<String> prevNode = new Node<>("Prev Data");
        node.setPrev(prevNode);
        assertEquals(prevNode, node.getPrev());
        assertEquals("Prev Data", node.getPrev().getData());
    }

    @Test
    void testToString() {
        assertEquals("Node{data=Test Data}", node.toString());
    }
}
