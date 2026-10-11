class Solution {
    public boolean isValid(String s) {
        /**
         1) []-> true
         2) empty -> true.
         3)
        */

        Stack<Character> stack = new Stack<>();
        // ] )
        for (char c : s.toCharArray()) {
            if (c == ']' || c == '}' || c == ')') {
                stack.add(c);
            }
        }

        //[
            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && c == '{' && stack.peek() == '}') {
                    stack.pop();
                }

                if (!stack.isEmpty() && c == '[' && stack.peek() == ']') {
                    stack.pop();
                }

                if (!stack.isEmpty() && c == '(' && stack.peek() == ')') {
                    stack.pop();
                } else {
                    continue;
                }
            }
        return stack.isEmpty(); // true,
    }
}
