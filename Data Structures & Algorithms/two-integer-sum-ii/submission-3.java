class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0, index2 = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< numbers.length; i++) {
            int temp = target - numbers[i];
            if (map.containsKey(temp)) {
                return new int[] {map.get(temp), i + 1};
            }
            map.put(numbers[i], i + 1);
        }
        return new int[] {-1, -1};
    }
}
