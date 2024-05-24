/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    
    public Node flatten(Node head) {
        if (head == null) {
            return null;  // Early return if the head is null
        }

        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                Node tempNext = cur.next; // Save the next node before flattening child
                Node child = flatten(cur.child); // Recursively flatten the child list

                cur.next = child; // Point current node to the head of the flattened child list
                child.prev = cur; // Set the child's previous to current node
                cur.child = null; // Clear the child pointer as it's now flattened into the main list

                // Find the tail of the newly flattened child list
                Node tail = child;
                while (tail.next != null) {
                    tail = tail.next;
                }

                // Reconnect the original next node (tempNext) to the tail of the flattened list
                tail.next = tempNext;
                if (tempNext != null) {
                    tempNext.prev = tail; // Correctly set tempNext's previous to tail
                }
            }
            // Move to the next node in the main list, which could now be part of the flattened child list
            cur = cur.next;
        }

        return head;
    }
}