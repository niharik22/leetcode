class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Character> sToTMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            // Check if sChar is already mapped to a character in t
            if (sToTMap.containsKey(sChar)) {
                // If the mapping is incorrect, return false
                if (sToTMap.get(sChar) != tChar) {
                    return false;
                }
            } else {
                // If sChar is not mapped yet, check if tChar is already mapped to another character in s
                // If tChar is already mapped, return false
                if (sToTMap.containsValue(tChar)) {
                    return false;
                }
                // Otherwise, create a new mapping from sChar to tChar
                sToTMap.put(sChar, tChar);
            }
        }
        
        return true;
    }
}