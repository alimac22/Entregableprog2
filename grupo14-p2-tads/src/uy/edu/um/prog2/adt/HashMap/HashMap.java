package uy.edu.um.prog2.adt.HashMap;

public class HashMap<K, V> {
    private int capacity =10;
    private float loadFactor = 0.75F;
    private int size;
    private Nodo<K,V>[] table;

    public HashMap(){
        this.table = new Nodo[capacity];
    }
    private class Nodo<K,V>{
        K key;
        V value;
        Nodo<K,V> next;
        public Nodo(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private int hash(K key){
        return key.hashCode() % capacity;
    }

    private void resize(){
        int newCapacity = capacity *2;
        Nodo<K,V>[] newTable = new Nodo[newCapacity];
        for (int i = 0; i < capacity; i++) {
            Nodo<K,V> nodo = table[i];
            while (nodo != null){
                int index = hash(nodo.key);
                nodo.next = newTable[index];
                newTable[index] = nodo;
                nodo = nodo.next;
            }
        }
        table = newTable;
        capacity = newCapacity;
    }

    public void add(K key, V value){
        int index = hash(key);
        Nodo<K,V> nodo = table[index];
        while(nodo !=null){
            if(nodo.key.equals(key)){
                nodo.value = value;
                return;
            }
            nodo = nodo.next;
        }
        Nodo<K,V> nuevoNodo = new Nodo<>(key, value);
        nuevoNodo.next = table[index];
        table[index] = nuevoNodo;
        size++;
        if(size > capacity*loadFactor){
            resize();
        }
    }

    public void remove(K key){
        int index = hash(key);
        Nodo<K,V> nodo = table[index];
        Nodo<K,V> prev = null;
        while(nodo !=null){
            if(nodo.key.equals(key)){
                if(prev == null){
                    table[index] = nodo.next;
                }else{
                    prev.next = nodo.next;
                }
                size--;
                return;
            }
            prev = nodo;
            nodo = nodo.next;
        }

    }
    public V get(K key){
        int index = hash(key);
        Nodo<K,V> nodo = table[index];
        while(nodo != null){
            if(nodo.key.equals(key)){
                return nodo.value;
            }
            nodo = nodo.next;
        }
        return null;
    }

    public int getSize(){
        return this.size;
    }




}
