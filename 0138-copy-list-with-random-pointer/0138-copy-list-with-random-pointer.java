/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    public Node copyRandomList(Node head) {
        
         if (head == null) return null;
        
        Node cur = head;
                                           
        while(cur != null){
            Node newCur = new Node(cur.val);
            newCur.random = cur.random;
            newCur.next = cur.next; 
            cur.next = newCur;
            cur = newCur.next;
        }
    
        
        cur =  head;
        
        while(cur != null){
            if(cur.next.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        Node resultHead = head.next;
        cur =  head;
        Node copy = resultHead;
        
        while(cur!=null){
            cur.next = cur.next.next;
            if (copy.next != null) {copy.next = copy.next.next;}
            cur = cur.next;
            copy = copy.next;
        }
        
        return resultHead;
    }
}