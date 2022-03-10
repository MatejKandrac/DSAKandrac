
/*
 * Copyright (c) Matej Kandráč
 * Created: 2022.2.27
 */

package com.kandrac.matej.tree;

import com.kandrac.matej.node.AVLNode;

public class AVLTree extends BinaryTree<AVLNode> {

    @Override
    protected AVLNode insertRecursive(AVLNode node, AVLNode root) {
        if (node.getValue() < root.getValue()) {
            if (root.getLeft() != null)
                root.setLeft(insertRecursive(node, root.getLeft()));
            else
                root.setLeft(node);
        } else {
            if (root.getRight() != null)
                root.setRight(insertRecursive(node, root.getRight()));
            else
                root.setRight(node);
        }
        root.update();
        return balance(root);
    }

    @Override
    AVLNode balance(AVLNode node) {
        if (node.getBF() == -2) {
            if (node.getLeft().getBF() > 0)
                node.setLeft(node.getLeft().rotateLeft());
            return node.rotateRight();
        } else if (node.getBF() == 2) {
            if (node.getRight().getBF() < 0)
                node.setRight(node.getRight().rotateRight());
            return node.rotateLeft();
        }
        return node;
    }

    @Override
    protected AVLNode deleteRecursive(AVLNode root, int value) {
        if (root.getValue() == value) {
            if (root.getRight() == null && root.getLeft() == null)
                return null;
            if (root.getRight() == null)
                return root.getLeft();
            if (root.getRight() != null) {
                if (root.getLeft() == null)
                    return root.getRight();
                else
                    return insertRecursive(root.getLeft(), root.getRight());
            }
            return root.getLeft();
        }
        if (value < root.getValue() && root.getLeft() != null)
            root.setLeft(deleteRecursive(root.getLeft(), value));
        else if (root.getRight() != null)
                root.setRight(deleteRecursive(root.getRight(), value));
        root.update();
        return balance(root);
    }

}
