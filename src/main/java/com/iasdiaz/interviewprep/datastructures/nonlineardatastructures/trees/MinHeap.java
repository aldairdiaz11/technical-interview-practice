package com.iasdiaz.interviewprep.datastructures.nonlineardatastructures.trees;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MinHeap {
    // This is a 1-based min-heap backed by an ArrayList with a sentinel node.
    // Insert uses bubble-up, delete swaps the root with the last element and heapifies down.
    // The implementation handles edge cases explicitly and maintains O(log n) guarantees
    // Complexity:
    // add() → O(log n)
    // pop() → O(log n)
    // space → O(n)

    private final ArrayList<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(null);
    }

    public void add(final int value) {
        heap.add(value);
        bubbleUp();
    }

    public int pop() {
        if (heap.size() <= 1) {
            throw new NoSuchElementException("Heap is empty!");
        }
        swap(1, heap.size() - 1);
        int minValue = heap.removeLast();
        heapify();
        return minValue;
    }

    private void bubbleUp() {
        int currentIndex = this.heap.size() - 1;

        while (currentIndex > 1 && heap.get(currentIndex) < heap.get(getParent(currentIndex))) {
            swap(currentIndex, getParent(currentIndex));
            currentIndex = getParent(currentIndex);
        }
    }

    private void heapify() {
        if (heap.size() <= 1) {
            return;
        }
        int currentIndex = 1;
        int leftChildIndex = getLeftChild(currentIndex);
        int rightChildIndex = getRightChild(currentIndex);

        while (canSwap(currentIndex, leftChildIndex, rightChildIndex)) {

            if (this.exists(leftChildIndex) && this.exists(rightChildIndex)) {
                if (this.heap.get(leftChildIndex) < this.heap.get(rightChildIndex)) {
                    swap(currentIndex, leftChildIndex);
                    currentIndex = leftChildIndex;
                } else {
                    swap(currentIndex, rightChildIndex);
                    currentIndex = rightChildIndex;
                }
            } else if (exists(leftChildIndex)) {
                swap(currentIndex, leftChildIndex);
                currentIndex = leftChildIndex;
            } else {
                swap(currentIndex, rightChildIndex);
                currentIndex = rightChildIndex;
            }
            leftChildIndex = getLeftChild(currentIndex);
            rightChildIndex = getRightChild(currentIndex);
        }
    }

    private void swap(final int i, final int j) {
        final int temp = heap.get(j);
        heap.set(j, heap.get(i));
        heap.set(i, temp);
    }

    private int getParent(final int index) {
        return index / 2;
    }

    private int getLeftChild(final int index) {
        return index * 2;
    }

    private int getRightChild(final int index) {
        return index * 2 + 1;
    }

    private boolean exists(final int index) {
        return index <= this.heap.size() - 1;
    }

    private boolean canSwap(final int currentIndex, final int leftChildIndex, final int rightChildIndex) {
        final int currentValue = heap.get(currentIndex);
        return (exists(leftChildIndex) && currentValue > heap.get(leftChildIndex))
                || (exists(rightChildIndex) && currentValue > heap.get(rightChildIndex));
    }
}
