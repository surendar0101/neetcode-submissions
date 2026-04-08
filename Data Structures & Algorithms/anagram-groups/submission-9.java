class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for(String str: strs) {
            char[] dict = new char[26];
            for (char c: str.toCharArray())
                dict[c - 'a']++;
            String key = Arrays.toString(dict);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(str);
        }
        return new ArrayList<>(result.values());
    }
}
