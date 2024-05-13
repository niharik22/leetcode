public class LinkedListNode {
    public int value;
    public LinkedListNode next;

    public LinkedListNode(int val) {
        this.value = val;
        this.next = null;
    }
}

class MyLinkedList {
    private LinkedListNode head;

    public MyLinkedList() {
        this.head = null;
    }

    public int get(int index) {
        LinkedListNode curNode = head;
        int curIndex = 0;
        while (curNode != null) {
            if (curIndex == index) {
                return curNode.value;
            }
            curNode = curNode.next;
            curIndex++;
        }
        return -1; // return -1 if index is out of bounds
    }

    public void addAtHead(int val) {
        LinkedListNode newNode = new LinkedListNode(val);
        newNode.next = head;
        head = newNode;
    }

    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        LinkedListNode curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = new LinkedListNode(val);
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        LinkedListNode curNode = head;
        int curIndex = 0;
        while (curNode != null && curIndex < index - 1) {
            curNode = curNode.next;
            curIndex++;
        }
        if (curNode != null && curIndex == index - 1) {
            LinkedListNode newNode = new LinkedListNode(val);
            newNode.next = curNode.next;
            curNode.next = newNode;
        }
    }

    public void deleteAtIndex(int index) {
        if (head == null) return; // nothing to delete if list is empty
        if (index == 0) {
            head = head.next; // remove head
            return;
        }
        LinkedListNode curNode = head;
        int curIndex = 0;
        while (curNode.next != null && curIndex < index - 1) {
            curNode = curNode.next;
            curIndex++;
        }
        if (curNode.next != null && curIndex == index - 1) {
            curNode.next = curNode.next.next; // unlink the node to delete
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */