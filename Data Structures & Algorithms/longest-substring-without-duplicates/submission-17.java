class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, n = s.length();
        int result = 0;
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) 
                left = Math.max(left, map.get(c) + 1);
            map.put(c, right);
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
