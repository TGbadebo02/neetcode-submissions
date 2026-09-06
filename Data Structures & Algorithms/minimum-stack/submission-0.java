class MinStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MinStack() {
        // intlz the stack objects.
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void push(int val) {
        // 6
        stack1.push(val);
        if (stack2.isEmpty() || val <= stack2.peek()) {
            stack2.push(val);
        }
    }

    public void pop() {
        // simple pop operation.
        if (stack2.peek() == stack1.peek()) {
            stack2.pop();
        }
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
