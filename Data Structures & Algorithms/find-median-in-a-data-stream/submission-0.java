class MedianFinder {
    private Queue<Integer> smallHeap; // small elements - maxHeap
    private Queue<Integer> largeHeap; // large elements - minHeap

    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a,b) -> b - a); // constructs maxHeap with b > a
        largeHeap = new PriorityQueue<>((a,b) -> a - b); // constructs minHeap with a > b
    }
    
    public void addNum(int num) {
        smallHeap.add(num);
        // 1) max element in smallHeap <= min element in largeHeap
        // 2) len(smallHeap) <= len(largeHeap) + 1
        // 3) both should not be null
        // If not then remove the max element and add it in large heap
        if (
            smallHeap.size() - largeHeap.size() > 1 ||
            !largeHeap.isEmpty() &&
            smallHeap.peek() > largeHeap.peek()
        ) {
            // remove max element and add it in large heap
            largeHeap.add(smallHeap.poll());
        }
        if (largeHeap.size() - smallHeap.size() > 1) {
            smallHeap.add(largeHeap.poll());
        }

    }
    
    public double findMedian() {
        if (smallHeap.size() < largeHeap.size()) {
            return (double) largeHeap.peek();
        } else if (smallHeap.size() > largeHeap.size()) {
            return (double) smallHeap.peek();
        } else {
            return (double) (smallHeap.peek() + largeHeap.peek()) / 2;
        }
    }
}
