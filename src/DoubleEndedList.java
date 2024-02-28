import java.util.NoSuchElementException;
import java.io.PrintStream;

public class DoubleEndedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoubleEndedList(int size){
        this.size =size;
    }
    public boolean isEmpty(){
        size=0;
        return head == null;
    }

    public Node<T> addFirst(T item) {
        Node<T> newNode = new Node<T>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
        return head;
    }

    public T removeFirst() throws NoSuchElementException {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (head == tail) {
            T temp = head.getData();
            head = null;
            tail = null;
            return temp;
        }
        else {
            T temp = head.getData();
            head = head.getNext();
            head.setPrev(null);
            return temp;
        }
    }

    public void addLast(T item) {
        Node<T> newNode = new Node<T>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public T removeLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (head == tail) {
            T temp = head.getData();
            head = null;
            tail = null;
            size=0;
            return temp;
        }
        else {
            T temp = tail.getData();
            tail = tail.getPrev();
            tail.setNext(null);
            size=size-1;
            return temp;
        }
    }

    public T getFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.getData();
    }

    public T getLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.getData();
    }


}
