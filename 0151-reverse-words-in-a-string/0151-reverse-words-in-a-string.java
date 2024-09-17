class Solution {
    public String reverseWords(String s) {

        StringBuilder result = new StringBuilder();
        String[] words = s.trim().split(" ");
        for(int i = words.length-1; i>=0; i-- ){
            if(!words[i].isEmpty()){
                result.append(words[i]).append(" ");
            }
        }
        return result.toString().trim();
    }
}