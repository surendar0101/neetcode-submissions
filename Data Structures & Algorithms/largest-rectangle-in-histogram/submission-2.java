class Pair {
    int index, height;
    public Pair(int index, int height) {
        this.index = index;
        this.height = height;
    }
}
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Pair> stack = new Stack<>();
        int n = heights.length;
        for (int i=0; i<n; i++) {
            int startIndex = i;
            int currentHeight = heights[i];
            while (!stack.isEmpty() && stack.peek().height >= currentHeight) {
                Pair pair = stack.pop();
                maxArea = Math.max(maxArea, pair.height * (i - pair.index));
                startIndex = pair.index;
            }
            stack.push(new Pair(startIndex, currentHeight));
        }

        for (Pair pair: stack)
            maxArea = Math.max(maxArea, pair.height * (n - pair.index));
        return maxArea;
    }
}
