public class CacheImpl<K,V> implements Cache<K,V>{
    private long numberOfCacheMiss;
    private long numberOfTotalLookups;
    private int cachesize;

    private HashmapImpl<K,V> HashMap;
    private DoublyLinkedList<T> queue;

    public CacheImpl(int cachesize) {
        this.cachesize = cachesize;
    }

    @Override
    public V lookUp(K key) {
        return null;

    }

    @Override
    public void store(K key, V value) {

    }

    @Override
    public double getHitRatio() {
        return (double)(numberOfTotalLookups - numberOfCacheMiss)/numberOfTotalLookups;
    }

    @Override
    public long getHits() {
        return numberOfTotalLookups - numberOfCacheMiss;
    }

    @Override
    public long getMisses() {
        return numberOfCacheMiss;
    }

    @Override
    public long getNumberOfLookUps() {
        return numberOfTotalLookups;
    }
}