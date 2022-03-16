/*
 * Copyright (c) Matej Kandráč
 * Created: 2022.3.16
 */

package com.kandrac.matej.node;

import com.kandrac.matej.node.Node;

/**
 * <h1>Basic TreeNode class.</h1>
 * Contains basic values common for every type of TreeNode.
 */
public abstract class TreeNode extends Node {

    /**
     * Left and right nodes
     */
    protected TreeNode left;
    protected TreeNode right;

    /**
     * Basic constructor
     * @param value Value TreeNode contains
     */
    public TreeNode(int value) {
        super(value);
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    /**
     * Tree right rotation method.
     * @return new root TreeNode
     */
    public TreeNode rotateRight() {
        TreeNode oldLeft = left;
        left = oldLeft.right;
        oldLeft.setRight(this);

        return oldLeft;
    }

    /**
     * Tree left rotation.
     * @return new root TreeNode
     */
    public TreeNode rotateLeft() {
        TreeNode oldRight = right;
        right = oldRight.left;
        oldRight.setLeft(this);

        return oldRight;
    }

}
