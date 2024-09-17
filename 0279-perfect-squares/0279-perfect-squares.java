class Solution {
    

    public int numSquares(int n) {

        int count = 0;
        Queue<Integer> process = new LinkedList<>();
        
        process.offer(n);
        
        while(!process.isEmpty()){
            int s = process.size();
            count++;
            for(int i = 0; i<s;i++){
                int cur = process.poll();
                for(int j =1; j*j<=cur; j++){
                    int next = cur - j*j;         
                    if(next==0){
                        return count;
                    }
                    process.offer(next);
                }
            }
        }
        return count;
    }
}