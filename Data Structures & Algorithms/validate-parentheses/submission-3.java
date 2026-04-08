class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketMap = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
        );

        for(char c: s.toCharArray()) {
            if(bracketMap.containsKey(c)) {
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
