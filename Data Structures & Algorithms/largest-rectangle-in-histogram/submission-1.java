class Pair {
    int index;
    int height;
    public Pair(int index, int height) {
        this.index = index;
        this.height = height;
    }
}
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0; // Holds the result
        Stack<Pair> stack = new Stack<>();
        int n = heights.length;
        
        // One pass to construct stack with possible heights
        for(int i=0; i<n; i++) {
            int start = i;
            int currHeight = heights[i];
            while(!stack.isEmpty() && stack.peek().height > currHeight) {
                Pair topPair = stack.pop();
                maxArea = Math.max(maxArea, topPair.height * (i - topPair.index));
                start = topPair.index;
            }
            stack.push(new Pair(start, currHeight));
        }

        // Re-eval the maxArea with remaining heights in stack
        for (Pair pair: stack)
            maxArea = Math.max(maxArea, pair.height * (heights.length - pair.index));
        return maxArea;
    }
}
