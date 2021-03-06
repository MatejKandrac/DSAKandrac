/*
 * Copyright (c) Matej Kandráč
 * Created: 2022.3.1
 */

package com.kandrac.matej.node;


public class AVLNode extends TreeNode {

    /**
     * Height and balance factor. Values are calculated automatically when balancing
     */
    private int height = 0;
    private int balanceFactor = 0;

    /**
     * Basic constructor initializing value
     * @param value Value node contains
     */
    public AVLNode(int value) {
        super(value);
    }

    /**
     * Update method calculates height and balance factor of Node.
     */
    public void update() {
        // Update values
        int leftValue = left == null ? -1 : ((AVLNode) left).height;
        int rightValue = right == null ? -1 : ((AVLNode) right).height;
        height = 1 + Math.max(leftValue, rightValue);
        balanceFactor = rightValue - leftValue;
    }

    /**
     * Tree right rotation method.
     * @return new root Node
     */
    public AVLNode rotateRight() {
        AVLNode oldLeft = (AVLNode) super.rotateRight();
        update();
        oldLeft.update();

        return oldLeft;
    }

    /**
     * Tree left rotation.
     * @return new root Node
     */
    public AVLNode rotateLeft() {
        AVLNode oldRight = (AVLNode) super.rotateLeft();
        update();
        oldRight.update();

        return oldRight;
    }

    public int getBF() {
        return balanceFactor;
    }

    public AVLNode getLeft() {
        return (AVLNode) left;
    }

    public AVLNode getRight() {
        return (AVLNode) right;
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
