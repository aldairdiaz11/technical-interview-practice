package com.iasdiaz.interviewprep.datastructures.lineardatastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {

    private Queue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>(3);
    }

    @Test
    void constructor_shouldThrowException_whenMaxSizeIsZero() {
        assertThrows(IllegalArgumentException.class, () -> new Queue<>(0));
    }

    @Test
    void constructor_shouldThrowException_whenMaxSizeIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Queue<>(-5));
    }

    @Test
    void enqueue_shouldAddElementsToQueue() {
        queue.enqueue(10);
        queue.enqueue(20);

        assertFalse(queue.isEmpty());
    }

    @Test
    void enqueue_shouldThrowException_whenQueueIsFull() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertTrue(queue.isFull());
        assertThrows(RuntimeException.class, () -> queue.enqueue(4));
    }

    @Test
    void peek_shouldReturnFirstElement_withoutRemovingIt() {
        queue.enqueue(100);
        queue.enqueue(200);

        int value = queue.peek();

        assertEquals(100, value);
        assertFalse(queue.isEmpty());
    }

    @Test
    void peek_shouldThrowException_whenQueueIsEmpty() {
        assertThrows(IllegalStateException.class, queue::peek);
    }

    @Test
    void dequeue_shouldRemoveAndReturnElementsInFifoOrder() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void dequeue_shouldThrowException_whenQueueIsEmpty() {
        assertThrows(IllegalStateException.class, queue::dequeue);
    }

    @Test
    void isEmpty_shouldReturnTrue_whenQueueIsNew() {
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
    }

    @Test
    void isFull_shouldReturnTrue_whenQueueReachesMaxSize() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertTrue(queue.isFull());
        assertFalse(queue.isEmpty());
    }

    @Test
    void queue_shouldAllowReuse_afterDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.dequeue();
        queue.dequeue();

        assertFalse(queue.isFull());

        queue.enqueue(4);
        queue.enqueue(5);

        assertTrue(queue.isFull());
    }
}
