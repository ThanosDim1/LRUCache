package datastrucs;

import java.util.NoSuchElementException;
import components.*;

public class DoublyLinkedList<T> {
    private Node<T> head; // Pointer to the first node of the list
    private Node<T> tail; // Pointer to the last node of the list
    private int size = 0; // Tracks the number of elements in the list

    // Checks if the list is empty
    public boolean isEmpty(){
        return head == null; // The list is empty if head is null
    }

    // Adds an element at the beginning of the list
    public Node<T> addFirst(T item) {
        Node<T> newNode = new Node<T>(item); // Creates a new node with the given item
        if (head == null) { // If the list is empty
            head = newNode; // The new node becomes both head and tail
            tail = newNode;
        }
        else { // If the list is not empty
            newNode.setNext(head); // The new node points to the former head
            head.setPrev(newNode); // The former head's previous points to the new node
            head = newNode; // The new node becomes the new head
        }
        size++; // Increase the size of the list
        return head; // Return the new head of the list
    }

    // Retrieves the last element's value from the list
    public T getLast() throws NoSuchElementException {
        if (isEmpty()) { // Check if the list is empty
            return null; // Throw an exception if the list is empty
        }
        return tail.getData(); // Return the data of the tail node
    }

    // Additional methods like addLast, removeFirst, removeLast, etc., could be implemented here.
}
