// Reorder List: O(n) time and O(1) auxiliary space.
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode front = head.next;
            head.next = prev;
            prev = head;
            head = front;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Count the nodes.
        ListNode dummy = head;
        int count = 0;
        while (dummy != null) {
            count++;
            dummy = dummy.next;
        }

        // Keep the extra node in the first half.
        int halfList = (count + 1) / 2;
        int index = 1;
        ListNode halfPointer = head;
        while (index < halfList) {
            halfPointer = halfPointer.next;
            index++;
        }

        // Split, then reverse the second half.
        ListNode head1 = halfPointer.next;
        halfPointer.next = null;
        ListNode prev = reverseList(head1);

        // Merge the halves alternately.
        ListNode first = head;
        ListNode second = prev;
        while (second != null) {
            ListNode nextFirst = first.next;
            ListNode nextSecond = second.next;
            first.next = second;
            second.next = nextFirst;
            first = nextFirst;
            second = nextSecond;
        }
    }
}

// ListNode is provided by LeetCode. Omit this definition there.
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
