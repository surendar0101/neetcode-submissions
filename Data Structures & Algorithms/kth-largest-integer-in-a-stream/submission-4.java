class KthLargest {
    private PriorityQueue<Integer> heap;
    private int k;
    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<Integer>();
        this.k = k;
        for (int num: nums) {
            add(num);
            if (heap.size() > k) 
                heap.poll();
        }
    }
    
    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k)
            heap.poll();

        return heap.peek();
    }
}
