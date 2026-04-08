class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        for (char c: s1.toCharArray())
            freq[c - 'a']++;
        
        int left = 0, right = 0;
        int required = s1.length();
        while(right < s2.length()) {
            char rightChar = s2.charAt(right);
            if (freq[rightChar - 'a']-- > 0) {
                required--;
            }
            right++;

            if (right - left > s1.length()) {
                char leftChar = s2.charAt(left);
                if (++freq[leftChar - 'a'] > 0)
                    required++;
                left++;
            }

            if (required == 0) 
                return true;
        }
        return false;
    }
}
