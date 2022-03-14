/*
 * Copyright (c) Matej Kandráč
 * Created: 2022.3.14
 */

package com.kandrac.matej.table;

import com.kandrac.matej.node.TableNode;

import java.util.LinkedList;

public class ChainedHashTable extends HashTable<LinkedList<TableNode>> {

    @Override
    public void insert(TableNode node) {

        if (tableSize == 0) {
            LinkedList<TableNode> chain = new LinkedList<>();
            table = (LinkedList<TableNode>[]) new LinkedList[1];
            chain.add(node);
            table[0] = chain;
            tableSize++;
        }
        else {
            if (nodesInserted >= tableSize / 2 && !expanding)
                expandAndRehash();
            int index = getHashedIndex(node);
            if (table[index] != null) {
                handleCollision(index, node);
            } else {
                LinkedList<TableNode> chain = new LinkedList<>();
                chain.add(node);
                table[index] = chain;
            }
        }
        nodesInserted++;
    }

    void expandAndRehash() {
        expanding = true;
        int newTableSize = tableSize * 2;
        LinkedList<TableNode>[] temp = table;
        table = new LinkedList[newTableSize];
        nodesInserted = 0;
        for (LinkedList<TableNode> tableNodes : temp) {
            if (tableNodes != null) {
                for (TableNode tableNode : tableNodes) {
                    insert(tableNode);
                }
            }
        }
        tableSize = newTableSize;
        expanding = false;
    }


    @Override
    void handleCollision(int index, TableNode node) {
        table[index].add(node);
    }

}
