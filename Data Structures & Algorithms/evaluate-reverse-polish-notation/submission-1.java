class Solution {
    public int evalRPN(String[] tokens) {
        //set the base case.
        if(tokens.length == 0 || tokens.length > 1000) return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        
        for(String token : tokens){
            if(!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")){
                int tokennum = Integer.parseInt(token);
                stack.add(tokennum);
            }
            else if(token.equals("+")){
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                int result = operand1 + operand2;
                stack.add(result);
            }

            else if(token.equals("-")){
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                int result = operand1 - operand2;
                stack.add(result);
            }

            else if(token.equals("*")){
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                int result = operand1 * operand2;
                stack.add(result);
            }

            else{
                
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                int result = operand1 - operand2;
                stack.add(result);
            }
        }
      return stack.peek();
    }
}
