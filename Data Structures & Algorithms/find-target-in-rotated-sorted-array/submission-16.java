class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target)
                return mid;

            // Check if mid is in left sorted portion
            // Else place in right sorted portion
            if (nums[left] <= nums[mid]) {
                // check the edges to decide where to place mid pointers next
                if (nums[left] > target || nums[mid] < target)
                    left = mid + 1;
                else 
                    right = mid - 1;

            } else {
                // check the edges to decide where to place mid pointers next
                if (nums[right] < target || nums[mid] > target)
                    right = mid - 1;
                else 
                    left = mid + 1;
            }
        }
        return -1; //Negative base case
    }
}
