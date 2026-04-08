class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Stores temperature, index pair
        Stack<int[]> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for (int i = 0; i<n ; i++) {
            int temp = temperatures[i];
            while(!stack.isEmpty() && temp > stack.peek()[0]) {
                int[] pair = stack.pop();
                result[pair[1]] = i - pair[1];
            }
            stack.push(new int[] {temp, i});
        }
        return result;
    }
}
