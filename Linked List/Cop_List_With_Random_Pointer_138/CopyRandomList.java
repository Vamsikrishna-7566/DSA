import java.util.HashMap;
import java.util.Map;

// LeetCode provides Node; omit this definition when submitting there.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummy = head;

        // Pass 1: create a copy of every original node.
        while (dummy != null) {
            map.put(dummy, new Node(dummy.val));
            dummy = dummy.next;
        }

        Node pointer = head;

        // Pass 2: connect copies using the original links.
        while (pointer != null) {
            Node temp = map.get(pointer);
            Node nextTemp = map.get(pointer.next);
            Node randomTemp = map.get(pointer.random);
            temp.next = nextTemp;
            temp.random = randomTemp;
            pointer = pointer.next;
        }

        return map.get(head);
    }
}
