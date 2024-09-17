class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>();
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u');

        int count = 0;
        int max = 0;

        for(int i=0; i<k; i++){
           if(vowels.contains(s.charAt(i))){
           count++;
           }
        }
        
        max = count;
        
        for(int j=k; j<s.length(); j++){
            if(vowels.contains(s.charAt(j))){
                count++;
            }
            if(vowels.contains(s.charAt(j-k))){
                count--;
            }
        max = Integer.max(max,count);
        }
        return max;
    }
}