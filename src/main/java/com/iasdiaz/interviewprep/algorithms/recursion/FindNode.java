package com.iasdiaz.interviewprep.algorithms.recursion;

import com.iasdiaz.interviewprep.datastructures.linear.Node;

public class FindNode<T> {
    public Node<T> findNodeRecursively(final T data, final Node<T>  currentNode) {
        if (currentNode == null) {
            return null;
        } else if (currentNode.getData().equals(data)) {
            return  currentNode;
        } else  {
            return findNodeRecursively(data, currentNode.getNext());
        }
    }
}
