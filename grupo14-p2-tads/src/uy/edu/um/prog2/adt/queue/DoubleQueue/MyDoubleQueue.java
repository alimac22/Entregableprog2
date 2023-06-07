package uy.edu.um.prog2.adt.queue.DoubleQueue;

import uy.edu.um.prog2.adt.queue.EmptyQueueException;

public interface MyDoubleQueue<T> {
    void enqueueLeft(T element);

    T dequeueLeft() throws EmptyQueueException;

    void enqueueRight(T element);

    T dequeueRight() throws EmptyQueueException;

    boolean isEmpty();
}
