class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String str: strs) {
            int[] dict = new int[26];
            for (char c: str.toCharArray()) {
                dict[c - 'a']++;
            }
            String key = Arrays.toString(dict);
            resultMap.putIfAbsent(key, new ArrayList<>());
            resultMap.get(key).add(str);
        }
        return new ArrayList<>(resultMap.values());
    }
}
