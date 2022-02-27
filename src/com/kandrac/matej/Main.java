package com.kandrac.matej;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BinaryTree tree = new BinaryTree(BinaryTree.BINARY_AVL);

        System.out.println("Type -1 to terminate creation");
        int value;
        while ((value = sc.nextInt()) != -1) {
            tree.insertNode(new Node(value));
        }
        System.out.println("Search for: ");
        value = sc.nextInt();
        System.out.println("Found: " + tree.search(value));
    }

}
