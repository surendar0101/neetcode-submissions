class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int result = 0, maxFreq = 0;
        int[] freq = new int[26];
        while (r <= s.length() - 1) {
            freq[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(r) - 'A']);
            if (r - l + 1 - maxFreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            result = Math.max(result, r - l + 1);
            r++;
        }
        return result;
    }
}
