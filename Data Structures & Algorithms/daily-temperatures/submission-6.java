class Pair {
    int index;
    int temp;
    public Pair (int index, int temp) {
        this.index = index;
        this.temp = temp;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Pair> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            int currTemp = temperatures[i];
            while (!stack.isEmpty() && stack.peek().temp < currTemp) {
                Pair pair = stack.pop();
                result[pair.index] = i - pair.index; // Gives the index of warmer temp from temp index
            }
            stack.push(new Pair(i, currTemp));
        }
        return result;
    }
}
