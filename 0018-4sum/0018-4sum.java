class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int a = 0;
        int b = a+1;
        int c = nums.length-1;
        
        int c = d-1;
        List<List<Integer>> result = new ArrayList<>(); 
        HashSet<List<Integer>> uR = new HashSet<>();
        List<Integer> rS = new ArrayList<>();
        while(b<c){
            int sum = nums[a]+nums[b]+nums[c]+nums[d];
            if(sum == target){
                rS.add(a);
                rS.add(b);
                rS.add(c);
                rS.add(d);   
                uR.putIfAbsent(rs); 
                rs.clear();
                a+=1;
                b+=1;
                c+=1;
                d+=1;
            }
            if(sum < target){
                
            }
        }
    }
}