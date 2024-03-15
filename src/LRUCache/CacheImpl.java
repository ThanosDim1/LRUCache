package LRUCache; // Package declaration

import components.*; // Importing components package
import datastrucs.*; // Importing datastrucs package

public class CacheImpl<K,V> implements Cache<K,V> { // Class declaration implementing Cache interface
    private long CacheMisses; // Variable to track cache misses
    private long TotalLookups; // Variable to track total lookups

    private final HashMap<K,V> storage; // HashMap to store key-value pairs
    private final DoublyLinkedList<Data<K,V>> cache; // Doubly linked list for cache implementation

    public CacheImpl(int cachesize) { // Constructor with cache size parameter
        storage = new HashMap<>(cachesize); // Initializing storage HashMap with specified cache size
        cache = new DoublyLinkedList<>(); // Initializing cache as an empty doubly linked list
    }

    @Override
    public V lookUp(K key) { // Method to look up a value based on key
        ++TotalLookups; // Incrementing total lookups
        Data<K,V> result = storage.contains(key); // Checking if key exists in storage
        if(result == null){ // If key not found
            return null; // Returning null
        }else{ // If key found
            cache.addFirst(result); // Moving the accessed key-value pair to the front of the cache
            return result.value; // Returning the value associated with the key
        }
    }

    @Override
    public void store(K key, V value) { // Method to store a key-value pair
        ++CacheMisses; // Incrementing cache misses
        Data<K,V> deleted; // Variable to hold the data removed from cache
        if(cache.getLast() == null){ // If cache is empty
            deleted = null; // No data to delete
        }else{ // If cache is not empty
            deleted = cache.getLast(); // Get the last element in the cache
        }

        storage.remove(deleted); // Removing the data from storage corresponding to the evicted cache entry
        Node<Data<K,V>> NewNode = cache.addFirst(new Data<>(key, value)); // Adding new data to the front of the cache
        storage.add(NewNode.getData()); // Adding the new data to storage
    }

    @Override
    public double getHitRatio() { // Method to calculate hit ratio
        return (double)(TotalLookups - CacheMisses)/ TotalLookups; // Calculating hit ratio
    }

    @Override
    public long getHits() { // Method to get the number of cache hits
        return TotalLookups - CacheMisses; // Calculating and returning the number of cache hits
    }

    @Override
    public long getMisses() { // Method to get the number of cache misses
        return CacheMisses; // Returning the number of cache misses
    }

    @Override
    public long getNumberOfLookUps() { // Method to get the total number of lookups
        return TotalLookups; // Returning the total number of lookups
    }
}
