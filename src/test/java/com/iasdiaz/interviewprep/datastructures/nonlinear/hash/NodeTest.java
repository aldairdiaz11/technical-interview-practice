package com.iasdiaz.interviewprep.datastructures.nonlinear.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NodeTest {
    private Node<String, String> node;

    @BeforeEach
    void setUp() {
        node = new Node<>("key","Test Data");
    }

    @Test
    void testConstructor() {
        final Node<String, String> newNode = new Node<>("key","Constructor Test");
        assertEquals("Constructor Test", newNode.getData());
        assertNull(newNode.getNext());
        assertNull(newNode.getPrev());
    }

    @Test
    void testGetData() {
        assertEquals("Test Data", node.getData());
    }

    @Test
    void testGetKey() {
        assertEquals("key", node.getKey());
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
        final Node<String, String> nextNode = new Node<>("new key","Next Data");
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
        Node<String, String> prevNode = new Node<>("prev key", "Prev Data");
        node.setPrev(prevNode);
        assertEquals(prevNode, node.getPrev());
        assertEquals("Prev Data", node.getPrev().getData());
    }

    @Test
    void testToString() {
        assertEquals("Node{data=Test Data}", node.toString());
    }
}