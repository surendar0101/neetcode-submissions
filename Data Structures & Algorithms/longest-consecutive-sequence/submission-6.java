class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums)
            set.add(num);
        int result = 0;
        for (int num: nums) {
            int curr = 1;
            while (set.contains(num - 1)) {
                num = num - 1;
                curr++;
            }
            result = Math.max(result , curr);
        }
        return result;
    }
}
