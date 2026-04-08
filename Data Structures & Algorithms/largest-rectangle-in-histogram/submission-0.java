class Pair {
    int index;
    int height;

    public Pair() {}

    public Pair(int index, int height) {
        this.index = index;
        this.height = height;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        
        // Following stack stores index and height pair
        Stack<Pair> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for (int i=0; i<n; i++) {
            int startIndex = i;
            while (!stack.isEmpty() && stack.peek().height > heights[i]) {
                Pair pair = stack.pop();
                maxArea = Math.max(maxArea, pair.height * (i - pair.index));
                startIndex = pair.index;
            }
            stack.push(new Pair(startIndex, heights[i]));
        }
 
        for (Pair pair: stack)
            maxArea = Math.max(maxArea, pair.height * (heights.length - pair.index));
        return maxArea;
    }
}
