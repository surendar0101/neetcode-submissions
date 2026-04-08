class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int result = 0, maxFreq = 0;
        int n = s.length(), l=0;
        for(int r=0; r<n; r++) {
            // Update the freq of current char by 1 in each iteration
            freq[s.charAt(r) - 'A']++;
            // compare and update the freq for char against maxFreq
            maxFreq = Math.max(maxFreq, freq[s.charAt(r) - 'A']);

            // If (window size - maxfreq) > given k 
            // then reduce the window size by incrementing left 
            // and reducing the freq of char indexed by 'l'
            if(r - l + 1 - maxFreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}
