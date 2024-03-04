package datastrucs;

import components.*;

// Defines a generic SinglyLinkedList class that stores key-value pairs.
public class SinglyLinkedList<K,V> {
    // The head of the list, which holds nodes that in turn hold data nodes.
    private Node<Data<K,V>> head;

    // Adds a new node with the specified data to the end of the list.
    public void add(Data<K,V> data) {
        Node<Data<K,V>> newNode = new Node<>(data); // Create a new node holding the given data node.
        if (head == null) {
            head = newNode; // If the list is empty, the new node becomes the head.
        } else {
            Node<Data<K,V>> current = head; // Start at the head of the list.
            while (current.next != null) { // Traverse to the end of the list.
                current = current.next;
            }
            current.next = newNode; // Add the new node at the end of the list.
        }
    }

    // Searches for a node by its key and returns it if found.
    public Data<K,V> find(K key){
        Node<Data<K,V>> currentNode = head; // Start at the head of the list.
        while(currentNode != null){ // Traverse through the list.
            if(currentNode.data.key.equals(key)){ // Check if the current node's key matches the search key.
                return currentNode.data; // Return the matching data node.
            }
            currentNode = currentNode.next; // Move to the next node in the list.
        }

        return null; // Return null if the key is not found in any node.
    }

    // Removes the first occurrence of the specified data from the list.
    public void remove(Data<K,V> data) {
        if (head == null) return; // If the list is empty, do nothing.

        if (head.data.equals(data)) {
            // If the data to remove is at the head, remove it by setting the head to the next node.
            head = head.next;
            return;
        }

        Node<Data<K,V>> current = head; // Start at the head of the list.
        while (current.next != null) { // Traverse through the list.
            if (current.next.data.equals(data)) {
                // If the next node contains the data to remove, skip it by setting the current node's next to the next node's next.
                current.next = current.next.next;
                return; // Exit the method.
            }
            current = current.next; // Move to the next node in the list.
        }
        // If the data is not found, the method simply returns without removing anything.
    }
}
