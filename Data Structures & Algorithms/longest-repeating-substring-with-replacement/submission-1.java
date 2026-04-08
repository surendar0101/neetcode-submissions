class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l=0, result=0, maxFreq = 0, n = s.length();
        for(int r=0; r<n; r++) {
            freq[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(r) - 'A']);
            if (r - l + 1 - maxFreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            result = Math.max(result, r-l+1);
        }
        return result;
    }
}
