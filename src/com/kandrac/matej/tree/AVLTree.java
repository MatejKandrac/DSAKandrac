
/*
 * Copyright (c) Matej Kandráč
 * Created: 2022.2.27
 */

package com.kandrac.matej.tree;

import com.kandrac.matej.node.AVLNode;

public class AVLTree extends BinaryTree<AVLNode> {

    protected AVLNode insertRecursive(AVLNode node, AVLNode root) {
        if (node.getValue() < root.getValue()) {
            if (root.getLeft() != null)
                root.setLeft(insertRecursive(node, ((AVLNode) root.getLeft())));
            else
                root.setLeft(node);
        } else {
            if (root.getRight() != null)
                root.setRight(insertRecursive(node, ((AVLNode) root.getRight())));
            else
                root.setRight(node);
        }
        root.update();
        return balance(root);
    }

    @Override
    void delete(int value) {
        // TODO
    }

    @Override
    AVLNode balance(AVLNode node) {
        if (root.getBF() == -2) {
            if (((AVLNode) root.getLeft()).getBF() > 0)
                root.setLeft(((AVLNode) root.getLeft()).rotateLeft());
            return root.rotateRight();
        } else if (root.getBF() == 2) {
            if (((AVLNode) root.getRight()).getBF() < 0)
                root.setRight(((AVLNode) root.getRight()).rotateRight());

            return root.rotateLeft();
        }
        return root;
    }


}
