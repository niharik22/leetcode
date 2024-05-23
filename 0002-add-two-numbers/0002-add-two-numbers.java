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
   
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode a = l1, b = l2, dummy = new ListNode(0), curr = dummy;
        int carry = 0;
            
        while(a != null || b != null){
            
            int x = a == null? 0 : a.val;
            int y = b == null? 0 : b.val;
            
            int sum = x + y + carry;
            
            carry = sum/10;
            curr .next = new ListNode(sum%10);
            
            curr = curr.next;
            if(a!=null){
                a = a.next;
            }
            if(b!=null){
                b = b.next;
            }            
        }
        if(carry!=0){
             curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
}