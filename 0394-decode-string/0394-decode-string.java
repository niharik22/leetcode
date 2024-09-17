class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                int repeat = countStack.pop();
                StringBuilder decodeString = stringStack.pop();
                for (int i = 0; i < repeat; i++) {
                    decodeString.append(currentString);
                }
                currentString = decodeString;
            } else {
                currentString.append(c);
            }
        }
        return currentString.toString();
    }
}