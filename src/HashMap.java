public class HashMap<K,V> {
    private final int buffersize;
    private SingleEndedList<K,V>[] buffer;

    public HashMap(int buffersize){
        this.buffersize=buffersize;
        this.buffer= new SingleEndedList[buffersize];

        for (int i = 0; i<buffersize; ++i){
            buffer[i] = new SingleEndedList<K,V>();
        }
    }

    public Node<Object<K,V>> remove(Object<K,V> node){
        if(node == null) return null;
        return buffer[hashing(node.key)].remove(node);
    }

    /**
     * Add a new doubly-Linked-List Node to a certain hashmap's singlyLinkedList.
     * @param node
     * @return
     */
    public Node<Object<K,V>> add(Node<Object<K,V>> node){
        return buffer[hashing(node.data.key)].add(node);
    }

    /**
     *
     * @param key
     * @return a Doubly-Linked-List Node(Node<Model<K,D>>) if exists with certain key.
     */
    public Node<Object<K,V>> contains(K key){
        return buffer[hashing(key)].find(key);
    }

    /**
     * A hashing method.
     * @param key
     * @return the offset.
     */
    private int hashing(K key){
        int hash = key.hashCode();
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        hash = hash ^ (hash >>> 7) ^ (hash >>> 4);
        return Math.abs(hash % buffersize);
    }
}
