class Solution {
    class Pair {
        int index;
        int temp;
        public Pair(int index, int temp) {
            this.index = index;
            this.temp = temp;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for (int i=0; i<n; i++) {
            int currentTemp = temperatures[i];
            while (!stack.isEmpty() && stack.peek().temp < currentTemp) {
                Pair pair = stack.pop();
                result[pair.index] = i - pair.index;
            }
            stack.push(new Pair(i, currentTemp));
        }
        return result;
    }
}
