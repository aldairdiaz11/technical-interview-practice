package com.iasdiaz.interviewprep.datastructures.nonlinear.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HashMapTest {

    private HashMap<String, Integer> map;

    @BeforeEach
    void setUp() {
        map = new HashMap<>(10);
    }

    // ---------- Basic behavior ----------

    @Test
    void newMap_shouldBeEmpty() {
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
    }

    @Test
    void put_shouldAddNewKeyValuePair() {
        map.put("a", 1);

        assertEquals(1, map.size());
        assertEquals(1, map.get("a"));
    }

    @Test
    void put_existingKey_shouldUpdateValue() {
        map.put("a", 1);
        map.put("a", 99);

        assertEquals(1, map.size());
        assertEquals(99, map.get("a"));
    }

    @Test
    void put_existingKeyInCollisionChain_shouldNotIncreaseSize() {
        String k1 = "FB";
        String k2 = "Ea"; // collides with FB

        map.put(k1, 1);
        map.put(k2, 2);

        int sizeBefore = map.size();

        map.put(k1, 99); // update existing key

        assertEquals(sizeBefore, map.size());
        assertEquals(99, map.get(k1));
        assertEquals(2, map.get(k2));
    }

    @Test
    void get_unknownKey_shouldReturnNull() {
        assertNull(map.get("missing"));
    }

    // ---------- Remove ----------

    @Test
    void remove_existingKey_shouldRemoveAndReturnValue() {
        map.put("a", 10);

        Integer removed = map.remove("a");

        assertEquals(10, removed);
        assertEquals(0, map.size());
        assertFalse(map.containsKey("a"));
    }

    @Test
    void remove_missingKey_shouldReturnNull() {
        assertNull(map.remove("missing"));
    }

    @Test
    void remove_missingKey_shouldNotChangeSize() {
        map.put("a", 1);
        int sizeBefore = map.size();

        assertNull(map.remove("missing"));
        assertEquals(sizeBefore, map.size());
    }

    @Test
    void remove_keyFromCollisionChain_shouldDecrementSizeOnce() {
        String k1 = "FB";
        String k2 = "Ea";

        map.put(k1, 1);
        map.put(k2, 2);

        int sizeBefore = map.size();

        Integer removed = map.remove(k1);

        assertEquals(1, removed);
        assertEquals(sizeBefore - 1, map.size());
        assertNull(map.get(k1));
        assertEquals(2, map.get(k2));
    }

    @Test
    void remove_nonHeadNode_shouldPreserveOtherEntries() {
        String k1 = "FB";
        String k2 = "Ea";

        map.put(k1, 1);
        map.put(k2, 2);

        // Depending on insertion order, one is head, one is not
        map.remove(k2);

        assertEquals(1, map.size());
        assertTrue(map.containsKey(k1));
        assertFalse(map.containsKey(k2));
    }

    // ---------- Contains ----------

    @Test
    void containsKey_shouldReturnTrueWhenKeyExists() {
        map.put("x", 5);

        assertTrue(map.containsKey("x"));
        assertFalse(map.containsKey("y"));
    }

    @Test
    void containsKey_shouldWorkForCollisionChain() {
        String k1 = "FB";
        String k2 = "Ea";

        map.put(k1, 1);
        map.put(k2, 2);

        assertTrue(map.containsKey(k1));
        assertTrue(map.containsKey(k2));
    }

    // ---------- Null handling ----------

    @Test
    void put_nullKey_shouldThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> map.put(null, 1));
    }

    @Test
    void get_nullKey_shouldThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> map.get(null));
    }

    // ---------- Collision handling ----------

    @Test
    void shouldHandleIndexForCollisionsCorrectly() {
        // These strings intentionally collide in many hash functions
        String k1 = "FB";
        String k2 = "Ea";

        map.put(k1, 1);
        map.put(k2, 2);

        assertEquals(2, map.size());
        assertEquals(1, map.get(k1));
        assertEquals(2, map.get(k2));
    }

    // ---------- Resizing ----------

    @Test
    void shouldHandleManyInsertionsWithoutDataLoss() {
        int elements = 100;

        for (int i = 0; i < elements; i++) {
            map.put("key" + i, i);
        }

        for (int i = 0; i < elements; i++) {
            assertEquals(i, map.get("key" + i));
        }

        assertEquals(elements, map.size());
    }
}
