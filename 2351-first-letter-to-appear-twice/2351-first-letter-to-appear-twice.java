class Solution {
    public char repeatedCharacter(String s) {
        HashSet<Character> l = new HashSet<>();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(l.contains(c)){
                return c;
            } else{
                l.add(c);
            }
        }
        return '\0';
    }
}