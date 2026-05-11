class KthLargest {

    private PriorityQueue<Integer> q;
    private int size;
    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<>(); // Min heap
        size = k; 
        for (int num: nums) {
            q.offer(num);
            if (q.size() > k) {
                q.poll();
            }
        }
    }
    
    public int add(int val) {
        q.offer(val);
        if (q.size() > size)
            q.poll();
        return q.peek();
    }
}
