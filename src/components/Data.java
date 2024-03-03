package components;

/**
 * components.KeyValuePair represents a pair of key and value.
 * This class is designed to hold two related objects together in a single unit.
 * The key and value can be of any type, as denoted by the generic types K and V.
 */
public class Data<K,V> {

    public K key; // The key of the key-value pair
    public V value; // The value of the key-value pair

    /**
     * Constructor for creating a components.KeyValuePair instance with the provided key and value.
     * @param key The key part of the pair.
     * @param value The value part of the pair.
     */
    public Data(K key, V value) {
        this.key = key; // Initialize the key with the provided key.
        this.value = value; // Initialize the value with the provided value.
    }
}
