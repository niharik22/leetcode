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
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null){
            return null;
        }
        if(head.next == null|| head.next.next == null){
            return head;
        }
        
        ListNode even = head.next;
        ListNode odd = head;
        ListNode evenHead = head.next;
        
        while(even!=null && even.next!=null){
            odd.next  = even.next;
            even.next = even.next.next;
            odd.next.next = evenHead;
            
            odd = odd.next;
            even = even.next;
        }
        
    return head;
    }
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    