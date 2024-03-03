package datastrucs;

import components.*;

public class SinglyLinkedList<K,V> {
    private Node<Node<Data<K,V>>> head;

    public void add(Node<Data<K,V>> data) {
        Node<Node<Data<K,V>>> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<Node<Data<K,V>>> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Node<Data<K,V>> find(K key){
        Node<Node<Data<K,V>>> currentNode = head;
        while(currentNode != null){
            if(currentNode.data.data.key.equals(key)){
                return currentNode.data;
            }
            currentNode = currentNode.next;
        }

        return null;
    }

    public void remove(Data<K,V> data) {
        if (head == null) return;

        if (head.data.equals(data)) {
            Node<Data<K,V>> temp = head.data;
            head = head.next;
            return;
        }

        Node<Node<Data<K,V>>> current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                Node<Data<K,V>> temp= current.next.data;
                current.next = current.next.next;
                return; // Data not found
            }
            current = current.next;
        }

    }
}