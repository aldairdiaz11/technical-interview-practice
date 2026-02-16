package com.iasdiaz.interviewprep.datastructures.nonlinear.hash;

public class HashMap<K, V> {

    private final LinkedList<K, V>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public HashMap(final int size) {
        this.buckets = (LinkedList<K, V>[]) new LinkedList[size];
        for (int i = 0; i < size; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    private int indexFor(final K key) {
        return Math.abs(key.hashCode()) % this.buckets.length;
    }

    public void put(K key, V value){

        if (key == null || value == null) {
            throw new IllegalArgumentException("Key and value must not be null");
        }

        final LinkedList<K, V> bucket = this.buckets[indexFor(key)];
        boolean insertedNew = bucket.put(key, value);

        if (insertedNew) {
            this.size++;
        }
    }

    public V get(K key){

        if (key == null) {
            throw new IllegalArgumentException("Key must not be null");
        }

        return this.buckets[indexFor(key)].get(key);
    }

    public V remove(K key) {

        if (key == null) {
            throw new IllegalArgumentException("Key must not be null");
        }

        final V removed = this.buckets[indexFor(key)].remove(key);
        if (removed != null) {
            this.size--;
        }
        return removed;
    }

    public boolean containsKey(K key){
        if (key == null) {
            throw new IllegalArgumentException("Key must not be null");
        }

        return this.buckets[indexFor(key)].containsKey(key);
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }
}
