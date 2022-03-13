/*
 * Copyright (c) Matej Kandráč
 * Created: 2022.3.1
 */

package com.kandrac.matej.node;

public class RedBlackNode extends Node{

    /**
     * Constants for colors
     */
    public static final int RED = 0;
    public static final int BLACK = 1;

    /**
     * Color of node
     */
    private int color = RED;

    /**
     * Parent of node
     */
    private RedBlackNode parent;

    /**
     * Basic constructor for RedBlack tree
     * @param value Value node contains
     */
    public RedBlackNode(int value) {
        super(value);
    }

    @Override
    public RedBlackNode getLeft() {
        return (RedBlackNode) left;
    }

    @Override
    public RedBlackNode getRight() {
        return (RedBlackNode) right;
    }

    @Override
    public RedBlackNode rotateLeft() {
        return (RedBlackNode) super.rotateLeft();
    }

    @Override
    public RedBlackNode rotateRight() {
        return (RedBlackNode) super.rotateRight();
    }

    public void setLeft(RedBlackNode left) {
        super.setLeft(left);
        left.parent = this;
    }

    public void setRight(RedBlackNode right) {
        super.setRight(right);
        right.parent = this;
    }

    public void setParent(RedBlackNode parent) {
        this.parent = parent;
    }

    public boolean isRightRed() {
        return right != null && getRight().getColor() == RED;
    }

    public boolean isLeftRed() {
        return left != null && getLeft().getColor() == RED;
    }

    public boolean hasBothRed() {
        return isRightRed() && isLeftRed();
    }

    public boolean hasRed() {
        return isRightRed() || isLeftRed();
    }

    public int getColor() {
        return color;
    }

    public RedBlackNode getParent() {
        return parent;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
