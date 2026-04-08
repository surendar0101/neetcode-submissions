class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, result = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        while(right < n) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            right++;
            result = Math.max(result, right - left);
        }
        return result;
    }
}
