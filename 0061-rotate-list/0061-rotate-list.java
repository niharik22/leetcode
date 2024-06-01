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
   
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i<k; i++){
            fast = fast.next;
            if(fast == null){
                fast = head;
            }
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        if(slow == fast) return head;
        ListNode newHead = slow.next;
        fast.next = head;
        slow.next = null;
        
        return newHead;
    }
}