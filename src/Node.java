/**
 * ListNode represents a list node
 * Each node contains a generic type T as data and a reference to the next node in the list.
 */
public class Node<T> {
    protected T data;
    protected Node<T> next = null;
    protected Node<T> prev = null;

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

    public void setNext(Node<T> next) {
        this.next = next;
    }
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
}