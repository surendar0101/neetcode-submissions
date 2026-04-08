class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketMap = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
        );

        for(char c: s.toCharArray()) {
            // If the close bracket is encountered check for validity
            // else push the open bracket to stack
            if(bracketMap.containsKey(c)) {
                // if current closed bracked is equal to the top of stack then pop the top
                // else the paranthesis is not valid
                if(!stack.isEmpty() && stack.peek().equals(bracketMap.get(c))) {
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
