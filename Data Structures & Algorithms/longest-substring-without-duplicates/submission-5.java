class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0, n = s.length();
        int result = 0;
        for (int right = 0; right < n; right++) {
            if(charMap.containsKey(s.charAt(right))) {
                left = Math.max(charMap.get(s.charAt(right)) + 1, left);
            }
            charMap.put(s.charAt(right), right);
            result = Math.max(right - left + 1, result);
        }
        return result;
    }
}
