class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        int n = word.length(), m = abbr.length();
        while (i < n && j < m) {
            // If there are any leading zeros then abbr is invalid
            if (abbr.charAt(j) == '0') return false;

            // Check if current index of abbr is a digit
            // Else move to else block to validate correctness of char
            if (Character.isDigit(abbr.charAt(j))) {
                int subLen = 0;
                // The following is to check if there are any adjacent digits
                while ( j < m && Character.isDigit(abbr.charAt(j))) {
                    subLen = subLen * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                // Perform replacement by moving index of word to replacement length
                i += subLen;
            } else {
                if (i < n && word.charAt(i) == abbr.charAt(j)) {
                    // This indicates correctness of char 
                    // in corresponding indices
                    i++;
                    j++;
                } else {
                    // This case will indicate the invalidity of abbr
                    return false;
                }
            }
        }
        return i == n && j == m;
    }
}