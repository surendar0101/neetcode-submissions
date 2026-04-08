class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        char[] dict = new char[26];
        for(char c: s.toCharArray()) {
            dict[c - 'a']++;
        }

        for(char c: t.toCharArray()) {
            dict[c - 'a']--;
        }

        for(int count: dict) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
