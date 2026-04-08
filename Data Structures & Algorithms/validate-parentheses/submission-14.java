class Solution {
    private Map<Character, Character> map = Map.of(
        '}', '{',
        ')', '(',
        ']', '['
    );
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if (map.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek().equals(map.get(c))) 
                    stack.pop(); // Valid paranthesis
                else 
                    return false;
            } else 
                stack.push(c);
        }
        return stack.isEmpty();
    }
}
