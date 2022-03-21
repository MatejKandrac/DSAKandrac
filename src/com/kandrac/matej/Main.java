
/*
 * Copyright (c) Matej Kandráč
 * Created: 2022.2.27
 */

package com.kandrac.matej;

import com.kandrac.matej.node.AVLNode;
import com.kandrac.matej.node.RedBlackNode;
import com.kandrac.matej.node.TableNode;
import com.kandrac.matej.table.ChainingHashTable;
import com.kandrac.matej.table.OpenAddressingHashTable;
import com.kandrac.matej.tree.AVLTree;
import com.kandrac.matej.tree.RedBlackTree;

import java.util.Random;
import java.util.UUID;

/**
 * <h1>This is a main class with only one method <br>
 * {@code main(String[] args)}</h1>
 *
 * It is a launcher of console app.
 */

public class Main {

    private static final int SIZE = 100000;
    private static final int RANDOM_INDEXES_SIZE = 10000;

    /**
     * It creates instances of {@link AVLTree} on which operations will be performed.
     * At first, user needs to type integer values <b>EXCEPT OF -1</b>. Those values will be inserted
     * into the tree. When -1 is entered. User will be prompted to enter value to search for.
     * If value is found, node is displayed. Otherwise, null is found.
     * @param args launch arguments
     */
    public static void main(String[] args) {
        CommonOperations[] trees = {
                new AVLTree(),
                new RedBlackTree()
        };
        CommonOperations[] tables = {
                new ChainingHashTable(),
                new OpenAddressingHashTable()
        };
        Random rn = new Random();

        int[] randomIndexes = new int[RANDOM_INDEXES_SIZE];

        for (int i = 0; i < RANDOM_INDEXES_SIZE; i++)
            randomIndexes[i] = rn.nextInt(SIZE);

        long timeTracker;

        ///////////////////////// TREES ///////////////////////////////////

//        ///////////////////////// AVL TREE ////////////////////////////////
        System.out.print("Starting AVL Insertion    ");
        timeTracker = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++)
            trees[0].insert(new AVLNode(i));

        timeTracker = System.currentTimeMillis() - timeTracker;
        System.out.println("Insertion completed in " + timeTracker +"ms");

        System.out.println("Starting AVL search");
        timeTracker = System.currentTimeMillis();
        for (int i = 0; i < RANDOM_INDEXES_SIZE; i++)
            trees[0].search(new AVLNode(randomIndexes[i]));
        timeTracker = System.currentTimeMillis() - timeTracker;
        System.out.println("Search completed in " + timeTracker + "ms");

        System.out.println("Starting AVL delete");
        timeTracker = System.currentTimeMillis();
        for (int i = 0; i < RANDOM_INDEXES_SIZE; i++)
            trees[0].delete(new AVLNode(i));
        timeTracker = System.currentTimeMillis() - timeTracker;
        System.out.println("Delete completed in " + timeTracker + "ms");
        System.out.println("\n\n");
        ///////////////////////// RED BLACK TREE //////////////////////////
        System.out.print("Starting RED BLACK Insertion");
        timeTracker = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++)
            trees[1].insert(new RedBlackNode(i));
        timeTracker = System.currentTimeMillis() - timeTracker;
        System.out.println("Insertion completed in " + timeTracker +"ms");

        System.out.println("Starting RED BLACK search");
        timeTracker = System.currentTimeMillis();
        for (int i = 0; i < RANDOM_INDEXES_SIZE; i++)
            trees[1].search(new RedBlackNode(randomIndexes[i]));
        timeTracker = System.currentTimeMillis() - timeTracker;
        System.out.println("Search completed in " + timeTracker + "ms");

//        System.out.println("Starting RED BLACK delete     ");
//        timeTracker = System.currentTimeMillis();
//        trees[0].delete(new RedBlackNode(10_000));
//        timeTracker = System.currentTimeMillis() - timeTracker;
//        System.out.println("Delete completed in " + timeTracker + "ms");

        ////////////////////////// TABLES ///////////////////////////////////

        String[] inserts = new String[SIZE];

        for (int i = 0; i < SIZE; i++)
            inserts[i] = UUID.randomUUID().toString();

        System.out.println("\n\n");
        System.out.println("Starting Linear Probing");
        compareTable(tables[0], inserts, randomIndexes);

        System.out.println("\n\n");
        System.out.println("Starting Open Addressing");
        compareTable(tables[1], inserts, randomIndexes);

        ////////////////////////////////////////////////////////////////////////
    }

    static void compareTable(CommonOperations tableInterface, String[] strings, int[] randomIndexes) {
        long timeTracker = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++)
            tableInterface.insert(new TableNode(strings[i]));
        System.out.println("Insert completed in: " + (System.currentTimeMillis() - timeTracker) + "ms");
        timeTracker = System.currentTimeMillis();
        for (int searchIndex : randomIndexes)
            tableInterface.search(new TableNode(strings[searchIndex]));
        System.out.println("Searching completed in: " + (System.currentTimeMillis() - timeTracker) + "ms");
        timeTracker = System.currentTimeMillis();
        for (int searchIndex : randomIndexes)
            tableInterface.delete(new TableNode(strings[searchIndex]));
        System.out.println("Delete completed in: " + (System.currentTimeMillis() - timeTracker) + "ms");
    }

}
