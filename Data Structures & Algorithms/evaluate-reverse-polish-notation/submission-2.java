class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numberStack = new Stack<>();
        for(String character: tokens) {
            switch(character) {
                case "+":   
                            numberStack.push(numberStack.pop() + numberStack.pop());
                            break;
                case "-":   
                            int a = numberStack.pop();
                            int b = numberStack.pop();
                            numberStack.push(b-a);
                            break;
                case "*": 
                            numberStack.push(numberStack.pop() * numberStack.pop());
                            break;
                case "/":   
                            int c = numberStack.pop();
                            int d = numberStack.pop();
                            numberStack.push((int) ((double) d/c));
                            break;
                default : 
                           numberStack.push(Integer.parseInt(character));
                           break;
            }
        }
        return numberStack.pop();
    }
}
