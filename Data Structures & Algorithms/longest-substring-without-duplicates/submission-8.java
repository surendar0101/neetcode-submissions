class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, result = 0, n = s.length();
        Map<Character, Integer> charMap = new HashMap<>();
        while(right < n) {
            if (charMap.containsKey(s.charAt(right))) {
                left = Math.max(left, charMap.get(s.charAt(right)) + 1);
            }
            charMap.put(s.charAt(right), right);
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
