class Pair {
    private int index;
    private int height;
    public Pair(int index, int height) {
        this.index = index;
        this.height = height;
    }
}
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Pair> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            int startIndex = i;
            while(!stack.isEmpty() && stack.peek().height > heights[i]) {
                Pair pair = stack.pop();
                maxArea = Math.max(maxArea, pair.height * (i - pair.index));
                startIndex = pair.index;
            }
            stack.push(new Pair(startIndex, heights[i]));
        }

        for (Pair pair: stack) {
            maxArea = Math.max(maxArea, pair.height * (n - pair.index));
        }
        return maxArea;
    }
}
