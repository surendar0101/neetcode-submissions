class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int l=0, result = 0;
        for(int r=0; r < s.length(); r++) {
            while(charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(r));
            // get the max of window size
            result = Math.max(r - l + 1, result);
        }
        return result;
    }
}
