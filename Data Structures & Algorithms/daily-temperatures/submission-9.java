class Pair {
    private int index;
    private int temp;
    public Pair(int index, int temp) {
        this.index = index;
        this.temp = temp;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] result = new int[n];
        Stack<Pair> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            while (!stack.isEmpty() && stack.peek().temp < temp[i]) {
                Pair pair = stack.pop();
                result[pair.index] = i - pair.index;
            }
            stack.push(new Pair(i, temp[i]));
        }
        return result;
    }
}
