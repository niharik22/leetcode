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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
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

        if(listA == null && listB != null){
            listA = headB;
            while(listA != null){
                listA = listA.next;
                listB = listB.next;
                if(listB == null){
                    listB = headA;    
                }
                if(listA == listB){
                    return listA;
                }
            }
        }
        else if(listB == null && listA != null){
            listB = headA;
            while(listB != null){
                listA = listA.next;
                listB = listB.next;
                if(listA == null){
                    listA = headB;    
                }
                if(listA == listB){
                    return listA;
                }
            }
        }
     
    return null;
}
}