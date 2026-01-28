package com.iasdiaz.interviewprep.datastructures.nonlineardatastructures.trees;

import java.util.ArrayList;

public class TreeNode<T> {

    private T data;
    private final ArrayList<TreeNode<T>> children;

    public TreeNode(final T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public T getData() {
        return this.data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public void addChild(final TreeNode<T> child) {
        this.children.add(child);
    }

    public void addChild(final T childData) {
        this.children.add(new TreeNode<>(childData));
    }

    public void removeChild(final TreeNode<T> childToRemove) {
        if (this.children.isEmpty()) return;
        else if(this.children.remove(childToRemove)) return;
        else {
            for (TreeNode<T> child : this.children) {
                child.removeChild(childToRemove);
            }
        }
    }

    public void removeChild(final T childToRemove) {
        if (this.children.isEmpty()) return;

        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getData().equals(childToRemove)) {
                this.children.remove(i);
                return;
            }
        }

        for (final TreeNode<T> child_ : this.children) {
            child_.removeChild(childToRemove);
        }
    }

    public ArrayList<TreeNode<T>> getChildren() {
        return new ArrayList<>(children);
    }
}
