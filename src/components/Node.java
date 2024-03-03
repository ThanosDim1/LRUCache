package components;

/**
 * components.Node represents a list node in a doubly linked list structure.
 * Each node contains data of a generic type T and references to both the next and previous nodes in the list.
 */
public class Node<T> {
    // The data stored in this node, of generic type T.
    public T data;
    // Reference to the next node in the list. It is null if there is no next node.
    public Node<T> next = null;
    // Reference to the previous node in the list. It is null if there is no previous node.
    public Node<T> prev = null;

    // Constructor that initializes the node with data.
    public Node(T data) {
        this.data = data; // Store the data passed in the constructor.
    }

    // Method to retrieve the data stored in this node.
    public T getData() {
        // Return the data stored in this node.
        return data;
    }

    // Method to set the next node in the list.
    public void setNext(Node<T> next) {
        // Update the reference to the next node.
        this.next = next;
    }

    // Method to set the previous node in the list.
    public void setPrev(Node<T> prev) {
        // Update the reference to the previous node.
        this.prev = prev;
    }
}
