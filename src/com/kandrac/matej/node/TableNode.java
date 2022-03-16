/*
 * Copyright (c) Matej Kandráč
 * Created: 2022.3.14
 */

package com.kandrac.matej.node;

public class TableNode extends Node {

    private String key;

    public TableNode(String key) {
        super(0);
        this.key = key;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String getKey() {
        return key;
    }
}
