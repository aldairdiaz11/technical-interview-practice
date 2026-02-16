package com.iasdiaz.interviewprep.datastructures.nonlinear.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TreeTest {

    private Tree<Integer> createSampleTree() {
        /*
                1
              /   \
             2     3
            /
           4
        */

        final TreeNode<Integer> root = new TreeNode<>(1);
        final TreeNode<Integer> child1 = new TreeNode<>(2);
        final TreeNode<Integer> child2 = new TreeNode<>(3);
        final TreeNode<Integer> grandChild = new TreeNode<>(4);

        child1.addChild(grandChild);
        root.addChild(child1);
        root.addChild(child2);

        return new Tree<>(root);
    }

    @Test
    void depthFirstTraversal_returnsCorrectOrder() {
        final Tree<Integer> tree = createSampleTree();

        final List<Integer> result = tree.depthFirstTraversal();

        assertEquals(List.of(1, 2, 4, 3), result);
    }

    @Test
    void breadthFirstTraversal_returnsCorrectOrder() {
        final Tree<Integer> tree = createSampleTree();

        final List<Integer> result = tree.breadthFirstTraversal();

        assertEquals(List.of(1, 2, 3, 4), result);
    }

}