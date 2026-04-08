class KthLargest {
    private PriorityQueue<Integer> heap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        this.k = k;
        for (int num: nums) {
            add(num);
            if (heap.size() > k)
                heap.poll();
        }
    }
    
    public int add(int val) {
        this.heap.offer(val);
        if (heap.size() > k)
            heap.poll();
        return heap.peek();
    }
}
