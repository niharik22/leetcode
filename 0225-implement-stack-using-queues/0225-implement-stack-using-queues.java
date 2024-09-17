class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int tail;
    
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        tail = x;
        if (queue2.isEmpty()) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
    }
    
    public int pop() {
        if (empty()) {
            return -1;
        }
        int size;
        if (queue2.isEmpty()) {
            size = queue1.size();
            for (int i = 0; i < size; i++) {
                int current = queue1.poll();
                if (i == size - 1) {
                    return current;
                } else {
                    tail = current;
                    queue2.offer(current);
                }
            }
        } else {
            size = queue2.size();
            for (int i = 0; i < size; i++) {
                int current = queue2.poll();
                if (i == size - 1) {
                    return current;
                } else {
                    tail = current;
                    queue1.offer(current);
                }
            }
        }
        return -1; // This should never be reached due to the empty check at the beginning
    }
    
    public int top() {
        if (empty()) {
            return -1;
        }
        return tail;
    }
    
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */