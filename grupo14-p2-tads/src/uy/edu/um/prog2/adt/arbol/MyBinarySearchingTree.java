package uy.edu.um.prog2.adt.arbol;

public interface MyBinarySearchingTree <K extends Comparable<K>, T>{

    T find(K key);
    void insert (K key, T data);
    void delete (K key);

}
