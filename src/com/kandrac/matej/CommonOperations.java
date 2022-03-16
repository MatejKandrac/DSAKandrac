/*
 * Copyright (c) Matej Kandráč
 * Created: 2022.3.16
 */

package com.kandrac.matej;

import com.kandrac.matej.node.Node;

public interface CommonOperations {

    Node search(Node node);
    void delete(Node node);
    void insert(Node node);

}
