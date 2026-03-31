class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dict = new HashMap<>();
        int result = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (dict.containsKey(c)) {
                left = Math.max(left, dict.get(c) + 1);
            }
            dict.put(c, right);
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
