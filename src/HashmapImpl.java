import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Simple implementation of a HashTable. It uses a static map and Chaining for
 * resolving hash collisions
 *
 */
public class HashmapImpl<K,V>{

    private DoublyLinkedList<K,V>[] array;

    /**
     * the number of items currently inserted
     */
    private int size;

    /**
     * useful for object comparison
     */
    private Comparator<T> cmp;

    public HashmapImpl(int arraySize, Comparator<T> cmp) {

        this.array = new DoublyLinkedList[arraySize];
        this.size = 0;
        this.cmp = cmp;
    }

    /**
     * Adds an object to the hash table
     * @param data the item to be inserted
     * @return true if the item was inserted, false if the item was already present in the hash table
     */

    @Override
    public boolean add(T data) {

        // hash data

        // compress address

        //find list in which data is going to be inserted,
        //depending on its hash code -
        // check if list is initialized

        // add data if not present in list
    }

    @Override
    public boolean remove(T data) throws NoSuchElementException {

        // hash data

        // compress address

        // check if data is in list

        //remove data from list
    }

    @Override
    public boolean contains(T data) {

        // hash data

        // compress address

        // check if data is in list
    }

    public int getSize() {

        return this.size;
    }
}

