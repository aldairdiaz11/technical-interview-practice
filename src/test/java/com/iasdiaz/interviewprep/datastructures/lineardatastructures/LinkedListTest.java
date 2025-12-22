package com.iasdiaz.interviewprep.datastructures.lineardatastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    private LinkedList list;

    @BeforeEach
    void setUp() {
        list = new LinkedList();
    }

    @Test
    void testAddToHead() {
        list.addToHead("A");
        list.addToHead("B");
        assertEquals("B -> A -> <tail>", list.printList().replace("<head> ", ""));
    }

    @Test
    void testAddToTail() {
        list.addToTail("A");
        list.addToTail("B");
        assertEquals("A -> B -> <tail>", list.printList().replace("<head> ", ""));
    }

    @Test
    void testRemoveHead() {
        list.addToTail("A");
        list.addToTail("B");
        assertEquals("A", list.removeHead());
        assertEquals("B -> <tail>", list.printList().replace("<head> ", ""));
        assertEquals("B", list.removeHead());
        assertNull(list.removeHead());
    }
}