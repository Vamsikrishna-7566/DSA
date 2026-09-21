import java.util.HashMap;
import java.util.Map;

class Node {
    public int key;
    public int val;
    public Node prev;
    public Node next;

    public Node() {}

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/** LRU cache using a map and a doubly linked list.
 *  head.next is most recent; tail.prev is least recent.
 *  get and put: O(1) average time. Live storage: O(capacity).
 */
public class LRUCache {
    private final Map<Integer, Node> map;
    private final int capacity;
    private final Node head = new Node();
    private final Node tail = new Node();

    public LRUCache(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        map = new HashMap<>();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int value = map.get(key).val;
        // Replace the old node with a node at the most recent position.
        deleteNode(key);
        Node updatedNode = addNode(key, value);
        map.put(key, updatedNode);
        return value;
    }

    // Helpers change only the list; callers synchronize the map.
    private Node addNode(int key, int value) {
        Node newNode = new Node(key, value);
        Node temp = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = temp;
        temp.prev = newNode;
        return newNode;
    }

    // Precondition: key exists in the map and its node is in the list.
    private void deleteNode(int key) {
        Node presentNode = map.get(key);
        Node prevNode = presentNode.prev;
        Node nextNode = presentNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (map.containsKey(key)) {
            deleteNode(key);
            Node updatedNode = addNode(key, value);
            map.put(key, updatedNode);
        } else if (map.size() < capacity) {
            map.put(key, addNode(key, value));
        } else {
            Node tailPrevNode = tail.prev;
            // List removal must happen first: deleteNode reads the map.
            deleteNode(tailPrevNode.key);
            map.remove(tailPrevNode.key);
            map.put(key, addNode(key, value));
        }
    }
}
