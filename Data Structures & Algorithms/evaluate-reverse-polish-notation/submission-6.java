class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens) {
            switch(token) {
                case "+": stack.push(stack.pop() + stack.pop()); break;
                case "-": int a = stack.pop(), b = stack.pop();
                          stack.push(b-a);
                          break;
                case "*": stack.push(stack.pop() * stack.pop()); break;
                case "/": int c = stack.pop(), d = stack.pop();
                          stack.push(d/c);
                          break;
                default:  stack.push(Integer.valueOf(token));
                          break;
            }
        }
        return stack.peek();
    }
}
