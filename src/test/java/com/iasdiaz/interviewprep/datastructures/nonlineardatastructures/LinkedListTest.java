package com.iasdiaz.interviewprep.datastructures.nonlineardatastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    private LinkedList<String, Integer> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    @Test
    void testPeek() {
        list.put("A", 1);
        list.put("B", 2);

        assertEquals(1, list.peekHead());
    }

    @Test
    void testPeekHeadEmpty() {
        assertNull(list.peekHead());
    }

    // ---------- Put ----------

    @Test
    void put_firstElement_shouldInsertAndReturnTrue() {
        boolean inserted = list.put("a", 1);

        assertTrue(inserted);
        assertEquals(1, list.get("a"));
    }

    @Test
    void put_secondElement_shouldAppendToList() {
        list.put("a", 1);
        list.put("b", 2);

        assertEquals(1, list.get("a"));
        assertEquals(2, list.get("b"));
    }

    @Test
    void put_existingKey_shouldUpdateValueAndReturnFalse() {
        list.put("a", 1);

        boolean inserted = list.put("a", 99);

        assertFalse(inserted);
        assertEquals(99, list.get("a"));
    }

    // ---------- Get ----------

    @Test
    void get_missingKey_shouldReturnNull() {
        assertNull(list.get("missing"));
    }

    @Test
    void get_existingKeyInCollisionChain_shouldReturnCorrectValue() {
        list.put("FB", 1); // intentional hash collision pattern
        list.put("Ea", 2);

        assertEquals(1, list.get("FB"));
        assertEquals(2, list.get("Ea"));
    }

    // ---------- Contains ----------

    @Test
    void containsKey_existingKey_shouldReturnTrue() {
        list.put("x", 10);

        assertTrue(list.containsKey("x"));
    }

    @Test
    void containsKey_missingKey_shouldReturnFalse() {
        list.put("x", 10);

        assertFalse(list.containsKey("y"));
    }

    @Test
    void containsKey_shouldWorkForCollisionChain() {
        list.put("FB", 1);
        list.put("Ea", 2);

        assertTrue(list.containsKey("FB"));
        assertTrue(list.containsKey("Ea"));
    }

    // ---------- Remove ----------

    @Test
    void remove_headNode_shouldRemoveAndReturnValue() {
        list.put("a", 1);
        list.put("b", 2);

        Integer removed = list.remove("a");

        assertEquals(1, removed);
        assertNull(list.get("a"));
        assertTrue(list.containsKey("b"));
    }

    @Test
    void remove_nonHeadNode_shouldRemoveOnlyThatNode() {
        list.put("a", 1);
        list.put("b", 2);
        list.put("c", 3);

        Integer removed = list.remove("b");

        assertEquals(2, removed);
        assertNull(list.get("b"));
        assertEquals(1, list.get("a"));
        assertEquals(3, list.get("c"));
    }

    @Test
    void remove_missingKey_shouldReturnNull() {
        list.put("a", 1);

        assertNull(list.remove("missing"));
    }

    // ---------- Defensive / Stability ----------

    @Test
    void multipleOperations_shouldNotCorruptList() {
        list.put("a", 1);
        list.put("b", 2);
        list.put("c", 3);

        list.remove("b");
        list.put("d", 4);
        list.put("a", 99);

        assertEquals(99, list.get("a"));
        assertNull(list.get("b"));
        assertEquals(3, list.get("c"));
        assertEquals(4, list.get("d"));
    }

}