class MyCircularQueue {
    
    int[] data;
    int head=0;
    int tail=-1;
    
    public MyCircularQueue(int k) {
        data = new int[k];
    }
    
   public boolean enQueue(int value) {
    if (isFull()) {
        return false;
    } else {
        tail = (tail + 1) % data.length;
        data[tail] = value;
        return true;
    }
}
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(head == tail){
            head = 0;
            tail =-1;
            return true;
        }
        head++;
        if(head>=data.length){
            head = 0;
        }
        return true;
    }
    
    public int Front() {
        
        return isEmpty()? -1 : data[head];
    }
    
    public int Rear() {
        return isEmpty()? -1 : data[tail];
    }
    
    public boolean isEmpty() {
        return (tail<0);
    }
    
    public boolean isFull() {
        if((tail != -1) && ( (head == tail+1) || (head == 0 && tail == data.length-1))){
            return true;
        }
           return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */