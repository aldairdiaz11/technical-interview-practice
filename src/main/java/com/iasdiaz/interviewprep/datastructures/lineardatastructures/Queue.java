package com.iasdiaz.interviewprep.datastructures.lineardatastructures;

public class Queue<T> {

    private final LinkedList<T> queue;
    private int size;
    private final int maxSize;
    private static final int DEFAULT_MAX_CAPACITY = Integer.MAX_VALUE;

    public Queue() {
        this(DEFAULT_MAX_CAPACITY);
    }

    public Queue(int maxSize) {
        if (maxSize <= 0) throw new IllegalArgumentException();
        this.queue = new LinkedList<>();
        this.size = 0;
        this.maxSize = maxSize;
    }

    public void enqueue(final T data) {
        if (this.isFull()) {
            throw new IllegalStateException("Queue is full");
        }

        this.queue.addToTail(data);
        this.size ++;
    }

    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return this.queue.peekHead();
    }

    public T dequeue() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        final T data = this.queue.removeHead();
        this.size --;
        return data;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.maxSize;
    }
}
