class Solution {
  
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        //int[] result = new int[n];
        Stack<Integer> wait = new Stack<>(); 
        for(int i = 0; i<n; i++){
            while(!wait.isEmpty() && (temperatures[i]>temperatures[wait.peek()])){
                int cur = wait.pop();
                temperatures[cur] = i - cur;
            }
            wait.push(i);
        }
        while(!wait.isEmpty()){
            temperatures[wait.pop()] = 0;
        }
        return temperatures;
    }
}