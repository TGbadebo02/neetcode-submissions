class Solution {
    public boolean isValid(String s) {
        /**
         1) []-> true
         2) empty -> true.
         3)
        */

        Stack<Character> stack = new Stack<>();
        // 
        //
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.add(c);
                }
                else if (!stack.isEmpty() && c == '}' && stack.peek() == '{') {
                    stack.pop();
                }

                else if (!stack.isEmpty() && c == ']' && stack.peek() == '[') {
                    stack.pop();
                }

                else if (!stack.isEmpty() && c == ')' && stack.peek() == '(') {
                    stack.pop();
                }

                else {
                    return false;
                }
            }
         return stack.isEmpty(); // true,
    }
}
