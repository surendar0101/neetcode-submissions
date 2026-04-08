class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() <= 1) {
            return s.length();
        }
        HashSet<Character> charSet = new HashSet<>();
        int l = 0, result = 0;
        for (int r = 0; r < s.length(); r++) {
            while(charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(r));
            result = Math.max(result, r - l + 1);
        }
        return result;

    }
}
