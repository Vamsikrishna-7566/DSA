// Add Two Numbers: digits are stored in reverse order.
// For LeetCode, copy only class Solution.
// Time O(max(m, n)); auxiliary space O(1); output O(max(m, n)).

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode start = dummy;
        int carry = 0;

        while (temp1 != null || temp2 != null || carry != 0) {
            int digit1 = (temp1 != null) ? temp1.val : 0;
            int digit2 = (temp2 != null) ? temp2.val : 0;
            int sum = digit1 + digit2 + carry;

            carry = sum / 10;
            int remainder = sum % 10;

            ListNode node = new ListNode(remainder);
            start.next = node;
            start = start.next;

            if (temp1 != null) {
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                temp2 = temp2.next;
            }
        }
        return dummy.next;
    }
}

// Included for local compilation. LeetCode provides this class.
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
