class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for(String str: strs) {
            int[] counter = new int[26];
            for(char c: str.toCharArray()) {
                counter[c - 'a']++;
            }
            String key = Arrays.toString(counter);
            if(!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(str);
        }
        return new ArrayList<>(result.values());
    }
}
