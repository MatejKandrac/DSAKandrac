
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

    public int getValue() {
        return value;
    }
}
