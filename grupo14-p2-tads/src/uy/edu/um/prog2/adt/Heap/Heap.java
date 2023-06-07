package uy.edu.um.prog2.adt.Heap;

import java.util.Arrays;

public class Heap {

    private int capacity = 10;
    private int size = 0;

    private boolean max = false;

    int[] items = new int[capacity];

    public Heap(boolean isMax){
        this.max = isMax;
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int index1, int index2) {
        int aux = items[index1];
        items[index1] = items[index2];
        items[index2] = aux;
    }

    private void verifyCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) throw new IllegalArgumentException();

        return items[0];
    }

    public int delete() {
        if (size == 0) throw new IllegalArgumentException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();

        return item;
    }

    public void add(int item) {
        verifyCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size - 1;
        if (max) {
            while (hasParent(index) && parent(index) < items[index]) {
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            }
            while (hasParent(index) && parent(index) > items[index]) {
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            }

        }
    }

    public void heapifyDown() {
        int index = 0;
        if (max) {
            while (hasLeftChild(index)) {
                int biggerChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                    biggerChildIndex = getRightChildIndex(index);
                }
                if (items[index] > items[biggerChildIndex]) {
                    break;
                } else {
                    swap(index, biggerChildIndex);
                }
                index = biggerChildIndex;
            }
        }
            while (hasLeftChild(index)) {
                int smallerChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                    smallerChildIndex = getRightChildIndex(index);
                }
                if (items[index] < items[smallerChildIndex]) {
                    break;
                } else {
                    swap(index, smallerChildIndex);
                }
                index = smallerChildIndex;


            }

        }


    }















