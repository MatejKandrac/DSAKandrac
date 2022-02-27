
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

public abstract class BinaryTree {

    /**
     * Root of the tree
     */
    protected Node root;

    /**
     * Recursive method for inserting. Method is different for various types of trees.
     * Don't use this method from outside class. Use {@link #insert(Node)} instead.
     * @param node Node to be inserted (value is always same)
     * @param root Root node (value changes depending on height)
     * @return new root node
     */
    protected abstract Node insertRecursive(Node node, Node root);

    /**
     * Balance method different for each tree.
     * @param node node which will be balanced
     * @return new root node after balance
     */
    abstract Node balance(Node node);

    /**
     * Delete method different for each tree
     * @param value value of node to be deleted
     */
    abstract void delete(int value);

    /**
     * Public insert method. Launches recursive insertion if root is not null. See {@link #insertRecursive(Node, Node)}
     * @param node Node to be inserted
     */
    public void insert(Node node) {
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
