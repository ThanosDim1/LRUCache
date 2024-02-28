import java.io.ObjectStreamException;

public class SingleEndedList<K,V> {
    private Node<Node<Object<K,V>>> head;

    public Node<Object<K,V>> add(Node<Object<K,V>> data) {
        Node<Node<Object<K,V>>> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            return head.data;
        } else {
            Node<Node<Object<K,V>>> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            return current.next.data;
        }
    }

    public Node<Object<K,V>> find(K key){
        Node<Node<Object<K,V>>> currentNode = head;
        while(currentNode != null){
            if(currentNode.data.data.key.equals(key)){
                return currentNode.data;
            }
            currentNode = currentNode.next;
        }

        return null;
    }

    /**
     * Adds a new node with the specified data at the beginning of the list.
     */
    public void addFirst(Node<Object<K,V>> data) {
        Node<Node<Object<K,V>>> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Removes the node with the specified data.
     */
    public Node<Object<K,V>> remove(Object<K,V> data) {
        if (head == null) return null;

        if (head.data.equals(data)) {
            Node<Object<K,V>> temp = head.data;
            head = head.next;
            return temp;
        }

        Node<Node<Object<K,V>>> current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                Node<Object<K,V>> temp= current.next.data;
                current.next = current.next.next;
                return temp; // Data not found
            }
            current = current.next;
        }

        return null;
    }
}
