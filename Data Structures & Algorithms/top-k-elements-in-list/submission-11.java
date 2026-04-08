class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1) find the freq Map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        // 2) create a priority queue (Min heap)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> freqMap.get(a) - freqMap.get(b));

        // 3) construct the min heap of size k to 
        for(int num: freqMap.keySet()) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Create a result array of size k and extract the values from min heap
        int[] result = new int[k];
        for(int i = k-1; i>=0; i--) {
            result[i] = pq.poll();
        }
        return result;
    }
}
