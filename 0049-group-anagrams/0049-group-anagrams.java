class Solution {
    
    public  String getSortedString (String str){
             char[] chars = str.toCharArray();
             Arrays.sort(chars);
             return new String(chars);
         }
     public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,List<String>> container = new HashMap<>();
        List<List<String>> anagrams = new ArrayList<>();
        
         for(String word : strs){
            String sortedWord = getSortedString(word);
            container.putIfAbsent(sortedWord,new ArrayList<>());
            (container.get(sortedWord)).add(word);
         }
         for(String key : container.keySet()){
             anagrams.add(container.get(key));
         }
     return anagrams;
     }
}