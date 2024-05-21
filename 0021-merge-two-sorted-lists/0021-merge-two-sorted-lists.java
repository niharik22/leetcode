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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
         // Edge case: If either list is null, return the other.
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Use a dummy head to simplify the merging process.
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;

        // Traverse both lists and directly link nodes from list1 and list2.
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {  // Including the case when list1.val == list2.val to handle duplicates.
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // After the main loop, connect the remaining part of whichever list is not empty.
        current.next = (list1 != null) ? list1 : list2;

        return dummyHead.next;
    }
}