class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone: stones)
            maxHeap.add(stone);
        
        while(maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            if (Math.abs(stone1 - stone2) > 0) 
                maxHeap.add(Math.abs(stone1 - stone2));
        }
        return maxHeap.size() == 1 ? maxHeap.peek() : 0;
    }
}
