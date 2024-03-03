package LRUCache;

import components.*;
import datastrucs.*;

public class CacheImpl<K,V> implements Cache<K,V> {
    private long CacheMisses;
    private long TotalLookups;

    private final HashMap<K,V> HashMap;
    private final DoublyLinkedList<Data<K,V>> cache;

    public CacheImpl(int cachesize) {
        HashMap = new HashMap<>(cachesize);
        cache = new DoublyLinkedList<>();
    }

    @Override
    public V lookUp(K key) {
        ++TotalLookups;
        Node<Data<K,V>> result = HashMap.contains(key);
        if(result == null){
            return null;
        }else{
            cache.addFirst(result.data);
            return result.data.value;
        }
    }

    @Override
    public void store(K key, V value) {
        ++CacheMisses;
        Data<K,V> temp;
        if(cache.getLast() == null){
            temp = null;
        }else{
            temp = cache.getLast();
        }

        HashMap.remove(temp);
        Node<Data<K,V>> doublyLinkedListNode = cache.addFirst(new Data<>(key, value));
        HashMap.add(doublyLinkedListNode);
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