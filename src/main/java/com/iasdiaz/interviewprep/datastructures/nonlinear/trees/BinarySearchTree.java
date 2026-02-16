package com.iasdiaz.interviewprep.datastructures.nonlinear.trees;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private final int value;
    private BinarySearchTree left;
    private BinarySearchTree right;

    public BinarySearchTree(final int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public BinarySearchTree getLeft() {
        return left;
    }

    public BinarySearchTree getRight() {
        return right;
    }

    public void insert(final int value) {
        if (value < getValue()) {
            if (getLeft() == null) {
                this.left = new BinarySearchTree(value);
            } else {
                getLeft().insert(value);
            }
        } else {
            if (getRight() == null) {
                this.right = new BinarySearchTree(value);
            } else {
                getRight().insert(value);
            }
        }
    }

    public BinarySearchTree search(final int value) {
        if (value == getValue()) {
            return this;
        } else if (value < getValue() && getLeft() != null) {
            return getLeft().search(value);
        } else if (value > getValue() && getRight() != null) {
            return getRight().search(value);
        }
        return null;
    }

    public List<Integer> inOrderTraversal() {
        final List<Integer> result = new ArrayList<>();
        inOrderTraversal(this, result);
        return result;
    }

    public void inOrderTraversal(final BinarySearchTree node, final List<Integer> result) {
        if (node == null) return;

        inOrderTraversal(node.getLeft(), result);
        result.add(node.getValue());
        inOrderTraversal(node.getRight(), result);
    }

    public int depth() {
        return 1 + Math.max(
                getLeft() == null ? 0 : left.depth(),
                getRight() == null ? 0 : right.depth()
        );
    }
}
