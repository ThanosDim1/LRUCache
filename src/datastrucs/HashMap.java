package datastrucs;

import components.*;

// Declaration of the DataStructures.HashMap class with generic types K (for Key) and V (for Value).
public class HashMap<K,V> {
    // buffersize determines the size of the array that will store the linked lists.
    private final int buffersize;
    // An array of DataStructures.SinglyLinkedList, which will store the keys and values. Each index of the array acts as a bucket.
    private SinglyLinkedList<K,V>[] buffer;

    // Constructor of the DataStructures.HashMap class.
    public HashMap(int buffersize){
        this.buffersize = buffersize; // Initialize buffersize with the provided value.
        this.buffer = new SinglyLinkedList[buffersize]; // Initialize the buffer array with the size of buffersize.

        // Initialize each element of the buffer array with a new DataStructures.SinglyLinkedList to avoid NullPointerException.
        for (int i = 0; i < buffersize; ++i){
            buffer[i] = new SinglyLinkedList<K,V>();
        }
    }

    // Method to remove a node from the DataStructures.HashMap.
    public void remove(Data<K,V> node){
        // Check if the provided node is null, to avoid operating on a null value.
        if(node == null) return;
        // Use the hashing method to find the correct bucket and call the remove method on that DataStructures.SinglyLinkedList.
        buffer[hashing(node.key)].remove(node);
    }

    // Method to add a node to the DataStructures.HashMap.
    public void add(Data<K,V> node){
        // Use the hashing method to find the correct bucket and call the add method on that DataStructures.SinglyLinkedList.
        buffer[hashing(node.key)].add(node);
    }

    // Method to check if a key is present in the DataStructures.HashMap.
    public Data<K, V> contains(K key){
        // Use the hashing method to find the correct bucket and call the find method on that DataStructures.SinglyLinkedList to check for the key.
        return buffer[hashing(key)].find(key);
    }

    // Private method for hashing the key to find the correct bucket index in the buffer array.
    private int hashing(K key){
        int hash = key.hashCode(); // Get the hashCode of the key.
        // Manipulate the hash to reduce collision.
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        hash = hash ^ (hash >>> 7) ^ (hash >>> 4);
        // Ensure the hash index is within the bounds of the buffer array.
        return Math.abs(hash % buffersize);
    }
}
