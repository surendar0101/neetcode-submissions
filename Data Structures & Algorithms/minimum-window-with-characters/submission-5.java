class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c: t.toCharArray())
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        int[] result = new int[] {-1,-1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;
        int have = 0, need = countT.size();
        for(int r=0; r<s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (window.containsKey(c) && window.get(c) == countT.get(c))
                have++;
            
            while(have == need) {
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    result[0] = l;
                    result[1] = r;
                }
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);

                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar))
                    have--;
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }
}
