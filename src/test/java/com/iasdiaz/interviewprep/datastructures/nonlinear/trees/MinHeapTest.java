package com.iasdiaz.interviewprep.datastructures.nonlinear.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

public class MinHeapTest {

    @Test
    void add_singleElement_popReturnsThatElement() {
        MinHeap heap = new MinHeap();
        heap.add(10);

        assertEquals(10, heap.pop());
    }

    @Test
    void add_multipleElements_popReturnsMinimum() {
        MinHeap heap = new MinHeap();
        heap.add(10);
        heap.add(4);
        heap.add(15);
        heap.add(1);

        assertEquals(1, heap.pop());
    }

    @Test
    void pop_multipleTimes_returnsElementsInAscendingOrder() {
        MinHeap heap = new MinHeap();
        heap.add(5);
        heap.add(3);
        heap.add(8);
        heap.add(1);
        heap.add(2);

        assertEquals(1, heap.pop());
        assertEquals(2, heap.pop());
        assertEquals(3, heap.pop());
        assertEquals(5, heap.pop());
        assertEquals(8, heap.pop());
    }

    @Test
    void pop_onEmptyHeap_throwsException() {
        MinHeap heap = new MinHeap();

        assertThrows(NoSuchElementException.class, heap::pop);
    }

    @Test
    void add_duplicateValues_preservesHeapOrder() {
        MinHeap heap = new MinHeap();
        heap.add(3);
        heap.add(3);
        heap.add(3);

        assertEquals(3, heap.pop());
        assertEquals(3, heap.pop());
        assertEquals(3, heap.pop());
    }

    @Test
    void interleavedAddAndPop_maintainsMinHeapProperty() {
        MinHeap heap = new MinHeap();
        heap.add(10);
        heap.add(5);

        assertEquals(5, heap.pop());

        heap.add(2);
        heap.add(8);

        assertEquals(2, heap.pop());
        assertEquals(8, heap.pop());
        assertEquals(10, heap.pop());
    }

    @Test
    void largeDescendingInsertions() {
        MinHeap heap = new MinHeap();

        for (int i = 1000; i >= 1; i--) {
            heap.add(i);
        }

        for (int i = 1; i <= 1000; i++) {
            assertEquals(i, heap.pop());
        }
    }
}