class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0, n = s.length(), left = 0;
        int[] freq = new int[26];
        int result = 0;
        for (int right = 0; right < n; right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            if (right - left + 1 > k + maxFreq) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
