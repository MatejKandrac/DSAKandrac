
/*
 * Copyright (c) Matej Kandráč
 * Created: 2022.2.27
 */

package com.kandrac.matej.tree;

import com.kandrac.matej.node.Node;

/**
 * <h1>Abstract class {@link BinaryTree} contains all common methods and variables for other trees.</h1>
 * When a binary tree is created, it should extend this class to ensure all methods are implemented. <br>
 * See also {@link AVLTree} {@link RedBlackTree}
 */

public abstract class BinaryTree<T extends Node> {

    /**
     * Root of the tree
     */
    protected T root;

    /**
     * Recursive method for inserting. Method is different for various types of trees.
     * Don't use this method from outside class. Use {@link #insert(T)} instead.
     * @param node Node to be inserted (value is always same)
     * @param root Root node (value changes depending on height)
     * @return new root node
     */
    protected abstract T insertRecursive(T node, T root);

    /**
     * Balance method different for each tree.
     * @param node node which will be balanced
     * @return new root node after balance
     */
    abstract T balance(T node);

    /**
     * Delete method different for each tree
     * @param value value of node to be deleted
     */
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    /**
     * Delete recursive method
     * @param root root node
     * @param value value to delete
     * @return new root node
     */
    protected abstract T deleteRecursive(T root, int value);

    /**
     * Public insert method. Launches recursive insertion if root is not null. See {@link #insertRecursive(T, T)}
     * @param node Node to be inserted
     */
    public void insert(T node) {
        if (root == null) {
            root = node;
            return;
        }
        root = insertRecursive(node, root);
    }

    /**
     * Public search method. Launches recursive searching. {@link #searchRecursive(Node, int)}
     * @param value value to search for
     * @return null if not found, instance if found
     */
    public Node search(int value) {
        return searchRecursive(root, value);
    }

    /**
     * Recursive search method.
     * @param node root node to be checked. Changes with height
     * @param value value to search for
     * @return Null if not found, instance if found
     */
    private Node searchRecursive(Node node, int value) {
        System.out.println("Searching " + node.toString());
        if (node.getValue() == value)
            return node;
        else if (node.getValue() > value) {
            if (node.getLeft() == null)
                return null;
            return searchRecursive(node.getLeft(), value);
        }
        else {
            if (node.getRight() == null)
                return null;
            return searchRecursive(node.getRight(), value);
        }
    }

}
