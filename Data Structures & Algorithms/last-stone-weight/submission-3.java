class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone: stones) 
            pq.offer(stone);
        
        while (pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            if (Math.abs(stone1 - stone2) > 0) 
                pq.offer(Math.abs(stone1 - stone2));
        }
        return pq.size() == 0 ? 0 : pq.peek();
    }
}
