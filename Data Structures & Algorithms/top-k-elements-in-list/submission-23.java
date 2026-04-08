class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        
        // Construct a min heap to maintain the k freq Elements
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> freqMap.get(a) - freqMap.get(b));

        for (int key: freqMap.keySet()) {
            pq.offer(key);
            if (pq.size() > k) 
                pq.poll(); // Removes the least freq on top
        }

        int[] result = new int[k];
        
        for (int i=0; i<k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}
