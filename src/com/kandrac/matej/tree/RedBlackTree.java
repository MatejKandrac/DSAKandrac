/*
 * Copyright (c) Matej Kandráč
 * Created: 2022.2.27
 */

package com.kandrac.matej.tree;

import com.kandrac.matej.node.RedBlackNode;

import static com.kandrac.matej.node.RedBlackNode.BLACK;
import static com.kandrac.matej.node.RedBlackNode.RED;

public class RedBlackTree extends BinaryTree<RedBlackNode> {

    private boolean violation = false;

    @Override
    protected RedBlackNode insertRecursive(RedBlackNode node, RedBlackNode root) {
        if (root == null) {
            node.setColor(RedBlackNode.BLACK);
            root = node;
            return root;
        }
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
        if (violation) {
            violation = false;
            RedBlackNode newRoot = balance(root);
            if (this.root == newRoot)
                newRoot.setColor(BLACK);
            return newRoot;
        }
        if (root.getColor() == RED && root.hasRed())
            violation = true;
        return root;
    }

    @Override
    RedBlackNode balance(RedBlackNode node) {
        if (node.hasBothRed()) {
            node.getLeft().setColor(BLACK);
            node.getRight().setColor(BLACK);
            node.setColor(RED);
            return node;
        }

        if (node.isLeftRed()) {
            if (!node.getLeft().isLeftRed())
                node.setLeft(node.getLeft().rotateLeft());
            node.setColor(RED);
            node.getLeft().setColor(BLACK);
            return node.rotateRight();
        }
        else {
            if (!node.getRight().isRightRed())
                node.setRight(node.getRight().rotateLeft());
            node.setColor(RED);
            node.getRight().setColor(BLACK);
            return node.rotateLeft();
        }
    }

    @Override
    protected RedBlackNode deleteRecursive(RedBlackNode root, int value) {
        return null;
    }


}
