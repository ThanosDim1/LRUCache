/**
 * ListNode represents a list node
 * Each node contains a generic type T as data and a reference to the next node in the list.
 */
public class Node<T> {
    protected T data;
    protected Node next = null;
    protected Node prev = null;

    Node(T data) {
        this.data = data;
    }

    public T getData() {
        // return data stored in this node
        return data;
    }

    public Node<T> getNext() {
        // get next node
        return next;
    }
    public Node<T> getPrev() {
        // get previous node
        return prev;
    }
}