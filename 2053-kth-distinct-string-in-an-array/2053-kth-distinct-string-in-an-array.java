class Solution {
    public String kthDistinct(String[] arr, int k) {
        var freq = new HashMap<String, Integer>();

        for (String s : arr) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }
        int count =0;
        for( String s: arr){
            if(freq.get(s) == 1){
                count++;
                if(count == k){
                    return s;
                }
            }
        }
        return "";
    }
}