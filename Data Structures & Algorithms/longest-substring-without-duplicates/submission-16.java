class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dict = new HashMap<>();
        int left = 0, right = 0;
        int result = 0;
        while(right < s.length()) {
            char c = s.charAt(right);
            if (dict.containsKey(c)) {
                left = Math.max(left, dict.get(c) + 1);
            }
            dict.put(c, right);
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
