class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        String alphaNumericString = sb.toString();
        int n = alphaNumericString.length();
        for(int i=0, j=n-1; i<j; i++, j--) {
            if (alphaNumericString.charAt(i) != alphaNumericString.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
