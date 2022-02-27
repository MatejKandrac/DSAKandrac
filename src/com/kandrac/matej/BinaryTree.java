package com.kandrac.matej;

/**
 * <h1>This is a title </h1>
 *
 */

public class BinaryTree {

    public static final int BINARY_AVL = 0;
    public static final int BINARY_RED_BLACK = 0;

    private Node root;
    private int mode;

    public BinaryTree(int mode) {
        this.mode = mode;
    }

    void insertNode(Node node) {
        if (root == null) {
            root = node;
            return;
        }
        root = insertRecursive(node, root);
    }

    Node search(int value) {
        return searchRecursive(root, value);
    }

    private Node searchRecursive(Node node, int value) {
        System.out.println("Searching " + node.toString());
        if (node.getValue() == value)
            return node;
        else if (node.getValue() > value) {
            if (node.getLeft() == null)
                return null;
            return searchRecursive(node.getLeft(), value);
        }
        else {
            if (node.getRight() == null)
                return null;
            return searchRecursive(node.getRight(), value);
        }
    }

    private Node insertRecursive(Node node, Node root) {
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
        };
        root.update();
        if (mode == BINARY_AVL)
            return balanceAVL(root);
        else
            return balanceRedBlack(root);
    }

    Node balanceRedBlack(Node root) {
        return root;
    }

    Node balanceAVL(Node root) {
        if (root.getBF() == -2) {
            if (root.getLeft().getBF() > 0)
                root.setLeft(root.getLeft().rotateLeft());

            return root.rotateRight();
        } else if (root.getBF() == 2) {
            if (root.getRight().getBF() < 0)
                root.setRight(root.getRight().rotateRight());

            return root.rotateLeft();
        }
        return root;
    }

}
