public class CacheImpl<K,V> implements Cache<K,V>{
    private long numberOfCacheMiss;
    private long numberOfTotalLookups;
    private int cachesize;

    private HashMap<K,V> HashMap;
    private DoubleEndedList<Object<K,V>> list;

    public CacheImpl(int cachesize) {
        this.cachesize = cachesize;
        HashMap = new HashMap<>(116269); //prime number
        list = new DoubleEndedList<>(cachesize);
    }

    @Override
    public V lookUp(K key) {
        ++numberOfTotalLookups;
        Node<Object<K,V>> result = HashMap.contains(key);
        if(result == null){
            return null;
        }else{
            list.addFirst(result.data);
            return result.data.value;
        }
    }

    @Override
    public void store(K key, V value) {
        ++numberOfCacheMiss;
        Object<K,V> keyItemDeleted;
        if(list.getLast().value == null){
            keyItemDeleted = null;
        }else{
            keyItemDeleted = list.getLast();
        }

        HashMap.remove(keyItemDeleted);
        Node<Object<K,V>> doublyLinkedListNode = list.addFirst(new Object<>(key, value));
        HashMap.add(doublyLinkedListNode);
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