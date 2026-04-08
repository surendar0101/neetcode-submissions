class MedianFinder {
    private Queue<Integer> smallHeap; // maxHeap b > a
    private Queue<Integer> largeHeap; // minHeap a > b
    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a,b) -> b-a);
        largeHeap = new PriorityQueue<>((a,b) -> a-b);
    }
    
    public void addNum(int num) {
        smallHeap.add(num);
        if (
            smallHeap.size() > largeHeap.size() ||
            !largeHeap.isEmpty() &&
            smallHeap.peek() > largeHeap.peek()
        ) {
            largeHeap.add(smallHeap.poll());
        }

        if (largeHeap.size() > smallHeap.size()) {
            smallHeap.add(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        if (smallHeap.size() > largeHeap.size()) {
            return (double) smallHeap.peek();
        } else if (smallHeap.size() < largeHeap.size()) {
            return (double) largeHeap.peek();
        } else {
            return (double) (smallHeap.peek() + largeHeap.peek()) / 2;
        }
    }
}
