class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        for(int i=0; i<s.length(); i++) {
            // calculate the number of palindromes with odd and even length
            result += countPalindromes(s, i, i);
            result += countPalindromes(s, i, i+1);
        }
        return result;
    }

    private int countPalindromes(String s, int l, int r) {
        int result = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { 
            result++;
            r++;
            l--;
        }
        return result;
    }
}
