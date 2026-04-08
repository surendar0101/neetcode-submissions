class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int l = 0, r = 0;
        
        // The double ended queue that stores the indices of elements based on decreasing values.
        Deque<Integer> q = new LinkedList<>();
        
        while(r < n) {
            // Remove all the elements that are less than current element as they'll never be maximum
            while(!q.isEmpty() && nums[q.getLast()] < nums[r])
                q.removeLast();

            q.addLast(r);

            // Remove first element as it's out of window
            // Would have already been considered in output array
            if (l > q.getFirst())
                q.removeFirst();
            
            // This block will start only when the right pointer reaches window size for the first time
            if ((r + 1) >= k) 
                result[l++] = nums[q.getFirst()];
            r++;
        }
        return result;
    }
}
