
/*
 * Copyright (c) Matej Kandráč
 * Created: 2022.2.27
 */

package com.kandrac.matej;

import com.kandrac.matej.node.AVLNode;
import com.kandrac.matej.node.Node;
import com.kandrac.matej.node.RedBlackNode;
import com.kandrac.matej.node.TableNode;
import com.kandrac.matej.table.ChainedHashTable;
import com.kandrac.matej.table.RehashingHashTable;
import com.kandrac.matej.tree.AVLTree;
import com.kandrac.matej.tree.RedBlackTree;

import java.util.Scanner;

/**
 * <h1>This is a main class with only one method <br>
 * {@code main(String[] args)}</h1>
 *
 * It is a launcher of console app.
 */

public class Main {

    private static int SIZE = 100_000;

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
        String value;
        CommonOperations[] trees = {
                new AVLTree(),
                new RedBlackTree()
        };
        CommonOperations[] tables = {
                new ChainedHashTable(),
                new RehashingHashTable()
        };
        long timeTracker = 0;

        ///////////////////////// TREES ///////////////////////////////////

        ///////////////////////// AVL TREE ////////////////////////////////
        System.out.print("Starting AVL Insertion    ");
        timeTracker = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            trees[0].insert(new AVLNode(i));
        }
        timeTracker = System.currentTimeMillis() - timeTracker;
        System.out.println("Insertion completed in " + timeTracker +"ms");

        System.out.println("Starting AVL search     ");
        timeTracker = System.currentTimeMillis();
        Node node = trees[0].search(new AVLNode(0));
        timeTracker = System.currentTimeMillis() - timeTracker;
        System.out.println("Search completed in " + timeTracker + "ms, node: " + node);

        System.out.println("Starting AVL delete     ");
        timeTracker = System.currentTimeMillis();
        trees[0].delete(new AVLNode(SIZE / 2));
        timeTracker = System.currentTimeMillis() - timeTracker;
        System.out.println("Delete completed in " + timeTracker + "ms");

        ///////////////////////// RED BLACK TREE //////////////////////////
        System.out.println("\n\n");

        System.out.print("Starting RED BLACK Insertion    ");
        timeTracker = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            trees[1].insert(new RedBlackNode(i));
        }
        timeTracker = System.currentTimeMillis() - timeTracker;
        System.out.println("Insertion completed in " + timeTracker +"ms");

        System.out.println("Starting RED BLACK search     ");
        timeTracker = System.currentTimeMillis();
        node = trees[1].search(new RedBlackNode(0));
        timeTracker = System.currentTimeMillis() - timeTracker;
        System.out.println("Search completed in " + timeTracker + "ms, node: " + node);

//        System.out.println("Starting RED BLACK delete     ");
//        timeTracker = System.currentTimeMillis();
//        trees[0].delete(new RedBlackNode(10_000));
//        timeTracker = System.currentTimeMillis() - timeTracker;
//        System.out.println("Delete completed in " + timeTracker + "ms");

        ////////////////////////// TABLES ///////////////////////////////////


        ///////////////////////// CHAINED HASH TABLE ///////////////////////
//        System.out.println("Type -1 to terminate creation");
//        while ((value = sc.nextLine()) != null) {
//            chainedHashTable.insert(new TableNode(value));
//        }
//        System.out.println("Search for: ");
//        value = sc.nextInt();
//        System.out.println("Found: " + chainedHashTable.search(value));
        ////////////////////////////////////////////////////////////////////
    }

}
