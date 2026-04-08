class Solution {
    public int longestConsecutive(int[] nums) {
        // Create a hashSet to store unique nums
        // 2) Create a logic to get smallest nums
        //    So that we can find if there is a num + 1 sequece and so on
        Set<Integer> store = new HashSet<>();
        for(int num: nums) {
            store.add(num);
        }

        int result = 0;
        // Run through the array once again and 
        // Find the least number that is the start of longest consecutive
        for(int num: store) {
            if(!store.contains(num-1)) {
                int length = 0;
                while(store.contains(num + length)) {
                    length++;
                }
                result = Math.max(length, result);
            }
        }
        return result;
    }
}
