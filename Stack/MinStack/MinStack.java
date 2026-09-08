import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Min Stack implemented with a regular stack and a doubly linked list.
 *
 * The regular stack preserves LIFO order. Values greater than the current
 * minimum are stored after the dummy head. Each new minimum (including a
 * duplicate minimum) is stored before the dummy tail, preserving the history
 * of minimum values.
 */
class MinStack {
    private static class Node {
        int val;
        Node prev;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }
    }

    private final Stack<Integer> stack;
    private final Node head;
    private final Node tail;
    private int minValue;

    public MinStack() {
        stack = new Stack<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        minValue = Integer.MAX_VALUE;
    }

    public void push(int val) {
        stack.push(val);
        Node newNode = new Node(val);

        // Compare before changing minValue.
        if (val > minValue) {
            insertAfterHead(newNode);
        } else {
            insertBeforeTail(newNode);
            minValue = val;
        }
    }

    public void pop() {
        ensureNotEmpty();
        int removedValue = stack.pop();

        if (removedValue > minValue) {
            remove(head.next);
        } else {
            remove(tail.prev);

            if (stack.isEmpty()) {
                minValue = Integer.MAX_VALUE;
            } else {
                minValue = tail.prev.val;
            }
        }
    }

    public int top() {
        ensureNotEmpty();
        return stack.peek();
    }

    public int getMin() {
        ensureNotEmpty();
        return minValue;
    }

    private void insertAfterHead(Node node) {
        Node first = head.next;
        node.prev = head;
        node.next = first;
        head.next = node;
        first.prev = node;
    }

    private void insertBeforeTail(Node node) {
        Node last = tail.prev;
        node.prev = last;
        node.next = tail;
        last.next = node;
        tail.prev = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    private void ensureNotEmpty() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
    }
}
