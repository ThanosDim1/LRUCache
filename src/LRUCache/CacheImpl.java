package LRUCache;

import components.*;
import datastrucs.*;

public class CacheImpl<K,V> implements Cache<K,V> {
    private long CacheMisses;
    private long TotalLookups;

    private final HashMap<K,V> storage;
    private final DoublyLinkedList<Data<K,V>> cache;

    public CacheImpl(int cachesize) {
        storage = new HashMap<>(cachesize);
        cache = new DoublyLinkedList<>();
    }

    @Override
    public V lookUp(K key) {
        ++TotalLookups;
        Data<K,V> result = storage.contains(key);
        if(result == null){
            return null;
        }else{
            cache.addFirst(result);
            return result.value;
        }
    }

    @Override
    public void store(K key, V value) {
        ++CacheMisses;
        Data<K,V> deleted;
        if(cache.getLast() == null){
            deleted = null;
        }else{
            deleted = cache.getLast();
        }

        storage.remove(deleted);
        Node<Data<K,V>> NewNode = cache.addFirst(new Data<>(key, value));
        storage.add(NewNode.getData());
    }

    @Override
    public double getHitRatio() {
        return (double)(TotalLookups - CacheMisses)/ TotalLookups;
    }

    @Override
    public long getHits() {
        return TotalLookups - CacheMisses;
    }

    @Override
    public long getMisses() {
        return CacheMisses;
    }

    @Override
    public long getNumberOfLookUps() {
        return TotalLookups;
    }
}