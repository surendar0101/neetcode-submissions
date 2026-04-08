class Solution {
    public boolean isAnagram(String s, String t) {
        char[] dict = new char[26];
        for(char c: s.toCharArray()) 
            dict[c - 'a']++;
        for(char c: t.toCharArray())
            dict[c - 'a']--;
        
        for(int i=0; i<dict.length; i++) {
            if (dict[i] > 0)
                return false;
        }
        return true;
    }
}
