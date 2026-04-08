class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, result = 0;
        Map<Character, Integer> freq = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (freq.containsKey(c))
                left = Math.max(left, freq.get(c) + 1);
            freq.put(c, right);
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
