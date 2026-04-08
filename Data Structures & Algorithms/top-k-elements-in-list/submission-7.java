class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freq = new List[nums.length + 1];
        for (int i=0; i<freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            // Storing the keys of freqMap in index of their count
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int index =0;
        // If we iterate in reverse order we'll get the values of top k count 
        for(int i = freq.length-1; i > 0 && index < k; i--) {
            for(int value: freq[i]) {
                result[index++] = value;
                if (index == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
