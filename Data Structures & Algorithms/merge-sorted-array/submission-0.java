class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // follow a three pointer approach
        // last: denotes last pointer of nums1
        // i: denotes last valid entiry in nums1
        // j: denotes last entry in nums2
        int last = nums1.length - 1;
        int i = m-1, j = n-1;

        // This process will last till nums2 pointer reaches first elements
        while(j >=0 ) {
            if (i >=0 && nums1[i] >= nums2[j]) {
                // Add current valid last nums1 element to end of nums1
                nums1[last--] = nums1[i--];
            } else {
                // Add current last nums2 element to end of nums1
                nums1[last--] = nums2[j--];
            }
        }
    }
}