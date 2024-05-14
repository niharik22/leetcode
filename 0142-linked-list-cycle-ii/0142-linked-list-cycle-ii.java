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
    
    public ListNode detectCycle(ListNode head) {
        
        if(head == null || head.next==null){
            return null;
        }
        ListNode fastPointer = head.next.next;
        ListNode slowPointer = head.next;
        while(fastPointer != null && fastPointer.next!=null){
             if(slowPointer == fastPointer){
                fastPointer = head;
                while(slowPointer != fastPointer ){
                    slowPointer = slowPointer.next;
                    fastPointer = fastPointer.next;
                }
                 return fastPointer;
            }
        slowPointer = slowPointer.next;
        fastPointer = fastPointer.next.next;
        }
        return null;
    }
}