/*
 * Copyright (c) Matej Kandráč
 * Created: 2022.3.14
 */

package com.kandrac.matej.table;

import com.kandrac.matej.node.Node;
import com.kandrac.matej.node.TableNode;

public class OpenAddressingHashTable extends HashTable<TableNode> {

    @Override
    void handleCollision(int index, TableNode node) {
        while (true) {
            if (index == tableSize -1)
                index = 0;
            if (table[++index] == null) {
                table[index] = node;
                break;
            }
        }
    }

    @Override
    public Node search(Node node) {
        TableNode tableNode = (TableNode) node;
        int hashIndex = getHashedIndex(tableNode);
        int startIndex = hashIndex;
        do {
            if (hashIndex == tableSize -1)
                hashIndex = 0;
            if (tableNode.getKey().equals(table[hashIndex++].getKey()))
                return table[--hashIndex];
            if (table[hashIndex] == null)
                return null;
        } while (startIndex != hashIndex);
        return null;
    }

    @Override
    public void delete(Node node) {
        TableNode tableNode = (TableNode) node;
        int hashIndex = getHashedIndex(tableNode);
        int startIndex = hashIndex;
        while (true) {
            if (hashIndex == tableSize -1)
                hashIndex = 0;
            if (tableNode.getKey().equals(table[hashIndex++].getKey())) {
                table[--hashIndex].setKey(null);
                break;
            }
            if (startIndex == hashIndex || table[hashIndex] == null)
                break;
        }
    }

    @Override
    public void insert(Node node) {
        TableNode tableNode = (TableNode) node;
        if (tableSize == 0) {
            table = new TableNode[1];
            table[0] = tableNode;
            tableSize++;
        }
        else {
            if (nodesInserted >= tableSize / 2 && !expanding)
                expandAndRehash();
            int index = getHashedIndex(tableNode);
            if (table[index] != null && table[index].getKey() != null)
                handleCollision(index, tableNode);
            else
                table[index] = tableNode;
        }
        nodesInserted++;
    }

    @Override
    void expandAndRehash() {
        expanding = true;
        int newTableSize = closestPrime(tableSize * 4);
        TableNode[] temp = table;
        tableSize = newTableSize;
        table = new TableNode[newTableSize];
        nodesInserted = 0;
        for (TableNode tableNode : temp) {
            if (tableNode != null && tableNode.getKey() != null) {
                insert(tableNode);
            }
        }
        expanding = false;
    }
}
