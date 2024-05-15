/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int lengthCal(ListNode head){
        int length = 1;
        ListNode curNode = head;
        while(curNode.next != null){
            curNode = curNode.next;
            length++;
        }
        return length;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        } 
        int lengthA = lengthCal(headA);
        
        int lengthB = lengthCal(headB);
        
        if(lengthA>lengthB){
            for(int i = 1; i <= lengthA-lengthB; i++){
                headA = headA.next;
            }
        }
        if(lengthA<lengthB){
            for(int i = 1; i <= lengthB-lengthA; i++){
                headB = headB.next;
            }
        }
            ListNode listA = headA;
            ListNode listB = headB;
            while(listA != null && listB != null){
                if(listA == listB){
                    return listA;
                }
                listA = listA.next;
                listB = listB.next;
            }
    return null;
        }
}