
/*
 * Copyright (c) Matej Kandráč
 * Created: 2022.2.27
 */

package com.kandrac.matej.node;

/**
 * <h1>Basic Node class.</h1>
 * Contains basic values common for every type of Node.
 */
public abstract class Node {

    /**
     * Left and right nodes
     */
    protected Node left;
    protected Node right;

    /**
     * Value node contains
     */
    protected final int value;

    /**
     * Basic constructor
     * @param value Value node contains
     */
    public Node(int value) {
        this.value = value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    /**
     * Tree right rotation method.
     * @return new root Node
     */
    public Node rotateRight() {
        Node oldLeft = left;
        left = oldLeft.right;
        oldLeft.setRight(this);

        return oldLeft;
    }

    /**
     * Tree left rotation.
     * @return new root Node
     */
    public Node rotateLeft() {
        Node oldRight = right;
        right = oldRight.left;
        oldRight.setLeft(this);

        return oldRight;
    }

}
