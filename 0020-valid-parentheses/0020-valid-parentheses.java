class Solution {
  public boolean isValid(String s) {
 Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // If the character is an opening bracket, push the corresponding closing bracket onto the stack
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                // If the stack is empty or the top of the stack does not match the current character, it's invalid
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        // If the stack is empty, all opening brackets have been matched with their corresponding closing brackets
        return stack.isEmpty();
}
}