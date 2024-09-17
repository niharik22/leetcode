class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if(length == 0) return 0;

        int max = 0;
        var dupl = new HashSet<Character>();

        int left = 0;
        int right = 0;

        while(right<length){
            if(!dupl.contains(s.charAt(right))){
                dupl.add(s.charAt(right));
                right++;
                max = Integer.max(max, right-left);
            } else{
                dupl.remove(s.charAt(left));
                left++;
            }
        }

        return max;  
    }
}