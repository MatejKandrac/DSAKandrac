/*
 * Copyright (c) Matej Kandráč
 * Created: 2022.3.14
 */

package com.kandrac.matej.table;

import com.kandrac.matej.CommonOperations;
import com.kandrac.matej.node.TableNode;

public abstract class HashTable<V> implements CommonOperations {

    protected V[] table;
    protected int tableSize = 0;
    protected int nodesInserted = 0;
    protected boolean expanding = false;

    abstract void expandAndRehash();

    abstract void handleCollision(int index, TableNode node);

    protected int getHashedIndex(TableNode node) {
        int sum = 0;
        for (int i = 0; i < node.getKey().length(); i++) {
            sum += node.getKey().charAt(0);
        }
        return sum % (tableSize == 0 ? 1 : tableSize);
    }

    protected int closestPrime(int start) {
        int closest = start;
        while (!isPrime(closest))
            closest++;
        return closest;
    }

    protected boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
