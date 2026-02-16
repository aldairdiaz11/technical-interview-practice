package com.iasdiaz.interviewprep.datastructures.nonlinear.trees;

import java.util.*;

public class Tree<T> {
    private final TreeNode<T> root;

    public Tree(final TreeNode<T> root) {
        this.root = root;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public List<T> depthFirstTraversal() {
        final List<T> result = new ArrayList<>();
        depthFirstTraversal(this.root, result);
        return result;
    }

    public void depthFirstTraversal(final TreeNode<T> current,  final List<T> result) {
        if  (current == null) return;

        result.add(current.getData());

        for (final TreeNode<T> child : current.getChildren()) {
            depthFirstTraversal(child, result);
        }
    }

    public List<T> breadthFirstTraversal() {
        final List<T> result = new ArrayList<>();
        Queue<TreeNode<T>> queue = new LinkedList<>();

        queue.add(getRoot());

        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.poll();
            result.add(current.getData());
            queue.addAll(current.getChildren());
        }
        return result;
    }

    public void printTree() {
        printTree(getRoot(), 0);
    }

    public void printTree(final TreeNode<T> current, final int level) {
        System.out.print("-- ".repeat(Math.max(0, level)) + current.getData().toString());
        for (TreeNode<T> child : current.getChildren()) {
            printTree(child, level + 1);
        }
    }
}
