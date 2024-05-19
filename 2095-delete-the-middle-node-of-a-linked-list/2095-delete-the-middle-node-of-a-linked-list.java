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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next == null){
            return null;
        }
        if(head.next.next == null){
            head.next = null;
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode tortoise = dummy;
        ListNode hare = head;
        while(hare!=null && hare.next!=null){
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        tortoise.next = tortoise.next.next;
        return dummy.next;
    }
}