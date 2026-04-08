class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> answers = new HashMap<>();
        for(String s: strs) {
            int[] counter = new int[26];
            for(char c: s.toCharArray()) {
                counter[c - 'a']++;
            }
            String key = Arrays.toString(counter);
            if(!answers.containsKey(key)) {
                answers.put(key, new ArrayList<>());
            }
            answers.get(key).add(s);
        }
        return new ArrayList<>(answers.values());
    }
}
