
/*
 * Copyright (c) Matej Kandráč
 * Created: 2022.2.27
 */

package com.kandrac.matej;

import com.kandrac.matej.node.Node;
import com.kandrac.matej.tree.AVLTree;
import com.kandrac.matej.tree.BinaryTree;

import java.util.Scanner;

/**
 * <h1>This is a main class with only one method <br>
 * {@code main(String[] args)}</h1>
 *
 * It is a launcher of console app.
 */

public class Main {

    /**
     * Method main creates an instance of {@link Scanner} to allow user input.
     * It also creates instances of {@link AVLTree} on which operations will be performed.
     * At first, user needs to type integer values <b>EXCEPT OF -1</b>. Those values will be inserted
     * into the tree. When -1 is entered. User will be prompted to enter value to search for.
     * If value is found, node is displayed. Otherwise, null is found.
     * @param args launch arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BinaryTree tree = new AVLTree();

        System.out.println("Type -1 to terminate creation");
        int value;
        while ((value = sc.nextInt()) != -1) {
            tree.insert(new Node(value));
        }
        System.out.println("Search for: ");
        value = sc.nextInt();
        System.out.println("Found: " + tree.search(value));
    }

}
