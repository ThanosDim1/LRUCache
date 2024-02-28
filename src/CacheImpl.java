public class CacheImpl<K,V> implements Cache<K,V>{

    int size;

    public CacheImpl(int size) {
        this.size = size;

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
        return 0;
    }

    @Override
    public long getHits() {
        return 0;
    }

    @Override
    public long getMisses() {
        return 0;
    }

    @Override
    public long getNumberOfLookUps() {
        return 0;
    }
}
