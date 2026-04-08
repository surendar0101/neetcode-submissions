class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> store = new HashSet<>();
        for(int num: nums) {
            store.add(num);
        }

        int result = 0;
        for(int num: nums) { 
            if(!store.contains(num-1)) {
                int length = 0;
                while(store.contains(num + length)) {
                    length++;
                }
                result = Math.max(result, length);
            }
        }
        return result;
    }
}
