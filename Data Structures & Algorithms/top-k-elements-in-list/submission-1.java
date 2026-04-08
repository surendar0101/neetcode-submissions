class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> freqMap.get(a) - freqMap.get(b));

        // Create K top Freqent elements
        for(int num: freqMap.keySet()) {
            pq.offer(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];
        for(int i = k-1; i>=0; i--) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}
