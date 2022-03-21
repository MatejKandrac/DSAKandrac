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
//        if (root.getValue() == value) {
//            RedBlackNode successor;
//            if (root.getRight() == null && root.getLeft() == null)
//                successor = null;
//            else if (root.getRight() == null)
//                successor = root.getLeft();
//            else if (root.getLeft() == null)
//                successor = root.getRight();
//            else
//                successor = (RedBlackNode) getSuccessor(root);
//            boolean bothBlack = root.getColor() == BLACK && (successor == null || successor.getColor() == BLACK);
//            if (successor == null) {
//                if (root == this.root)
//                    this.root = null;
//                else {
//                    if (bothBlack) {
//
//                    }
//                    else {
//                        if (successorParent.getRight() != null)
//                            successor.getRight().setColor(RED);
//                    }
//                }
//            }
//            root.setValue(successor.getValue());
//            root.setRight(deleteRecursive(root.getRight(), successor.getValue()));
//            return root.getLeft();
//        }
//        if (value < root.getValue() && root.getLeft() != null)
//            root.setLeft(deleteRecursive(root.getLeft(), value));
//        else if (root.getRight() != null)
//            root.setRight(deleteRecursive(root.getRight(), value));
        return null;
    }

}
