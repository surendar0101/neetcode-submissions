class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left = 0, n = s.length();
        int result = 0;
        for(int right = 0; right < n; right++) {
            // If char already present remove the value and move left pointer
            while(charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            // Calculate the window size and compare it with result stored
            // to get max value
            result = Math.max(right - left + 1, result);
        }
        return result;
    }
}
