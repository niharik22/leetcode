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
   public int calLength(ListNode head){
    int length = 1;
    ListNode cur = head;
    while(cur.next != null){
        length++;
        cur = cur.next;
    }
    return length;
   }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int length = 1;
        ListNode cur = head;
        
        while(cur.next != null){
            length++;
            cur = cur.next;
        }
        int r = k%length;
        if(r==0) return head;

        ListNode fast = head;
        ListNode slow = head;

        for(int i = 0; i<r; i++){
            fast = fast.next;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        fast.next = head;
        slow.next = null;
        
        return newHead;
    }
}