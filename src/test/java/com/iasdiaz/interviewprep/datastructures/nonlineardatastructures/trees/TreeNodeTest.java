package com.iasdiaz.interviewprep.datastructures.nonlineardatastructures.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TreeNodeTest {

    @Test
    void constructor_initializesDataAndEmptyChildren() {
        TreeNode<Integer> node = new TreeNode<>(10);

        assertEquals(10, node.getData());
        assertTrue(node.getChildren().isEmpty());
    }

    @Test
    void addChild_byNode() {
        TreeNode<String> root = new TreeNode<>("root");
        TreeNode<String> child = new TreeNode<>("child");

        root.addChild(child);

        assertEquals(1, root.getChildren().size());
        assertEquals("child", root.getChildren().getFirst().getData());
    }

    @Test
    void addChild_byData() {
        TreeNode<String> root = new TreeNode<>("root");

        root.addChild("child");

        assertEquals(1, root.getChildren().size());
        assertEquals("child", root.getChildren().getFirst().getData());
    }

    @Test
    void removeChild_byNode_directChild() {
        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> child = new TreeNode<>(2);

        root.addChild(child);
        root.removeChild(child);

        assertTrue(root.getChildren().isEmpty());
    }

    @Test
    void removeChild_byNode_recursive() {
        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> child = new TreeNode<>(2);
        TreeNode<Integer> grandChild = new TreeNode<>(3);

        child.addChild(grandChild);
        root.addChild(child);

        root.removeChild(grandChild);

        assertTrue(child.getChildren().isEmpty());
    }

    @Test
    void removeChild_byData_recursive() {
        TreeNode<String> root = new TreeNode<>("A");
        TreeNode<String> child = new TreeNode<>("B");

        child.addChild("C");
        root.addChild(child);

        root.removeChild("C");

        assertTrue(child.getChildren().isEmpty());
    }

    @Test
    void setData_updatesValue() {
        TreeNode<String> node = new TreeNode<>("old");

        node.setData("new");

        assertEquals("new", node.getData());
    }
}
