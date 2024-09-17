class Solution {
    public int compress(char[] chars) {
        int l = chars.length;
        if (l == 0 || l == 1) {
            return l;
        }
        
        int j = 0;  // index to place the next character in the compressed form
        int count = 1;  // to count the occurrences of each character
        
        for (int i = 1; i <= l; i++) {
            if (i < l && chars[i] == chars[i - 1]) {
                count++;
            } else {
                chars[j++] = chars[i - 1];
                if (count > 1) {
                    String countStr = Integer.toString(count);
                    for (char ch : countStr.toCharArray()) {
                        chars[j++] = ch;
                    }
                }
                count = 1;  // reset the count
            }
        }
        
        return j;
    }
}