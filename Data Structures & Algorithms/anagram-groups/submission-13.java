class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] dict = new char[26];
            for (char c: str.toCharArray()) 
                dict[c - 'a']++;
            String key = new String(dict);
            if (!map.containsKey(key)) 
                map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
