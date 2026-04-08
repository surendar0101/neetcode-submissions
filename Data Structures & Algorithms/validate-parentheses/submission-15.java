class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = Map.of(
            '}', '{',
            ']', '[',
            ')', '('
        );

        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (map.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek().equals(map.get(c)))
                    stack.pop();
                else 
                    return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
