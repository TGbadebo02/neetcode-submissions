class Solution {
    public boolean isValid(String s) {
        /**
         1) []-> true
         2) empty -> true.
         3)
        */

        Stack<Character> stack = new Stack<>();
        // ) ] }

        //
        while (!stack.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (c == ']' || c == '}' || c == ')') {
                    stack.add(c);
                    
                }
                if (!stack.isEmpty() && c == '{' && stack.peek() == '}') {
                    stack.pop();
                }

                if (!stack.isEmpty() && c == '[' && stack.peek() == ']') {
                    stack.pop();
                }

                if (!stack.isEmpty() && c == '(' && stack.peek() == ')') {
                    stack.pop();
                } 

                if(stack.isEmpty() && (c == ']' || c == ')' || c == '}')){
                    return false;
                }
            }
        }
        return stack.isEmpty(); // true,
    }
}
