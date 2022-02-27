
/*
 * Copyright (c) Matej Kandráč
 * Created: 2022.2.27
 */

package com.kandrac.matej.node;

/**
 * <h1>Basic Node class.</h1>
 * Contains basic values common for every type of Node.
 */
public class Node {

    /**
     * Left and right nodes
     */
    private Node left;
    private Node right;

    /**
     * Height and balance factor. Values are calculated automatically when balancing
     */
    private int height = 0;
    private int balanceFactor = 0;

    /**
     * Value node contains
     */
    private final int value;

    /**
     * Basic constructor
     * @param value Value node contains
     */
    public Node(int value) {
        this.value = value;
    }

    /**
     * Tree right rotation method.
     * @return new root Node
     */
    public Node rotateRight() {
        Node oldLeft = left;
        left = oldLeft.right;
        oldLeft.setRight(this);

        update();
        oldLeft.update();

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

        update();
        oldRight.update();

        return oldRight;
    }

    /**
     * Update method calculates height and balance factor of Node.
     */
    public void update() {
        // Update values
        int leftValue = left == null ? -1 : left.height;
        int rightValue = right == null ? -1 : right.height;
        height = 1 + Math.max(leftValue, rightValue);
        balanceFactor = rightValue - leftValue;
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

    public int getBF() {
        return balanceFactor;
    }

    @Override
    public String toString() {
        return "Node{" +
                "v=" + value +
                " h=" + height +
                " bf=" + balanceFactor +
                '}';
    }
}
