package adt;

import java.io.Serializable;

public class ArrayQueue<T> implements QueueInterface<T>, Serializable {

    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 5;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int initialCapacity) {
        queue = (T[]) new Object[initialCapacity];
        frontIndex = 0;
        backIndex = -1;
        numberOfEntries = 0;
    }

    @Override
    public boolean enqueue(T newEntry) {
        if (isFull()) {
            doubleArray();
        }

        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
        numberOfEntries++;
        return true;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T front = queue[frontIndex];
        queue[frontIndex] = null; 
        frontIndex = (frontIndex + 1) % queue.length;
        numberOfEntries--;
        return front;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            return null;
        }

        return queue[frontIndex];
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public boolean isFull() {
        return numberOfEntries == queue.length;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    private void doubleArray() {
        T[] oldQueue = queue;
        T[] newQueue = (T[]) new Object[oldQueue.length * 2];

        for (int i = 0; i < numberOfEntries; i++) {
            newQueue[i] = oldQueue[(frontIndex + i) % oldQueue.length];
        }

        queue = newQueue;
        frontIndex = 0;
        backIndex = numberOfEntries - 1;
    }
    
    public int getFrontIndex() {
    return frontIndex;
    }

public int getBackIndex() {
    return backIndex;
}

public T[] getInternalArray() {
    return queue;
}

public int size() {
    return numberOfEntries;
}

    @Override
    public String toString() {
        String str = "Queue contents:\n";
        for (int i = 0; i < numberOfEntries; i++) {
            str += queue[(frontIndex + i) % queue.length] + "\n";
        }
        return str;
    }
}
