class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean containsDuplicate = false;
        for(int num: nums) {
            if (map.containsKey(num)) {
                containsDuplicate = true;
                break;
            }
            map.put(num, 1);
        }
        return containsDuplicate;
    }
}
