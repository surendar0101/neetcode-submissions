class Solution {
    public boolean isPalindrome(String s) {
        if(null == s) return false;

        StringBuilder normalizeString = new StringBuilder();
        for(char c: s.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                normalizeString.append(c);
            }
        }

        String alphaNumericString = normalizeString.toString();
        int first = 0, last = alphaNumericString.length()-1;

        while(first < last) {
            if (alphaNumericString.charAt(first) != alphaNumericString.charAt(last)) {
                return false;
            }
            first++;
            last--;
        }
        return true;
    }
}
