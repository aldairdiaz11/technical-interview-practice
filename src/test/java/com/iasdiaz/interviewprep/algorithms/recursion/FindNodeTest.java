package com.iasdiaz.interviewprep.algorithms.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.iasdiaz.interviewprep.datastructures.linear.Node;
import com.iasdiaz.interviewprep.datastructures.linear.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FindNodeTest {

    private FindNode<Integer> findNode;
    private LinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        findNode = new FindNode<>();
        list = new LinkedList<>();

        // Linked list: 1 -> 2 -> 3 -> 4 -> null
        list.addToHead(1);
        list.addToTail(2);
        list.addToTail(3);
        list.addToTail(4);
    }

    @Test
    void shouldFindNodeAtHead() {
        final Node<Integer> result = findNode.findNodeRecursively(1, list.head);
        list.printList();

        assertNotNull(result);
        assertEquals(1, result.getData());
    }

    @Test
    void shouldFindNodeInMiddle() {
        final Node<Integer> result = findNode.findNodeRecursively(3, list.head);

        assertNotNull(result);
        assertEquals(3, result.getData());
    }

    @Test
    void shouldFindLastNode() {
        final Node<Integer> result = findNode.findNodeRecursively(4, list.head);

        assertNotNull(result);
        assertEquals(4, result.getData());
    }

    @Test
    void shouldReturnNullWhenValueNotFound() {
        final Node<Integer> result = findNode.findNodeRecursively(99, list.head);

        assertNull(result);
    }

    @Test
    void shouldReturnNullWhenListIsEmpty() {
        final Node<Integer> result = findNode.findNodeRecursively(1, null);

        assertNull(result);
    }

    @Test
    void shouldFindNodeInSingleElementList() {
        final Node<Integer> single = new Node<>(42);

        final Node<Integer> result = findNode.findNodeRecursively(42, single);

        assertNotNull(result);
        assertEquals(42, result.getData());
    }
}
