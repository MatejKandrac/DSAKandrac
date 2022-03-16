/*
 * Copyright (c) Matej Kandráč
 * Created: 2022.3.16
 */

package com.kandrac.matej;

import com.kandrac.matej.node.Node;

public interface CommonOperations {

    public Node search(Node node);
    public void delete(Node node);
    public void insert(Node node);

}
