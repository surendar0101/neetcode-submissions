class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int w: stones)
            maxHeap.add(w);
        
        while (maxHeap.size() > 1) {
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            if (Math.abs(a - b) > 0)
                maxHeap.add(Math.abs(a - b));

        }
        return maxHeap.size() == 1 ? maxHeap.peek() : 0;
    }
}
