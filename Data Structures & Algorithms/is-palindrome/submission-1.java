class Solution {
    public boolean isPalindrome(String s) {
        if(null == s) return false;

        StringBuilder normalisedString = new StringBuilder();
        for(char c: s.toLowerCase().toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                normalisedString.append(c);
            }
        }

        String alphaNumbericString = normalisedString.toString();
        int j = alphaNumbericString.length()-1;
        for(int i=0; i < j; i++, j--) {
            if (alphaNumbericString.charAt(i) != alphaNumbericString.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
