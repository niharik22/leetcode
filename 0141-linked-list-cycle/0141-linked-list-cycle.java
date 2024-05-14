/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if (head == null || head.next == null) {
        return false;
    }
        
        ListNode slowPointer = head.next;
        ListNode fastPointer = head.next.next;
        
        while(fastPointer != null && fastPointer.next != null){
            if(fastPointer == slowPointer){
                return true;
            }
        slowPointer = slowPointer.next;
        fastPointer = fastPointer.next.next;
        }
        
        return false;
    }
}