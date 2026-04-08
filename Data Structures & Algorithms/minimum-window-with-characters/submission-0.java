class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];

        for(char c: t.toCharArray()) {
            freq[c]++;
        }

        int start =0, end=0;
        int startIndex = 0, minLength = Integer.MAX_VALUE;
        int characters = t.length();

        while(end < s.length()) {
            if (freq[s.charAt(end)] > 0) {
                characters--;
            }
            freq[s.charAt(end)]--;
            end++;
            while(characters == 0) {
                // Check if the obtained subString is of minLength
                if (minLength > end - start) {
                    minLength = end - start;
                    startIndex = start;
                }
                freq[s.charAt(start)]++;
                if (freq[s.charAt(start)] > 0) {
                    characters++;
                }
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }
}
