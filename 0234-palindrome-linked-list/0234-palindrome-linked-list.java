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
        public ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next; // Store next node
            curr.next = prev;          // Reverse current node's pointer
            prev = curr;               // Move prev and curr one step forward
            curr = next;
        }
        return prev; // prev will be the new head at the end of the loop
    }
    
   public boolean isPalindrome(ListNode head) {
    if(head == null) {
        return false;
    } else if(head.next == null) {
        return true;
    } else if(head.next.next == null) {
        return (head.val == head.next.val);
    }

    ListNode fast = head;
    ListNode slow = head;

    // Find the middle (slow will point to middle, fast at the end or null)
    while(fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }

    // If the list has an odd number of elements, skip the middle element
    if (fast != null) {
        slow = slow.next;
    }

    ListNode secondHalf = reverseLL(slow);
    ListNode firstHalf = head;

    while(secondHalf != null) {
        if (firstHalf.val != secondHalf.val) {
            return false;
        }
        firstHalf = firstHalf.next;
        secondHalf = secondHalf.next;
    }

    return true;
}
}