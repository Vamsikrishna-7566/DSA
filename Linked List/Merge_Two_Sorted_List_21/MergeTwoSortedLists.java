// Iterative merge without a dummy node.
// Time: O(n + m). Auxiliary space: O(1).
// Reuses and relinks input nodes; inputs must be sorted, acyclic, and disjoint.

/** Singly linked list node. Omit this class when the platform supplies it. */
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

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode temp;
        // Select the head and advance the selected input.
        if (list1.val <= list2.val) {
            temp = list1;
            list1 = list1.next;
        } else {
            temp = list2;
            list2 = list2.next;
        }

        ListNode tail = temp;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Attach the remaining sorted suffix.
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        return temp;
    }
}
