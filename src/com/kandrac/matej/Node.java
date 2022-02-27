package com.kandrac.matej;

public class Node {

    private Node left;
    private Node right;
    private int height = 0;
    private int balanceFactor = 0;
    private final int value;

    public Node(int value) {
        this.value = value;
    }

    Node rotateRight() {
        Node oldLeft = left;
        left = oldLeft.right;
        oldLeft.setRight(this);

        update();
        oldLeft.update();

        return oldLeft;
    }

    Node rotateLeft() {
        Node oldRight = right;
        right = oldRight.left;
        oldRight.setLeft(this);

        update();
        oldRight.update();

        return oldRight;
    }

    void update() {
        // Update values
        int leftValue = left == null ? -1 : left.height;
        int rightValue = right == null ? -1 : right.height;
        height = 1 + Math.max(leftValue, rightValue);
        balanceFactor = rightValue - leftValue;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    public int getBF() {
        return balanceFactor;
    }

    @Override
    public String toString() {
        return "Node{" +
                "v=" + value +
                " h=" + height +
                " bf=" + balanceFactor +
                '}';
    }
}
