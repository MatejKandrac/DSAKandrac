
/*
 * Copyright (c) Matej Kandráč
 * Created: 2022.2.27
 */

package com.kandrac.matej.tree;

import com.kandrac.matej.CommonOperations;
import com.kandrac.matej.node.Node;
import com.kandrac.matej.node.TreeNode;

/**
 * <h1>Abstract class {@link BinaryTree} contains all common methods and variables for other trees.</h1>
 * When a binary tree is created, it should extend this class to ensure all methods are implemented. <br>
 * See also {@link AVLTree} {@link RedBlackTree}
 */

public abstract class BinaryTree<T extends TreeNode> implements CommonOperations {

    /**
     * Root of the tree
     */
    protected T root;

    /**
     * Recursive method for inserting. Method is different for various types of trees.
     * Don't use this method from outside class. Use {@link #insert(Node)} instead.
     * @param node TreeNode to be inserted (value is always same)
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
     * @param node value of node to be deleted
     */
    @Override
    public void delete(Node node) {
        root = deleteRecursive(root, node.getValue());
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
     * @param node TreeNode to be inserted
     */

    @Override
    public void insert(Node node) {
        root = insertRecursive((T) node, root);
    }

    /**
     * Public search method. Launches recursive searching. {@link #searchRecursive(TreeNode, int)}
     * @param node value to search for
     * @return null if not found, instance if found
     */
    @Override
    public Node search(Node node) {
        return searchRecursive(root, node.getValue());
    }

    /**
     * Recursive search method.
     * @param node root node to be checked. Changes with height
     * @param value value to search for
     * @return Null if not found, instance if found
     */
    private TreeNode searchRecursive(TreeNode node, int value) {
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
