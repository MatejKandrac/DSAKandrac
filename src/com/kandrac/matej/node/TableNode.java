/*
 * Copyright (c) Matej Kandráč
 * Created: 2022.3.14
 */

package com.kandrac.matej.node;

public class TableNode {

    private int value;
    private String key;

    public TableNode(String key) {
        this.key = key;
        this.value = hashCode();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String getKey() {
        return key;
    }
}
