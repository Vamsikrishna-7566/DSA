/**
 * Reverse a singly linked list in place.
 * Time: O(n). Extra space: O(1).
 * On LeetCode, submit only Solution; ListNode is provided.
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            // Save the next node before reversing the link.
            ListNode front = head.next;
            head.next = prev;
            prev = head;
            head = front;
        }

        return prev;
    }
}

// Included so this file can also be compiled locally.
class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
