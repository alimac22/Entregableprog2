package uy.edu.um.prog2.adt.queue.PriorityQueue;

import uy.edu.um.prog2.adt.queue.LinkedQueue.MyQueue;

public interface MyPriorityQueue<T> extends MyQueue<T> {
    /* inserta de acuerdo a la prioridad; si hay más de un elemento con la misma prioridad, inserta al final */
    void enqueueWithPriority(T element, int prioridad);
}
