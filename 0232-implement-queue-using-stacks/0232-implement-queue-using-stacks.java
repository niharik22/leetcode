class MyQueue {

    Stack<Integer> stack;
    Stack<Integer> revStack;
    
    public MyQueue() {
        stack = new Stack<>();
        revStack = new Stack<>();
    }
    
    public void push(int x) {
        if(!revStack.isEmpty()){
            while(!revStack.isEmpty()){
                stack.push(revStack.pop());
            }
        }
        stack.push(x);
    }
    
    public int pop() {
        if(revStack.isEmpty() && stack.isEmpty()){
            return -1;
        }
        if(!stack.isEmpty()){
            while(!stack.isEmpty()){
               revStack.push(stack.pop());
           }
        }
        return revStack.pop();      
    }
    
    public int peek() {
        if(!stack.isEmpty()){
            while(!stack.isEmpty()){
                revStack.push(stack.pop());
            }
        } 
       return revStack.peek();
    }
    
    public boolean empty() {
        return stack.isEmpty() && revStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */