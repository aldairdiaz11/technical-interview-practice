package com.iasdiaz.interviewprep.datastructures.linear;

public class Stack<T> {

    private final LinkedList<T> stack;
    private int size;
    static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;
    private final int maxSize;

    public Stack() {
        this(DEFAULT_MAX_SIZE);
    }

    public Stack(final int maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException("maxSize must be greater than 0");
        }
        this.stack = new LinkedList<>();
        this.size = 0;
        this.maxSize = maxSize;
    }

    public int getSize() {
        return this.size;
    }

    public void push(final T data) {
        if (this.isFull()) {
            throw new IllegalStateException("Stack is full");
        }

        this.stack.addToHead(data);
        this.size++;
    }

    public T pop() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        final T data = this.stack.removeHead();
        this.size--;
        return data;
    }

    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return this.stack.peekHead();
    }

    private boolean isFull() {
        return this.size == this.maxSize;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }
}
