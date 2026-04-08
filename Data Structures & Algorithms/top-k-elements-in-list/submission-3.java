class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Create a map with frequency of it's count
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num: nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num , 0) + 1);
        }

        // Create a priority queue with min-heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> frequencyMap.get(a) - frequencyMap.get(b));

        // maintain the priority queue of size k
        for(int num: frequencyMap.keySet()) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // create a result array
        int[] result = new int[k];
        for (int i = k-1; i >= 0; i--) {
            result[i] = pq.poll();
        }
        return result;
    }
}
