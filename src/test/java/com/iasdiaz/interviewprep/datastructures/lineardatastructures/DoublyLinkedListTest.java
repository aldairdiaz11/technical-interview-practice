package com.iasdiaz.interviewprep.datastructures.lineardatastructures;

import com.iasdiaz.interviewprep.datastructures.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DoublyLinkedListTest {

    private DoublyLinkedList<String> dll;

    @BeforeEach
    void setUp() {
        dll = new DoublyLinkedList<>();
    }

    @Test
    void testAddToHead() {
        assertTrue(dll.isEmpty());
        assertEquals(0, dll.getSize());

        dll.addToHead("A");
        assertEquals("A", dll.getHead().getData());
        assertEquals("A", dll.getTail().getData());
        assertNull(dll.getHead().getPrev());
        assertNull(dll.getHead().getNext());
        assertEquals(1, dll.getSize());
        assertFalse(dll.isEmpty());

        dll.addToHead("B");
        assertEquals("B", dll.getHead().getData());
        assertEquals("A", dll.getTail().getData());
        assertEquals(dll.getHead(), dll.getHead().getNext().getPrev());  // Bidirectional check
        assertEquals("A", dll.getHead().getNext().getData());
        assertEquals(2, dll.getSize());
    }

    @Test
    void testAddToTail() {
        dll.addToTail("A");
        assertEquals("A", dll.getHead().getData());
        assertEquals("A", dll.getTail().getData());
        assertEquals(1, dll.getSize());

        dll.addToTail("B");
        assertEquals("A", dll.getHead().getData());
        assertEquals("B", dll.getTail().getData());
        assertEquals(dll.getTail(), dll.getTail().getPrev().getNext());  // Bidirectional check
        assertEquals("A", dll.getTail().getPrev().getData());
        assertEquals(2, dll.getSize());
    }

    @Test
    void testRemoveHead() {
        assertNull(dll.removeHead());  // Empty list
        assertEquals(0, dll.getSize());

        dll.addToTail("A");
        assertEquals("A", dll.removeHead());
        assertNull(dll.getHead());
        assertNull(dll.getTail());
        assertEquals(0, dll.getSize());
        assertTrue(dll.isEmpty());

        dll.addToTail("A");
        dll.addToTail("B");
        assertEquals("A", dll.removeHead());
        assertEquals("B", dll.getHead().getData());
        assertEquals("B", dll.getTail().getData());
        assertNull(dll.getHead().getPrev());
        assertEquals(1, dll.getSize());
    }

    @Test
    void testRemoveTail() {
        assertNull(dll.removeTail());  // Empty list

        dll.addToTail("A");
        assertEquals("A", dll.removeTail());
        assertNull(dll.getHead());
        assertNull(dll.getTail());
        assertEquals(0, dll.getSize());

        dll.addToTail("A");
        dll.addToTail("B");
        assertEquals("B", dll.removeTail());
        assertEquals("A", dll.getHead().getData());
        assertEquals("A", dll.getTail().getData());
        assertNull(dll.getTail().getNext());
        assertEquals(1, dll.getSize());
    }

    @Test
    void testRemoveByData() {
        assertNull(dll.removeByData("X"));  // Empty

        dll.addToTail("A");
        dll.addToTail("B");
        dll.addToTail("C");
        assertEquals(3, dll.getSize());

        // Remove middle
        Node<String> removed = dll.removeByData("B");
        assertNotNull(removed);
        assertEquals("B", removed.getData());
        assertEquals("A", dll.getHead().getData());
        assertEquals("C", dll.getTail().getData());
        assertEquals("C", dll.getHead().getNext().getData());  // A -> C
        assertEquals("A", dll.getTail().getPrev().getData());  // C <- A
        assertEquals(2, dll.getSize());

        // Remove non-existent
        assertNull(dll.removeByData("X"));
        assertEquals(2, dll.getSize());

        // Remove head
        dll.removeByData("A");
        assertEquals("C", dll.getHead().getData());
        assertEquals("C", dll.getTail().getData());
        assertEquals(1, dll.getSize());

        // Remove last (tail)
        dll.removeByData("C");
        assertNull(dll.getHead());
        assertNull(dll.getTail());
        assertEquals(0, dll.getSize());
        assertTrue(dll.isEmpty());
    }

    @Test
    void testPrintList() {
        dll.addToTail("A");
        dll.addToTail("B");
        final String result = dll.printList();
        assertTrue(result.contains("<head> A -> B -> <tail>"));  // Basic content check
    }

    @Test
    void testMixedOperations() {
        dll.addToHead("C");
        dll.addToTail("D");
        dll.addToHead("B");
        dll.addToTail("E");
        dll.addToHead("A");
        assertEquals(5, dll.getSize());
        assertEquals("A", dll.getHead().getData());
        assertEquals("E", dll.getTail().getData());

        dll.removeHead();  // Remove A
        dll.removeTail();  // Remove E
        assertEquals("B", dll.getHead().getData());
        assertEquals("D", dll.getTail().getData());
        assertEquals(3, dll.getSize());

        dll.removeByData("C");  // Remove middle
        assertEquals("B", dll.getHead().getData());
        assertEquals("D", dll.getTail().getData());
        assertEquals("D", dll.getHead().getNext().getData());
        assertEquals(2, dll.getSize());
    }
}