class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> answer = new HashMap<>();
        for(String word: strs) {
            int[] counter = new int[26];
            for(char c: word.toCharArray()) {
                counter[c - 'a']++;
            }
            String key = Arrays.toString(counter);
            if(! answer.containsKey(key)) {
                answer.put(key, new ArrayList<>());
            }
            answer.get(key).add(word);
        }
        return new ArrayList<>(answer.values());
    }
}
