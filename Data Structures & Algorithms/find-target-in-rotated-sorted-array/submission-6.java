class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) 
                return mid;

            // if all values from mid are <= of that of mid 
            // then mid is in left sorted segment
            if(nums[left] <= nums[mid]) {
                if (target > nums[mid] || target < nums[left]) {
                    // case if target > mid or target < left most element
                    // so the value will be in right segment of arr
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums[right]) {
                    // case if target < mid or > that of right most element
                    // so the value can be in left segement of rotated arr
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
