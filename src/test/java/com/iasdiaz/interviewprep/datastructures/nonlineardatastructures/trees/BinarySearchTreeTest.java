package com.iasdiaz.interviewprep.datastructures.nonlineardatastructures.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

    @Test
    void constructor_shouldInitializeRootCorrectly() {
        BinarySearchTree bst = new BinarySearchTree(10);

        assertEquals(10, bst.getValue());
        assertNull(bst.getLeft());
        assertNull(bst.getRight());
    }

    @Test
    void insert_shouldPlaceSmallerValuesOnLeft() {
        BinarySearchTree bst = new BinarySearchTree(10);
        bst.insert(5);

        assertNotNull(bst.getLeft());
        assertEquals(5, bst.getLeft().getValue());
    }

    @Test
    void insert_shouldPlaceGreaterOrEqualValuesOnRight() {
        BinarySearchTree bst = new BinarySearchTree(10);
        bst.insert(15);
        bst.insert(10);

        assertNotNull(bst.getRight());
        assertEquals(15, bst.getRight().getValue());
        assertEquals(10, bst.getRight().getLeft().getValue());
    }

    @Test
    void search_shouldReturnNodeWhenValueExists() {
        BinarySearchTree bst = new BinarySearchTree(10);
        bst.insert(5);
        bst.insert(15);

        BinarySearchTree result = bst.search(15);

        assertNotNull(result);
        assertEquals(15, result.getValue());
    }

    @Test
    void search_shouldReturnNullWhenValueDoesNotExist() {
        BinarySearchTree bst = new BinarySearchTree(10);
        bst.insert(5);
        bst.insert(15);

        assertNull(bst.search(99));
    }

    @Test
    void inOrderTraversal_shouldReturnSortedValues() {
        BinarySearchTree bst = new BinarySearchTree(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);

        List<Integer> traversal = bst.inOrderTraversal();

        assertEquals(List.of(3, 5, 7, 10, 15), traversal);
    }

    @Test
    void depth_shouldReturnCorrectTreeHeight() {
        BinarySearchTree bst = new BinarySearchTree(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);

        assertEquals(3, bst.depth());
    }
}
