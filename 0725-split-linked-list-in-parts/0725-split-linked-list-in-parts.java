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
    public int lengthOfLL(ListNode head){
        int length = 0;
        ListNode curNode = head;
        while(curNode!=null){
            length++;
            curNode = curNode.next;
        }
        return length;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = lengthOfLL(head);
        ListNode[] result = new ListNode[k];
        if(length<=k){
        ListNode curNode = head;
                for(int i = 0; i<length; i++){
                    if(curNode!=null){
                    result[i] = new ListNode(curNode.val);
                    curNode = curNode.next;
                    } else{
                        result[i] = null;
                    }
                }
        } else{
            ListNode curNode = new ListNode(-1, head);
            int q = length/k;
            int r = length%k;
            for(int i = 0; i<k;i++){
                result[i] = curNode.next;
                int counter = q;
                if(r!= 0){
                    counter++;
                    r--;
                }
                for(int j = 0; j<counter; j++){
                    curNode = curNode.next;
                }
                ListNode temp = new ListNode(curNode.val,curNode.next);
                curNode.next = null;
                curNode = temp;
            }
        }

    return result;
    }
}