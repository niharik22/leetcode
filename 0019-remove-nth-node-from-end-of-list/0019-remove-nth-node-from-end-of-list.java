/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return head;

        ListNode fast = head;
        ListNode slow = head;

        // Move fast ahead by n steps
        for (int i = 0; i < n; i++) {
            fast = fast.next;
            if (fast == null) {
                // If fast is null, n is equal to the length of the list
                // The head needs to be removed
                return head.next;
            }
        }

        // Move both pointers to find the nth node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return head;
    }
}