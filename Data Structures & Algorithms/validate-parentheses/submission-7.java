class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> bracketMap = Map.of(')', '(', ']', '[', '}', '{');
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()) {
            if (bracketMap.containsKey(c)) {
                // if stack is not empty and top of stack equals open braces 
                // then pop the top
                if (!stack.isEmpty() && stack.peek().equals(bracketMap.get(c))) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
