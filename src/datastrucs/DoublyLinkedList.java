package datastrucs;

import java.util.NoSuchElementException;

import components.*;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

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

    public T getLast() throws NoSuchElementException {
        if (isEmpty()) {
            return null;
        }
        return tail.getData();
    }


}

