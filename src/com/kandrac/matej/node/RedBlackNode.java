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
    private int color;

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

    public int getColor() {
        return color;
    }
}
