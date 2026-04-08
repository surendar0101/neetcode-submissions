class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> store = new HashSet<>();
        for(int num: nums) {
            store.add(num);
        }

        int lcs = 0;
        for(int num: nums) {
            if (!store.contains(num-1)) {
                int length = 0;
                while(store.contains(length + num)) {
                    length++;
                }
                lcs = Math.max(lcs, length);
            } 
        }
        return lcs;
    }
}
