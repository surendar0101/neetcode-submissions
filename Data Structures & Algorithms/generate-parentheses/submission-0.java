class Solution {
    private Stack<Character> stack;
    private List<String> result;
    private int totalCount;

    Solution() {
        stack = new Stack<>();
        result = new ArrayList<>();
    }

    public List<String> generateParenthesis(int n) {
        this.totalCount = n;
        backTrack(0, 0);
        return result;
    }

    private void backTrack(int openCount, int closedCount) {
        if (openCount == closedCount && openCount == totalCount) {
            StringBuilder sb = new StringBuilder();
            for (char c: stack) {
                sb.append(c);
            }
            result.add(sb.toString());
            return;
        }
        if (openCount < totalCount) {
            stack.push('(');
            backTrack(openCount + 1, closedCount);
            stack.pop();
        }

        if (closedCount < openCount) {
            stack.push(')');
            backTrack(openCount, closedCount + 1);
            stack.pop();
        }
    }
}
