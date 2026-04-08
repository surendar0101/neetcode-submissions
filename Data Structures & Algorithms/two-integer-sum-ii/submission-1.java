class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int first = 0, last = n-1;
        while(first < last) {
            int currentSum = numbers[first] + numbers[last];
            if ( currentSum < target){
                first++;
            } else if (currentSum > target) {
                last--;  
            } else {
                return new int[]{first + 1, last + 1};
            }
        }
        return new int[]{-1,-1};
    }
}
