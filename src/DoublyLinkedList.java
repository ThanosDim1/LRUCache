import java.util.NoSuchElementException;


public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    static private int size;

    public boolean isEmpty(){
        size=0;
        return head == null;
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

    public int size() {
        return size;
    }
}

