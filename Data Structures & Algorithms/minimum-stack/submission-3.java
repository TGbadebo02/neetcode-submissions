class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {

        if(minStack.isEmpty()){
            minStack.add(val);
        }stack.add(val);

        if(!minStack.isEmpty() && val <= minStack.peek()){
            minStack.add(val);
        }
    }

    public void pop() {
       int val = stack.pop();

        if(val == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
