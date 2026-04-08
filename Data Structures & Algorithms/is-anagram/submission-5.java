class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] dict = new int[26];
        for(char c: s.toCharArray()) {
            dict[c - 'a']++;
        }
        for(char c: t.toCharArray()) {
            dict[c - 'a']--;
        }
        for(int i: dict) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}
