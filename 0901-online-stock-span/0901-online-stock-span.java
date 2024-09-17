class StockSpanner {
    Stack<int[]> stock;
    public StockSpanner() {
        stock = new Stack<>(); 
    }
    
    public int next(int price) {
        int span = 1;
        
        while(!stock.isEmpty() && stock.peek()[0]<=price){
            span=span+stock.peek()[1];
            stock.pop();
        }
        stock.push(new int[]{price,span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */