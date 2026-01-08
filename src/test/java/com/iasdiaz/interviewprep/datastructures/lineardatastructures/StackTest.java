package com.iasdiaz.interviewprep.datastructures.lineardatastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Test
    void newStack_shouldHaveSizeZero() {
        assertEquals(0, stack.getSize());
    }

    @Test
    void constructor_withNegativeMaxSize_shouldThrowException() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> new Stack<>(-1));

        assertEquals("maxSize must be greater than 0", exception.getMessage());
    }

    @Test
    void push_shouldIncreaseSize() {
        stack.push(10);
        assertEquals(1, stack.getSize());

        stack.push(20);
        assertEquals(2, stack.getSize());
    }

    @Test
    void pop_shouldDecreaseSize() {
        stack.push(10);
        stack.push(20);

        int value = stack.pop();
        assertEquals(20, value);
        assertEquals(1, stack.getSize());
    }

    @Test
    void stack_shouldFollowLifoOrder() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertEquals(0, stack.getSize());
    }

    @Test
    void peek_shouldReturnTopWithoutRemoving() {
        stack.push(100);
        stack.push(200);

        int peeked = stack.peek();
        assertEquals(200, peeked);
        assertEquals(2, stack.getSize()); // size unchanged
    }

    @Test
    void peek_onEmptyStack_shouldThrowException() {
        IllegalStateException exception =
                assertThrows(IllegalStateException.class, () -> stack.peek());

        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    void pop_onEmptyStack_shouldThrowException() {
        IllegalStateException exception =
                assertThrows(IllegalStateException.class, () -> stack.pop());

        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    void push_whenStackIsFull_shouldThrowException() {
        Stack<Integer> boundedStack = new Stack<>(2);

        boundedStack.push(1);
        boundedStack.push(2);

        IllegalStateException exception =
                assertThrows(IllegalStateException.class, () -> boundedStack.push(3));

        assertEquals("Stack is full", exception.getMessage());
    }

    @Test
    void stack_withMaxSizeZero_shouldNotAllowPush() {
        Stack<Integer> zeroStack = new Stack<>(0);

        assertEquals(0, zeroStack.getSize());

        IllegalStateException exception =
                assertThrows(IllegalStateException.class, () -> zeroStack.push(1));

        assertEquals("Stack is full", exception.getMessage());
    }

    @Test
    void stack_shouldAllowNullValues_ifLinkedListSupportsIt() {
        stack.push(null);

        assertEquals(1, stack.getSize());
        assertNull(stack.peek());
        assertNull(stack.pop());
        assertEquals(0, stack.getSize());
    }

}