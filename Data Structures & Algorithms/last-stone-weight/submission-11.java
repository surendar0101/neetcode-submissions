class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone: stones)
            maxHeap.offer(stone);
        
        while(maxHeap.size() > 1) {
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            if (a > b) 
                maxHeap.add(a - b);
            else if (b > a)
                maxHeap.add(b - a);
        }
        return maxHeap.size() == 1 ? maxHeap.peek() : 0;
    }
}
