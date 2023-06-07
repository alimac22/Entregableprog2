package uy.edu.um.prog2.adt.queue.LinkedQueue;

import uy.edu.um.prog2.adt.queue.EmptyQueueException;

public interface MyQueue<T> {
    void enqueue(T element);

    T dequeue() throws EmptyQueueException;

    boolean isEmpty();
}
