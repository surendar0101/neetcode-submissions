class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // Calculate the frequency of characters in string t
        for(char c: t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        int have = 0, need = countT.size();
        int[] res = {-1,-1};
        int resLen = Integer.MAX_VALUE, l = 0;
        for(int r = 0; r<s.length(); r++) {
            // At each step populate the window with current char freq
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // If current char satisfies the countT map then increase "have" count 
            if(countT.containsKey(c) && window.get(c) == countT.get(c)) {
                have++;
            }
            while(have == need) {
                // If window size is lesser than the previously calculated length
                // then update the result
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                // Reduce the window size to calculate if there is a possible smaller window
                // with have == need
                char leftChar = s.charAt(l);

                // Reduce the freq of leftChar in window map
                window.put(leftChar, window.get(leftChar) - 1);

                // After reduction of char if the freq of leftChar in countT map is not met with window
                // then reduce have by one 
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }

                // Increase the left by one
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "": s.substring(res[0], res[1] + 1);
    }
}
